package medi.pro.api.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import medi.pro.api.domain.consulta.AgendamentoConsulta;
import medi.pro.api.domain.consulta.ConsultaService;
import medi.pro.api.domain.consulta.DetalhamentoConsulta;
import medi.pro.api.medico.Especialidade;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class ConsultaControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
    private JacksonTester<AgendamentoConsulta> dadosAgendamentoConsultaJson;
	
	@Autowired
    private JacksonTester<DetalhamentoConsulta> dadosDetalhamentoConsultaJacksonTester;
	
	@MockBean
    private ConsultaService consultaService;

	@Test
	@DisplayName("Deve retornar o código HTTP 400 em caso de informações inválidas")
	@WithMockUser
	void agendarCenario1() throws Exception { 

		var response = mvc.perform(post("/consultas")).andReturn().getResponse();

		assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
	}
	
	@Test
	@DisplayName("Deve retornar o código HTTP 200 em caso de informações válidas")
	@WithMockUser
	void agendarCenario2() throws Exception {
		
		var data = LocalDateTime.now().plusHours(1);
        var especialidade = Especialidade.CARDIOLOGIA;

		var dadosDetalhamento = new DetalhamentoConsulta(null, 2l, 1l, data);
		when(consultaService.agendar(any())).thenReturn(dadosDetalhamento);

		var response = mvc
                .perform(
                    post("/consultas")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(dadosAgendamentoConsultaJson.write(
                                    new AgendamentoConsulta(2l, 5l, data, especialidade)
                            ).getJson())
                )
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        
       var jsonEsperado = dadosDetalhamentoConsultaJacksonTester.write(
    		   dadosDetalhamento
        ).getJson();

        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
	}
}

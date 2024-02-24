package medi.pro.api.medico;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import medi.pro.api.domain.Endereco;
import medi.pro.api.domain.Medico;
import medi.pro.api.domain.consulta.Consulta;
import medi.pro.api.domain.paciente.DadosCadastroPaciente;
import medi.pro.api.domain.paciente.Paciente;
import medi.pro.api.endereco.DadosEndereço;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class MedicoRepositoryTest {

	@Autowired
	private MedicoRepository medicoRepository;

	@Autowired
	private TestEntityManager em;

	@Test
	@DisplayName("Deveria devolver null quando unico medico cadastrado na data nao deveria estar disponivel na data")
	void decidirMedicoAleatorioNaDataCenario1() {
		var proximaQuartaAs14 = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY)).atTime(14, 0);

		var medico = cadastrarMedico("DouglasN", "douglass@mail.com", "14528815", "125478", Especialidade.OTORRINOLARINGOLOGIA, null);
		var paciente = cadastrarPaciente("Jose", "jose@mail.com", "14525847", null, "masculino", "Febre", null);
		cadastrarConsulta(medico, paciente, proximaQuartaAs14);

		var medicoDisponivel = medicoRepository.decidirMedicoAleatorioNaData(Especialidade.ORTOPEDIA,
				proximaQuartaAs14);

		assertThat(medicoDisponivel).isNull();
	}

	@Test
	@DisplayName("Deveria devolver médico quando ele estiver disponivel na data")
	void decidirMedicoAleatorioNaDataCenario2() {
		var proximaQuartaAs14 = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY)).atTime(14, 0);

		var medico = cadastrarMedico("DouglasN", "douglass@mail.com", "14525874", "123456", Especialidade.OTORRINOLARINGOLOGIA, null);

		var medicoDisponivel = medicoRepository.decidirMedicoAleatorioNaData(Especialidade.OTORRINOLARINGOLOGIA,
				proximaQuartaAs14);
		assertThat(medicoDisponivel).isEqualTo(medico);
	}

	private void cadastrarConsulta(Medico medico, Paciente paciente, LocalDateTime data) {
		em.persist(new Consulta(null, medico, paciente, data, null, null));
	}

	private Medico cadastrarMedico(String nome, String email, String telefone, String crm, Especialidade especialidade, Endereco dadosEndereco) {
		var medico = new Medico(dadosMedico(nome, email, telefone, crm, especialidade, dadosEndereco));
		em.persist(medico);
		return medico;
	}

	private Paciente cadastrarPaciente(String nome, String email, String telefone, Date nasc, String genero,
			String registroSaude, Endereco endereco) {

		var paciente = new Paciente(dadosPaciente(nome, email, telefone, nasc, genero, registroSaude, endereco));
		em.persist(paciente);
		return paciente;
	}

	private DadosCadastroMedico dadosMedico(String nome, String email, String telefone, String crm, Especialidade especialidade, Endereco dadosEndereco) {
		return new DadosCadastroMedico(nome, email, telefone, crm, especialidade, dadosEndereco());
	}

	private DadosCadastroPaciente dadosPaciente(String nome, String email, String telefone, Date nasc, String genero,
			String registroSaude, Endereco endereco) {
		return new DadosCadastroPaciente(nome, email, telefone, nasc, genero, registroSaude, endereco);
	}

	private DadosEndereço dadosEndereco() {
		return new DadosEndereço("rua abc", "bairro", "12347589", "São Paulo", "SP", "Apartamento", "111");
	}
}

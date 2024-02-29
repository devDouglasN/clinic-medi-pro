package medi.pro.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import medi.pro.api.domain.consulta.AgendamentoConsulta;
import medi.pro.api.domain.consulta.Consulta;
import medi.pro.api.domain.consulta.ConsultaDTO;
import medi.pro.api.domain.consulta.ConsultaService;
import medi.pro.api.domain.consulta.DadosCancelamentoConsulta;

@RestController
@RequestMapping("consultas")
@SecurityRequirement(name = "bearer-key")
public class ConsultaController {
	
	@Autowired
	private ConsultaService agenda;
	
	@GetMapping
	public ResponseEntity<List<ConsultaDTO>> findAll() {
		List<Consulta> list = agenda.findAll();
		List<ConsultaDTO> listDTO = list.stream().map(ConsultaDTO::new).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping("/canceladas")
	public ResponseEntity<List<ConsultaDTO>> findAllAByCanceladaTrue() {
		List<Consulta> list = agenda.consultasCanceladas();
		List<ConsultaDTO> listDTO = list.stream().map(ConsultaDTO::new).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	@Transactional
	public ResponseEntity agendar(@RequestBody @Valid AgendamentoConsulta consultaDTO) {
		var objDTO = agenda.agendar(consultaDTO);
		return ResponseEntity.ok(objDTO);
	}
	
	@DeleteMapping
	@Transactional
	public ResponseEntity cancelarConsulta(@RequestBody @Valid DadosCancelamentoConsulta dados) {
		agenda.cancelar(dados);
		return ResponseEntity.noContent().build();
	}
}

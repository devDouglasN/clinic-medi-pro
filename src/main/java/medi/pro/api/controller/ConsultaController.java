package medi.pro.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import medi.pro.api.domain.consulta.AgendamentoConsulta;
import medi.pro.api.domain.consulta.ConsultaService;

@RestController
@RequestMapping("consultas")
@SecurityRequirement(name = "bearer-key")
public class ConsultaController {
	
	@Autowired
	private ConsultaService agenda;

	@PostMapping
	@Transactional
	public ResponseEntity agendar(@RequestBody @Valid AgendamentoConsulta consultaDTO) {
		var objDTO = agenda.agendar(consultaDTO);
		return ResponseEntity.ok(objDTO);
	}
}

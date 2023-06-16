package medi.pro.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import medi.pro.api.medico.DadosCadastroMedico;
import medi.pro.api.medico.Medico;
import medi.pro.api.medico.MedicoRepository;

@RestController
@RequestMapping("medicos")
public class MedicoController {
	
	@Autowired
	private MedicoRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
		repository.save(new Medico(dados));
	}
}

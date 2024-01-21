package medi.pro.api.domain.consulta.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import medi.pro.api.domain.ValidationException;
import medi.pro.api.domain.consulta.AgendamentoConsulta;
import medi.pro.api.medico.MedicoRepository;

@Component
public class ValidadorMedicoHabilitado implements ValidadorAgendamentoDeConsulta {
	
	@Autowired
	private MedicoRepository repository;
	
	public void validar(AgendamentoConsulta dados) {
		if(dados.idMedico() == null) {
			return;
		}
		
		var medicoEstaHabilitado = repository.findAtivoById(dados.idMedico());
		if(!medicoEstaHabilitado) {
			throw new ValidationException("Consulta não pode ser agendado com médico excluído");
		}
	}	
	
}

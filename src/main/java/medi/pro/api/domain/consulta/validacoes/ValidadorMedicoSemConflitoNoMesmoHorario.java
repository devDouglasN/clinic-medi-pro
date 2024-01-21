package medi.pro.api.domain.consulta.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import medi.pro.api.domain.ValidationException;
import medi.pro.api.domain.consulta.AgendamentoConsulta;
import medi.pro.api.domain.consulta.ConsultaRepository;

@Component
public class ValidadorMedicoSemConflitoNoMesmoHorario {

	@Autowired
	private ConsultaRepository repository;
	
	public void validar(AgendamentoConsulta dados) {
		var medicoPossuiOutraConsultaNoMesmoHoraio = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
		if(medicoPossuiOutraConsultaNoMesmoHoraio) {
			throw new ValidationException("Médico já possui outra consulta agendada nesse mesmo horário");
		}
	}
	
}

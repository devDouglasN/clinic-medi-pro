package medi.pro.api.domain.consulta.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import medi.pro.api.domain.ValidationException;
import medi.pro.api.domain.consulta.AgendamentoConsulta;
import medi.pro.api.domain.consulta.ConsultaRepository;

@Component
public class ValidadorPacienteSemConflitoDeConsultaNoDia implements ValidadorAgendamentoDeConsulta {

	@Autowired
	private ConsultaRepository repository;
	
	public void validar(AgendamentoConsulta dados) {
		var primeiroHorario = dados.data().withHour(7);
		var ultimoHorario = dados.data().withHour(18);
		var pacientePossuiOutraConsultaNoDia = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);
		if(pacientePossuiOutraConsultaNoDia) {
			throw new ValidationException("Paciente já possui uma consulta agendada nesse dia");
		}
	}
	
}

package medi.pro.api.domain.consulta.validacoes;

import java.time.DayOfWeek;

import org.springframework.stereotype.Component;

import medi.pro.api.domain.ValidationException;
import medi.pro.api.domain.consulta.AgendamentoConsulta;

@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsulta {

	public void validar(AgendamentoConsulta dados) {
		var dataConsulta = dados.data();
		var domingo = dados.data().getDayOfWeek().equals(DayOfWeek.SUNDAY);
		var dataAbertura =  dataConsulta.getHour() < 7;
		var dataFechamento = dataConsulta.getHour() > 18;

		if(domingo || dataAbertura || dataFechamento) {
			throw new ValidationException("Consulta fora do horário de funcionamento da clínica!");
		}
	}
	
}

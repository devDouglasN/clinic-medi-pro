package medi.pro.api.domain.consulta.validacoes;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import medi.pro.api.domain.ValidationException;
import medi.pro.api.domain.consulta.AgendamentoConsulta;

@Component
public class ValidadorHorarioAntecedencia {

	public void validar(AgendamentoConsulta dados) {
	    var dataConsulta = dados.data();
	    var agora = LocalDateTime.now();
	    var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();
	    if (diferencaEmMinutos < 30) {
	        throw new ValidationException("Consulta deve ser agendada com antecedência mínima de 30 minutos");
	    }
	}
	
}

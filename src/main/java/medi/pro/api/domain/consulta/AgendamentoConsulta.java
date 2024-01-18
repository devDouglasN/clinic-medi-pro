package medi.pro.api.domain.consulta;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import medi.pro.api.medico.Especialidade;

public record AgendamentoConsulta (
	Long idMedico,
	
	@NotNull
	Long idPaciente,
	
	@NotNull
	@Future
	LocalDateTime data,
	
	Especialidade especialidade	){
		
	}


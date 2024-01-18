package medi.pro.api.domain.consulta;

import java.time.LocalDateTime;

public record DetalhamentoConsulta(Long id, Long idMedico, Long idPacidente, LocalDateTime data) {

	public DetalhamentoConsulta(Consulta consulta) {
		this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getData());
	}
}

package medi.pro.api.domain.consulta;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import medi.pro.api.domain.Medico;
import medi.pro.api.domain.paciente.Paciente;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta {

	private Long id;
	private Medico medico;
	private Paciente paciente;
	private LocalDateTime data;
}

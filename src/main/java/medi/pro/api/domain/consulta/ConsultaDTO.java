package medi.pro.api.domain.consulta;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private Long id;

    @NotNull(message = "ID do médico não pode ser nulo")
    private Long medicoId;

    @NotNull(message = "ID do paciente não pode ser nulo")
    private Long pacienteId;

    @NotNull(message = "Data não pode ser nula")
    private LocalDateTime data;
    
    public ConsultaDTO(Consulta consulta) {
		super();
		this.id = consulta.getId();
		this.medicoId = consulta.getMedico().getId();
		this.pacienteId = consulta.getPaciente().getId();
		this.data = consulta.getData();
	}
}

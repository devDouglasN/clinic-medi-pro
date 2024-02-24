package medi.pro.api.domain.consulta;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import medi.pro.api.domain.Medico;
import medi.pro.api.domain.paciente.Paciente;

@Table(name = "consultas")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "medico_id")
	private Medico medico;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;
	
	private LocalDateTime data;
	
	private Boolean cancelada;
	
	@Column(name = "motivo_cancelamento")
	@Enumerated(EnumType.STRING)
	private MotivoCancelamento motivoCancelamento;
}

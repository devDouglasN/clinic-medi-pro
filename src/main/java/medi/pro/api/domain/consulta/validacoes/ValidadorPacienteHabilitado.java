package medi.pro.api.domain.consulta.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import medi.pro.api.domain.ValidationException;
import medi.pro.api.domain.consulta.AgendamentoConsulta;
import medi.pro.api.domain.paciente.PacienteRepository;

@Component
public class ValidadorPacienteHabilitado implements  {

	@Autowired
	private PacienteRepository repository;

	public void validar(AgendamentoConsulta dados) {
		var pacienteEstaHabilitado = repository.findAtivoById(dados.idPaciente());
		if (!pacienteEstaHabilitado) {
			throw new ValidationException("Consulta não pode ser agendada com paciente excluído");
		}
	}
	
}

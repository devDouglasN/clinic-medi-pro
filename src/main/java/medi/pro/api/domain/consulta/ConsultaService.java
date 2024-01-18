package medi.pro.api.domain.consulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import medi.pro.api.domain.Medico;
import medi.pro.api.domain.ValidationException;
import medi.pro.api.domain.paciente.PacienteRepository;
import medi.pro.api.medico.MedicoRepository;

@Service
public class ConsultaService {

	@Autowired
	private ConsultaRepository consultaRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	public DetalhamentoConsulta agendar(AgendamentoConsulta dados) {	
		if(!pacienteRepository.existsById(dados.idPaciente())) {
			throw new ValidationException("O ID do paciente fornecido não foi encontrado");
		}
		
		if(dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())) {
			throw new ValidationException("O ID do medico fornecido não foi encontrado");
		}
		
		var paciente = pacienteRepository.findById(dados.idPaciente()).get();
		var medico = selecionarMedico(dados);
		var consulta = new Consulta(null, medico, paciente, dados.data());
		consultaRepository.save(consulta);
		
		return new DetalhamentoConsulta(consulta);
	}

	private Medico selecionarMedico(AgendamentoConsulta dados) {
		if(dados.idMedico() != null) {
			return medicoRepository.getReferenceById(dados.idMedico());
		}
		if(dados.especialidade() == null) {
			throw new ValidationException("É obrigatório indicar a especialidade quando nenhum médico é especificado!") ;
		}
		
		return medicoRepository.decidirMedicoAleatorioNaData(dados.especialidade(), dados.data());
	}
}

package medi.pro.api.domain.consulta;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import medi.pro.api.domain.Medico;
import medi.pro.api.domain.ValidationException;
import medi.pro.api.domain.consulta.validacoes.ValidadorAgendamentoDeConsulta;
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
	
	@Autowired
	private List<ValidadorAgendamentoDeConsulta> validadores;
	
	public List<Consulta> findAll(){
		return consultaRepository.findAll();
	}
	
	public List<Consulta> consultasCanceladas(){
		return consultaRepository.findAllAByCanceladaTrue();
	}
	
	public DetalhamentoConsulta agendar(AgendamentoConsulta dados) {	
		if(!pacienteRepository.existsById(dados.idPaciente())) {
			throw new ValidationException("O ID do paciente fornecido não foi encontrado");
		}
		
		if(dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())) {
			throw new ValidationException("O ID do medico fornecido não foi encontrado");
		}
		
		validadores.forEach(v -> v.validar(dados));
		
		var paciente = pacienteRepository.findById(dados.idPaciente()).get();
		var medico = selecionarMedico(dados);
		var consulta = new Consulta(null, medico, paciente, dados.data(), null, null);
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
	
	public Consulta cancelar(DadosCancelamentoConsulta dados) {
		if (!consultaRepository.existsById(dados.idConsulta())) {
			throw new ValidationException("Id da consulta informado não existe!");
		}
		var consulta = consultaRepository.getReferenceById(dados.idConsulta());
		LocalDateTime dataCancelamento = LocalDateTime.now();
		
		if(dataCancelamento.plusDays(1).isAfter(consulta.getData())) {
			throw new ValidationException("A consulta só pode ser cancelada com no minimo 24h de antecedencia");
		}
		consulta.setCancelada(true);
		consulta.setMotivoCancelamento(dados.motivo());
		return consulta;
		
	}
}

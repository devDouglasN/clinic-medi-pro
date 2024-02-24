package medi.pro.api.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import medi.pro.api.domain.Medico;
import medi.pro.api.domain.paciente.Paciente;
import medi.pro.api.domain.paciente.PacienteRepository;
import medi.pro.api.medico.Especialidade;
import medi.pro.api.medico.MedicoRepository;

@Service
public class DBServices {
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	public void dbService() {
			
		Medico med1 = new Medico(null, "Carolina Sousa", "carolina.sousa.medi.pro", "12345/SP", "11988884444", Especialidade.CARDIOLOGIA, null, true);
		Medico med2 = new Medico(null, "Miguel Costa", "miguel.costa.medi.pro", "54215/SP", "11999885522", Especialidade.GINECOLOGIA, null, true);
		Medico med3 = new Medico(null, "Sofia Pereira", "sofia.pereira.medi.pro", "85415/SP", "11986682233", Especialidade.CARDIOLOGIA, null, true);
		Medico med4 = new Medico(null, "Carolina Sousa", "carolina.sousa.medi.pro", "12345/SP", "11988884444", Especialidade.ORTOPEDIA, null, true);
		Medico med5 = new Medico(null, "Miguel Ferreira", "miguel.ferreira.medi.pro", "45874/SP", "11988884444", Especialidade.OTORRINOLARINGOLOGIA, null, true);
		List<Medico> medicos = Arrays.asList(med1, med2, med3, med4, med5);
		List<Medico> saveMedicos = medicoRepository.saveAll(medicos);
		
		Paciente pac1 = new Paciente(null, "Tiago Martins", "tiago.martins@mail.com", "11900112233", null, "Masculino", "Hipertensão Arterial", null, true);
		Paciente pac2 = new Paciente(null, "Ana Silva", "ana.silva@mail.com", "11999887766", null, "Feminino", "Infecção", null, true);
		Paciente pac3 = new Paciente(null, "Pedro Santos", "pedro.santos@mail.com", "11995544332", null, "Masculino", "Hipertensão arterial", null, true);
		Paciente pac4 = new Paciente(null, "Mariana Oliveira", "mariana.oliveira@mail.com", "11996611223", null, "Feminino", "Fratura de tornozelo", null, true);
		Paciente pac5 = new Paciente(null, "Carlos Almeida", "carlos.almeida@mail.com", "11994455661", null, "Masculino", "Perda auditiva", null, true);
		Paciente pac6 = new Paciente(null, "Luana Golçanves", "luana.golcanves@mail.com", "11997788991", null, "Feminino", "Endometriose", null, true);
		Paciente pac7 = new Paciente(null, "Luisa Mendes", "luisa.mendes@mail.com", "11990011222", null, "Feminino", "Angina", null, true);
		Paciente pac8 = new Paciente(null, "Ricardo Oliveira", "ricardo.oliveira@mail.com", "11998877665", null, "Masculino", "Lesão no joelho", null, true);
		Paciente pac9 = new Paciente(null, "Camila Silva", "camila.silva@mail.com", "11997755441", null, "Feminino", "Gravidez de alto risco", null, true);
		List<Paciente> pacientes = Arrays.asList(pac1, pac2, pac3, pac4, pac5, pac6, pac7, pac8, pac9);
		List<Paciente> savePacientes = pacienteRepository.saveAll(pacientes);	
	}
}

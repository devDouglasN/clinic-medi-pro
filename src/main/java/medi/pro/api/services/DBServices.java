package medi.pro.api.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import medi.pro.api.domain.Endereco;
import medi.pro.api.domain.Medico;
import medi.pro.api.domain.paciente.Paciente;
import medi.pro.api.domain.paciente.PacienteRepository;
import medi.pro.api.endereco.DadosEndereço;
import medi.pro.api.medico.Especialidade;
import medi.pro.api.medico.MedicoRepository;

@Service
public class DBServices {
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	public void dbService() {
		
		DadosEndereço endMed1 = new DadosEndereço("Avenida Paulista", "Bela Vista", "01311300", "São Paulo", "SP", "Complemento 1", "15");
		Endereco enderecoMed1 = new Endereco(endMed1);
		
		DadosEndereço endMed2 = new DadosEndereço("Rua Augusta", "Consolação", "01304900", "São Paulo", "SP", "Complemento 2", "545");
		Endereco enderecoMed2 = new Endereco(endMed2);

		DadosEndereço endMed3 = new DadosEndereço("Rua Oscar Freire", "Jardins", "01426000", "São Paulo", "SP", "Complemento 3", "85");
		Endereco enderecoMed3 = new Endereco(endMed3);

		DadosEndereço endMed4 = new DadosEndereço("Avenida Brigadeiro Faria Lima", "Itaim Bibi", "01452000", "São Paulo", "SP", "Complemento 4", "17");
		Endereco enderecoMed4 = new Endereco(endMed4);

		DadosEndereço endMed5 = new DadosEndereço("Rua Haddock Lobo", "Cerqueira César", "01414000", "São Paulo", "SP", "Complemento 5", "1005");
		Endereco enderecoMed5 = new Endereco(endMed5);

		//endereços para pacientes
		DadosEndereço endPac1 = new DadosEndereço("Rua da Consolação", "Consolação", "01301000", "São Paulo", "SP", "Complemento 6", "4854");
		Endereco enderecoPac1 = new Endereco(endPac1);

		DadosEndereço endPac2 = new DadosEndereço("Rua Maria Antônia", "Vila Buarque", "01222000", "São Paulo", "SP", "Complemento 7", "963");
		Endereco enderecoPac2 = new Endereco(endPac2);

		DadosEndereço endPac3 = new DadosEndereço("Rua Treze de Maio", "Bela Vista", "01327000", "São Paulo", "SP", "Complemento 8", "65");
		Endereco enderecoPac3 = new Endereco(endPac3);

		DadosEndereço endPac4 = new DadosEndereço("Rua dos Pinheiros", "Pinheiros", "05422000", "São Paulo", "SP", "Complemento 9", "369");
		Endereco enderecoPac4 = new Endereco(endPac4);

		DadosEndereço endPac5 = new DadosEndereço("Rua Harmonia", "Vila Madalena", "05435000", "São Paulo", "SP", "Complemento 10", "708");
		Endereco enderecoPac5 = new Endereco(endPac5);

		DadosEndereço endPac6 = new DadosEndereço("Rua Fradique Coutinho", "Pinheiros", "05416000", "São Paulo", "SP", "Complemento 11", "2058");
		Endereco enderecoPac6 = new Endereco(endPac6);

		DadosEndereço endPac7 = new DadosEndereço("Rua Aspicuelta", "Vila Madalena", "05433000", "São Paulo", "SP", "Complemento 12", "3358");
		Endereco enderecoPac7 = new Endereco(endPac7);

		DadosEndereço endPac8 = new DadosEndereço("Rua Girassol", "Vila Madalena", "05433002", "São Paulo", "SP", "Complemento 13", "09");
		Endereco enderecoPac8 = new Endereco(endPac8);

		DadosEndereço endPac9 = new DadosEndereço("Rua Purpurina", "Vila Madalena", "05435000", "São Paulo", "SP", "Complemento 14", "785");
		Endereco enderecoPac9 = new Endereco(endPac9);
		
		Medico med1 = new Medico(null, "Carolina Sousa", "carolina.sousa.medi.pro", "12345/SP", "11988884444", Especialidade.CARDIOLOGIA, enderecoMed1, true);
		Medico med2 = new Medico(null, "Miguel Costa", "miguel.costa.medi.pro", "54215/SP", "11999885522", Especialidade.GINECOLOGIA, enderecoMed2, true);
		Medico med3 = new Medico(null, "Sofia Pereira", "sofia.pereira.medi.pro", "85415/SP", "11986682233", Especialidade.CARDIOLOGIA, enderecoMed3, true);
		Medico med4 = new Medico(null, "Carolina Sousa", "carolina.sousa.medi.pro", "12345/SP", "11988884444", Especialidade.ORTOPEDIA, enderecoMed4, true);
		Medico med5 = new Medico(null, "Miguel Ferreira", "miguel.ferreira.medi.pro", "45874/SP", "11988884444", Especialidade.OTORRINOLARINGOLOGIA, enderecoMed5, true);
		List<Medico> medicos = Arrays.asList(med1, med2, med3, med4, med5);
		List<Medico> saveMedicos = medicoRepository.saveAll(medicos);
		
		LocalDate localDate1 = LocalDate.of(1998, 1, 27);
		Date dataNascimento1 = Date.valueOf(localDate1);	
		Paciente pac1 = new Paciente(null, "Tiago Martins", "tiago.martins@mail.com", "11900112233", dataNascimento1, "Masculino", "Hipertensão Arterial", enderecoPac1, true);
		
		LocalDate localDate2 = LocalDate.of(2005, 5, 13);
		Date dataNascimento2 = Date.valueOf(localDate2);	
		Paciente pac2 = new Paciente(null, "Ana Silva", "ana.silva@mail.com", "11999887766", dataNascimento2, "Feminino", "Infecção", enderecoPac2, true);
		
		LocalDate localDate3 = LocalDate.of(1988, 4, 06);
		Date dataNascimento3 = Date.valueOf(localDate3);	
		Paciente pac3 = new Paciente(null, "Pedro Santos", "pedro.santos@mail.com", "11995544332", dataNascimento3, "Masculino", "Hipertensão arterial", enderecoPac3, true);
		
		LocalDate localDate4 = LocalDate.of(1998, 10, 11);
		Date dataNascimento4 = Date.valueOf(localDate4);	
		Paciente pac4 = new Paciente(null, "Mariana Oliveira", "mariana.oliveira@mail.com", "11996611223", dataNascimento4, "Feminino", "Fratura de tornozelo", enderecoPac4, true);
		
		LocalDate localDate5 = LocalDate.of(1998, 3, 20);
		Date dataNascimento5 = Date.valueOf(localDate5);	
		Paciente pac5 = new Paciente(null, "Carlos Almeida", "carlos.almeida@mail.com", "11994455661", dataNascimento5, "Masculino", "Perda auditiva", enderecoPac5, true);
		
		LocalDate localDate6 = LocalDate.of(1998, 12, 02);
		Date dataNascimento6 = Date.valueOf(localDate6);	
		Paciente pac6 = new Paciente(null, "Luana Golçanves", "luana.golcanves@mail.com", "11997788991", dataNascimento6, "Feminino", "Endometriose", enderecoPac6, true);
		
		LocalDate localDate7 = LocalDate.of(1998, 2, 25);
		Date dataNascimento7 = Date.valueOf(localDate7);	
		Paciente pac7 = new Paciente(null, "Luisa Mendes", "luisa.mendes@mail.com", "11990011222", dataNascimento7, "Feminino", "Angina", enderecoPac7, true);
		
		LocalDate localDate8 = LocalDate.of(1998, 7, 10);
		Date dataNascimento8 = Date.valueOf(localDate8);	
		Paciente pac8 = new Paciente(null, "Ricardo Oliveira", "ricardo.oliveira@mail.com", "11998877665", dataNascimento8, "Masculino", "Lesão no joelho", enderecoPac8, true);
		
		LocalDate localDate9 = LocalDate.of(1998, 9, 28);
		Date dataNascimento9 = Date.valueOf(localDate9);	
		Paciente pac9 = new Paciente(null, "Camila Silva", "camila.silva@mail.com", "11997755441", dataNascimento9, "Feminino", "Gravidez de alto risco", enderecoPac9, true);
		List<Paciente> pacientes = Arrays.asList(pac1, pac2, pac3, pac4, pac5, pac6, pac7, pac8, pac9);
		List<Paciente> savePacientes = pacienteRepository.saveAll(pacientes);	
	}
}

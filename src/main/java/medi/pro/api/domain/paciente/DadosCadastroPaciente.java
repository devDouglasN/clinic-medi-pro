package medi.pro.api.domain.paciente;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import medi.pro.api.domain.Endereco;

public record DadosCadastroPaciente(
		
		@NotBlank
		String nome,
		
		@NotBlank
		String email,
		
		@NotBlank
		String telefone,
		
		@DateTimeFormat(pattern = "dd/MM/yyyy")
		Date dataNascimento,
		
		@NotBlank
		String genero,
		
		@NotBlank
		String registroSaude,
		
		Endereco endereco) {
}

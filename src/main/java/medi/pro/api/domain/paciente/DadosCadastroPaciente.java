package medi.pro.api.domain.paciente;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import medi.pro.api.domain.Endereco;

public record DadosCadastroPaciente(
		
		@NotBlank
		String nome,
		
		@NotBlank
		String email,
		
		@NotBlank
		String telefone,
		
		Date dataNascimento,
		
		@NotBlank
		String genero,
		
		@NotBlank
		String registroSaude,
		
		Endereco endereco) {
}

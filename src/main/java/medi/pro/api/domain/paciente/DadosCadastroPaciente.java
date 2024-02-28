package medi.pro.api.domain.paciente;

import java.util.Date;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import medi.pro.api.endereco.DadosEndereço;

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
		
		@NotNull
		@Valid
		DadosEndereço endereco) {
}

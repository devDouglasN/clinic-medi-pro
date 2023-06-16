package medi.pro.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import medi.pro.api.endereco.DadosEndereço;

public record DadosCadastroMedico(
		
		@NotBlank
		String nome, 
		
		@NotBlank
		@Email
		String email, 
		
		@NotBlank
		String telefone,
		
		@NotBlank
		@Pattern(regexp = "\\d{4,6}")
		String crm, 
		
		@NotNull
		Especialidade especialidade, 
		
		@NotNull
		@Valid
		DadosEndereço endereco) {

}

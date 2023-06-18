package medi.pro.api.medico;

import jakarta.validation.constraints.NotNull;
import medi.pro.api.endereco.DadosEndereço;

public record DadosAtualizacaoMedico(
		@NotNull
		Long id, 
		String nome, 
		String telefone, 
		DadosEndereço endereco) {
	
}

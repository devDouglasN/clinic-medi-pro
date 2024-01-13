package medi.pro.api.domain.paciente;

import jakarta.validation.constraints.NotNull;
import medi.pro.api.endereco.DadosEndereço;

public record DadosAtualizacaoPaciente(@NotNull
		Long id, 
		String nome, 
		String telefone,
		String registroSaude,
		DadosEndereço endereco) {
}

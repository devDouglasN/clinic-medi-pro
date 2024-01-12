package medi.pro.api.domain.paciente;

import java.util.Date;

import medi.pro.api.domain.Endereco;

public record DadosDetalhamentoPaciente(Long id, String nome, String email, String telefone, Date dataNascimento, String genero, String registroSaude, Endereco endereco) {

	public DadosDetalhamentoPaciente(Paciente paciente) {
		this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getDataNascimento(), paciente.getGenero(), 
				paciente.getRegistroSaude(), paciente.getEndereco());
	}
}

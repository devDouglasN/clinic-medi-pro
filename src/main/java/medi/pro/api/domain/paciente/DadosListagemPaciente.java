package medi.pro.api.domain.paciente;

import java.util.Date;

public record DadosListagemPaciente(Long id, String nome, String email, String telefone, Date dataNascimento, String genero, String registroSaude) {

	public DadosListagemPaciente(Paciente paciente) {
		this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getDataNascimento(), paciente.getGenero(), paciente.getRegistroSaude());
	}
}

package medi.pro.api.domain.paciente;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import medi.pro.api.domain.Endereco;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {

	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private Date dataNascimento;
	private String genero;
	private String registroSaude;
	
	private Endereco endereco;
}

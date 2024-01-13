package medi.pro.api.domain.paciente;

import java.util.Date;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import medi.pro.api.domain.Endereco;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private Date dataNascimento;
	private String genero;
	private String registroSaude;
	
	@Embedded
	private Endereco endereco;
	
	private Boolean ativo;
	
	public Paciente(DadosCadastroPaciente dados) {
		this.ativo = true;
		this.nome = dados.nome();
		this.email = dados.email();
		this.telefone = dados.telefone();
		this.dataNascimento = dados.dataNascimento();
		this.genero = dados.genero();
		this.registroSaude = dados.registroSaude();
		this.endereco = dados.endereco();
	}
	
	public void atualizarInformacoes(@Valid DadosAtualizacaoPaciente dados) {
		if(dados.nome() != null) {
			this.nome = dados.nome();
		}
		if(dados.telefone() !=null) {
			this.telefone = dados.telefone();
		}
		if(dados.endereco() != null) {
			this.endereco.atualizarInformacoes(dados.endereco());
		}
	}
	
	public void excluir() {
		this.ativo = false;
	}
}
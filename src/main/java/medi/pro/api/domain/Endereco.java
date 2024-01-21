 package medi.pro.api.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import medi.pro.api.endereco.DadosEndereço;

@Embeddable
@Getter
@AllArgsConstructor
public class Endereco {
	
	private String logradouro;
	private String bairro;
	private String cep;
	private String numero;
	private String complemento;
	private String cidade;
	private String uf;
	
	public Endereco() {
	}
	
	public Endereco(DadosEndereço dados) {
		this.logradouro = dados.logradouro();
		this.bairro = dados.bairro();
		this.cep = dados.cep();
		this.uf = dados.uf();
		this.cidade = dados.cidade();
		this.numero = dados.numero();
		this.complemento = dados.complemento();
	}

	public void atualizarInformacoes(DadosEndereço dados) {
		if(dados.logradouro() != null){
			this.logradouro = dados.logradouro();
		}
		if(dados.bairro() != null){
			this.bairro = dados.bairro();
		}
		if(dados.cep() != null){
			this.cep = dados.cep();
		}
		if(dados.numero() != null){
			this.numero = dados.numero();
		}
		if(dados.complemento() != null){
			this.complemento = dados.complemento();
		}
		if(dados.cidade() != null){
			this.cidade = dados.cidade();
		}
		if(dados.uf() != null){
			this.uf = dados.uf();
		}
	}	
}

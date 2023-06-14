package medi.pro.api.medico;

import medi.pro.api.endereco.DadosEndereço;

public record DadosCadastroMedico(String nome, String email, String crm, Especialidade especialidade, DadosEndereço endereco) {

}

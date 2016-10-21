package br.com.sweetmanu.modelos;

public class AdmLoja {

	private String nome;
	private String cpf;
	
	public AdmLoja(){
	}
	
	public AdmLoja(String nome, String cpf){
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}
	
}

package br.com.sweetmanu.modelos;

public class AdmLoja {

	private Integer id;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "AdmLoja [id=" + id + ", nome=" + nome + ", cpf=" + cpf + "]";
	}
	
}

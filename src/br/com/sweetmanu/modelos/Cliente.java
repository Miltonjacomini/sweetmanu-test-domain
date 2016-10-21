package br.com.sweetmanu.modelos;

public class Cliente {

	private String cpf;
	private String nome;

	public Cliente(){
	}
	
	public Cliente(String nome, String cpf){
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public void enviarPedido(Pedido pedido) {
		pedido.enviar();
	}

}

package br.com.sweetmanu.modelos;

public class Produto {

	private String nome;
	private ProdutoTipo tipo;

	public Produto(){
	}

	public Produto(String nome, ProdutoTipo tipo){
		this.nome = nome;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public ProdutoTipo getTipo() {
		return tipo;
	}
	
}

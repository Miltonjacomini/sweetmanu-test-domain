package br.com.sweetmanu.modelos;

import java.util.List;

public class Pedido {

	private Cliente cliente;
	private List<Produto> produtos;
	private PedidoStatus status;
	
	public Pedido(){
	}

	public Pedido(Cliente cliente){
		this.cliente = cliente;
	}


	public void addProduto(Produto produto) {
		produtos.add(produto);
	}

	public void enviar() {
		setStatus(PedidoStatus.ENVIADO);
	}

	/* GETTERS AND SETTERS */
	public Cliente getCliente() {
		return cliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public PedidoStatus getStatus() {
		return status;
	}

	public void setStatus(PedidoStatus status) {
		this.status = status;
	}
}

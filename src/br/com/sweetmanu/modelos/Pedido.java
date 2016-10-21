package br.com.sweetmanu.modelos;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private Integer id;
	private Cliente cliente;
	private List<Produto> produtos = new ArrayList<Produto>();
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", cliente=" + cliente + ", status=" + status + ", produtos=" + produtos + "]";
	}
	
}

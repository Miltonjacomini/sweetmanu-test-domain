package br.com.sweetmanu.dao;

import java.util.HashMap;

import br.com.sweetmanu.modelos.Produto;

public class ProdutoDAO {

	private Integer idProduto = 0;
	private HashMap<Integer, Produto> listaDeProdutos = new HashMap<Integer, Produto>();

	public void salvar(Produto produto) {
		
		if (produto.getId() == null) {
			this.idProduto++;
			produto.setId(this.idProduto);
			listaDeProdutos.put(this.idProduto, produto);
		} else {
			listaDeProdutos.put(produto.getId(), produto);
		}
	}

}

package br.com.sweetmanu.dao;

import java.util.HashMap;

import br.com.sweetmanu.modelos.ProdutoTipo;

public class ProdutoTipoDAO {

	private Integer idTipo = 0;
	private HashMap<Integer, ProdutoTipo> listaDeProdutoTipo = new HashMap<Integer, ProdutoTipo>();

	public void salvar(ProdutoTipo produtoTipo) {
		
		if (produtoTipo.getId() == null) {
			this.idTipo++;
			produtoTipo.setId(this.idTipo);
			listaDeProdutoTipo.put(this.idTipo, produtoTipo);
		} else {
			listaDeProdutoTipo.put(produtoTipo.getId(), produtoTipo);
		}
	}

}

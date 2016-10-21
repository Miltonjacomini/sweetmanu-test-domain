package br.com.sweetmanu.dao;

import java.util.HashMap;

import br.com.sweetmanu.modelos.Cliente;

public class ClienteDAO {

	private Integer idCliente = 0;
	private HashMap<Integer, Cliente> listaDeClientes = new HashMap<Integer, Cliente>();

	public void salvar(Cliente cliente) {
		
		if (cliente.getId() == null) {
			this.idCliente++;
			cliente.setId(this.idCliente);
			listaDeClientes.put(this.idCliente, cliente);
		} else {
			listaDeClientes.put(cliente.getId(), cliente);
		}
	}

}

package br.com.sweetmanu.dao;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import br.com.sweetmanu.modelos.AdmLoja;
import br.com.sweetmanu.modelos.Cliente;
import br.com.sweetmanu.modelos.Pedido;
import br.com.sweetmanu.modelos.PedidoStatus;

public class PedidoDAO {

	HashMap<Integer, Pedido> listaDePedidos = new HashMap<Integer, Pedido>();

	public List<Pedido> listaPedidosByStatus(PedidoStatus status) {
		return listaDePedidos.values().stream()
				.filter(pedido -> pedido.getStatus().equals(status))
				.collect(Collectors.toList());
	}

	public void enviarPedido(Cliente cliente, Pedido pedido) {
		pedido.setStatus(PedidoStatus.ENVIADO);
		listaDePedidos.put(listaDePedidos.size()+1, pedido);
	}

	public void confirmaPedido(AdmLoja manuela, Pedido pedido) {
		listaDePedidos.values().stream()
			.filter(pedido -> pedido.equals(pedido))
	}

}

package br.com.sweetmanu.dao;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import br.com.sweetmanu.modelos.AdmLoja;
import br.com.sweetmanu.modelos.Pedido;
import br.com.sweetmanu.modelos.PedidoStatus;

public class PedidoDAO {

	Integer idPedido = 0;
	HashMap<Integer, Pedido> listaDePedidos = new HashMap<Integer, Pedido>();

	public List<Pedido> listaPedidosByStatus(PedidoStatus status) {
		return listaDePedidos.values().stream()
				.filter(pedido -> pedido.getStatus().equals(status))
				.collect(Collectors.toList());
	}
	
	public Pedido procuraPedidoPorId(Integer idPedido){
		Pedido pedido;
		
		if(listaDePedidos.size() != 0){
			pedido = listaDePedidos.get(idPedido);
		}else{
			pedido = new Pedido();
			pedido.setId(this.idPedido);
		}
		
		return pedido;
	}

	public void enviarPedido(Pedido pedido) {
		pedido.setStatus(PedidoStatus.ENVIADO);
		salvar(pedido);
	}

	public void confirmaPedido(AdmLoja admLoja, Pedido pedido) {
		if(admLoja.getId() != null){
			Pedido pedidoAConfirmar = procuraPedidoPorId(pedido.getId());
			if(pedidoAConfirmar != null){
				pedidoAConfirmar.setStatus(PedidoStatus.CONFIRMADO);
				salvar(pedidoAConfirmar);
			}else{
				System.out.println("Pedido não encontrado!");
			}
		}
	}

	public void salvar(Pedido pedido) {

		if(pedido.getId() == null){
			this.idPedido++;
			pedido.setId(this.idPedido);
			listaDePedidos.put(this.idPedido, pedido);
		}else{
			listaDePedidos.put(pedido.getId(), pedido);
		}
		
	}

	public void pedidoEntregue(AdmLoja admLoja, Pedido pedido) {
		
		if(admLoja.getId() != null){
			Pedido pedidoEntregue = procuraPedidoPorId(pedido.getId());
			if(pedidoEntregue != null){
				pedidoEntregue.setStatus(PedidoStatus.ENTREGUE);
				salvar(pedidoEntregue);
			}else{
				System.out.println("Pedido não encontrado!");
			}
		}
		
	}

	public void pedidoEmPreparo(AdmLoja admLoja, Pedido pedido) {
	
		if(admLoja.getId() != null){
			Pedido pedidoEntregue = procuraPedidoPorId(pedido.getId());
			if(pedidoEntregue != null){
				pedidoEntregue.setStatus(PedidoStatus.EM_PREPARO);
				salvar(pedidoEntregue);
			}else{
				System.out.println("Pedido não encontrado!");
			}
		}
	}

	public void pedidoFinalizado(AdmLoja admLoja, Pedido pedido) {
	
		if(admLoja.getId() != null){
			Pedido pedidoEntregue = procuraPedidoPorId(pedido.getId());
			if(pedidoEntregue != null){
				pedidoEntregue.setStatus(PedidoStatus.FINALIZADO);
				salvar(pedidoEntregue);
			}else{
				System.out.println("Pedido não encontrado!");
			}
		}
	}

}

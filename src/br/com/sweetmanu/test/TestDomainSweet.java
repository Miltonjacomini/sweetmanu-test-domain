package br.com.sweetmanu.test;

import java.util.List;

import br.com.sweetmanu.dao.PedidoDAO;
import br.com.sweetmanu.modelos.AdmLoja;
import br.com.sweetmanu.modelos.Cliente;
import br.com.sweetmanu.modelos.Pedido;
import br.com.sweetmanu.modelos.PedidoStatus;
import br.com.sweetmanu.modelos.Produto;
import br.com.sweetmanu.modelos.ProdutoTipo;

public class TestDomainSweet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cliente cliente = new Cliente("Milton J. Neto", "36613354805");
		
		ProdutoTipo tipoBolo = new ProdutoTipo("Bolo");
		ProdutoTipo tipoBemCasado = new ProdutoTipo("Bem casado");
		ProdutoTipo tipoBrigadeiro = new ProdutoTipo("Brigadeiro");
		ProdutoTipo tipoBrigadeiroGourmet = new ProdutoTipo("Brigadeiro Gourmet");
		
		Produto bolo = new Produto("Bolo" , tipoBolo);
		Produto bemCasado = new Produto("Bem casado", tipoBemCasado);
		Produto brigadeiro = new Produto("Brigadeiro", tipoBrigadeiro);
		Produto brigadeiroGourmet = new Produto("Brigadeiro Gourmet", tipoBrigadeiroGourmet);
		
		Pedido encomenda1 = new Pedido(cliente);
		encomenda1.addProduto(bolo);
		encomenda1.addProduto(bemCasado);
		
		Pedido encomenda2 = new Pedido(cliente);
		encomenda2.addProduto(brigadeiro);
		encomenda2.addProduto(brigadeiroGourmet);
		
		PedidoDAO pedidoDAO = new PedidoDAO();

		pedidoDAO.enviarPedido(cliente, encomenda1);
		pedidoDAO.enviarPedido(cliente, encomenda2);
		
		AdmLoja manuela = new AdmLoja("Manuela", "33402920122");
		List<Pedido> pedidosRecebidos = pedidoDAO.listaPedidosByStatus(PedidoStatus.ENVIADO);
		pedidoDAO.confirmaPedido(manuela, pedidosRecebidos.get(0));

		System.out.println("Adm Pedidos Confirmados" + pedidoDAO.listaPedidosByStatus(PedidoStatus.CONFIRMADO));
		System.out.println("Adm Pedidos A Confirmar:" + pedidoDAO.listaPedidosByStatus(PedidoStatus.ENVIADO));
		
		System.out.println("Cliente pedidosSendoPreparados:" + pedidoDAO.listaPedidosByStatus(PedidoStatus.EM_PREPARO));
		System.out.println("Cliente pedidosRealizados:" + pedidoDAO.listaPedidosByStatus(PedidoStatus.FINALIZADO));
		System.out.println("Cliente pedidosRecebidos:" + pedidoDAO.listaPedidosByStatus(PedidoStatus.ENTREGUE));
		
		pedidoDAO.pedidoEntregue(manuela, encomenda1);
		
		System.out.println("Adm Pedidos Confirmados" + pedidoDAO.listaPedidosByStatus(PedidoStatus.ENTREGUE));
		
		System.out.println("Cliente pedidosRecebidos:" + pedidoDAO.listaPedidosByStatus(PedidoStatus.ENTREGUE));
		
	}

}

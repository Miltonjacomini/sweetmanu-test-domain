package br.com.sweetmanu.test;

import java.util.List;

import br.com.sweetmanu.dao.AdmLojaDAO;
import br.com.sweetmanu.dao.ClienteDAO;
import br.com.sweetmanu.dao.PedidoDAO;
import br.com.sweetmanu.dao.ProdutoDAO;
import br.com.sweetmanu.dao.ProdutoTipoDAO;
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
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente);
		
		ProdutoTipoDAO tipoDAO = new ProdutoTipoDAO();
		ProdutoTipo tipoBolo = new ProdutoTipo("Bolo"); 
		tipoDAO.salvar(tipoBolo);
		ProdutoTipo tipoBemCasado = new ProdutoTipo("Bem casado"); 
		tipoDAO.salvar(tipoBemCasado);
		ProdutoTipo tipoBrigadeiro = new ProdutoTipo("Brigadeiro"); 
		tipoDAO.salvar(tipoBrigadeiro);
		ProdutoTipo tipoBrigadeiroGourmet = new ProdutoTipo("Brigadeiro Gourmet"); 
		tipoDAO.salvar(tipoBrigadeiroGourmet);
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto bolo = new Produto("Bolo" , tipoBolo);
		produtoDAO.salvar(bolo);
		Produto bemCasado = new Produto("Bem casado", tipoBemCasado);
		produtoDAO.salvar(bemCasado);
		Produto brigadeiro = new Produto("Brigadeiro", tipoBrigadeiro);
		produtoDAO.salvar(brigadeiro);
		Produto brigadeiroGourmet = new Produto("Brigadeiro Gourmet", tipoBrigadeiroGourmet);
		produtoDAO.salvar(brigadeiroGourmet);
		
		Pedido encomenda1 = new Pedido(cliente);
		encomenda1.addProduto(bolo);
		encomenda1.addProduto(bemCasado);
		
		Pedido encomenda2 = new Pedido(cliente);
		encomenda2.addProduto(brigadeiro);
		encomenda2.addProduto(brigadeiroGourmet);
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		pedidoDAO.enviarPedido(encomenda1);
		pedidoDAO.enviarPedido(encomenda2);
		
		AdmLojaDAO admLojaDAO = new AdmLojaDAO();
		AdmLoja manuela = new AdmLoja("Manuela", "33402920122");
		admLojaDAO.salvar(manuela);
		
		List<Pedido> pedidosRecebidos = pedidoDAO.listaPedidosByStatus(PedidoStatus.ENVIADO);
		pedidoDAO.confirmaPedido(manuela, pedidosRecebidos.get(0));

		System.out.println(" ------------------------------LISTAGEM PARA O ADM ------------------------------------------");
		System.out.println("Pedidos Confirmados: \n" + pedidoDAO.listaPedidosByStatus(PedidoStatus.CONFIRMADO));
		System.out.println("Pedidos A Confirmar: \n" + pedidoDAO.listaPedidosByStatus(PedidoStatus.ENVIADO));
		
		System.out.println(" ------------------------------LISTAGEM PARA O CLIENTE --------------------------------------");
		System.out.println("Pedidos sendo preparados: \n" + pedidoDAO.listaPedidosByStatus(PedidoStatus.EM_PREPARO));
		System.out.println("Pedidos finalizados: \n" + pedidoDAO.listaPedidosByStatus(PedidoStatus.FINALIZADO));
		System.out.println("Pedidos entregues: \n" + pedidoDAO.listaPedidosByStatus(PedidoStatus.ENTREGUE));
		System.out.println(" ---------------------------------------------------------------------------------------------");
		
		pedidoDAO.pedidoEmPreparo(manuela, encomenda1);
		System.out.println(" ------------------------------ PEDIDO EM PREPARO --------------------------------------------");
		System.out.println("Cliente pedidosSendoPreparados: \n" + pedidoDAO.listaPedidosByStatus(PedidoStatus.EM_PREPARO));
		
		pedidoDAO.pedidoFinalizado(manuela, encomenda1);
		System.out.println(" ------------------------------ PEDIDO FINALIZADO --------------------------------------------");
		System.out.println("Pedidos finalizados: \n" + pedidoDAO.listaPedidosByStatus(PedidoStatus.FINALIZADO));
		
		pedidoDAO.pedidoEntregue(manuela, encomenda1);
		System.out.println(" ------------------------------ PEDIDO ENTREGUE ----------------------------------------------");
		System.out.println("Cliente pedidos entregues: \n" + pedidoDAO.listaPedidosByStatus(PedidoStatus.ENTREGUE));
		
		
	}

}

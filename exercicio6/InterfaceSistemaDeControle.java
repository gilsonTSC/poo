package Exercicio06;

import java.util.List;

public interface InterfaceSistemaDeControle {

	void adicionaPedido(Pedido p);
	
	List<Pedido> pesquisaPedidosIncluindoProduto(String codProduto) throws PedidoInexistenteException;
	
	void removePedido(long numPedido) throws PedidoInexistenteException;
}

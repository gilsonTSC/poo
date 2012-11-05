package Sondagem;

import java.util.List;

public interface InterfaceSistemaDeControle {

	void adicionaPedido(Pedido p);
	
	List<Pedido> pesquisaPedidosIncluindoProduto(long codProduto);
	
	void removePedido(long numPedido);
}

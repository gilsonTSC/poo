package br.ufpb.sistemapedidos;
import java.util.List;
/**
 * A interface tem os métodos basicos para um sistema de controle.
 * @author gilson.
 */
public interface InterfaceSistemaDeControle {
	/**
	 * método para adiciona um pedido.
	 * @param pedido objeto Pedido a ser adicionado.
	 */
	public void adicionaPedido(Pedido pedido);
	/**
	 * método que pesquisa pedidos utilizando o código do produto.
	 * @param codProduto recebe um código do produto do tipo String.
	 * @return uma lista do tipo Pedido.
	 */
	public List<Pedido> pesquisaPedidosIncluindoProduto(String codProduto);
	/**
	 * método para remove um pedido.
	 * @param numPedido recebe o número do pedido do tipo long à ser removido.
	 */
	public void removePedido(long numPedido);
}

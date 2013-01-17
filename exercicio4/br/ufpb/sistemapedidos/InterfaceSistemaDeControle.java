package br.ufpb.sistemapedidos;
import java.util.List;
/**
 * A interface tem os m�todos basicos para um sistema de controle.
 * @author gilson.
 */
public interface InterfaceSistemaDeControle {
	/**
	 * m�todo para adiciona um pedido.
	 * @param pedido objeto Pedido a ser adicionado.
	 */
	public void adicionaPedido(Pedido pedido);
	/**
	 * m�todo que pesquisa pedidos utilizando o c�digo do produto.
	 * @param codProduto recebe um c�digo do produto do tipo String.
	 * @return uma lista do tipo Pedido.
	 */
	public List<Pedido> pesquisaPedidosIncluindoProduto(String codProduto);
	/**
	 * m�todo para remove um pedido.
	 * @param numPedido recebe o n�mero do pedido do tipo long � ser removido.
	 */
	public void removePedido(long numPedido);
}

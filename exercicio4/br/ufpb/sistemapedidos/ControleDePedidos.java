package br.ufpb.sistemapedidos;
import java.util.List;
import java.util.ArrayList;

/**
 * Classe que implementa a InterfaceSistemaDeControle para controla uma lista de pedidos.
 * @author gilson.
 */
public class ControleDePedidos implements InterfaceSistemaDeControle {

	private List<Pedido> pedidos;
	/**
	 * Construtor para inicializa a lista de pedidos.
	 */
	public ControleDePedidos(){
		this.pedidos = new ArrayList<Pedido>();
	}
	/**
	 * @param nomeCliente do tipo string para localiza o cliente na lista
	 * e calcula a quantidade de pedidos do cliente.
	 * @return a quantidade de pedidos do cliente.
	 */
	public int calculaQuantidadeDePedidosDoCliente(String nomeCliente){
		int cont = 0;
		for(Pedido p : this.pedidos){
			if(p.getCliente().getNome().equals(nomeCliente)){
				cont ++;
			}
		}
		return cont;
	}
	/**
	 * Este método recebe um Pedido e adiciona a lista pedidos. 
	 * @param pedido do tipo Pedido.
	 */
	public void adicionaPedido(Pedido pedido){
		this.pedidos.add(pedido);
	}
	/**
	 * Este método pesquisa pedidos utilizando o código do produto 
	 * @param recebe um string que é o código do produto.
	 * @return Retorna uma lista do tipo Pedido.
	 */
	public List<Pedido> pesquisaPedidosIncluindoProduto(String codProduto){
		List<Pedido> pesquisa = new ArrayList<Pedido>();
		for(Pedido p : this.pedidos){
			for(ItemDePedido i : p.getItens()){
				if(i.getCodProduto().equals(codProduto)){
					pesquisa.add(p);
				}
			}
		}
		return pesquisa;
	}
	/**
	 * Este método remove um pedido.
	 * @param numPedido que é o número do pedido para ser removido
	 * da lista de pedidos.
	 */
	public void removePedido(long numPedido){
		for(Pedido p : this.pedidos){
			if(p.getNumeroDoPedido() == numPedido){
				this.pedidos.remove(p);
				break;
			}
		}
	}
}
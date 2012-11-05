package Sondagem;

import java.util.ArrayList;
import java.util.List;

public class ControleDePedidos implements InterfaceSistemaDeControle{

	private List<Pedido> pedidos;
	
	public ControleDePedidos(){
		this.pedidos = new ArrayList<Pedido>();
	}
	public int calculaQuantidadeDePedidosDoCliente(String nome){
		int quant = 0;
		for(Pedido p : this.pedidos){
			if(p.getCliente().getNome().equals(nome)){
				quant ++;
			}
		}return quant;
	}
	public void adicionaPedido(Pedido p) {
		this.pedidos.add(p);
	}
	public List<Pedido> pesquisaPedidosIncluindoProduto(long codProduto) {
		List<Pedido> pedido = new ArrayList<Pedido>();
		for(Pedido p : this.pedidos){
			for(ItemDePedido i : p.getItens()){
				if(i.getCodProduto() == codProduto){
					pedido.add(p);
				}
			}
		}return pedido;
	}
	public void removePedido(long numPedido) {
		for(Pedido p : this.pedidos){
			if(p.getNumeroDoPedido() == numPedido){
				this.pedidos.remove(p);
			}
		}
	}
	public List<Pedido> getPedidos(){
		return this.pedidos;
	}
}

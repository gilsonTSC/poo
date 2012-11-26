package Exercicio06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ControleDePedidos implements InterfaceSistemaDeControle{

	private List<Pedido> pedidos = null;
	private GravadorDePedidos gravador;
	
	public ControleDePedidos(){
		this.gravador = new GravadorDePedidos();
		try {
			this.pedidos = this.gravador.lePedidos();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			this.pedidos = new ArrayList<Pedido>();
		}
	}
	public int calculaQuantidadeDePedidosDoCliente(String nome)throws PedidoInexistenteException{
		int quant = 0;
		for(Pedido p : this.pedidos){
			if(p.getCliente().getNome().equals(nome)){
				quant ++;
			}
		}
		if(quant == 0){
			throw new PedidoInexistenteException("Não existe pedido codigo: " + nome);
		}
		return quant;
	}
	public void adicionaPedido(Pedido p) {
		this.pedidos.add(p);
		salva();
	}
	public List<Pedido> pesquisaPedidosIncluindoProduto(String codProduto) throws PedidoInexistenteException{
		boolean achou = false;
		List<Pedido> pedido = new ArrayList<Pedido>();
		for(Pedido p : this.pedidos){
			for(ItemDePedido i : p.getItens()){
				if(i.getCodProduto().equals(codProduto)){
					pedido.add(p);
					achou = true;
				}
			}
		}
		if(achou){
			return pedido;
		}
		throw new PedidoInexistenteException("Não existe pedido codigo: " + codProduto);

	}
	public void removePedido(long numPedido) throws PedidoInexistenteException{
		boolean achou = false;
		for(Pedido p : this.pedidos){
			if(p.getNumeroDoPedido() == numPedido){
				achou = true;
				this.pedidos.remove(p);
				salva();
			}
		}
		if(!achou){
			throw new PedidoInexistenteException("Pedido não existe codigo: " + numPedido);
		}
	}
	public List<Pedido> getPedidos(){
		return this.pedidos;
	}
	public void salva(){
		try {
			this.gravador.gravaPedidos(this.pedidos);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
}

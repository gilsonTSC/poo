package br.ufpb.sistemapedidos;

public class ProgramaPrincipal {

	public static void main(String[]args){
		
		Pedido p1 = new Pedido(10);
		Pedido p2 = new Pedido(20);
		
		Cliente c1 = new Cliente();
		c1.setNome("Gilson");
		
		p1.setCliente(c1);
		p2.setCliente(c1);
		
		ControleDePedidos cont = new ControleDePedidos();
		cont.adicionaPedido(p1);
		cont.adicionaPedido(p2);
		
		if(cont.calculaQuantidadeDePedidosDoCliente(c1.getNome()) == 2){
			System.out.println("Programa correto!");
		}
		else{
			System.out.println("Programa incorreto!");
		}
		
	}
}

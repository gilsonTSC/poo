package Sondagem;

public class ControleMain {

	public static void main(String[] args){
		GravadorDePedidos gravador = new GravadorDePedidos();
		ControleDePedidos controle = new ControleDePedidos();
		
		Cliente cliente = new Cliente("gilson");
		
		Pedido p1 = new Pedido(1);
		Pedido p2 = new Pedido(2);
		
		ItemDePedido item = new ItemDePedido(1,1,1.0);
		
		p1.adicionaItem(item);
		
		p1.setCliente(cliente);
		p2.setCliente(cliente);
		
		controle.adicionaPedido(p1);
		controle.adicionaPedido(p2);
		if(controle.calculaQuantidadeDePedidosDoCliente("gilson") == 2){
			System.out.println("Programa correto");
		}else{
			System.out.println("Programa incorreto");
		}
		
		gravador.gravaPedidos(controle.getPedidos());
		
		for(Pedido p : gravador.lePedidos()){
			System.out.println(p.getCliente().getNome());
			System.out.println(p.getNumeroDoPedido());
		}
	}
}

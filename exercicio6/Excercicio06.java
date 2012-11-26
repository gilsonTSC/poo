package Exercicio06;

import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

public class Excercicio06 {

	public static void main(String[] args){
		
		ControleDePedidos controle = new ControleDePedidos();
		
		int entradaUsuario = 0;
		long cod = 0;
		String nome = new String();
		do{
			entradaUsuario = Integer.parseInt(JOptionPane.showInputDialog(" 1 - Adiciona Pedido \n 2 - Remover Pedido \n" +
										" 3 - Calcula Quantidade De Pedidos Do Cliente \n" +
										" 4 - Pesquisa Pedidos Incluindo Produto \n" +
										" 5 - Sair"));
			switch(entradaUsuario){
			case 1:
				int c = Integer.parseInt(JOptionPane.showInputDialog(" 1 - Adiciona um novo cliente \n 2 - Adiciona itens a um cliente"));
				if(c == 1){
					nome = JOptionPane.showInputDialog("Digite o nome do cliente");
					cod = Long.parseLong(JOptionPane.showInputDialog("Digite o número do pedido"));
					Pedido p = new Pedido(cod);
					p.setCliente(new Cliente(nome));
					controle.adicionaPedido(p);
				}else{
					nome = JOptionPane.showInputDialog("Digite o nome do cliente");
					boolean um = true;
					for(Pedido p : controle.getPedidos()){
						if(p.getCliente().getNome().equals(nome) & um){
							um = false;
							String codigo = JOptionPane.showInputDialog(null,"Informe o codigo do produto");
							int quant = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe a quantidade do produto"));
							double valor = Double.parseDouble(JOptionPane.showInputDialog(null,"Informe o valor unitario"));
							ItemDePedido item = new ItemDePedido(codigo,quant,valor);
							p.adicionaItem(item);
						}
					}
				}
				break;
			case 2:
				cod = Long.parseLong(JOptionPane.showInputDialog("Digite o codigo do produto"));
				try {
					controle.removePedido(cod);
				} catch (PedidoInexistenteException e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
				break;
			case 3:
				nome = JOptionPane.showInputDialog("Digite o nome do cliente");
				try{
					controle.calculaQuantidadeDePedidosDoCliente(nome);
				}catch(PedidoInexistenteException e){
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
				break;
			case 4:
				String codigoProduto = JOptionPane.showInputDialog("Digite o codigo do produto");
				try {
					List<Pedido> pedidos = controle.pesquisaPedidosIncluindoProduto(codigoProduto);
					for(Pedido pedido : pedidos){
						JOptionPane.showMessageDialog(null,"Nome: " + pedido.getCliente().getNome());
						for(ItemDePedido i : pedido.getItens()){
							JOptionPane.showMessageDialog(null,"Quantidade: " +i.getQuantidade() + "\n" + 
														  "Valor unitario: " + i.getValorUniterio());
						}
					}
				} catch (PedidoInexistenteException e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
				break;
			default:
				controle.salva();
			}
		}while(entradaUsuario != 5);
	}
}

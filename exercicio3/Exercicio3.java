package Sondagem;
import java.util.*;

public class Exercicio3 {

	public static void main(String[] args){
		
		Scanner s = new Scanner(System.in);
		
		Pedido pedido = new Pedido(1);
		int quant = 0;
		String codigo = new String();
		double valor = 0.0,total = 0.0;
		do{
			System.out.println("Informe o código do produto pedido:");
			codigo = s.next();
			if(Integer.parseInt(codigo) != 0){
				System.out.println("Informe a quantidade de itens:");
				quant = s.nextInt();
				System.out.println("Informe o valor unitário");
				valor = s.nextDouble();
			
				ItemDePedido item = new ItemDePedido(codigo,quant,valor);
				pedido.adicionaItem(item);
			}
		}while(Integer.parseInt(codigo) != 0);
		
		for(ItemDePedido item : pedido.getItens()){
			total += (item.getQuantidade() * item.getValorUniterio());
		}
		System.out.println("Valor total:R$ " + total);
	}
}

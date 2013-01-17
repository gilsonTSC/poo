package br.ufpb.sistemapedidos;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Exercicio3 {

	public static void main(String[]args){
		
		Scanner s = new Scanner(System.in);
		Pedido pedido = new Pedido(0);
		String cod = new String();
		
		do{
			System.out.println("Informe o código do produto pedido: ");
			cod = s.next();
			if(Integer.parseInt(cod)!= 0){
			
				System.out.println("Informe a quantidade desse item pedido: ");
				int quant = s.nextInt();
				System.out.println("Informe o valor unitário do item: ");
				double valor = s.nextDouble();
			
				ItemDePedido itp = new ItemDePedido(quant, cod , valor);
				pedido.adicionaItem(itp);
		
			}
			
					
		}while(Integer.parseInt(cod) != 0);
		double valorTotal = 0;
		for(ItemDePedido ped : pedido.getItens()){
			 
			valorTotal += (ped.getValorUnitario()*ped.getQuantidade());
		}
		System.out.println("Valor total: " + valorTotal);
	}
}

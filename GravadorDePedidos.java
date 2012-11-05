package Sondagem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GravadorDePedidos {

	private Charset utf8;
	private Path path;
	
	public GravadorDePedidos() {
		this.utf8 = StandardCharsets.UTF_8;
		this.path = Paths.get("C:/Pedido/clientes.txt");
		try {
			Files.createDirectories(path.getParent());
		} catch (IOException e) {
			e.printStackTrace();
			this.path = Paths.get("C:/Pedido/clientes.txt");
			System.out.println("Os dados não puderam ser lidos");
		}
	}
	public List<Pedido> lePedidos(){
		List<Pedido> pedidos = new ArrayList<Pedido>();
		try(BufferedReader reader = Files.newBufferedReader(this.path,this.utf8)){
			String linha = null;
			int cont = 0;
			long numPedido = 0,cod = 0;
			String nome = "";
			int quant = 0;
			double valor = 0.0;
			while((linha = reader.readLine()) != null){
				switch(cont){
				case 0:
					numPedido = Long.parseLong(linha);
					cont++;
					break;
				case 1:
					nome = linha;
					cont++;
					break;
				case 2:
					quant = Integer.parseInt(linha);
					cont++;
					break;
				case 3:
					cod = Long.parseLong(linha);
					cont++;
					break;
				case 4:
					valor = Double.parseDouble(linha);
					cont = 0;
					break;
				}
				Cliente cliente = new Cliente(nome);
				ItemDePedido item = new ItemDePedido(cod,quant,valor);
				Pedido p = new Pedido(numPedido);
				p.setCliente(cliente);
				p.adicionaItem(item);
				pedidos.add(p);
			}
		}catch(IOException e){
			e.printStackTrace();	
		}
		return pedidos;
	}
	public void gravaPedidos(List<Pedido> pedidos){
		try(BufferedWriter w = Files.newBufferedWriter(this.path, this.utf8)){
			for(Pedido p : pedidos){
				w.write(p.getNumeroDoPedido() + "\n");
				w.write(p.getCliente().getNome() + "\n");
				for(ItemDePedido i : p.getItens()){
					if(p.getItens().size() != 0){
						w.write(i.getQuantidade() + "\n");
						w.write(i.getCodProduto() + "\n");
						w.write(i.getValorUniterio() + "\n");
					}
				}
			}
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}

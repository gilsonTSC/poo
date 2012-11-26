package Exercicio06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class GravadorDePedidos {

	private boolean naoGravou,naoLeu;
	
	public GravadorDePedidos() {
		this.naoGravou = false;
		this.naoLeu = false;
	}
	public List<Pedido> lePedidos() throws IOException{
		ObjectInputStream in = null;
		List<Pedido> pedido = null;
		try{
			in = new ObjectInputStream(new FileInputStream("Pedidos.txt"));
			pedido = (List<Pedido>) in.readObject();
			return pedido;
		}catch(FileNotFoundException e){
			this.naoLeu = true;
			throw new IOException("Não foi possivel le o arquivo Pedidos.txt");
		} catch(IOException e){
			this.naoLeu = true;
			throw e;
		} catch(ClassNotFoundException e){
			this.naoLeu = true;
			throw new IOException("Classe dos objetos gravados no arquivo Pedidos.txt não existe ",e);
		} finally{
			if(in != null){
				in.close();
			}
		}
	}
	public void gravaPedidos(List<Pedido> pedidos) throws IOException{
		ObjectOutputStream out = null;
		try{
			out = new ObjectOutputStream(new FileOutputStream("Pedidos.txt"));
			out.writeObject(pedidos);
		}catch(FileNotFoundException e){
			this.naoGravou = true;
			throw new IOException("Não foi encontrado o arquivo Pedidos.txt");
		}catch(IOException e){
			this.naoGravou = true;
			throw e;
		}finally{
			if(out != null){
				out.close();
			}
		}
	}
	public void setNaoGravou(){
		this.naoGravou = false;
	}
	public boolean getNaoGravou(){
		return this.naoGravou;
	}
	public void setNaoLeu(boolean leu){
		this.naoLeu = leu;
	}
	public boolean getNaoLeu(){
		return this.naoLeu;
	}
}
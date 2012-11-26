package exercicio05;

import java.io.*;
import java.util.List;
import java.util.Map;

public class GravadorDeContatos {

	@SuppressWarnings("unchecked")
	public List<Contato> leContatos() throws IOException{
		ObjectInputStream in = null;
		List<Contato> list = null;
		try{
			in = new ObjectInputStream(new FileInputStream("contatos.txt"));
			list = (List<Contato>) in.readObject();
			return list;
		} catch(FileNotFoundException e){
			throw new IOException("Não foi encontrado o arquivo contatos");
		} catch(IOException e){
			throw e;
		} catch(ClassNotFoundException e){
			throw new IOException("Classe dos objetos gravados no arquivo contatos.txt não existe ",e);
		} finally{
			if(in != null){
				in.close();
			}
		}
	}
	public void gravaContatos(List<Contato> contatos) throws IOException{
		ObjectOutputStream out = null;
		try{
			out = new ObjectOutputStream(new FileOutputStream("contatos.txt"));
			out.writeObject(contatos);
		} catch(FileNotFoundException e){
			throw new IOException("Não foi encontrado o arquivo contatos.txt",e);
		} catch(IOException e){
			throw e;
		}finally{
			out.close();
		}
	}
	@SuppressWarnings("unchecked")
	public Map<String,Contato> leContatosMap() throws IOException{
		ObjectInputStream in = null;
		Map<String, Contato> map = null;
		try{
			in = new ObjectInputStream(new FileInputStream("contatosMap.txt"));
			map = (Map<String,Contato>) in.readObject();
			return map;
		} catch(FileNotFoundException e){
			throw new IOException("Não foi encontrado o arquivo contatos");
		} catch(IOException e){
			throw e;
		} catch(ClassNotFoundException e){
			throw new IOException("Classe dos objetos gravados no arquivo contatos.txt não existe ",e);
		} finally{
			if(in != null){
				in.close();
			}
		}
	}
	public void gravaContatos(Map<String,Contato> contatos) throws IOException{
		ObjectOutputStream out = null;
		try{
			out = new ObjectOutputStream(new FileOutputStream("contatosMap.txt"));
			out.writeObject(contatos);
		} catch(FileNotFoundException e){
			throw new IOException("Não foi encontrado o arquivo contatos.txt",e);
		} catch(IOException e){
			throw e;
		}finally{
			out.close();
		}
	}
}

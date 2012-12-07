package exercicio05;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import Exercicio06.Pedido;

public interface AgendaIF {

	void adicionarContato(String nome,String tel);
	
	void removerContato(String nome) throws ContatoInexistenteException;
	
	Contato pesquisaContato(String nomeContato) throws ContatoInexistenteException;
	
	Collection getContatos();
	
	Iterator getContatosOrdenados();
}

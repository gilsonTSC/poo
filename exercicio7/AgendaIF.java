package exercicio05;

import java.io.IOException;
import java.util.ArrayList;

import Exercicio06.Pedido;

public interface AgendaIF {

	void adicionarContato(String nome,String tel);
	
	void removerContato(String nome) throws ContatoInexistenteException,IOException;
	
	Contato pesquisaContato(String nomeContato) throws ContatoInexistenteException;
}



public interface AgendaIF {

	void adicionarContato(String nome,String tel);
	
	void removerContato(String nome) throws ContatoInexistenteException;
	
	Contato pesquisaContato(String nomeContato) throws ContatoInexistenteException;
}

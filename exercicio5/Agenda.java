
import java.util.*;
public class Agenda implements AgendaIF{

	private List<Contato> agenda;
	
	public Agenda(){
		this.agenda = new ArrayList<Contato>();
	}
	public void adicionarContato(String nome, String tel) {
		Contato c = new Contato(nome,tel);
		this.agenda.add(c);
	}
	public void removerContato(String nomeContato) throws ContatoInexistenteException {
		boolean achou = false;
		for(Contato c : this.agenda){
			if(c.getNome().equals(nomeContato)){
				this.agenda.remove(c);
				achou = true;
				break;
			}
		}
		
		if(!achou){
			throw new ContatoInexistenteException("Contato não cadastrado: " + nomeContato);
		}
	}
	public Contato pesquisaContato(String nomeContato) throws ContatoInexistenteException {
		for(Contato c : this.agenda){
			if(c.getNome().equals(nomeContato)){
				return c;
			}
		}
		throw new ContatoInexistenteException("Contato não cadastrado: " + nomeContato);
	}

}

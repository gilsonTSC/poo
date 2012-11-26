package exercicio05;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class AgendaMap implements AgendaIF{

	private Map<String,Contato> agenda;
	private GravadorDeContatos gravador;
	
	public AgendaMap(){
		this.gravador = new GravadorDeContatos();
		try{
			this.agenda = this.gravador.leContatosMap();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e.getMessage());
			this.agenda = new HashMap<String,Contato>();
		}
	}
	public void adicionarContatoMap(Contato contato) throws ContatoExistenteException,ContatoExistenteException{
		boolean achou = false;
		for(Contato c : this.agenda.values()){
			if(c.getNome().equals(contato.getNome())){
				throw new ContatoExistenteException("Contato já existente");
			}
		}
		if(!achou){
			this.agenda.put(contato.getNome(),contato);
		}
	}
	public void adicionarContato(String nome, String tel) {
		this.agenda.put(nome,new Contato(nome,tel));
	}
	public void removerContato(String nome) throws ContatoInexistenteException {
		boolean achou = false;
		for(Contato c : this.agenda.values()){
			if(c.getNome().equals(nome)){
				achou = true;
				throw new ContatoInexistenteException("contato inexistente " + nome);
			}
		}
		if(!achou){
			this.agenda.remove(nome);
		}
	}
	public Contato pesquisaContato(String nomeContato) throws ContatoInexistenteException {
		boolean achou = false;
		for(Contato c : this.agenda.values()){
			if(c.getNome().equals(nomeContato)){
				achou = true;
				return  this.agenda.get(nomeContato);
			}
		}
		throw new ContatoInexistenteException("contato inexistente " + nomeContato);
	}
	public void salva(){
		try {
			this.gravador.gravaContatos(this.agenda);
		} catch (IOException e) {
			System.err.println("Não salvou");
		}
	}
}

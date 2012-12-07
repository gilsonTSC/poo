package exercicio05;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
	/*public void adicionarContatoMap(Contato contato) throws ContatoExistenteException{
		boolean achou = false;
		for(Contato c : this.agenda.values()){
			if(c.getNome().equals(contato.getNome())){
				achou = true;
				throw new ContatoExistenteException("Contato já existente");
			}
		}
		if(achou){
			this.agenda.put(contato.getNome(),contato);
		}
	}*/
	public void adicionarContato(String nome, String tel) {
		if(this.agenda.containsKey(nome)){
			this.agenda.get(nome).setTelefone(tel);
		}else{
			this.agenda.put(nome,new Contato(nome,tel));
		}
		try {
			this.gravador.gravaContatos(this.agenda);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	public void removerContato(String nome) throws ContatoInexistenteException {
		boolean achou = false;
		for(Contato c : this.agenda.values()){
			if(c.getNome().equals(nome)){
				achou = true;
				this.agenda.remove(nome);
				try {
					this.gravador.gravaContatos(this.agenda);
				} catch (IOException e) {
					System.err.println(e.getMessage());
				}
			}
		}
		if(!achou){
			throw new ContatoInexistenteException("contato inexistente " + nome);
		}
	}
	public Contato pesquisaContato(String nomeContato) throws ContatoInexistenteException {
		if(this.agenda.containsKey(nomeContato)){
			return this.agenda.get(nomeContato);
		}
		throw new ContatoInexistenteException("contato inexistente " + nomeContato);
	}
	public Collection<Contato> getContatos() {
		List<Contato> c = new ArrayList<Contato>();
		c.addAll(this.agenda.values());
		return c;
	}
	public Iterator<Contato> getContatosOrdenados() {
		List<Contato> c = new ArrayList<Contato>();
		c.addAll(this.agenda.values());
		Collections.sort(c);
		return c.iterator();
	}
}

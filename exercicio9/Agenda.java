package exercicio05;
import java.io.IOException;
import java.util.*;

import javax.swing.JOptionPane;
public class Agenda implements AgendaIF{

	private List<Contato> agenda;
	private GravadorDeContatos contatos;
	
	public Agenda(){
		this.contatos = new GravadorDeContatos();
		try {
			this.agenda = this.contatos.leContatos();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			this.agenda = new ArrayList<>();
		}
	}
	public void adicionarContato(String nome, String tel) {
		for(Contato c : this.agenda){
			if(c != null){
				if(c.getNome().equals(nome)){
					c.setTelefone(tel);
					return;
				}
			}
		}
		Contato c = new Contato(nome,tel);
		this.agenda.add(c);
		try {
			this.contatos.gravaContatos(this.agenda);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	public void removerContato(String nomeContato) throws ContatoInexistenteException {
		boolean achou = false;
		for(Contato c : this.agenda){
			if(c.getNome().equals(nomeContato)){
				this.agenda.remove(c);
				try {
					this.contatos.gravaContatos(this.agenda);
				} catch (IOException e) {
					System.err.println(e.getMessage());
				}
				achou = true;
				break;
			}
		}
		try {
			this.contatos.gravaContatos(this.agenda);
		} catch (IOException e) {
			System.err.println(e.getMessage());
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
	/*public void salva() throws IOException{
		this.contatos.gravaContatos(this.agenda);
	}*/
	public Collection<Contato> getContatos() {
		Collection<Contato> contato = new ArrayList<>();
		contato.addAll(this.agenda);
		return contato;
	}
	public Iterator<Contato> getContatosOrdenados() {
		Collections.sort(this.agenda);
		return this.agenda.iterator();
	}
}

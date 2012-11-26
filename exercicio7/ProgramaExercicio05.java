package exercicio05;

import java.io.IOException;

public class ProgramaExercicio05 {

	public static void main(String[] args){
		
		Agenda agenda = new Agenda();
		
		
		agenda.adicionarContato("gilson", "2222-2222");
		
		try {
			
				agenda.removerContato("gilson");
		}catch (IOException e) {
			System.err.println(e.getMessage());
		} catch (ContatoInexistenteException e) {
			System.err.println(e.getMessage());
		}
		
		try {
			agenda.removerContato("joão");
		}catch (IOException e) {
			System.err.println(e.getMessage());
		}catch (ContatoInexistenteException e) {
			System.err.println(e.getMessage());
		}
		
		try {
			agenda.pesquisaContato("joão");
		} catch (ContatoInexistenteException e) {
			System.err.println(e.getMessage());
		}
		
		try {
			agenda.pesquisaContato("gilson");
		} catch (ContatoInexistenteException e) {
			System.err.println(e.getMessage());
		}
	}
}

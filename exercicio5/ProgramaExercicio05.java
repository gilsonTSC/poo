

public class ProgramaExercicio05 {

	public static void main(String[] args){
		
		Agenda agenda = new Agenda();
		
		agenda.adicionarContato("gilson", "2222-2222");
		
		try {
			agenda.removerContato("gilson");
		} catch (ContatoInexistenteException e) {
			System.err.println(e.getMessage());
		}
		
		try {
			agenda.removerContato("jo�o");
		} catch (ContatoInexistenteException e) {
			System.err.println(e.getMessage());
		}
		
		try {
			agenda.pesquisaContato("jo�o");
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

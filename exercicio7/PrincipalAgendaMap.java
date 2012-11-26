package exercicio05;

import java.io.IOException;

import javax.swing.JOptionPane;

public class PrincipalAgendaMap {

	public static void main(String[] args){
		int i = 0;
		AgendaMap agenda = new AgendaMap();
		String nome = new String(),tel = new String();
		
		do{
			i = Integer.parseInt(JOptionPane.showInputDialog(null," 1 - Adiciona " + "\n" + " 2 - Remover \n" + " 3 - Consultar Contatos \n" + " 4 - Sair"));
			switch(i){
			case 1:
				nome = JOptionPane.showInputDialog(null,"Informe o nome do contato");
				tel = JOptionPane.showInputDialog(null,"Informe o telefone do contato");
				try {
					agenda.adicionarContatoMap(new Contato(nome,tel));
				} catch (ContatoExistenteException e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
				break;
			case 2:
				nome = JOptionPane.showInputDialog(null,"Informe o nome do contato");
				try {
						agenda.removerContato(nome);
				}catch (ContatoInexistenteException e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
				}catch(Exception e){
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
				break;
			case 3:
				try {
					Contato c = agenda.pesquisaContato(JOptionPane.showInputDialog(null,"Informe o nome do contato"));
					JOptionPane.showMessageDialog(null,"Nome: " + c.getNome() + "\n" + "Telefone: " + c.getTelefone());
				} catch (ContatoInexistenteException e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
				break;
			case 4:
				agenda.salva();
				break;
			}
		}while(i != 4);
	}
}

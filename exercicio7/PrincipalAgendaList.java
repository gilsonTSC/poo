package exercicio05;

import java.io.IOException;

import javax.swing.JOptionPane;

public class PrincipalAgendaList {
	
	public static void main(String[] args){
		int i = 0;
		Agenda agenda = new Agenda();
		String nome = new String(),tel = new String();
		
		do{
			i = Integer.parseInt(JOptionPane.showInputDialog(null," 1 - Adiciona " + "\n" + " 2 - Remover \n" + " 3 - Consultar Contatos \n" + " 4 - Sair"));
			switch(i){
			case 1:
				nome = JOptionPane.showInputDialog(null,"Informe o nome do contato");
				tel = JOptionPane.showInputDialog(null,"Informe o telefone do contato");
				agenda.adicionarContato(nome,tel);
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
				try {
					agenda.salva();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
				break;
			}
		}while(i != 4);
	}
	
}

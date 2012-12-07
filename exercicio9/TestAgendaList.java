package exercicio05;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.junit.*;
import org.junit.Test;


public class TestAgendaList {

	private Agenda agenda;
	
	@Before
	public void setUp(){
		this.agenda = new Agenda();
	}
	@After
	public void tearDown(){
		File file = new File("contatos.txt");
		if(file.exists()){
			file.delete();
		}
	}
	@Test
	public void adicionarContatoTest() {
		
		this.agenda.adicionarContato("gilson","91512643");
		this.agenda.adicionarContato("gilson","81818181");
		try {
			Contato c = this.agenda.pesquisaContato("gilson");
			assertTrue("81818181".equals(c.getTelefone()));
		} catch (ContatoInexistenteException e) {
			fail("não deveria lança exceção");
		}
		
	}
	@Test
	public void removerTest(){
		this.agenda.adicionarContato("gilson","333");
		try{
			this.agenda.removerContato("gilson");
			//OK
		}catch(ContatoInexistenteException e){
			fail("não deveria lança exceção");
		}
		try{
			this.agenda.pesquisaContato("gilson");
			fail("Deveria ter lançado a exceção");
		}catch(ContatoInexistenteException e){
			//OK
		}
	}
	@Test
	public void pesquisaContatoTest(){
		this.agenda.adicionarContato("gilson","222");
		try{
			assertEquals("gilson",this.agenda.pesquisaContato("gilson").getNome());
			assertEquals("222",this.agenda.pesquisaContato("gilson").getTelefone());
			//OK
		}catch(ContatoInexistenteException e){
			fail("não deveria lança a exceção");
		}
		try {
			this.agenda.removerContato("gilson");
		} catch (ContatoInexistenteException e) {
			fail("não deveria lança a exceção");
		}
		try{
			this.agenda.pesquisaContato("gilson");
			fail("não deveria lança a exceção");
		}catch(ContatoInexistenteException e){
			//OK
		}
	}
	@Test
	public void getContatosTest(){
		this.agenda.adicionarContato("gilson","222");
		this.agenda.adicionarContato("italo","333");
		assertTrue(this.agenda.getContatos().size() == 2);
		List<Contato> list = (List<Contato>) this.agenda.getContatos();
		assertEquals("gilson",list.get(0).getNome());
		assertEquals("222",list.get(0).getTelefone());
	}
	@Test
	public void getContatosOrdenados(){
		this.agenda.adicionarContato("gilson","222");
		this.agenda.adicionarContato("alisson","444");
		Iterator<Contato> i = this.agenda.getContatosOrdenados();
		boolean achou = true;
		while(i.hasNext()){
			Contato c = i.next();
			if(achou){
				assertEquals("alisson",c.getNome());
				assertEquals("444",c.getTelefone());
				achou = false;
			}else{
				assertEquals("gilson",c.getNome());
				assertEquals("222",c.getTelefone());
			}
		}
	}
}
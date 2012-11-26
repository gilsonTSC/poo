package exercicio05;

import java.io.Serializable;

public class Contato implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nome,telefone;
	
	public Contato(){
		this("","");
	}
	public Contato(String nome,String tel){
		this.nome = nome;
		this.telefone = tel;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	public String getNome(){
		return this.nome;
	}
	public void setTelefone(String tel){
		this.telefone = tel;
	}
	public String getTelefone(){
		return this.telefone;
	}
}

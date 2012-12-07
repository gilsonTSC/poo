package exercicio05;

import java.io.Serializable;

public class Contato implements Serializable,Comparable<Contato>{

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
	public String toString(){
		return "Nome: " + this.nome + " Telefone: " + this.telefone + "\n";
	}
	public int compareTo(Contato o) {
		if(this.nome.compareTo(o.getNome()) == 0){
			return 0;
		}else if(this.nome.compareTo(o.getNome()) < 0){
			return -1;
		}else{
			return 1;
		}
	}
}

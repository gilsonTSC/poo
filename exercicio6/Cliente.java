package Exercicio06;

import java.io.Serializable;

public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nome;
	
	public Cliente(){
		this("");
	}
	public Cliente(String nome){
		this.nome = nome;
	}
	public String getNome(){
		return this.nome;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
}
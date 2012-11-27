package exercicio05;

public class Pessoa {

	private String nome;
	private int idade;
	
	public Pessoa(String nome,int idade){
		this.nome = nome;
		this.idade = idade;
	}
	public String getNome(){
		return this.nome;
	}
	public int getIdade(){
		return this.idade;
	}
	public int compareTo(Pessoa p){
		if(this.nome.compareTo(p.getNome()) == 0 & this.idade == p.getIdade()){
			return 0;
		}else if(this.nome.compareTo(p.getNome()) < 0){
			return -1;
		}else{
			return 1;
		}
	}
	public boolean equals(Object o){
		if(!(o instanceof Pessoa)){
			return false;
		}else{
			Pessoa p = (Pessoa) o;
			if(this.nome.equals(p.getNome()) & this.idade == p.getIdade()){
				return true;
			}
		}
		return false;
	}
	public String toString(){
		return "Nome: " + this.nome + "\n" + "Idade: " + this.idade;
	}
}

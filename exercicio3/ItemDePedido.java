package Sondagem;

public class ItemDePedido {
	
	private int quantidade;
	private String codProduto;
	private double valorUnitario;
	
	public ItemDePedido(String cod,int quant,double valor){
		this.quantidade = quant;
		this.codProduto = cod;
		this.valorUnitario = valor;
	}
	public int getQuantidade(){
		return this.quantidade;
	}
	public void setQuantidade(int quantidade){
		this.quantidade = quantidade;
	}
	public String getCodProduto(){
		return this.codProduto;
	}
	public void setCodProduto(String codProduto){
		this.codProduto = codProduto;
	}
	public double getValorUniterio(){
		return this.valorUnitario;
	}
	public void setValorUnitario(double valorUnitario){
		this.valorUnitario = valorUnitario;
	}
}

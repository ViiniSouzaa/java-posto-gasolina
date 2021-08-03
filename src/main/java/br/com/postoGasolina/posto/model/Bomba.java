package br.com.postoGasolina.posto.model;

public class Bomba {
	
	private Combustivel combustivel;
	private double preco;
	private double totalAbastecido = 0;
	private int litroPorMinuto;

	/*Construtor*/
	
	public Bomba(Combustivel combustivel, double preco, int litroPorMinuto) {
		this.combustivel = combustivel;
		this.preco = preco;
		this.litroPorMinuto = litroPorMinuto;
	}
	
	/*Getters e Setters*/
	public Combustivel getCombustivel() {
		return combustivel;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public double getTotalAbastecido() {
		return totalAbastecido;
	}
	
	public int getLitroPorMinuto() {
		return litroPorMinuto;
	}
	
	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public void setTotalAbastecido(double totalAbastecido) {
		this.totalAbastecido += totalAbastecido;
	}
}

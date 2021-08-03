package br.com.postoGasolina.posto.model;

public class Carro {
	private String modelo;
	private String placa;
	private double consumoEtanol;
	private double consumoGasolina;
	private int capacidadeTanque;
	
	
	/*Construtor*/
	public Carro(String modelo, String placa, double consumoEtanol, double consumoGasolina, int capacidadeTanque) {
		this.modelo = modelo;
		this.placa = placa;
		this.consumoEtanol = consumoEtanol;
		this.consumoGasolina = consumoGasolina;
		this.capacidadeTanque = capacidadeTanque;
	}
	
	/*Getters e Setter*/
	public String getModelo() {
		return modelo;
	}
	
	public String getPlaca() {
		return placa;
	}

	public double getConsumoEtanol() {
		return consumoEtanol;
	}
	
	public double getConsumoGasolina() {
		return consumoGasolina;
	}
	
	public int getCapacidadeTanque() {
		return capacidadeTanque;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public void setConsumoEtanol(double consumoEtanol) {
		this.consumoEtanol = consumoEtanol;
	}
	
	public void setConsumoGasolina(double consumoGasolina) {
		this.consumoGasolina = consumoGasolina;
	}
	
	public void setCapacidadeTanque(int capacidadeTanque) {
		this.capacidadeTanque = capacidadeTanque;
	}
}

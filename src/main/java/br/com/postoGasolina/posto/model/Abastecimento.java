package br.com.postoGasolina.posto.model;

import java.util.List;
import java.util.stream.Collectors;

public class Abastecimento {
	private long ID;
	private Carro carro;
	private List<Bomba> bombas;
	
	public Abastecimento(Carro carro, List<Bomba> bombas, long ID) {
		this.bombas = bombas;
		this.carro = carro;
		this.ID = ID;
	}
	/*	
	 	Aqui está sendo feita a comparação de qual combustivel está sendo mais
	 	eficiente em cada veiculo, através da chamada do método MediaKM_Real,
	 	onde quando determinado qual combustivel é mais eficiente, se encaminha
	 	para a bomba especificada.
	*/
	public Combustivel CalculaMelhorCombustivel() {
		double mediaGasolina = MediaKM_Real(carro.getConsumoGasolina(), 
                                                    bombas
                    					.stream()
                                        		.filter(b -> b.getCombustivel().equals(Combustivel.GASOLINA))
							.collect(Collectors.toList())
							.get(0).getPreco(), 
                                                    carro.getCapacidadeTanque());
		double mediaEtanol = MediaKM_Real(  carro.getConsumoEtanol(), 
                                                    bombas
							.stream()
							.filter(b -> b.getCombustivel().equals(Combustivel.ETANOL))
							.collect(Collectors.toList())
							.get(0).getPreco(),
                                                    carro.getCapacidadeTanque());
		
		if(mediaGasolina > mediaEtanol){
			return Combustivel.GASOLINA;
		}else {
			return Combustivel.ETANOL;
		}
		
	}
	/*
	 	Aqui é onde é calculado a eficiencia de cada combustivel para cada 
	 	veiculo. a conta é feita levando em conta quantos quilometros o carro
	 	andará com tanque cheio e quanto será gasto para encher o tanque,
	 	retornando um valor de quantos quilometros o veiculo fará por real de 
	 	combustivel.
	 */
	private double MediaKM_Real(double consumoCombustivel, double precoCombustivel, int CapacidadeTanque){
		return (consumoCombustivel*CapacidadeTanque)/(precoCombustivel*CapacidadeTanque);
	}
}

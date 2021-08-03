package br.com.postoGasolina.posto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Relatorio {
	private List<Bomba> bombas;
	private List<Abastecimento> abastecimentos;
	private String relatorioAbastecimento;
	private String resumoRelatorio;
	private int hora;
	private int minutos;

	/*Construtor*/
	public Relatorio(List<Bomba> bombas) {
		super();
		this.bombas = bombas;
		this.abastecimentos = new ArrayList<Abastecimento>();
		this.relatorioAbastecimento = "";
		this.resumoRelatorio = "";
		this.hora = 0;
		this.minutos = 0;
	}	

	/*Getters e Setters*/
	public String getRelatorioAbastecimento() {
		return relatorioAbastecimento;
	}

	public String getResumoRelatorio() {
		return resumoRelatorio;
	}	

	public void setRelatorioAbastecimento(String relatorioAbastecimento) {
		this.relatorioAbastecimento +=  relatorioAbastecimento + "\n";
	}
	
	public void setResumoRelatorio(String resumoRelatorio) {
		this.resumoRelatorio = resumoRelatorio + "\n";
	}
	
	public List<Bomba> getBombas() {
		return bombas;
	}

	/*
	 	Aqui é feita a manipulação do horario de abastecimento dos veiculos.
	 */
	private void manipulaHora(int tempo) {
		minutos += tempo;
		if(minutos >= 60) {
			hora++;
			minutos -=60;
		}
	}
	
	/*
	  	Aqui é adicionado a lista de abastecimento cada abastecimento feito no
	  	posto, onde somente recebe como dado o Carro e com isso, chama os metodos
	  	necessarios para se saber para onde cada veiculo vai ser redirecionado.
	  	Tambem a cada abastecimento os relatórios são atualizados.
	*/
	public void addAbastecimento(Carro c) {
		abastecimentos.add(new Abastecimento(c, bombas, abastecimentos.size()));
			switch(abastecimentos.get(abastecimentos.size()-1).CalculaMelhorCombustivel()) {
				case GASOLINA:
					Bomba gasolina = bombas
									.stream()
									.filter(b -> b.getCombustivel()
									.equals(Combustivel.GASOLINA))
									.collect(Collectors.toList())
									.get(0);
					
					for(Bomba b : bombas) {
						if(b == gasolina) {
							b.setTotalAbastecido(c.getCapacidadeTanque());
						}
					}
					manipulaHora(1 + ((int) c.getCapacidadeTanque() / gasolina.getLitroPorMinuto()));
					setRelatorioAbastecimento(criaRelatorioAbastecimento(c,gasolina));
					setResumoRelatorio(criaResumoRelatorio());
					break;
				case ETANOL:
					Bomba etanol = bombas
									.stream()
									.filter(b -> b.getCombustivel()
									.equals(Combustivel.ETANOL))
									.collect(Collectors.toList())
									.get(0);
					for(Bomba b : bombas) {
						if(b == etanol) {
							b.setTotalAbastecido(c.getCapacidadeTanque());
						}
					}
					manipulaHora(1 + ((int) c.getCapacidadeTanque() / etanol.getLitroPorMinuto()));
					setRelatorioAbastecimento(criaRelatorioAbastecimento(c,etanol));
					setResumoRelatorio(criaResumoRelatorio());
					break;
			}
	}
	
	/*
	  Aqui é feito o adicionamento de cada abastecimento no relatório.
	 */
	private String criaRelatorioAbastecimento(Carro c, Bomba bomba) {
		return "["+ hora + ":" + minutos +"] Veículo modelo " + c.getModelo() + ", placa " 
				+ c.getPlaca() + " foi abastecido com " + c.getCapacidadeTanque() + " litros de " 
				+ bomba.getCombustivel().toString() + ".\n";
	}
	
	/*
	 * Aqui é onde fica o resumo do relatório de abastecimento do posto, onde é 
	 * atualizado a cada novo abastecimento.
	 * */
	private String criaResumoRelatorio() {
		Bomba 	gasolina = bombas
							.stream()
							.filter(b -> b.getCombustivel()
							.equals(Combustivel.GASOLINA))
							.collect(Collectors.toList())
							.get(0),
				etanol = bombas
							.stream()
							.filter(b -> b.getCombustivel()
							.equals(Combustivel.ETANOL))
							.collect(Collectors.toList())
							.get(0);
		
		return "Total abastecido na bomba 1 (GASOLINA): "+ gasolina.getTotalAbastecido() +" litros\n"
				+ "Total abastecido na bomba 2 (ETANOL): "+ etanol.getTotalAbastecido() +" litros\n"
				+ "Total geral abastecido de GASOLINA: "+ gasolina.getTotalAbastecido() +" litros\n"
				+ "Total abastecido de ETANOL: "+ etanol.getTotalAbastecido() +" litros";
	}
	
	public List<Bomba> returnBomba(){
		return bombas;
	}
}

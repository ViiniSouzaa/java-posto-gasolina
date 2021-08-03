package br.com.postoGasolina.posto;

import java.util.ArrayList;
import java.util.List;

import br.com.postoGasolina.posto.model.Bomba;
import br.com.postoGasolina.posto.model.Carro;
import br.com.postoGasolina.posto.model.Combustivel;
import br.com.postoGasolina.posto.model.Relatorio;

public class App {
    
    public static void main(String[] args) {
    	List<Carro> carros = new ArrayList<Carro>();
    	List<Bomba> bombas = new ArrayList<Bomba>();
    	Relatorio relatorio;
    	
    	/*Preenchendo a lista de carros*/
    	carros.add(new Carro("FIAT-UNO", "JGG-7389", 8.9, 12.7, 48));
    	carros.add(new Carro("FORD-KA", "JGF-8573", 8.1, 11.6, 55));
    	carros.add(new Carro("AUDI-A1", "JGE-0620", 0, 10.8, 45));
    	carros.add(new Carro("CITROEN-C3", "JWM-1235", 7.5, 11.9, 47));
    	carros.add(new Carro("RENAULT-CLIO", "KRM-6771", 9.5, 14.3, 50));
    	carros.add(new Carro("AUDI-A1", "JGE-4583", 0, 10.8, 45));
    	carros.add(new Carro("FORD-KA", "JGE-9393", 8.1, 11.6, 55));
    	carros.add(new Carro("RENAULT-CLIO", "JGE-0611", 9.5, 14.3, 50));
    	carros.add(new Carro("CITROEN-C3", "JHM-7491", 7.5, 11.9, 47));
    	carros.add(new Carro("FORD-KA", "JGM-4773", 8.1, 11.6, 55));
    	carros.add(new Carro("AUDI-A4", "JMM-7513", 0, 8.8, 65));
    	

    	/*Criando as bombas*/
    	bombas.add(new Bomba(Combustivel.GASOLINA, 2.9, 10));
    	bombas.add(new Bomba(Combustivel.ETANOL, 0.5, 12));
    	
    	relatorio = new Relatorio(bombas);
    	
    	for(Carro c : carros) {
    		relatorio.addAbastecimento(c);
    		/*
    		 Recupera o valor abastecido nas bombas a cada novo abastecimento,
    		 para que seja já novo para os próximos relatorios.
    		*/
    		bombas = relatorio.getBombas();
    	}
    	
    	System.out.println("RELATORIO DE ABASTECIMENTO: \n"
    			+ 	"____________________________________\n" 
    			+	relatorio.getRelatorioAbastecimento());
    	System.out.println("RESUMO DO RELATORIO: \n"
    			+ 	"____________________________________\n" 
    			+	relatorio.getResumoRelatorio());
    	
    	
    }
    
}

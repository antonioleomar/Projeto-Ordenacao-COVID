package algoritmosOrdenacao;

import entidades.Dado;
import entidades.Dataset;

public class SelectionSortObitos {	
	

	//Algoritmo Selection Sort
	public static void selectionSort(Dataset dt) {
		
		//long tempoInicial = System.currentTimeMillis(); 
		
		//Encontra o índice do menor elemento
		for(int i = 0; i < dt.getDados().length; i++) {			
			int indexMenor = i;
			for(int j = i+1; j < dt.getDados().length; j++) {
				if(dt.getDados()[j].getDeaths() < dt.getDados()[indexMenor].getDeaths()) {
					indexMenor = j;
				}
			}
			//troca de valores
			Dado aux = dt.getDados()[i];	
			dt.getDados()[i] = dt.getDados()[indexMenor];
			dt.getDados()[indexMenor] = aux;			
		}
		
		//long tempoFinal = System.currentTimeMillis(); 
		//System.out.println("Tempo de execução do Selection Sort (Óbitos): " + (tempoFinal - tempoInicial) + "ms");
	}	

}//fim da classe

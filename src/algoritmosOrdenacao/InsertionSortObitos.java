package algoritmosOrdenacao;

import entidades.Dado;
import entidades.Dataset;

public class InsertionSortObitos {

	public static void insertionSort(Dataset dt) {

		//long tempoInicial = System.currentTimeMillis();

		for (int i = 1; i < dt.getDados().length; i++) {
			int j = i;
			while (j > 0 && dt.getDados()[j].getDeaths() < dt.getDados()[j - 1].getDeaths()) {

				Dado aux = dt.getDados()[j];
				dt.getDados()[j] = dt.getDados()[j - 1];
				dt.getDados()[j - 1] = aux;
				j -= 1;
			}
		}
		
		//long tempoFinal = System.currentTimeMillis(); 
		//System.out.println("Tempo de execução do Insertion Sort (Óbitos): " + (tempoFinal - tempoInicial) + "ms");

	}//fim do método InsertionSort

}//fim da classe

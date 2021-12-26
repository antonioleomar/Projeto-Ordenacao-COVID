package algoritmosOrdenacao;

import entidades.Dado;
import entidades.Dataset;

public class CountingSortObitos {

	public static void countingSort(Dataset dt) {		
	

		int k = maiorValorArray(dt);

		int[] C = new int[k+1];//**** + 1 para contabilizar o zero

		// frequência
		for (int i = 0; i < dt.getDados().length; i++) {
			C[dt.getDados()[i].getDeaths()] += 1;			
		}

		// cumulativa
		for (int i = 1; i < C.length; i++) {
			C[i] += C[i - 1];
		}

		Dado[] B = new Dado[dt.getDados().length];

		for (int i = dt.getDados().length - 1; i >= 0; i--) {
			B[C[dt.getDados()[i].getDeaths()] - 1] = dt.getDados()[i];
			C[dt.getDados()[i].getDeaths()] -= 1;
		}
		
		dt.setDados(B);	
		
		
	}// fim do método countigSort

	
	// Determinar maior valor do array
	public static int maiorValorArray(Dataset dt) {
		
		int maior = dt.getDados()[0].getDeaths();
		for (int i = 0; i < dt.getDados().length; i++) {
			if (dt.getDados()[i].getDeaths() > maior) {
				maior = dt.getDados()[i].getDeaths();
			}
		}
		return maior;
	}

}// fim da classe

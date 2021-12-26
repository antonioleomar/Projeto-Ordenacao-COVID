package algoritmosOrdenacao;

import entidades.Dado;
import entidades.Dataset;

public class SelectionSortCidades {

	// Algoritmo Selection Sort
	public static void selectionSort(Dataset dt) {

		//long tempoInicial = System.currentTimeMillis();

		// Encontra o �ndice do menor elemento
		for (int i = 0; i < dt.getDados().length; i++) {
			int indexMenor = i;
			for (int j = i + 1; j < dt.getDados().length; j++) {
				if (semAcento(dt.getDados()[j].getCity())
						.compareTo(semAcento(dt.getDados()[indexMenor].getCity())) < 0) {
					indexMenor = j;

				}
			}
			// troca de valores
			Dado aux = dt.getDados()[i];
			dt.getDados()[i] = dt.getDados()[indexMenor];
			dt.getDados()[indexMenor] = aux;
		}

		//long tempoFinal = System.currentTimeMillis(); 
		//System.out.println("Tempo de execu��o do Selection Sort (Cidades): " + (tempoFinal - tempoInicial) + "ms");
	}

	public static String semAcento(String txt) {
		String s = "";
		for (int i = 0; i < txt.length(); i++) {
			char c = txt.charAt(i);
			switch (c) {
			case '�':
			case '�':
			case '�':
				c = 'A';
				break;
			case '�':
			case '�':
				c = 'E';
				break;
			case '�':
				c = 'I';
				break;
			case '�':
			case '�':
			case '�':
				c = 'O';
				break;
			case '�':
				c = 'U';
				break;
			case '�':
				c = 'C';

			case '�':
			case '�':
			case '�':
				c = 'a';
				break;
			case '�':
			case '�':
				c = 'e';
				break;
			case '�':
				c = 'i';
				break;
			case '�':
			case '�':
			case '�':
				c = 'o';
				break;
			case '�':
				c = 'u';
				break;
			case '�':
				c = 'c';
				break;
			}
			s += c;
		}
		return s;
	}

}// fim da classe

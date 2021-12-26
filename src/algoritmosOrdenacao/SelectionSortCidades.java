package algoritmosOrdenacao;

import entidades.Dado;
import entidades.Dataset;

public class SelectionSortCidades {

	// Algoritmo Selection Sort
	public static void selectionSort(Dataset dt) {

		//long tempoInicial = System.currentTimeMillis();

		// Encontra o нndice do menor elemento
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
		//System.out.println("Tempo de execuзгo do Selection Sort (Cidades): " + (tempoFinal - tempoInicial) + "ms");
	}

	public static String semAcento(String txt) {
		String s = "";
		for (int i = 0; i < txt.length(); i++) {
			char c = txt.charAt(i);
			switch (c) {
			case 'Б':
			case 'А':
			case 'Г':
				c = 'A';
				break;
			case 'Й':
			case 'К':
				c = 'E';
				break;
			case 'Н':
				c = 'I';
				break;
			case 'У':
			case 'Х':
			case 'Ф':
				c = 'O';
				break;
			case 'Ъ':
				c = 'U';
				break;
			case 'З':
				c = 'C';

			case 'б':
			case 'а':
			case 'г':
				c = 'a';
				break;
			case 'й':
			case 'к':
				c = 'e';
				break;
			case 'н':
				c = 'i';
				break;
			case 'у':
			case 'х':
			case 'ф':
				c = 'o';
				break;
			case 'ъ':
				c = 'u';
				break;
			case 'з':
				c = 'c';
				break;
			}
			s += c;
		}
		return s;
	}

}// fim da classe

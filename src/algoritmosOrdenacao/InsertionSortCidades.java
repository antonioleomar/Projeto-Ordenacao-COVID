package algoritmosOrdenacao;

import entidades.Dado;
import entidades.Dataset;

public class InsertionSortCidades {

	public static void insertionSort(Dataset dt) {

		//long tempoInicial = System.currentTimeMillis();

		for (int i = 1; i < dt.getDados().length; i++) {
			int j = i;
			while (j > 0 && semAcento(dt.getDados()[j].getCity()).compareTo(semAcento(dt.getDados()[j - 1].getCity())) < 0) {
				Dado aux = dt.getDados()[j];
				dt.getDados()[j] = dt.getDados()[j - 1];
				dt.getDados()[j - 1] = aux;
				j -= 1;
			}
		}
		
		//long tempoFinal = System.currentTimeMillis(); 
		//System.out.println("Tempo de execu��o do Insertion Sort (Cidades): " + (tempoFinal - tempoInicial) + "ms");

	}//fim do m�todo InsertionSort
	
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

}//fim da classe

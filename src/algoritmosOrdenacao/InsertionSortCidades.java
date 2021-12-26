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
		//System.out.println("Tempo de execuзгo do Insertion Sort (Cidades): " + (tempoFinal - tempoInicial) + "ms");

	}//fim do mйtodo InsertionSort
	
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

}//fim da classe

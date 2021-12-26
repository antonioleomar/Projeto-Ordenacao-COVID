package algoritmosOrdenacao;

import entidades.Dado;
import entidades.Dataset;

public class HeapSortCidades {

	private static int tam;
	private static Dataset dataSet;

	public static void heapsort(Dataset dt) {
		dataSet = dt;
		tam = dataSet.getDados().length - 1;

		constroiHeap();

		for (int i = tam; i > 0; i--) {
			troca(0, tam);
			tam -= 1;
			maxHeapifica(0);
		}
	}

	private static void constroiHeap() {

		int meio = (int) (tam / 2);

		for (int i = meio - 1; i >= 0; i--) {
			maxHeapifica(i);
		}
	}

	private static void troca(int i, int j) {

		Dado aux = dataSet.getDados()[j];
		dataSet.getDados()[j] = dataSet.getDados()[i];
		dataSet.getDados()[i] = aux;
	}

	private static void maxHeapifica(int pai) {
		int maior = pai, esquerda = 2 * pai + 1, direita = 2 * pai + 2;

		if (esquerda <= tam && semAcento(dataSet.getDados()[esquerda].getCity()).compareTo(semAcento(dataSet.getDados()[maior].getCity()))>0)
			maior = esquerda;

		if (direita <= tam && semAcento(dataSet.getDados()[direita].getCity()).compareTo(semAcento(dataSet.getDados()[maior].getCity()))>0)
			maior = direita;

		if (maior != pai) {
			troca(pai, maior);
			maxHeapifica(maior);
		}
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


}

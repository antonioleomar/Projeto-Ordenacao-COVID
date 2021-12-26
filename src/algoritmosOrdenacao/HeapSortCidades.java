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
			case 'Á':
			case 'À':
			case 'Ã':
				c = 'A';
				break;
			case 'É':
			case 'Ê':
				c = 'E';
				break;
			case 'Í':
				c = 'I';
				break;
			case 'Ó':
			case 'Õ':
			case 'Ô':
				c = 'O';
				break;
			case 'Ú':
				c = 'U';
				break;
			case 'Ç':
				c = 'C';

			case 'á':
			case 'à':
			case 'ã':
				c = 'a';
				break;
			case 'é':
			case 'ê':
				c = 'e';
				break;
			case 'í':
				c = 'i';
				break;
			case 'ó':
			case 'õ':
			case 'ô':
				c = 'o';
				break;
			case 'ú':
				c = 'u';
				break;
			case 'ç':
				c = 'c';
				break;
			}
			s += c;
		}
		return s;
	}


}

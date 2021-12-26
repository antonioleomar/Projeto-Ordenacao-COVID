package algoritmosOrdenacao;

import entidades.Dado;
import entidades.Dataset;

public class HeapSortCasos {

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

		if (esquerda <= tam && dataSet.getDados()[esquerda].getConfirmed() > dataSet.getDados()[maior].getConfirmed())
			maior = esquerda;

		if (direita <= tam && dataSet.getDados()[direita].getConfirmed() > dataSet.getDados()[maior].getConfirmed())
			maior = direita;

		if (maior != pai) {
			troca(pai, maior);
			maxHeapifica(maior);
		}
	}

}

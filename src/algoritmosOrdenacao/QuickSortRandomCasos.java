package algoritmosOrdenacao;

import java.util.Arrays;

import entidades.Dado;
import entidades.Dataset;

public class QuickSortRandomCasos {

	public static void quickSortRandom(Dataset dt, int inicio, int fim) {

		if (inicio < fim) {

			int indicePivot = particionamentoHoare(dt, inicio, fim);

			quickSortRandom(dt, inicio, indicePivot - 1);
			quickSortRandom(dt, indicePivot + 1, fim);
		}
	}
	

	public static int particionamentoHoare(Dataset dt, int inicio, int fim) {

		// Escolher tipo de seleção do pivot:
		// int pivot = dt.getDados()[inicio].getConfirmed();
		int pivot = pivotRandom(dt, inicio, fim);
		//int pivot = pivotMediana(dt, inicio, fim);
		// int pivot = pivotMedianaDe3(dt, inicio, fim);

		int indexPivot = indexPivot(dt, pivot);

		// Trocar posição do pivot com o último elemento (posição right)
		Dado dadoAux = dt.getDados()[indexPivot];
		dt.getDados()[indexPivot] = dt.getDados()[fim];
		dt.getDados()[fim] = dadoAux;

		// Hoare
		int x = dt.getDados()[fim].getConfirmed();
		int i = inicio - 1;
		for (int j = inicio; j < fim; j++) {
			if (dt.getDados()[j].getConfirmed() <= x) {
				i++;
				Dado dadoAux2 = dt.getDados()[i];
				dt.getDados()[i] = dt.getDados()[j];
				dt.getDados()[j] = dadoAux2;

			}
		}
		// Trocar pivot na ultima posição por posição certa
		Dado dadoAux3 = dt.getDados()[i + 1];
		dt.getDados()[i + 1] = dt.getDados()[fim];
		dt.getDados()[fim] = dadoAux3;

		return i + 1;
	}// fim do particionamento Hoare

	public static int pivotRandom(Dataset dt, int inicio, int fim) {

		// Escolhendo Pivot Aleatoriamente
		// tamanho do array
		int range = (fim - inicio) + 1;
		// valores entre left e rigth aleatório
		int indicePivotRandon = (int) (Math.random() * range) + inicio;
		// Valor do pivot
		int valorPivot = dt.getDados()[indicePivotRandon].getConfirmed();

		return valorPivot;
	}

	public static int pivotMedianaDe3(Dataset dt, int inicio, int fim) {

		// Escolhendo Pivot da mediana de 3: valor intermediário dentre o inicio, meio e
		// fim
		int valorPivot;
		int meio = (inicio + fim) / 2;
		int[] sorted = { dt.getDados()[inicio].getConfirmed(), dt.getDados()[meio].getConfirmed(),
				dt.getDados()[fim].getConfirmed() };
		Arrays.sort(sorted);
		if (sorted[1] == dt.getDados()[fim].getConfirmed()) {

			valorPivot = dt.getDados()[fim].getConfirmed();

		} else if (sorted[1] == dt.getDados()[meio].getConfirmed()) {

			valorPivot = dt.getDados()[meio].getConfirmed();

		} else {
			valorPivot = dt.getDados()[inicio].getConfirmed();
		}
		return valorPivot;
	}

	public static int pivotMediana(Dataset dt, int inicio, int fim) {
		// Escolhendo Pivot da mediana (m) = (Maior valor + Menor valor) / 2
		int valorPivot = dt.getDados()[inicio].getConfirmed();
		int menorValor = dt.getDados()[inicio].getConfirmed();
		int maiorValor = dt.getDados()[inicio].getConfirmed();

		for (int i = inicio; i <= fim; i++) {
			if (dt.getDados()[i].getConfirmed() < menorValor) {
				menorValor = dt.getDados()[i].getConfirmed();
			}
		}

		for (int i = inicio; i <= fim; i++) {
			if (dt.getDados()[i].getConfirmed() > maiorValor) {
				maiorValor = dt.getDados()[i].getConfirmed();
			}
		}

		int mediana = (maiorValor + menorValor) / 2;
		int diferenca = mediana - dt.getDados()[inicio].getConfirmed();
		if (diferenca < 0) {
			diferenca = (diferenca) * (-1);
		}

		for (int i = inicio; i <= fim; i++) {
			int diferencaAtual = mediana - dt.getDados()[i].getConfirmed();
			if (diferencaAtual < 0) {
				diferencaAtual = (diferencaAtual) * (-1);
			}

			if (diferencaAtual < diferenca) {
				diferenca = diferencaAtual;
				valorPivot = dt.getDados()[i].getConfirmed();
			}
		}

		return valorPivot;
	}

	public static int indexPivot(Dataset dt, int pivot) {
		int indexPivot = -1;
		for (int i = 0; i < dt.getDados().length; i++) {
			if (dt.getDados()[i].getConfirmed() == pivot) {
				indexPivot = i;
			}
		}
		return indexPivot;
	}

}

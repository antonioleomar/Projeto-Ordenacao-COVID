package algoritmosOrdenacao;

import java.util.Arrays;

import entidades.Dado;
import entidades.Dataset;

public class QuickSortMediana3Cidades {

	public static void quickSortMediana3(Dataset dt, int inicio, int fim) {

		if (inicio < fim) {

			int indicePivot = particionamentoHoare(dt, inicio, fim);

			quickSortMediana3(dt, inicio, indicePivot - 1);
			quickSortMediana3(dt, indicePivot + 1, fim);
		}
	}

	public static int particionamentoHoare(Dataset dt, int inicio, int fim) {

		// Escolher tipo de seleção do pivot:
		// String pivot = dt.getDados()[inicio].getCity();
		//String pivot = pivotRandom(dt, inicio, fim);
		// Iniável de utilizar ==> String pivot = pivotMediana(dt, inicio, fim);
		String pivot = pivotMedianaDe3(dt, inicio, fim);

		int indexPivot = indexPivot(dt, pivot);

		// Trocar posição do pivot com o último elemento (posição right)
		Dado dadoAux = dt.getDados()[indexPivot];
		dt.getDados()[indexPivot] = dt.getDados()[fim];
		dt.getDados()[fim] = dadoAux;

		// Hoare
		String x = semAcento(dt.getDados()[fim].getCity());
		int i = inicio - 1;
		for (int j = inicio; j < fim; j++) {
			if (semAcento(dt.getDados()[j].getCity()).compareTo(x) < 0) {
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

	public static String pivotRandom(Dataset dt, int inicio, int fim) {

		// Escolhendo Pivot Aleatoriamente
		// tamanho do array
		int range = (fim - inicio) + 1;
		// valores entre left e rigth aleatório
		int indicePivotRandon = (int) (Math.random() * range) + inicio;
		// Valor do pivot
		String valorPivot = dt.getDados()[indicePivotRandon].getCity();

		return valorPivot;
	}

	public static String pivotMedianaDe3(Dataset dt, int inicio, int fim) {

		// Escolhendo Pivot da mediana de 3: valor intermediário dentre o inicio, meio e
		// fim
		String valorPivot;
		int meio = (inicio + fim) / 2;
		String[] sorted = { semAcento(dt.getDados()[inicio].getCity()), semAcento(dt.getDados()[meio].getCity()),
				semAcento(dt.getDados()[fim].getCity()) };
		Arrays.sort(sorted);
		if (sorted[1].equals(semAcento(dt.getDados()[fim].getCity()))) {

			valorPivot = dt.getDados()[fim].getCity();

		} else if (sorted[1].equals(semAcento(dt.getDados()[meio].getCity()))) {

			valorPivot = dt.getDados()[meio].getCity();

		} else {
			valorPivot = dt.getDados()[inicio].getCity();
		}
		return valorPivot;
	}

	/*
	 * public static int pivotMediana(Dataset dt, int inicio, int fim) { //
	 * Escolhendo Pivot da mediana (m) = (Maior valor + Menor valor) / 2 String
	 * valorPivot = semAcento(dt.getDados()[inicio].getCity()); String menorValor =
	 * semAcento(dt.getDados()[inicio].getCity()); String maiorValor =
	 * semAcento(dt.getDados()[inicio].getCity());
	 * 
	 * for(int i = inicio; i <= fim; i++) {
	 * if(semAcento(dt.getDados()[i].getCity()).compareTo(menorValor) < 0) {
	 * menorValor = semAcento(dt.getDados()[i].getCity()); } }
	 * 
	 * for(int i = inicio; i <= fim; i++) {
	 * if(semAcento(dt.getDados()[i].getCity()).compareTo(maiorValor) > 0) {
	 * maiorValor = semAcento(dt.getDados()[i].getCity()); } }
	 * 
	 * int mediana = (maiorValor + menorValor)/2; int diferenca = mediana -
	 * dt.getDados()[inicio].getCity(); if(diferenca < 0) { diferenca = (diferenca)
	 * * (-1); }
	 * 
	 * for(int i = inicio; i <= fim; i++) { int diferencaAtual = mediana -
	 * dt.getDados()[i].getCity(); if(diferencaAtual < 0) { diferencaAtual =
	 * (diferencaAtual) * (-1); }
	 * 
	 * if(diferencaAtual < diferenca) { diferenca = diferencaAtual; valorPivot =
	 * dt.getDados()[i].getCity(); } }
	 * 
	 * return valorPivot; }
	 */

	public static int indexPivot(Dataset dt, String pivot) {
		int indexPivot = -1;
		for (int i = 0; i < dt.getDados().length; i++) {
			if (semAcento(dt.getDados()[i].getCity()).equals(semAcento(pivot))) {
				indexPivot = i;
			}
		}
		return indexPivot;
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

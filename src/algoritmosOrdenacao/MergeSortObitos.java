package algoritmosOrdenacao;

import entidades.Dado;
import entidades.Dataset;

public class MergeSortObitos {

	public static void mergeSort(Dataset dt, int left, int rigth) {
	
		if (left >= rigth) {
			return;
		}

		else {
			int middle = (int) (left + rigth) / 2;
			mergeSort(dt, left, middle);
			mergeSort(dt, middle + 1, rigth);
			merge(dt, left, middle, rigth);
		}
	}

	public static void merge(Dataset dt, int left, int middle, int rigth) {

		Dataset datasetAux = new Dataset();
		for (int i = 0; i < dt.getDados().length; i++) {
			//datasetAux.getDados()[i] = dt.getDados()[i];
			String date = dt.getDados()[i].getDate();
			String state = dt.getDados()[i].getState();
			String city = dt.getDados()[i].getCity();
			int confirmed = dt.getDados()[i].getConfirmed();
			int deaths = dt.getDados()[i].getDeaths();
			Dado dado = new Dado(date, state, city, confirmed, deaths);
			datasetAux.adicionarDadoArray(dado);
		}

		int i = left;
		int j = middle + 1;
		int k = left;

		while (i <= middle && j <= rigth) {
			if (datasetAux.getDados()[i].getDeaths() < datasetAux.getDados()[j].getDeaths()) {
				dt.getDados()[k] = datasetAux.getDados()[i];
				i++;
				k++;
			} else {
				dt.getDados()[k] = datasetAux.getDados()[j];
				j++;
				k++;
			}
		}

		while (i <= middle) {
			dt.getDados()[k] = datasetAux.getDados()[i];
			i++;
			k++;
		}

		while (j <= rigth) {
			dt.getDados()[k] = datasetAux.getDados()[j];
			j++;
			k++;
		}

	}// fim do método merge

}// fim da classe

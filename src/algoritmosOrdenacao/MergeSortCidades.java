package algoritmosOrdenacao;

import entidades.Dado;
import entidades.Dataset;

public class MergeSortCidades {

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
			if (semAcento(datasetAux.getDados()[i].getCity()).compareTo(semAcento(datasetAux.getDados()[j].getCity())) < 0) {
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


}// fim da classe

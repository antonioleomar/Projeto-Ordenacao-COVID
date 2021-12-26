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

	}// fim do m�todo merge
	
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


}// fim da classe

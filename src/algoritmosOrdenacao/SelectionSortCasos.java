package algoritmosOrdenacao;

import java.io.IOException;

import javax.swing.JOptionPane;

import entidades.Dado;
import entidades.Dataset;

public class SelectionSortCasos {	
	

	//Algoritmo Selection Sort
	public static void selectionSort(Dataset dt) {
		
		
		//long tempoInicial = System.currentTimeMillis(); 
		
		//Encontra o índice do menor elemento
		for(int i = 0; i < dt.getDados().length; i++) {			
			int indexMenor = i;
			for(int j = i+1; j < dt.getDados().length; j++) {
				if(dt.getDados()[j].getConfirmed() < dt.getDados()[indexMenor].getConfirmed()) {
					indexMenor = j;
				}
			}
			//troca de valores
			Dado aux = dt.getDados()[i];	
			dt.getDados()[i] = dt.getDados()[indexMenor];
			dt.getDados()[indexMenor] = aux;
			
		}
		
		//long tempoFinal = System.currentTimeMillis(); 
		//System.out.println("Tempo de execução do Selection Sort (Casos): " + (tempoFinal - tempoInicial) + "ms");		
	}	

}//fim da classe

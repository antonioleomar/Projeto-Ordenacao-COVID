package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import algoritmosOrdenacao.InsertionSortCasos;
import algoritmosOrdenacao.InsertionSortCidades;
import algoritmosOrdenacao.InsertionSortObitos;
import algoritmosOrdenacao.MergeSortCasos;
import algoritmosOrdenacao.MergeSortCidades;
import algoritmosOrdenacao.MergeSortObitos;
import algoritmosOrdenacao.QuickSortMediana3Casos;
import algoritmosOrdenacao.QuickSortMediana3Cidades;
import algoritmosOrdenacao.QuickSortMediana3Obitos;
import algoritmosOrdenacao.QuickSortRandomCasos;
import algoritmosOrdenacao.QuickSortRandomCidades;
import algoritmosOrdenacao.QuickSortRandomObitos;
import algoritmosOrdenacao.SelectionSortCasos;
import algoritmosOrdenacao.SelectionSortCidades;
import algoritmosOrdenacao.SelectionSortObitos;
import algoritmosOrdenacao.CountingSortCasos;
import algoritmosOrdenacao.CountingSortObitos;
import algoritmosOrdenacao.HeapSortCasos;
import algoritmosOrdenacao.HeapSortCidades;
import algoritmosOrdenacao.HeapSortObitos;
import entidades.Dado;
import entidades.Dataset;
import gui.AbrirArquivo;
import gui.CriarArquivo;
import gui.TelaPrincipal;

public class Programa {

	public static void main(String[] args) {
	
		String path = "c:\\Users\\anton\\Desktop\\Arquivos Projeto Covid-19\\testeMod - Pior Cidades.csv"; // Local do Dataset em CSV	

		Dataset dt = new Dataset();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			// Determinando o índice das colunas utilizadas no arquivo do dataset
			int indexDate = -1, indexState = -1, indexCity = -1, indexConfirmed = -1, indexDeaths = -1;
			String line = br.readLine();// ler cabeçalho
			String[] lineCabecalho = line.split(";");
			
			for (int i = 0; i < lineCabecalho.length; i++) {
				if (lineCabecalho[i].equals("date")) {
					indexDate = i;
				}
				if (lineCabecalho[i].equals("state")) {
					indexState = i;
				}
				if (lineCabecalho[i].equals("city")) {
					indexCity = i;
				}
				if (lineCabecalho[i].equals("confirmed")) {
					indexConfirmed = i;
				}
				if (lineCabecalho[i].equals("deaths")) {
					indexDeaths = i;
				}
			}

			//Se o dataset estiver com todas as informações
			if (indexDate != -1 && indexState != -1 && indexCity != -1 && indexConfirmed != -1 && indexDeaths != -1) {

				line = br.readLine();// ler segunda linha

				while (line != null) {

					String[] vect = line.split(";"); // O arquivo CSV está separado por ";"
					String date = vect[indexDate];
					String state = vect[indexState];
					String city = vect[indexCity];
					int confirmed = Integer.parseInt(vect[indexConfirmed]);
					int deaths = Integer.parseInt(vect[indexDeaths]);

					Dado dado = new Dado(date, state, city, confirmed, deaths);

					dt.adicionarDadoArray(dado);

					line = br.readLine();
				}
				
				//Seleção dos Algoritmos de Ordenação:
				
				System.out.println("Tempo de execução dos Algoritmos de ordenação:\n");
				
				//Selection Sort:
				System.out.println("#### Selection Sort ####");
				long tempoInicial1 = System.currentTimeMillis(); 
				SelectionSortCasos.selectionSort(dt);
				long tempoFinal1 = System.currentTimeMillis(); 
				System.out.println("Tempo de execução do Selection Sort (Casos): " + (tempoFinal1 - tempoInicial1) + "ms");			
				long tempoInicial2 = System.currentTimeMillis(); 
				SelectionSortObitos.selectionSort(dt);
				long tempoFinal2 = System.currentTimeMillis(); 
				System.out.println("Tempo de execução do Selection Sort (Óbitos): " + (tempoFinal2 - tempoInicial2) + "ms");
				long tempoInicial3 = System.currentTimeMillis(); 
				SelectionSortCidades.selectionSort(dt);
				long tempoFinal3 = System.currentTimeMillis(); 
				System.out.println("Tempo de execução do Selection Sort (Cidades): " + (tempoFinal3 - tempoInicial3) + "ms");
				 
				//Insertion Sort
				System.out.println("\n#### Insertion Sort ####");
				long tempoInicial4 = System.currentTimeMillis();
				InsertionSortCasos.insertionSort(dt);
				long tempoFinal4 = System.currentTimeMillis(); 
				System.out.println("Tempo de execução do Insertion Sort (Casos): " + (tempoFinal4 - tempoInicial4) + "ms");
				long tempoInicial5 = System.currentTimeMillis();
				InsertionSortObitos.insertionSort(dt);
				long tempoFinal5 = System.currentTimeMillis(); 
				System.out.println("Tempo de execução do Insertion Sort (Óbitos): " + (tempoFinal5 - tempoInicial5) + "ms");
				long tempoInicial6 = System.currentTimeMillis();
				InsertionSortCidades.insertionSort(dt);
				long tempoFinal6 = System.currentTimeMillis(); 
				System.out.println("Tempo de execução do Insertion Sort (Cidades): " + (tempoFinal6 - tempoInicial6) + "ms");
		
				//Merge sort
				System.out.println("\n#### Merge Sort ####");
				long tempoInicial7 = System.currentTimeMillis(); 
				MergeSortCasos.mergeSort(dt, 0, (dt.getDados().length) - 1);
				long tempoFinal7 = System.currentTimeMillis(); 
			    System.out.println("Tempo de execução do Merge Sort (Casos): " + (tempoFinal7 - tempoInicial7) + "ms");
				long tempoInicial8 = System.currentTimeMillis(); 
				MergeSortObitos.mergeSort(dt, 0, (dt.getDados().length) - 1);
				long tempoFinal8 = System.currentTimeMillis(); 
				System.out.println("Tempo de execução do Merge Sort (Óbitos): " + (tempoFinal8 - tempoInicial8) + "ms");
				long tempoInicial9 = System.currentTimeMillis(); 
				MergeSortCidades.mergeSort(dt, 0, (dt.getDados().length) - 1);
				long tempoFinal9 = System.currentTimeMillis(); 
				System.out.println("Tempo de execução do Merge Sort (Cidades): " + (tempoFinal9 - tempoInicial9) + "ms");
				
				//Quick Sort
				System.out.println("\n#### Quick Sort ####");
				long tempoInicial10 = System.currentTimeMillis(); 
				QuickSortRandomCasos.quickSortRandom(dt, 0, (dt.getDados().length) - 1);
				long tempoFinal10 = System.currentTimeMillis(); 
				System.out.println("Tempo de execução do Quick Sort - Random (Casos): " + (tempoFinal10 - tempoInicial10) + "ms");
				long tempoInicial11 = System.currentTimeMillis(); 
				QuickSortRandomObitos.quickSortRandom(dt, 0, (dt.getDados().length) - 1);
				long tempoFinal11 = System.currentTimeMillis(); 
				System.out.println("Tempo de execução do Quick Sort - Random (Óbitos): " + (tempoFinal11 - tempoInicial11) + "ms");
				long tempoInicial12 = System.currentTimeMillis(); 
				QuickSortRandomCidades.quickSortRandom(dt, 0, (dt.getDados().length) - 1);
				long tempoFinal12 = System.currentTimeMillis(); 
				System.out.println("Tempo de execução do Quick Sort - Random (Cidades): " + (tempoFinal12 - tempoInicial12) + "ms");				
				
				//Quick Sort - Mediana de 3
				System.out.println("\n#### Quick Sort - Mediana de 3 ####");
				long tempoInicial13 = System.currentTimeMillis(); 
				QuickSortMediana3Casos.quickSortMediana3(dt, 0, (dt.getDados().length) - 1);
				long tempoFinal13 = System.currentTimeMillis(); 
				System.out.println("Tempo de execução do Quick Sort - Mediana de 3 (Casos): " + (tempoFinal13 - tempoInicial13) + "ms");
				long tempoInicial14 = System.currentTimeMillis(); 
				QuickSortMediana3Obitos.quickSortMediana3(dt, 0, (dt.getDados().length) - 1);
				long tempoFinal14 = System.currentTimeMillis(); 
				System.out.println("Tempo de execução do Quick Sort - Mediana de 3 (Óbitos): " + (tempoFinal14 - tempoInicial14) + "ms");
				long tempoInicial15 = System.currentTimeMillis(); 
				QuickSortMediana3Cidades.quickSortMediana3(dt, 0, (dt.getDados().length) - 1);
				long tempoFinal15 = System.currentTimeMillis(); 
				System.out.println("Tempo de execução do Quick Sort - Mediana de 3 (Cidade): " + (tempoFinal15 - tempoInicial15) + "ms");
				
				//Countig Sort
				System.out.println("\n#### Counting Sort ####");
				long tempoInicial16 = System.currentTimeMillis(); 
				CountingSortCasos.countingSort(dt);
				long tempoFinal16 = System.currentTimeMillis(); 
				System.out.println("Tempo de execução do Counting Sort (Casos): " + (tempoFinal16 - tempoInicial16) + "ms");
				long tempoInicial17 = System.currentTimeMillis(); 
				CountingSortObitos.countingSort(dt);
				long tempoFinal17 = System.currentTimeMillis(); 
				System.out.println("Tempo de execução do Counting Sort (Óbitos): " + (tempoFinal17 - tempoInicial17) + "ms");
				
				//Heap Sort
				System.out.println("\n#### Heap Sort ####");
				long tempoInicial18 = System.currentTimeMillis(); 
				HeapSortCasos.heapsort(dt);
				long tempoFinal18 = System.currentTimeMillis(); 
				System.out.println("Tempo de execução do Heap Sort (Casos): " + (tempoFinal18 - tempoInicial18) + "ms");
				long tempoInicial19 = System.currentTimeMillis(); 
				HeapSortObitos.heapsort(dt);
				long tempoFinal19 = System.currentTimeMillis(); 
				System.out.println("Tempo de execução do Heap Sort (Óbitos): " + (tempoFinal19 - tempoInicial19) + "ms");
				long tempoInicial20 = System.currentTimeMillis(); 
				HeapSortCidades.heapsort(dt);
				long tempoFinal20 = System.currentTimeMillis(); 
				System.out.println("Tempo de execução do Heap Sort (Cidades): " + (tempoFinal20 - tempoInicial20) + "ms");
				
				//dt.imprimirDataset();
				//CriarArquivo.criarArquivo(dt);
			}
			//Se o dataset não estiver com todas as informações
			else {
				JOptionPane.showMessageDialog (null , "O dataset não possui uma das seguintes colunas: date, state, city, confirmed e deaths", "Atenção", JOptionPane.WARNING_MESSAGE );
			}
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}

	}// fim do main

}// fim da classe

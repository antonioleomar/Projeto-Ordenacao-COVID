package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import algoritmosOrdenacao.CountingSortCasos;
import algoritmosOrdenacao.CountingSortObitos;
import algoritmosOrdenacao.HeapSortCasos;
import algoritmosOrdenacao.HeapSortCidades;
import algoritmosOrdenacao.HeapSortObitos;
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
import entidades.Dado;
import entidades.Dataset;

public class TelaPrincipal extends JFrame {

	private final JButton botaoImportar;
	private final JButton botaoExportar;
	private final JLabel label1;
	private final JLabel label2;
	private final JRadioButton radioSelection;
	private final JRadioButton radioInsertion;
	private final JRadioButton radioMerge;
	private final JRadioButton radioQuick;
	private final JRadioButton radioQuickMediana3;
	private final JRadioButton radioCounting;
	private final JRadioButton radioHeap;
	private final JRadioButton radioCasos;
	private final JRadioButton radioObitos;
	private final JRadioButton radioCidades;
	private final ButtonGroup radiogrupo;
	private final ButtonGroup radiogrupo2;

	private final GridBagLayout layout;
	private final GridBagConstraints constraints;

	Dataset dt = new Dataset();

	public TelaPrincipal() {
		super("Programa de Ordena��o de Dados - COVID 19");
		layout = new GridBagLayout();
		setLayout(layout);
		constraints = new GridBagConstraints();

		// Bot�o de importar arquivo
		botaoImportar = new JButton("Importar arquivo");
		constraints.fill = GridBagConstraints.BOTH;
		addComponent(botaoImportar, 0, 0, 3, 1);// posi��o
		ButtonHandler handler = new ButtonHandler(); // listening
		botaoImportar.addActionListener(handler);

		// Label:
		label1 = new JLabel("Selecione o algoritmo de ordena��o:");//
		addComponent(label1, 2, 0, 1, 1);

		// RadioButton:
		radioSelection = new JRadioButton("Selection Sort", true);// marcado
		radioInsertion = new JRadioButton("Insertion Sort", false);
		radioMerge = new JRadioButton("Merge Sort", false);
		radioQuick = new JRadioButton("Quick Sort", false);
		radioQuickMediana3 = new JRadioButton("Quick Sort - Mediana de 3", false);
		radioCounting = new JRadioButton("Counting Sort", false);
		radioHeap = new JRadioButton("Heap Sort", false);
		addComponent(radioSelection, 3, 0, 1, 1);
		addComponent(radioInsertion, 4, 0, 1, 1);
		addComponent(radioMerge, 5, 0, 1, 1);
		addComponent(radioQuick, 6, 0, 1, 1);
		addComponent(radioQuickMediana3, 7, 0, 1, 1);
		addComponent(radioCounting, 8, 0, 1, 1);
		addComponent(radioHeap, 9, 0, 1, 1);
		// Cria grupo de bot�es que apenas 1 pode ser selecionado
		radiogrupo = new ButtonGroup();
		radiogrupo.add(radioSelection);
		radiogrupo.add(radioInsertion);
		radiogrupo.add(radioMerge);
		radiogrupo.add(radioQuick);
		radiogrupo.add(radioQuickMediana3);
		radiogrupo.add(radioCounting);
		radiogrupo.add(radioHeap);


		// Label:
		label2 = new JLabel("Selecione o par�metro de ordena��o:");
		addComponent(label2, 4, 1, 1, 1);

		// RadioButton Casos, obitos e Cidades:
		radioCasos = new JRadioButton("Casos", true);// marcado
		radioObitos = new JRadioButton("�bitos", false);
		radioCidades = new JRadioButton("Cidades", false);
		// Cria grupo de bot�es que apenas 1 pode ser selecionado
		radiogrupo2 = new ButtonGroup();
		radiogrupo2.add(radioCasos);
		radiogrupo2.add(radioObitos);
		radiogrupo2.add(radioCidades);
		addComponent(radioCasos, 5, 1, 1, 1);
		addComponent(radioObitos, 6, 1, 1, 1);
		addComponent(radioCidades, 7, 1, 1, 1);

		// Bot�o de exportar arquivo
		botaoExportar = new JButton("Exportar arquivo ordenado");
		constraints.fill = GridBagConstraints.BOTH;
		addComponent(botaoExportar, 10, 0, 3, 3);
		ButtonHandler2 handlerExportar = new ButtonHandler2(); // listening
		botaoExportar.addActionListener(handlerExportar);

	}// fim do construtor

	// classe interna para tratamento de evento de bot�o importar
	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {

			AbrirArquivo application = new AbrirArquivo();

			try (BufferedReader br = new BufferedReader(new FileReader(application.getPath()))) {

				// Determinando o �ndice das colunas utilizadas no arquivo do dataset
				int indexDate = -1, indexState = -1, indexCity = -1, indexConfirmed = -1, indexDeaths = -1;
				String line = br.readLine();// ler cabe�alho
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

				// Se o dataset estiver com todas as informa��es
				if (indexDate != -1 && indexState != -1 && indexCity != -1 && indexConfirmed != -1
						&& indexDeaths != -1) {

					line = br.readLine();// ler segunda linha

					while (line != null) {

						String[] vect = line.split(";"); // O arquivo CSV est� separado por ";"
						String date = vect[indexDate];
						String state = vect[indexState];
						String city = vect[indexCity];
						int confirmed = Integer.parseInt(vect[indexConfirmed]);
						int deaths = Integer.parseInt(vect[indexDeaths]);

						Dado dado = new Dado(date, state, city, confirmed, deaths);

						dt.adicionarDadoArray(dado);

						line = br.readLine();
					}

				}
				// Se o dataset n�o estiver com todas as informa��es
				else {
					JOptionPane.showMessageDialog(null,
							"O dataset n�o possui uma das seguintes colunas: date, state, city, confirmed e deaths",
							"Aten��o", JOptionPane.WARNING_MESSAGE);
				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null,
						"Erro: " + e.getMessage(),"Aten��o", JOptionPane.WARNING_MESSAGE);
				System.out.println("Error: " + e.getMessage());
				e.printStackTrace();
			}

		}

	}// fim da classe interna bot�o importar

	// classe interna para tratamento de evento de bot�o Exportar
	private class ButtonHandler2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {

			try {
				//Selection Sort
				if (radioSelection.isSelected() && radioCasos.isSelected()) {
					long tempoInicial = System.currentTimeMillis();
					System.out.println("Selection e casos!");
					SelectionSortCasos.selectionSort(dt);
					long tempoFinal = System.currentTimeMillis(); 
					System.out.println("Tempo de execu��o do Selection Sort (Casos): " + (tempoFinal - tempoInicial) + "ms");
					JOptionPane.showMessageDialog(null, "Ordena��o realizada com sucesso!\n\nAlgoritmo: Selection Sort\nPar�metro: Casos\nTempo de execu��o: " + (tempoFinal - tempoInicial) + "ms", "Informa��o", JOptionPane.INFORMATION_MESSAGE);
					CriarArquivo.criarArquivo(dt);					
				} else if (radioSelection.isSelected() && radioObitos.isSelected()) {
					System.out.println("Selection e Obitos!");
					long tempoInicial = System.currentTimeMillis();
					SelectionSortObitos.selectionSort(dt);
					long tempoFinal = System.currentTimeMillis(); 
					System.out.println("Tempo de execu��o do Selection Sort (�bitos): " + (tempoFinal - tempoInicial) + "ms");
					JOptionPane.showMessageDialog(null, "Ordena��o realizada com sucesso!\n\nAlgoritmo: Selection Sort\nPar�metro: �bitos\nTempo de execu��o: " + (tempoFinal - tempoInicial) + "ms", "Informa��o", JOptionPane.INFORMATION_MESSAGE);
					CriarArquivo.criarArquivo(dt);
				} else if (radioSelection.isSelected() && radioCidades.isSelected()) {
					System.out.println("Selection e cidades!");
					long tempoInicial = System.currentTimeMillis();
					SelectionSortCidades.selectionSort(dt);
					long tempoFinal = System.currentTimeMillis(); 
					System.out.println("Tempo de execu��o do Selection Sort (Cidades): " + (tempoFinal - tempoInicial) + "ms");
					JOptionPane.showMessageDialog(null, "Ordena��o realizada com sucesso!\n\nAlgoritmo: Selection Sort\nPar�metro: Cidades\nTempo de execu��o: " + (tempoFinal - tempoInicial) + "ms", "Informa��o", JOptionPane.INFORMATION_MESSAGE);
					CriarArquivo.criarArquivo(dt);
				
				//Insertion Sort
				} else if (radioInsertion.isSelected() && radioCasos.isSelected()) {
					System.out.println("Insertion e casos!");
					long tempoInicial = System.currentTimeMillis();
					InsertionSortCasos.insertionSort(dt);
					long tempoFinal = System.currentTimeMillis(); 
					System.out.println("Tempo de execu��o do Insertion Sort (Casos): " + (tempoFinal - tempoInicial) + "ms");
					JOptionPane.showMessageDialog(null, "Ordena��o realizada com sucesso!\n\nAlgoritmo: Insertion Sort\nPar�metro: Casos\nTempo de execu��o: " + (tempoFinal - tempoInicial) + "ms", "Informa��o", JOptionPane.INFORMATION_MESSAGE);
					CriarArquivo.criarArquivo(dt);
				} else if (radioInsertion.isSelected() && radioObitos.isSelected()) {
					System.out.println("Insertion e obitos!");
					long tempoInicial = System.currentTimeMillis();
					InsertionSortObitos.insertionSort(dt);
					long tempoFinal = System.currentTimeMillis(); 
					System.out.println("Tempo de execu��o do Insertion Sort (�bitos): " + (tempoFinal - tempoInicial) + "ms");
					JOptionPane.showMessageDialog(null, "Ordena��o realizada com sucesso!\n\nAlgoritmo: Insertion Sort\nPar�metro: �bitos\nTempo de execu��o: " + (tempoFinal - tempoInicial) + "ms", "Informa��o", JOptionPane.INFORMATION_MESSAGE);
					CriarArquivo.criarArquivo(dt);
				} else if (radioInsertion.isSelected() && radioCidades.isSelected()) {
					System.out.println("Insertion e cidades!");
					long tempoInicial = System.currentTimeMillis();
					InsertionSortCidades.insertionSort(dt);	
					long tempoFinal = System.currentTimeMillis(); 
					System.out.println("Tempo de execu��o do Insertion Sort (Cidades): " + (tempoFinal - tempoInicial) + "ms");
					JOptionPane.showMessageDialog(null, "Ordena��o realizada com sucesso!\n\nAlgoritmo: Insertion Sort\nPar�metro: Cidades\nTempo de execu��o: " + (tempoFinal - tempoInicial) + "ms", "Informa��o", JOptionPane.INFORMATION_MESSAGE);
					CriarArquivo.criarArquivo(dt);
					
				//Merge Sort
				} else if (radioMerge.isSelected() && radioCasos.isSelected()) {
					System.out.println("Merge e casos!");
					long tempoInicial = System.currentTimeMillis();
					MergeSortCasos.mergeSort(dt, 0, (dt.getDados().length) - 1);
					long tempoFinal = System.currentTimeMillis(); 
					System.out.println("Tempo de execu��o do Merge Sort (Casos): " + (tempoFinal - tempoInicial) + "ms");
					JOptionPane.showMessageDialog(null, "Ordena��o realizada com sucesso!\n\nAlgoritmo: Merge Sort\nPar�metro: Casos\nTempo de execu��o: " + (tempoFinal - tempoInicial) + "ms", "Informa��o", JOptionPane.INFORMATION_MESSAGE);
					CriarArquivo.criarArquivo(dt);
				} else if (radioMerge.isSelected() && radioObitos.isSelected()) {
					System.out.println("Merge e obitos!");
					long tempoInicial = System.currentTimeMillis();
					MergeSortObitos.mergeSort(dt, 0, (dt.getDados().length) - 1);
					long tempoFinal = System.currentTimeMillis(); 
					System.out.println("Tempo de execu��o do Merge Sort (�bitos): " + (tempoFinal - tempoInicial) + "ms");
					JOptionPane.showMessageDialog(null, "Ordena��o realizada com sucesso!\n\nAlgoritmo: Merge Sort\nPar�metro: �bitos\nTempo de execu��o: " + (tempoFinal - tempoInicial) + "ms", "Informa��o", JOptionPane.INFORMATION_MESSAGE);
					CriarArquivo.criarArquivo(dt);
				} else if (radioMerge.isSelected() && radioCidades.isSelected()) {
					System.out.println("Merge e cidades!");
					long tempoInicial = System.currentTimeMillis();
					MergeSortCidades.mergeSort(dt, 0, (dt.getDados().length) - 1);
					long tempoFinal = System.currentTimeMillis(); 
					System.out.println("Tempo de execu��o do Merge Sort (Cidades): " + (tempoFinal - tempoInicial) + "ms");
					JOptionPane.showMessageDialog(null, "Ordena��o realizada com sucesso!\n\nAlgoritmo: Merge Sort\nPar�metro: Cidades\nTempo de execu��o: " + (tempoFinal - tempoInicial) + "ms", "Informa��o", JOptionPane.INFORMATION_MESSAGE);
					CriarArquivo.criarArquivo(dt);
					
				//Quick Sort
				} else if (radioQuick.isSelected() && radioCasos.isSelected()) {
					System.out.println("Quick e casos!");
					long tempoInicial = System.currentTimeMillis();
					QuickSortRandomCasos.quickSortRandom(dt, 0, (dt.getDados().length) - 1);
					long tempoFinal = System.currentTimeMillis(); 
					System.out.println("Tempo de execu��o do Quick Sort (Casos): " + (tempoFinal - tempoInicial) + "ms");
					JOptionPane.showMessageDialog(null, "Ordena��o realizada com sucesso!\n\nAlgoritmo: Quick Sort\nPar�metro: Casos\nTempo de execu��o: " + (tempoFinal - tempoInicial) + "ms", "Informa��o", JOptionPane.INFORMATION_MESSAGE);
					CriarArquivo.criarArquivo(dt);
				} else if (radioQuick.isSelected() && radioObitos.isSelected()) {
					System.out.println("Quick e obitos!");
					long tempoInicial = System.currentTimeMillis();
					QuickSortRandomObitos.quickSortRandom(dt, 0, (dt.getDados().length) - 1);
					long tempoFinal = System.currentTimeMillis(); 
					System.out.println("Tempo de execu��o do Quick Sort (�bitos): " + (tempoFinal - tempoInicial) + "ms");
					JOptionPane.showMessageDialog(null, "Ordena��o realizada com sucesso!\n\nAlgoritmo: Quick Sort\nPar�metro: �bitos\nTempo de execu��o: " + (tempoFinal - tempoInicial) + "ms", "Informa��o", JOptionPane.INFORMATION_MESSAGE);
					CriarArquivo.criarArquivo(dt);
				} else if (radioQuick.isSelected() && radioCidades.isSelected()) {
					System.out.println("Quick e cidades!");
					long tempoInicial = System.currentTimeMillis();
					QuickSortRandomCidades.quickSortRandom(dt, 0, (dt.getDados().length) - 1);
					long tempoFinal = System.currentTimeMillis(); 
					System.out.println("Tempo de execu��o do Quick Sort (Cidades): " + (tempoFinal - tempoInicial) + "ms");
					JOptionPane.showMessageDialog(null, "Ordena��o realizada com sucesso!\n\nAlgoritmo: Quick Sort\nPar�metro: Cidades\nTempo de execu��o: " + (tempoFinal - tempoInicial) + "ms", "Informa��o", JOptionPane.INFORMATION_MESSAGE);
					CriarArquivo.criarArquivo(dt);					
					
					//Quick Sort Mediana de 3
				} else if (radioQuickMediana3.isSelected() && radioCasos.isSelected()) {
					System.out.println("Quick Mediana de 3 e casos!");
					long tempoInicial = System.currentTimeMillis();
					QuickSortMediana3Casos.quickSortMediana3(dt, 0, (dt.getDados().length) - 1);
					long tempoFinal = System.currentTimeMillis(); 
					System.out.println("Tempo de execu��o do Quick Sort Mediana de 3 (Casos): " + (tempoFinal - tempoInicial) + "ms");
					JOptionPane.showMessageDialog(null, "Ordena��o realizada com sucesso!\n\nAlgoritmo: Quick Sort Mediana de 3\nPar�metro: Casos\nTempo de execu��o: " + (tempoFinal - tempoInicial) + "ms", "Informa��o", JOptionPane.INFORMATION_MESSAGE);
					CriarArquivo.criarArquivo(dt);
				} else if (radioQuickMediana3.isSelected() && radioObitos.isSelected()) {
					System.out.println("Quick Medina de 3 e obitos!");
					long tempoInicial = System.currentTimeMillis();
					QuickSortMediana3Obitos.quickSortMediana3(dt, 0, (dt.getDados().length) - 1);
					long tempoFinal = System.currentTimeMillis(); 
					System.out.println("Tempo de execu��o do Quick Sort Mediana de 3 (�bitos): " + (tempoFinal - tempoInicial) + "ms");
					JOptionPane.showMessageDialog(null, "Ordena��o realizada com sucesso!\n\nAlgoritmo: Quick Sort Mediana de 3\nPar�metro: �bitos\nTempo de execu��o: " + (tempoFinal - tempoInicial) + "ms", "Informa��o", JOptionPane.INFORMATION_MESSAGE);
					CriarArquivo.criarArquivo(dt);
				} else if (radioQuickMediana3.isSelected() && radioCidades.isSelected()) {
					System.out.println("Quick Mediana de 3 e cidades!");
					long tempoInicial = System.currentTimeMillis();
					QuickSortMediana3Cidades.quickSortMediana3(dt, 0, (dt.getDados().length) - 1);
					long tempoFinal = System.currentTimeMillis(); 
					System.out.println("Tempo de execu��o do Quick Sort Mediana de 3 (Cidades): " + (tempoFinal - tempoInicial) + "ms");
					JOptionPane.showMessageDialog(null, "Ordena��o realizada com sucesso!\n\nAlgoritmo: Quick Sort Mediana de 3\nPar�metro: Cidades\nTempo de execu��o: " + (tempoFinal - tempoInicial) + "ms", "Informa��o", JOptionPane.INFORMATION_MESSAGE);
					CriarArquivo.criarArquivo(dt);						
					
				//Countig Sort
				} else if (radioCounting.isSelected() && radioCasos.isSelected()) {
					System.out.println("Counting e casos!");
					long tempoInicial = System.currentTimeMillis();
					CountingSortCasos.countingSort(dt);
					long tempoFinal = System.currentTimeMillis(); 
					System.out.println("Tempo de execu��o do Counting Sort (Casos): " + (tempoFinal - tempoInicial) + "ms");
					JOptionPane.showMessageDialog(null, "Ordena��o realizada com sucesso!\n\nAlgoritmo: Counting Sort\nPar�metro: Casos\nTempo de execu��o: " + (tempoFinal - tempoInicial) + "ms", "Informa��o", JOptionPane.INFORMATION_MESSAGE);
					CriarArquivo.criarArquivo(dt);
				} else if (radioCounting.isSelected() && radioObitos.isSelected()) {
					System.out.println("Counting e obitos!");
					long tempoInicial = System.currentTimeMillis();
					CountingSortObitos.countingSort(dt);
					long tempoFinal = System.currentTimeMillis(); 
					System.out.println("Tempo de execu��o do Counting Sort (�bitos): " + (tempoFinal - tempoInicial) + "ms");
					JOptionPane.showMessageDialog(null, "Ordena��o realizada com sucesso!\n\nAlgoritmo: Counting Sort\nPar�metro: �bitos\nTempo de execu��o: " + (tempoFinal - tempoInicial) + "ms", "Informa��o", JOptionPane.INFORMATION_MESSAGE);
					CriarArquivo.criarArquivo(dt);
				} else if (radioCounting.isSelected() && radioCidades.isSelected()) {
					System.out.println("Counting e cidades!");
					JOptionPane.showMessageDialog(null, "Op��o Indispon�vel", "Aten��o", JOptionPane.WARNING_MESSAGE);					
				
				//Heap Sort	
				} else if (radioHeap.isSelected() && radioCasos.isSelected()) {
					System.out.println("Heap e casos!");
					long tempoInicial = System.currentTimeMillis();
					HeapSortCasos.heapsort(dt);
					long tempoFinal = System.currentTimeMillis(); 
					System.out.println("Tempo de execu��o do Heap Sort (Casos): " + (tempoFinal - tempoInicial) + "ms");
					JOptionPane.showMessageDialog(null, "Ordena��o realizada com sucesso!\n\nAlgoritmo: Heap Sort\nPar�metro: Casos\nTempo de execu��o: " + (tempoFinal - tempoInicial) + "ms", "Informa��o", JOptionPane.INFORMATION_MESSAGE);
					CriarArquivo.criarArquivo(dt);
				} else if (radioHeap.isSelected() && radioObitos.isSelected()) {
					System.out.println("Heap e obitos!");
					long tempoInicial = System.currentTimeMillis();
					HeapSortObitos.heapsort(dt);
					long tempoFinal = System.currentTimeMillis(); 
					System.out.println("Tempo de execu��o do Heap Sort (�bitos): " + (tempoFinal - tempoInicial) + "ms");
					JOptionPane.showMessageDialog(null, "Ordena��o realizada com sucesso!\n\nAlgoritmo: Heap Sort\nPar�metro: �bitos\nTempo de execu��o: " + (tempoFinal - tempoInicial) + "ms", "Informa��o", JOptionPane.INFORMATION_MESSAGE);
					CriarArquivo.criarArquivo(dt);
				} else if (radioHeap.isSelected() && radioCidades.isSelected()) {
					System.out.println("Heap e Cidades!");
					long tempoInicial = System.currentTimeMillis();
					HeapSortCidades.heapsort(dt);
					long tempoFinal = System.currentTimeMillis(); 
					System.out.println("Tempo de execu��o do Heap Sort (Cidades): " + (tempoFinal - tempoInicial) + "ms");
					JOptionPane.showMessageDialog(null, "Ordena��o realizada com sucesso!\n\nAlgoritmo: Heap Sort\nPar�metro: Cidades\nTempo de execu��o: " + (tempoFinal - tempoInicial) + "ms", "Informa��o", JOptionPane.INFORMATION_MESSAGE);
					CriarArquivo.criarArquivo(dt);
				}				

			} catch (IOException | RuntimeException e1) {
				JOptionPane.showMessageDialog(null, "Erro ao exportar arquivo", "Aten��o", JOptionPane.WARNING_MESSAGE);
				System.out.println("Error: " + e1.getMessage());
			}

		}

	}// fim da classe interna bot�o Exportar
	

	//M�todo para posiconar elmentos na tela
	private void addComponent(Component component, int linha, int coluna, int largura, int altura) {
		constraints.gridx = coluna;
		constraints.gridy = linha;
		constraints.gridwidth = largura;
		constraints.gridheight = altura;
		layout.setConstraints(component, constraints);
		add(component);
	}//fim do m�todo addComponent

}
// fim da classe

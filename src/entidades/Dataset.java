package entidades;

import java.util.Arrays;

public class Dataset {

	// Atributos
	private Dado[] dados;

	// Get
	public Dado[] getDados() {
		return dados;
	}
	//Set
	public void setDados(Dado[] dados) {
		this.dados = dados;
	}

	// Adicionar elemento em Array com tamanho dinâmico
	public void adicionarDadoArray(Dado dado) {

		if (this.dados == null) {
			dados = new Dado[1];
			dados[0] = dado;
		} else {

			Dado[] vetorAux = new Dado[dados.length + 1];

			for (int x = 0; x < dados.length; x++) {
				vetorAux[x] = dados[x];
			}
			vetorAux[vetorAux.length - 1] = dado;
			dados = vetorAux;
		}
	}

	// imprimir dados do Dataset
	public void imprimirDataset() {
		for (int i = 0; i < dados.length; i++) {
			System.out.println("Posição " + (i + 1) + ": " + dados[i]);
		}
	}

	// Tamanho do array
	public int tamanhoArray() {
		System.out.println("Quantidade de dados: " + dados.length);
		return dados.length;
	}

}// fim da classe

package gui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import entidades.Dataset;

public class CriarArquivo {

	public static void criarArquivo(Dataset dt) throws IOException {

		//String path = "c:\\Users\\anton\\Desktop\\arquivoTeste.csv";	
		
		String path = SalvarArquivo.getPath();

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {

			// Cabeçalho
			bw.write("date");
			bw.write(";");
			bw.write("state");
			bw.write(";");
			bw.write("city");
			bw.write(";");
			bw.write("confirmed");
			bw.write(";");
			bw.write("deaths");
			bw.newLine();//pula linha

			for (int i = 0; i < dt.getDados().length; i++) {

				String date = dt.getDados()[i].getDate();
				String state = dt.getDados()[i].getState();
				String city = dt.getDados()[i].getCity();
				String confirmed = String.valueOf(dt.getDados()[i].getConfirmed());
				String deaths = String.valueOf(dt.getDados()[i].getDeaths());

				bw.write(date);
				bw.write(";");
				bw.write(state);
				bw.write(";");
				bw.write(city);
				bw.write(";");
				bw.write(confirmed);
				bw.write(";");
				bw.write(deaths);
				bw.newLine();//pula linha
			}	

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e.getMessage(),"Atenção", JOptionPane.PLAIN_MESSAGE);
		}
		

	}// fim do método criarArquivo

}// fim da classe

package gui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SalvarArquivo {

	public static String getPath() throws IOException {

		// obt�m o Path para o arquivo ou diret�rio selecionado pelo usu�rio
		Path path = getDirectoryPath();
		String caminho = null;

		// se existir, retorna o caminho
		if (path != null) {
			caminho = path.toString();
		}
		// Path n�o existe - Abre uma janela de alerta
		else {
			JOptionPane.showMessageDialog(null, "Erro ao salvar - Caminho inexistente", "Aten��o",
					JOptionPane.PLAIN_MESSAGE);
		}

		return caminho;

	}

	// Permite que o usu�rio especifique o local de salvamento
	private static Path getDirectoryPath() {

		// configura o di�logo permitindo a sele��o de um arquivo ou diret�rio
		JFileChooser fileChooser = new JFileChooser(new File("C:\\"));
		fileChooser.setDialogTitle("Salvar como");
		int result = fileChooser.showSaveDialog(null);

		if (result == JFileChooser.APPROVE_OPTION) {
			return fileChooser.getSelectedFile().toPath();			
		}

		// se o usu�rio clicou no bot�o Cancel no di�logo, retorna
		else if (result == JFileChooser.CANCEL_OPTION) {
			//System.exit(1);//finaliza todo o programa (fecha tudo)				
		}
	
		// retorna o Path representando o arquivo selecionado
		return null;
	}


}

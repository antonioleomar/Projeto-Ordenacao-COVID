package gui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AbrirArquivo extends JFrame {

	public String getPath() throws IOException {
		// obt�m o Path para o arquivo ou diret�rio selecionado pelo usu�rio
		Path path = getFileOrDirectoryPath();
		String caminho = null;
		// se existir, exibe as informa��es coleta as informa��es sobre o arquivo (ou diret�rio)
		if (path != null && Files.exists(path)) {
			caminho = path.toString();
		}
		// Path n�o existe - Abre uma janela de alerta
		else {
			JOptionPane.showMessageDialog(this, path.getFileName() + " n�o existe", "ERRO", JOptionPane.ERROR_MESSAGE);
		}		
		return caminho;

	}

	// Permite que o usu�rio especifique o nome de arquivo ou diret�rio
	private Path getFileOrDirectoryPath() {

		// configura o di�logo permitindo a sele��o de um arquivo ou diret�rio
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fileChooser.showOpenDialog(this);

		// se o usu�rio clicou no bot�o Cancel no di�logo, retorna
		if (result == JFileChooser.CANCEL_OPTION) {
			//System.exit(1);//finaliza todo o programa (fecha tudo)
			dispose();//fecha apenas esta janela
		}
		// retorna o Path representando o arquivo selecionado
		return fileChooser.getSelectedFile().toPath();
	}

}

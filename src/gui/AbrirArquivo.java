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
		// obtém o Path para o arquivo ou diretório selecionado pelo usuário
		Path path = getFileOrDirectoryPath();
		String caminho = null;
		// se existir, exibe as informações coleta as informações sobre o arquivo (ou diretório)
		if (path != null && Files.exists(path)) {
			caminho = path.toString();
		}
		// Path não existe - Abre uma janela de alerta
		else {
			JOptionPane.showMessageDialog(this, path.getFileName() + " não existe", "ERRO", JOptionPane.ERROR_MESSAGE);
		}		
		return caminho;

	}

	// Permite que o usuário especifique o nome de arquivo ou diretório
	private Path getFileOrDirectoryPath() {

		// configura o diálogo permitindo a seleção de um arquivo ou diretório
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fileChooser.showOpenDialog(this);

		// se o usuário clicou no botão Cancel no diálogo, retorna
		if (result == JFileChooser.CANCEL_OPTION) {
			//System.exit(1);//finaliza todo o programa (fecha tudo)
			dispose();//fecha apenas esta janela
		}
		// retorna o Path representando o arquivo selecionado
		return fileChooser.getSelectedFile().toPath();
	}

}

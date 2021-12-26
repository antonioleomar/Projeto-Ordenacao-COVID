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

		// obtém o Path para o arquivo ou diretório selecionado pelo usuário
		Path path = getDirectoryPath();
		String caminho = null;

		// se existir, retorna o caminho
		if (path != null) {
			caminho = path.toString();
		}
		// Path não existe - Abre uma janela de alerta
		else {
			JOptionPane.showMessageDialog(null, "Erro ao salvar - Caminho inexistente", "Atenção",
					JOptionPane.PLAIN_MESSAGE);
		}

		return caminho;

	}

	// Permite que o usuário especifique o local de salvamento
	private static Path getDirectoryPath() {

		// configura o diálogo permitindo a seleção de um arquivo ou diretório
		JFileChooser fileChooser = new JFileChooser(new File("C:\\"));
		fileChooser.setDialogTitle("Salvar como");
		int result = fileChooser.showSaveDialog(null);

		if (result == JFileChooser.APPROVE_OPTION) {
			return fileChooser.getSelectedFile().toPath();			
		}

		// se o usuário clicou no botão Cancel no diálogo, retorna
		else if (result == JFileChooser.CANCEL_OPTION) {
			//System.exit(1);//finaliza todo o programa (fecha tudo)				
		}
	
		// retorna o Path representando o arquivo selecionado
		return null;
	}


}

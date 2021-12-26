package aplicacao;

import javax.swing.JFrame;

import gui.TelaPrincipal;


public class ProgramaInterface {

	public static void main(String[] args) {

		TelaPrincipal telaPrincipal = new TelaPrincipal();
		telaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaPrincipal.setSize(500, 300); //tamanho da tela
		telaPrincipal.setResizable(true);// não redimensionar tela
		telaPrincipal.setVisible(true); //janela visivel
		telaPrincipal.setLocationRelativeTo(null);//abre janela no centro

	}
}

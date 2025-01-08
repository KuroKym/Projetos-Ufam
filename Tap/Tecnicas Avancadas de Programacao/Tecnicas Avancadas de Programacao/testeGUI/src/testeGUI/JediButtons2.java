package testeGUI;
import java.awt.*;
import javax.swing.*;

class JediButtons2 {
	public static void main(String[] args) {
		JFrame janela = new JFrame("Botões Jedi");
		janela.setLayout(new BorderLayout());
		janela.add(new JButton("Yoda"), BorderLayout.NORTH);
		janela.add(new JButton("Qui-Gon"), BorderLayout.WEST);
		janela.add(new JButton("Obi-Wan"), BorderLayout.CENTER);
		janela.add(new JButton("Anakin"), BorderLayout.EAST);
		janela.add(new JButton("Luke Skywalker"), BorderLayout.SOUTH);
		janela.setSize(340, 140);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

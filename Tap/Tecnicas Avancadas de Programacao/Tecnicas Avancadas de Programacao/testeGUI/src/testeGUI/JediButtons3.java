package testeGUI;

import java.awt.*;
import javax.swing.*;
class JediButtons3 {
	public static void main(String[] args) {
		JFrame janela = new JFrame("Botões Jedi");
		janela.setLayout(new GridLayout(3, 2));
		janela.add(new JButton("N'Kata Del Gormo"));
		janela.add(new JButton("Yoda"));
		janela.add(new JButton("Qui-Gon Jinn"));
		janela.add(new JButton("Obi-Wan Kenobi"));
		janela.add(new JButton("Anakin Skywalker"));
		janela.add(new JButton("Luke Skywalker"));
		janela.setSize(340, 140);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

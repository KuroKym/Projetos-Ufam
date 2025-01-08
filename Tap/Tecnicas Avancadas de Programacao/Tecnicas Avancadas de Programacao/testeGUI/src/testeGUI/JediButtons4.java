package testeGUI;

import java.awt.*;
import javax.swing.*;

class JediButtons4 {
	public static void main(String[] args) {
		JFrame janela = new JFrame("Botões Jedi");
		janela.setSize(340, 140);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		janela.setLayout(new BorderLayout());
		janela.add(new JLabel("Jedi High Council"), BorderLayout.NORTH);
		janela.add(new JLabel("<<"), BorderLayout.WEST);
		janela.add(new JLabel(">>"), BorderLayout.EAST);
		janela.add(new JLabel("May the Force be with you!"), BorderLayout.SOUTH);
		
		JPanel pCenter = new JPanel();
		pCenter.setLayout(new GridLayout(2, 3));
		pCenter.add(new JButton("Yoda")); pCenter.add(new JButton("Mace Windu"));
		pCenter.add(new JButton("Obi-Wan")); pCenter.add(new JButton("Plo Koon"));
		pCenter.add(new JButton("Kit Fisto")); pCenter.add(new JButton("Shaak Ti"));
		janela.add(pCenter, BorderLayout.CENTER);
		
		janela.setVisible(true);
	}
}

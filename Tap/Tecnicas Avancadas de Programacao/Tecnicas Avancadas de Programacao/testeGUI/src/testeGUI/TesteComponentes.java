package testeGUI;

import javax.swing.*;

class TesteComponentes {
	public static void main(String[] args) {
		JFrame janela = new JFrame("Componente: JLabel");
		janela.setLayout(null);
		janela.setSize(345, 130);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		janela.setContentPane(new JLabel(new ImageIcon("/home/andre/Transferências/maytheforcebewithyou.jpg")));
		
		JLabel comp = new JLabel("Exemplo de uso do JLabel");
		comp.setBounds(20, 10, 280, 15); janela.add(comp);
		
		JLabel comp2 = new JLabel(new ImageIcon("/home/andre/Transferências/maytheforcebewithyou.jpg"));
		comp2.setBounds(20, 30, 118, 65); janela.add(comp2);
		janela.setVisible(true);
	}
}

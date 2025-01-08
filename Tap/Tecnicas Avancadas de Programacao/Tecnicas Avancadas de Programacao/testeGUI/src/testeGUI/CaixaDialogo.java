package testeGUI;

import javax.swing.*;

class CaixaDialogo {

	public static void main(String[] args) {
	
		String nome =JOptionPane.showInputDialog("Digite seu nome:");
		
		int confirm =  JOptionPane.showConfirmDialog(null, "Tem certeza ?");
		
		if(confirm == 0) {
			JOptionPane.showMessageDialog(null, nome + ", may the Force be with you", "Greetings", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("/home/andre/Transferências/maytheforcebewithyou.jpg"));
		}
	}
}
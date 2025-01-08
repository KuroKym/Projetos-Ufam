package testeGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TesteNovaJanela {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteNovaJanela window = new TesteNovaJanela();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TesteNovaJanela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Voce acessou o sistema!");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAquiEstaraO = new JLabel("Aqui estara o resto do sistema");
		lblAquiEstaraO.setBounds(114, 12, 233, 15);
		frame.getContentPane().add(lblAquiEstaraO);
	}

	public JFrame getFrame() {
		return frame;
	}	

}

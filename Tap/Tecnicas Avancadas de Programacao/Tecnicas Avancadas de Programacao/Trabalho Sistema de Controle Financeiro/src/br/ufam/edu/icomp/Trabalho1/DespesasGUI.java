package br.ufam.edu.icomp.Trabalho1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class DespesasGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DespesasGUI window = new DespesasGUI();
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
	public DespesasGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Despesas");
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel lblOQueVoc = new JLabel("O que você gostaria de fazer com alguma despesa?");
		lblOQueVoc.setBounds(38, 12, 426, 15);
		lblOQueVoc.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 14));
		frame.getContentPane().add(lblOQueVoc);
		
		JButton btnConsultarDespesas = new JButton("Consultar Despesa");
		btnConsultarDespesas.setBounds(145, 71, 188, 25);
		btnConsultarDespesas.addActionListener((ActionEvent e) -> {
				ConsultarDespesasGUI cons = new ConsultarDespesasGUI();
				cons.getFrame().setVisible(true);
			});
		frame.getContentPane().add(btnConsultarDespesas);
		
		JButton btnRemoverDespesa = new JButton("Remover Despesa");
		btnRemoverDespesa.setBounds(155, 108, 178, 25);
		btnRemoverDespesa.addActionListener((ActionEvent e) -> {
			RemoverDespesaGUI rem = new RemoverDespesaGUI();
			rem.getFrame().setVisible(true);
		});
		frame.getContentPane().add(btnRemoverDespesa);
		
		JButton btnAlterarDespesa = new JButton("Alterar Despesa");
		btnAlterarDespesa.setBounds(155, 145, 178, 25);
		btnAlterarDespesa.addActionListener((ActionEvent e) -> {
			AlterarDespesaGUI alt = new AlterarDespesaGUI();
			alt.getFrame().setVisible(true);
		});
		frame.getContentPane().add(btnAlterarDespesa);
	}

	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}

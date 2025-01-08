package br.ufam.edu.icomp.Trabalho1;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SistemaGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SistemaGUI window = new SistemaGUI();
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
	public SistemaGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Sistema de Controle Financeiro SCF v1.0");
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBemVindoAo = new JLabel("Bem vindo ao SCF!!");
		lblBemVindoAo.setBounds(143, 12, 214, 15);
		lblBemVindoAo.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 19));
		frame.getContentPane().add(lblBemVindoAo);
		
		JLabel lblOQueVoc = new JLabel("O que você deseja fazer?");
		lblOQueVoc.setBounds(142, 40, 229, 15);
		lblOQueVoc.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 15));
		frame.getContentPane().add(lblOQueVoc);
		
		JButton btnRelatrios = new JButton("Projetos");
		btnRelatrios.setBounds(81, 89, 117, 25);
		btnRelatrios.addActionListener((ActionEvent e) -> {
			ProjetosGUI proj = new ProjetosGUI();
			proj.getFrame().setVisible(true);
			});
		frame.getContentPane().add(btnRelatrios);
		
		JButton btnDespesas = new JButton("Despesas");
		btnDespesas.setBounds(282, 89, 117, 25);
		btnDespesas.addActionListener((ActionEvent e) -> {
			DespesasGUI proj = new DespesasGUI();
			proj.getFrame().setVisible(true);
			});
		frame.getContentPane().add(btnDespesas);
		
		JButton btnSobre = new JButton("Sobre o sistema...");
		btnSobre.setBounds(158, 209, 174, 25);
		btnSobre.addActionListener((ActionEvent e) -> {
			JOptionPane.showMessageDialog(null, "Sistema de Controle Financeiro v1.0!!!");
			});
		frame.getContentPane().add(btnSobre);
	}
}
package br.ufam.edu.icomp.Trabalho1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class ConsultarDespesasGUI {

	private JFrame frame;
	private JTextField txtNome;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnConsultar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarDespesasGUI window = new ConsultarDespesasGUI();
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
	public ConsultarDespesasGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Consulta de despesas");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		ProjetosDAO projetosDAO = new ProjetosDAO();
		
		JLabel lblInformeONome = new JLabel("Informe o nome da tabela de despesas do projeto");
		lblInformeONome.setBounds(12, 12, 450, 19);
		lblInformeONome.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 16));
		frame.getContentPane().add(lblInformeONome);
		
		txtNome = new JTextField();
		txtNome.setText("nome");
		txtNome.setBounds(12, 39, 541, 19);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 76, 728, 462);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 16));
		scrollPane.setViewportView(textArea);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(592, 36, 117, 25);
		btnConsultar.addActionListener((ActionEvent e) -> {
			textArea.setText("");
			String nomeTabelaDespesa = txtNome.getText();
			textArea.append(projetosDAO.mostrarDespesasProjeto(nomeTabelaDespesa));
			});
		frame.getContentPane().add(btnConsultar);
	}
	
	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}

package br.ufam.edu.icomp.Trabalho1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class RemoverProjetoGUI {

	private JFrame frame;
	private JTextField txtTitulo;
	private JButton btnRemovr;
	private JButton btnMostrarProjetos;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JTextField txtNomeDaTabela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoverProjetoGUI window = new RemoverProjetoGUI();
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
	public RemoverProjetoGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Remover projeto");
		frame.setBounds(100, 100, 650, 500);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		ProjetosDAO projetosDAO = new ProjetosDAO();
		
		JLabel lblInformeOTtulo = new JLabel("Informe o título de um projeto a ser removido");
		lblInformeOTtulo.setBounds(12, 12, 433, 26);
		lblInformeOTtulo.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 16));
		frame.getContentPane().add(lblInformeOTtulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setText("titulo");
		txtTitulo.setBounds(12, 39, 417, 19);
		frame.getContentPane().add(txtTitulo);
		txtTitulo.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 124, 610, 293);
		frame.getContentPane().add(scrollPane);
		
		JLabel lblInformeONome = new JLabel("Informe o nome da tabela de despesas a ser removida");
		lblInformeONome.setBounds(12, 70, 504, 15);
		lblInformeONome.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 16));
		frame.getContentPane().add(lblInformeONome);
		
		txtNomeDaTabela = new JTextField();
		txtNomeDaTabela.setText("nome da tabela");
		txtNomeDaTabela.setBounds(12, 93, 417, 19);
		frame.getContentPane().add(txtNomeDaTabela);
		txtNomeDaTabela.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 16));
		scrollPane.setViewportView(textArea);
		
		btnRemovr = new JButton("Remover");
		btnRemovr.setBounds(463, 36, 117, 25);
		btnRemovr.addActionListener((ActionEvent e) -> {
			if(projetosDAO.removerProjeto(txtTitulo.getText()) && projetosDAO.removerDespesaBD(txtNomeDaTabela.getText())){
				JOptionPane.showMessageDialog(null, "Remoção realizada com sucesso!");
			}else {
				JOptionPane.showMessageDialog(null, "ERRO Reveja parâmetros!!!");
			}
			});
		frame.getContentPane().add(btnRemovr);
		
		btnMostrarProjetos = new JButton("Mostrar projetos");
		btnMostrarProjetos.setBounds(12, 429, 209, 25);
		btnMostrarProjetos.addActionListener((ActionEvent e) -> {
			textArea.setText("");
			textArea.append(projetosDAO.mostrarProjetos());
			});
		frame.getContentPane().add(btnMostrarProjetos);
	}

	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}

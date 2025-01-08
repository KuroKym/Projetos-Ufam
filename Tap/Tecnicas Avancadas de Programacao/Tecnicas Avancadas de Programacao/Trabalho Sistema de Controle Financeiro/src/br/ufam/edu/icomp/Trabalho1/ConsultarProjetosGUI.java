package br.ufam.edu.icomp.Trabalho1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class ConsultarProjetosGUI {

	private JFrame frame;
	private JTextField txtNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarProjetosGUI window = new ConsultarProjetosGUI();
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
	public ConsultarProjetosGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ProjetosDAO projetosDAO = new ProjetosDAO();
		frame = new JFrame("Consulta de Projetos");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel lblProjetosCadastradosNo = new JLabel("Informe o nome de um projeto cadastrado no banco de dados");
		lblProjetosCadastradosNo.setBounds(12, 12, 689, 23);
		lblProjetosCadastradosNo.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 19));
		frame.getContentPane().add(lblProjetosCadastradosNo);
		
		txtNome = new JTextField();
		txtNome.setText("nome");
		txtNome.setBounds(12, 47, 547, 19);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 129, 737, 384);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea .setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 19));
		scrollPane.setViewportView(textArea);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(617, 44, 117, 25);
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			textArea.setText("");
			String tituloProj = txtNome.getText();
			textArea.append(projetosDAO.mostrarProjeto(tituloProj));
				
			}
		});
		frame.getContentPane().add(btnConsultar);

		JButton btnNewButton = new JButton("Mostrar todos os projetos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			textArea.setText("");
			textArea.append(projetosDAO.mostrarProjetos());
			}
		});
		btnNewButton.setBounds(12, 78, 246, 25);
		frame.getContentPane().add(btnNewButton);
		
		
	}

	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}

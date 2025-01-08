package br.ufam.edu.icomp.Trabalho1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class ProjetosGUI {

	private JFrame frame;

	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjetosGUI window = new ProjetosGUI();
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
	public ProjetosGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Controle de Projetos");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel lblControleDeProjetos = new JLabel("Cadastro e Consulta de Projetos");
		lblControleDeProjetos.setBounds(47, 12, 358, 15);
		lblControleDeProjetos.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 19));
		frame.getContentPane().add(lblControleDeProjetos);
		
		JLabel lblOQueVoc = new JLabel("O que você gostaria de fazer?");
		lblOQueVoc.setBounds(119, 39, 218, 15);
		frame.getContentPane().add(lblOQueVoc);
		
		JButton btnCadastrarUmNovo = new JButton("Cadastrar um novo Projeto");
		btnCadastrarUmNovo.setBounds(103, 79, 238, 25);
		btnCadastrarUmNovo.addActionListener((ActionEvent e) -> {
			CadastrarProjetoGUI proj = new CadastrarProjetoGUI();
			proj.getFrame().setVisible(true);
			});
		frame.getContentPane().add(btnCadastrarUmNovo);
		
		JButton btnConsultarProjetosCadastrados = new JButton("Consultar projetos cadastrados");
		btnConsultarProjetosCadastrados.setBounds(80, 116, 281, 25);
		btnConsultarProjetosCadastrados.addActionListener((ActionEvent e) -> {
			ConsultarProjetosGUI proj = new ConsultarProjetosGUI();
			proj.getFrame().setVisible(true);
			});
		frame.getContentPane().add(btnConsultarProjetosCadastrados);
		
		JButton btnCorrigirInformaesDe = new JButton("Alterar informações de um projeto");
		btnCorrigirInformaesDe.setBounds(33, 153, 358, 25);
		btnCorrigirInformaesDe.addActionListener((ActionEvent e) -> {
			AlterarInfoProjGUI proj = new AlterarInfoProjGUI();
			proj.getFrame().setVisible(true);
			});
		frame.getContentPane().add(btnCorrigirInformaesDe);
		
		JButton btnRemoverUmProjeto = new JButton("Remover um projeto");
		btnRemoverUmProjeto.setBounds(114, 190, 212, 25);
		btnRemoverUmProjeto.addActionListener((ActionEvent e) -> {
			RemoverProjetoGUI proj = new RemoverProjetoGUI();
			proj.getFrame().setVisible(true);
			});
		frame.getContentPane().add(btnRemoverUmProjeto);
	}
}

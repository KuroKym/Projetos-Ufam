package br.ufam.edu.icomp.Trabalho1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RemoverDespesaGUI {

	private JFrame frame;
	private JTextField txtNomeTabela;
	private JTextField txtDescricaoDespesa;
	private JButton btnRemover;
	private JTextField txtDescricaoDespesaMat;
	private JLabel lblDescrioDaDespesa_1;
	private JTextField txtDescricaoServTerc;
	private JButton btnRemoverDespServ;
	private JLabel lblNewLabel;
	private JTextField txtDescricaoServTerc_1;
	private JButton btnNewButton;
	private JLabel lblDescrioDaDespesa_2;
	private JTextField txtDescricaoDespPass;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_1;
	private JTextField txtDescricaoDespDiaria;
	private JButton btnRemoverDespDiaria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoverDespesaGUI window = new RemoverDespesaGUI();
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
	public RemoverDespesaGUI() {
		initialize();
	}

	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Remover despesas");
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		ProjetosDAO projetosDAO = new ProjetosDAO();
		
		JLabel lblInformeONome = new JLabel("Informe o nome da tabela de despesas do projeto");
		lblInformeONome.setBounds(12, 12, 466, 15);
		lblInformeONome.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 14));
		frame.getContentPane().add(lblInformeONome);
		
		txtNomeTabela = new JTextField();
		txtNomeTabela.setText("nome tabela");
		txtNomeTabela.setBounds(12, 39, 448, 19);
		frame.getContentPane().add(txtNomeTabela);
		txtNomeTabela.setColumns(10);
		
		JLabel lblInformeONome_1 = new JLabel("Descrição da despesa de capital a ser removida");
		lblInformeONome_1.setBounds(12, 98, 477, 15);
		lblInformeONome_1.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 14));
		frame.getContentPane().add(lblInformeONome_1);
		
		txtDescricaoDespesa = new JTextField();
		txtDescricaoDespesa.setText("descricao despesa capital");
		txtDescricaoDespesa.setBounds(12, 125, 345, 19);
		frame.getContentPane().add(txtDescricaoDespesa);
		txtDescricaoDespesa.setColumns(10);
		
		btnRemover = new JButton("Remover Desp cap");
		btnRemover.addActionListener((ActionEvent e) -> {
			if(projetosDAO.removerDespesaDoProjeto(txtNomeTabela.getText(), txtDescricaoDespesa.getText()) && 
					projetosDAO.atualizarTotalDespesaDoProjeto(txtNomeTabela.getText(), "desp_cap", "Despesa de Capital") &&
					projetosDAO.atualizarValorPrevistoDoProjeto(txtNomeTabela.getText())) {
				JOptionPane.showMessageDialog(null, "Remoção realizada com sucesso!");
			}else {
				JOptionPane.showMessageDialog(null, "ERRO reveja parâmetros!!!");
			}
		});
		btnRemover.setBounds(395, 122, 183, 25);
		frame.getContentPane().add(btnRemover);
		
		JLabel lblDescrioDaDespesa = new JLabel("Descrição da despesa de Mat. de Consumo a ser removida");
		lblDescrioDaDespesa.setBounds(12, 168, 512, 15);
		lblDescrioDaDespesa.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 14));
		frame.getContentPane().add(lblDescrioDaDespesa);
		
		txtDescricaoDespesaMat = new JTextField();
		txtDescricaoDespesaMat.setText("descricao despesa mat consumo");
		txtDescricaoDespesaMat.setBounds(12, 195, 345, 19);
		frame.getContentPane().add(txtDescricaoDespesaMat);
		txtDescricaoDespesaMat.setColumns(10);
		
		JButton btnRemoverDespMat = new JButton("Remover Desp Mat Cons");
		btnRemoverDespMat.setBounds(369, 192, 209, 25);
		btnRemoverDespMat.addActionListener((ActionEvent e) -> {
			if(projetosDAO.removerDespesaDoProjeto(txtNomeTabela.getText(), txtDescricaoDespesaMat.getText()) && 
					projetosDAO.atualizarTotalDespesaDoProjeto(txtNomeTabela.getText(), "desp_mat_cons", "Despesa Material de Consumo") &&
					projetosDAO.atualizarValorPrevistoDoProjeto(txtNomeTabela.getText())) {
				JOptionPane.showMessageDialog(null, "Remoção realizada com sucesso!");
			}else {
				JOptionPane.showMessageDialog(null, "ERRO reveja parâmetros!!!");
			}
		});
		frame.getContentPane().add(btnRemoverDespMat);
		
		lblDescrioDaDespesa_1 = new JLabel("Descrição da despesa Serv. Terc. Pessoa Fisica a ser removida");
		lblDescrioDaDespesa_1.setBounds(12, 239, 566, 15);
		lblDescrioDaDespesa_1.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 14));
		frame.getContentPane().add(lblDescrioDaDespesa_1);
		
		txtDescricaoServTerc = new JTextField();
		txtDescricaoServTerc.setText("descricao serv terc pes fis");
		txtDescricaoServTerc.setBounds(12, 266, 292, 19);
		frame.getContentPane().add(txtDescricaoServTerc);
		txtDescricaoServTerc.setColumns(10);
		
		btnRemoverDespServ = new JButton("Remover Desp Serv Terc Pes Fis");
		btnRemoverDespServ.setBounds(316, 263, 262, 25);
		btnRemoverDespServ.addActionListener((ActionEvent e) -> {
			if(projetosDAO.removerDespesaDoProjeto(txtNomeTabela.getText(), txtDescricaoServTerc.getText()) && 
					projetosDAO.atualizarTotalDespesaDoProjeto(txtNomeTabela.getText(), "serv_pes_fis", "Servicos Pessoa Fisica") &&
					projetosDAO.atualizarValorPrevistoDoProjeto(txtNomeTabela.getText())) {
				JOptionPane.showMessageDialog(null, "Remoção realizada com sucesso!");
			}else {
				JOptionPane.showMessageDialog(null, "ERRO reveja parâmetros!!!");
			}
		});
		frame.getContentPane().add(btnRemoverDespServ);
		
		lblNewLabel = new JLabel("Descrição da despesa Serv. Terc. Pessoa Juridica a ser removida");
		lblNewLabel.setBounds(12, 314, 566, 15);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 14));
		frame.getContentPane().add(lblNewLabel);
		
		txtDescricaoServTerc_1 = new JTextField();
		txtDescricaoServTerc_1.setText("descricao serv terc pes jur");
		txtDescricaoServTerc_1.setBounds(12, 341, 292, 19);
		frame.getContentPane().add(txtDescricaoServTerc_1);
		txtDescricaoServTerc_1.setColumns(10);
		
		btnNewButton = new JButton("Remover Desp Serv TercPes Jur");
		btnNewButton.setBounds(316, 341, 262, 25);
		btnNewButton.addActionListener((ActionEvent e) -> {
			if(projetosDAO.removerDespesaDoProjeto(txtNomeTabela.getText(), txtDescricaoServTerc_1.getText()) && 
					projetosDAO.atualizarTotalDespesaDoProjeto(txtNomeTabela.getText(), "serv_pes_jur", "Servicos Pessoa Juridica") &&
					projetosDAO.atualizarValorPrevistoDoProjeto(txtNomeTabela.getText())) {
				JOptionPane.showMessageDialog(null, "Remoção realizada com sucesso!");
			}else {
				JOptionPane.showMessageDialog(null, "ERRO reveja parâmetros!!!");
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("Descrição da despesa Diarias a ser removida");
		lblNewLabel_1.setBounds(12, 380, 512, 15);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 14));
		frame.getContentPane().add(lblNewLabel_1);
		
		txtDescricaoDespDiaria = new JTextField();
		txtDescricaoDespDiaria.setText("descricao desp diaria");
		txtDescricaoDespDiaria.setBounds(12, 407, 302, 19);
		frame.getContentPane().add(txtDescricaoDespDiaria);
		txtDescricaoDespDiaria.setColumns(10);
		
		btnRemoverDespDiaria = new JButton("Remover Desp Diaria");
		btnRemoverDespDiaria.setBounds(343, 404, 235, 25);
		btnRemoverDespDiaria.addActionListener((ActionEvent e) -> {
			if(projetosDAO.removerDespesaDoProjeto(txtNomeTabela.getText(), txtDescricaoDespDiaria.getText()) && 
					projetosDAO.atualizarTotalDespesaDoProjeto(txtNomeTabela.getText(), "diarias", "Diarias") &&
					projetosDAO.atualizarValorPrevistoDoProjeto(txtNomeTabela.getText())) {
				JOptionPane.showMessageDialog(null, "Remoção realizada com sucesso!");
			}else {
				JOptionPane.showMessageDialog(null, "ERRO reveja parâmetros!!!");
			}
		});
		frame.getContentPane().add(btnRemoverDespDiaria);
		
		lblDescrioDaDespesa_2 = new JLabel("Descrição da despesa Passagem a ser removida");
		lblDescrioDaDespesa_2.setBounds(12, 453, 466, 15);
		lblDescrioDaDespesa_2.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 14));
		frame.getContentPane().add(lblDescrioDaDespesa_2);
		
		txtDescricaoDespPass = new JTextField();
		txtDescricaoDespPass.setText("descricao desp pass");
		txtDescricaoDespPass.setBounds(12, 483, 302, 19);
		frame.getContentPane().add(txtDescricaoDespPass);
		txtDescricaoDespPass.setColumns(10);
		
		btnNewButton_1 = new JButton("Remover Desp Passagem");
		btnNewButton_1.setBounds(348, 480, 230, 25);
		btnNewButton_1.addActionListener((ActionEvent e) -> {
			if(projetosDAO.removerDespesaDoProjeto(txtNomeTabela.getText(), txtDescricaoDespPass.getText()) && 
					projetosDAO.atualizarTotalDespesaDoProjeto(txtNomeTabela.getText(), "passagens", "Passagem") &&
					projetosDAO.atualizarValorPrevistoDoProjeto(txtNomeTabela.getText())) {
				JOptionPane.showMessageDialog(null, "Remoção realizada com sucesso!");
			}else {
				JOptionPane.showMessageDialog(null, "ERRO reveja parâmetros!!!");
			}
		});
		frame.getContentPane().add(btnNewButton_1);	
	}
}

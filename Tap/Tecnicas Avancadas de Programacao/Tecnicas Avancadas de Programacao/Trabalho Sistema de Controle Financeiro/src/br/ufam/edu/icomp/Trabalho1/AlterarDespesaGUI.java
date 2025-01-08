package br.ufam.edu.icomp.Trabalho1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AlterarDespesaGUI {

	private JFrame frame;
	private JTextField txtNomeTabDesp;
	private JTextField txtDescricaoDespCap;
	private JLabel lblInformeONovo;
	private JTextField txtNovoValorDesp;
	private JButton btnAlterarDespesaCapital;
	private JLabel lblInformeADescrio_1;
	private JTextField txtDescricaoDespMat;
	private JLabel lblInformeONovo_1;
	private JTextField txtNovoValorDesp_1;
	private JButton btnAlterarDespesaMat;
	private JLabel lblInformeADescrio_2;
	private JTextField txtDescricaoDespServ;
	private JLabel lblInformeONovo_2;
	private JTextField txtNovoValorDesp_2;
	private JButton btnAlterarDespServ;
	private JLabel lblInformeADescrio_3;
	private JTextField txtDescricaoDespServ_1;
	private JLabel lblInformeONovo_3;
	private JTextField txtNovoValorDesp_3;
	private JButton btnAlterarDespServ_1;
	private JLabel lblInformeADescrio_4;
	private JTextField txtDescricaoDiarias;
	private JLabel lblInformeONovo_4;
	private JTextField txtNovoValorDiaria;
	private JButton btnAlterarDiaria;
	private JLabel lblInformeADescrio_5;
	private JTextField txtDescricaoPassagem;
	private JLabel lblInformeONovo_5;
	private JTextField txtNovoValorPassagem;
	private JButton btnAlterarPassagem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarDespesaGUI window = new AlterarDespesaGUI();
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
	public AlterarDespesaGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Alterar despesa");
		frame.setBounds(100, 100, 650, 1000);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ProjetosDAO projetosDAO = new ProjetosDAO();
		
		JLabel lblInformeONome = new JLabel("Informe o nome da tabela de despesas cuja despesa irá ser alterada");
		lblInformeONome.setBounds(12, 12, 566, 15);
		lblInformeONome.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 14));
		frame.getContentPane().add(lblInformeONome);
		
		txtNomeTabDesp = new JTextField();
		txtNomeTabDesp.setText("nome tab desp");
		txtNomeTabDesp.setBounds(12, 39, 529, 19);
		frame.getContentPane().add(txtNomeTabDesp);
		txtNomeTabDesp.setColumns(10);
		
		JLabel lblInformeADescrio = new JLabel("Informe a descrição da Despesa de Capital a ser alterada");
		lblInformeADescrio.setBounds(12, 87, 490, 15);
		lblInformeADescrio.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 14));
		frame.getContentPane().add(lblInformeADescrio);
		
		txtDescricaoDespCap = new JTextField();
		txtDescricaoDespCap.setText("descricao desp cap");
		txtDescricaoDespCap.setBounds(12, 114, 616, 19);
		frame.getContentPane().add(txtDescricaoDespCap);
		txtDescricaoDespCap.setColumns(10);
		
		lblInformeONovo = new JLabel("Informe o novo valor da Despesa de Capital");
		lblInformeONovo.setBounds(12, 145, 400, 15);
		lblInformeONovo.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 14));
		frame.getContentPane().add(lblInformeONovo);
		
		txtNovoValorDesp = new JTextField();
		txtNovoValorDesp.setText("novo valor desp cap");
		txtNovoValorDesp.setBounds(12, 172, 309, 19);
		frame.getContentPane().add(txtNovoValorDesp);
		txtNovoValorDesp.setColumns(10);
		
		btnAlterarDespesaCapital = new JButton("Alterar Despesa Capital");
		btnAlterarDespesaCapital.setBounds(333, 169, 295, 25);
		btnAlterarDespesaCapital.addActionListener((ActionEvent e) -> {
			Double novoValor = Double.parseDouble(txtNovoValorDesp.getText());
			if(projetosDAO.alterarValorDespesaBD(txtNomeTabDesp.getText(), txtDescricaoDespCap.getText(), novoValor) &&
					projetosDAO.atualizarTotalDespesaDoProjeto(txtNomeTabDesp.getText(), "desp_cap", "Despesa de Capital") &&
					projetosDAO.atualizarValorPrevistoDoProjeto(txtNomeTabDesp.getText())){
				JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");
			}else {
				JOptionPane.showMessageDialog(null, "ERRO reveja parâmetros!!!");
			}
		});
		frame.getContentPane().add(btnAlterarDespesaCapital);
		
		lblInformeADescrio_1 = new JLabel("Informe a descrição da Despesa de Material de Consumo a ser alterada");
		lblInformeADescrio_1.setBounds(12, 230, 616, 15);
		lblInformeADescrio_1.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 14));
		frame.getContentPane().add(lblInformeADescrio_1);
		
		txtDescricaoDespMat = new JTextField();
		txtDescricaoDespMat.setText("descricao desp mat cons");
		txtDescricaoDespMat.setBounds(12, 257, 616, 19);
		frame.getContentPane().add(txtDescricaoDespMat);
		txtDescricaoDespMat.setColumns(10);
		
		lblInformeONovo_1 = new JLabel("Informe o novo valor da Despesa de Material de Consumo");
		lblInformeONovo_1.setBounds(12, 288, 490, 15);
		lblInformeONovo_1.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 14));
		frame.getContentPane().add(lblInformeONovo_1);
		
		txtNovoValorDesp_1 = new JTextField();
		txtNovoValorDesp_1.setText("novo valor desp mat cons");
		txtNovoValorDesp_1.setBounds(12, 315, 270, 19);
		frame.getContentPane().add(txtNovoValorDesp_1);
		txtNovoValorDesp_1.setColumns(10);
		
		btnAlterarDespesaMat = new JButton("Alterar Despesa Mat. Consumo");
		btnAlterarDespesaMat.setBounds(294, 315, 334, 25);
		btnAlterarDespesaMat.addActionListener((ActionEvent e) -> {
			Double novoValor = Double.parseDouble(txtNovoValorDesp_1.getText());
			if(projetosDAO.alterarValorDespesaBD(txtNomeTabDesp.getText(), txtDescricaoDespMat.getText(), novoValor) &&
					projetosDAO.atualizarTotalDespesaDoProjeto(txtNomeTabDesp.getText(), "desp_mat_cons", "Despesa Material de Consumo") &&
					projetosDAO.atualizarValorPrevistoDoProjeto(txtNomeTabDesp.getText())){
				JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");
			}else {
				JOptionPane.showMessageDialog(null, "ERRO reveja parâmetros!!!");
			}
		});
		frame.getContentPane().add(btnAlterarDespesaMat);
		
		lblInformeADescrio_2 = new JLabel("Informe a descrição da Desp. de Serv. Terc. Pessoa Física a ser alterada");
		lblInformeADescrio_2.setBounds(12, 376, 616, 15);
		lblInformeADescrio_2.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 14));
		frame.getContentPane().add(lblInformeADescrio_2);
		
		txtDescricaoDespServ = new JTextField();
		txtDescricaoDespServ.setText("descricao desp serv terc pes fis");
		txtDescricaoDespServ.setBounds(12, 396, 616, 19);
		frame.getContentPane().add(txtDescricaoDespServ);
		txtDescricaoDespServ.setColumns(10);
		
		lblInformeONovo_2 = new JLabel("Informe o novo valor da Desp. Serv. Terc. Pes. Fisica");
		lblInformeONovo_2.setBounds(12, 427, 566, 15);
		lblInformeONovo_2.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 14));
		frame.getContentPane().add(lblInformeONovo_2);
		
		txtNovoValorDesp_2 = new JTextField();
		txtNovoValorDesp_2.setText("novo valor desp serv terc pes fis");
		txtNovoValorDesp_2.setBounds(12, 454, 270, 19);
		frame.getContentPane().add(txtNovoValorDesp_2);
		txtNovoValorDesp_2.setColumns(10);
		
		btnAlterarDespServ = new JButton("Alterar Desp. Serv. Terc. Pes. Fis.");
		btnAlterarDespServ.setBounds(294, 454, 334, 25);
		btnAlterarDespServ.addActionListener((ActionEvent e) -> {
			Double novoValor = Double.parseDouble(txtNovoValorDesp_2.getText());
			if(projetosDAO.alterarValorDespesaBD(txtNomeTabDesp.getText(), txtDescricaoDespServ.getText(), novoValor) &&
					projetosDAO.atualizarTotalDespesaDoProjeto(txtNomeTabDesp.getText(), "serv_pes_fis", "Servicos Pessoa Fisica") &&
					projetosDAO.atualizarValorPrevistoDoProjeto(txtNomeTabDesp.getText())){
				JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");
			}else {
				JOptionPane.showMessageDialog(null, "ERRO reveja parâmetros!!!");
			}
		});
		frame.getContentPane().add(btnAlterarDespServ);
		
		lblInformeADescrio_3 = new JLabel("Informe a descrição da Desp. Serv. Terc. Pes. Jurídica a ser alterada");
		lblInformeADescrio_3.setBounds(12, 505, 566, 15);
		lblInformeADescrio_3.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 14));
		frame.getContentPane().add(lblInformeADescrio_3);
		
		txtDescricaoDespServ_1 = new JTextField();
		txtDescricaoDespServ_1.setText("descricao desp serv terc pes jur");
		txtDescricaoDespServ_1.setBounds(12, 532, 616, 19);
		frame.getContentPane().add(txtDescricaoDespServ_1);
		txtDescricaoDespServ_1.setColumns(10);
		
		lblInformeONovo_3 = new JLabel("Informe o novo valor da Desp. Serv. Terc. Pes. Jurídica");
		lblInformeONovo_3.setBounds(12, 563, 566, 15);
		lblInformeONovo_3.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 14));
		frame.getContentPane().add(lblInformeONovo_3);
		
		txtNovoValorDesp_3 = new JTextField();
		txtNovoValorDesp_3.setText("novo valor desp serv terc pes jur");
		txtNovoValorDesp_3.setBounds(12, 590, 270, 19);
		frame.getContentPane().add(txtNovoValorDesp_3);
		txtNovoValorDesp_3.setColumns(10);
		
		btnAlterarDespServ_1 = new JButton("Alterar Desp. Serv. Terc. Pes. Jur.");
		btnAlterarDespServ_1.setBounds(294, 590, 334, 25);
		btnAlterarDespServ_1.addActionListener((ActionEvent e) -> {
			Double novoValor = Double.parseDouble(txtNovoValorDesp_3.getText());
			if(projetosDAO.alterarValorDespesaBD(txtNomeTabDesp.getText(), txtDescricaoDespServ_1.getText(), novoValor) &&
					projetosDAO.atualizarTotalDespesaDoProjeto(txtNomeTabDesp.getText(), "serv_pes_jur", "Servicos Pessoa Juridica") &&
					projetosDAO.atualizarValorPrevistoDoProjeto(txtNomeTabDesp.getText())){
				JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");
			}else {
				JOptionPane.showMessageDialog(null, "ERRO reveja parâmetros!!!");
			}
		});
		frame.getContentPane().add(btnAlterarDespServ_1);
		
		lblInformeADescrio_4 = new JLabel("Informe a descrição da Diaria a ser alterada");
		lblInformeADescrio_4.setBounds(12, 639, 490, 15);
		lblInformeADescrio_4.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 14));
		frame.getContentPane().add(lblInformeADescrio_4);
		
		txtDescricaoDiarias = new JTextField();
		txtDescricaoDiarias.setText("descricao diarias");
		txtDescricaoDiarias.setBounds(12, 666, 616, 19);
		frame.getContentPane().add(txtDescricaoDiarias);
		txtDescricaoDiarias.setColumns(10);
		
		lblInformeONovo_4 = new JLabel("Informe o novo valor da Diaria");
		lblInformeONovo_4.setBounds(12, 697, 309, 15);
		lblInformeONovo_4.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 14));
		frame.getContentPane().add(lblInformeONovo_4);
		
		txtNovoValorDiaria = new JTextField();
		txtNovoValorDiaria.setText("novo valor diaria");
		txtNovoValorDiaria.setBounds(12, 724, 361, 19);
		frame.getContentPane().add(txtNovoValorDiaria);
		txtNovoValorDiaria.setColumns(10);
		
		btnAlterarDiaria = new JButton("Alterar Diaria");
		btnAlterarDiaria.setBounds(403, 721, 225, 25);
		btnAlterarDiaria.addActionListener((ActionEvent e) -> {
			Double novoValor = Double.parseDouble(txtNovoValorDiaria.getText());
			if(projetosDAO.alterarValorDespesaBD(txtNomeTabDesp.getText(), txtDescricaoDiarias.getText(), novoValor) &&
					projetosDAO.atualizarTotalDespesaDoProjeto(txtNomeTabDesp.getText(), "diarias", "Diarias") &&
					projetosDAO.atualizarValorPrevistoDoProjeto(txtNomeTabDesp.getText())){
				JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");
			}else {
				JOptionPane.showMessageDialog(null, "ERRO reveja parâmetros!!!");
			}
		});
		frame.getContentPane().add(btnAlterarDiaria);
		
		lblInformeADescrio_5 = new JLabel("Informe a descrição da Passagem a ser alterada");
		lblInformeADescrio_5.setBounds(12, 773, 566, 15);
		lblInformeADescrio_5.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 14));
		frame.getContentPane().add(lblInformeADescrio_5);
		
		txtDescricaoPassagem = new JTextField();
		txtDescricaoPassagem.setText("descricao passagem");
		txtDescricaoPassagem.setBounds(12, 800, 616, 19);
		frame.getContentPane().add(txtDescricaoPassagem);
		txtDescricaoPassagem.setColumns(10);
		
		lblInformeONovo_5 = new JLabel("Informe o novo valor da passagem");
		lblInformeONovo_5.setBounds(12, 831, 566, 15);
		lblInformeONovo_5.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 14));
		frame.getContentPane().add(lblInformeONovo_5);
		
		txtNovoValorPassagem = new JTextField();
		txtNovoValorPassagem.setText("novo valor passagem");
		txtNovoValorPassagem.setBounds(12, 858, 361, 19);
		frame.getContentPane().add(txtNovoValorPassagem);
		txtNovoValorPassagem.setColumns(10);
		
		btnAlterarPassagem = new JButton("Alterar Passagem");
		btnAlterarPassagem.setBounds(403, 855, 225, 25);
		btnAlterarPassagem.addActionListener((ActionEvent e) -> {
			Double novoValor = Double.parseDouble(txtNovoValorPassagem.getText());
			if(projetosDAO.alterarValorDespesaBD(txtNomeTabDesp.getText(), txtDescricaoPassagem.getText(), novoValor) &&
					projetosDAO.atualizarTotalDespesaDoProjeto(txtNomeTabDesp.getText(), "passagens", "Passagem") &&
					projetosDAO.atualizarValorPrevistoDoProjeto(txtNomeTabDesp.getText())){
				JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");
			}else {
				JOptionPane.showMessageDialog(null, "ERRO reveja parâmetros!!!");
			}
		});
		frame.getContentPane().add(btnAlterarPassagem);

	}

	public JFrame getFrame() {
		return frame;
	}
}

package br.ufam.edu.icomp.Trabalho1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JTextPane;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.JButton;

public class CadastrarProjetoGUI {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblProfessorResponsvel;
	private JTextField txtProfessor;
	private JLabel lblValorGasto;
	private JTextField txtValor;
	private JTextField txtNomeDaTabela;
	private JTextField txtDescrio;
	private JTextField txtValorDespCap;
	private JTextField txtDescrioDespMat;
	private JTextField txtValorDespMat;
	private JLabel lblServiosDeTerceiros;
	private JTextField txtServTercPes;
	private JTextField txtValorDespServ;
	private JLabel lblValor;
	private JLabel lblValor_1;
	private JLabel lblValor_2;
	private JLabel lblResponsveis;
	private JTextField txtNomesDosRespons;
	private JLabel lblDia;
	private JTextField txtDia;
	private JLabel lblMs;
	private JTextField txtMes;
	private JLabel lblAno;
	private JTextField txtAno;
	private JLabel lblServiosDeTerceiros_2;
	private JTextField txtDescrioServTerc;
	private JLabel lblValor_3;
	private JTextField txtValorServTerc;
	private JLabel lblDia_1;
	private JTextField textField_1;
	private JLabel lblMs_1;
	private JTextField txtMes_1;
	private JLabel lblMs_2;
	private JTextField txtAno_1;
	private JLabel lblServiosDeTerceiros_1;
	private JTextField txtDescrDiarias;
	private JLabel lblValor_4;
	private JTextField txtValorDiarias;
	private JLabel lblServiosDeTerceiros_3;
	private JTextField txtNomeLocal;
	private JLabel lblServiosDeTerceiros_4;
	private JTextField txtNomeEvento;
	private JLabel lblDia_2;
	private JTextField textField_2;
	private JLabel lblMs_3;
	private JTextField textField_3;
	private JLabel lblMs_4;
	private JTextField textField_4;
	private JLabel lblServiosDeTerceiros_5;
	private JTextField txtDescrPass;
	private JLabel lblValor_5;
	private JTextField txtValorPass;
	private JLabel lblDia_3;
	private JTextField textField_7;
	private JLabel lblMs_5;
	private JTextField textField_8;
	private JLabel lblMs_6;
	private JTextField textField_9;
	private JLabel lblServiosDeTerceiros_6;
	private JTextField textField_10;
	private JLabel lblServiosDeTerceiros_7;
	private JTextField textField_11;
	private JLabel lblResponsveis_1;
	private JTextField textField_5;
	private JButton btnNewButton;
	private JButton btnAdicionarDespCap;
	private JButton btnAdicionarDespesaMaterial;
	private JButton btnAdicionarServiosPessoa;
	private JButton btnAdicionarServioPessoa;
	private JButton btnAdicionarServiosPessoa_1;
	private JButton btnAdicionarServiosPessoa_2;
	private JButton btnNewButton_1;
	private String nomeTabela;
	private ProjetoPesquisa p;

	public ProjetoPesquisa getP() {
		return p;
	}

	public String getNomeTabela() {
		return nomeTabela;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarProjetoGUI window = new CadastrarProjetoGUI();
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
	public CadastrarProjetoGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Cadastro de Projeto");
		frame.setBounds(100, 100, 1200, 1000);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		ProjetosDAO projetosDAO = new ProjetosDAO();
		projetosDAO.criarListaProjetosBD();
		
		JLabel lblDigiteAsInformaes = new JLabel("Ficha de cadastro do projeto");
		lblDigiteAsInformaes.setBounds(474, 12, 268, 15);
		lblDigiteAsInformaes.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 16));
		frame.getContentPane().add(lblDigiteAsInformaes);
		
		JLabel lblTtulo = new JLabel("Título");
		lblTtulo.setBounds(12, 46, 47, 15);
		lblTtulo .setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 14));
		frame.getContentPane().add(lblTtulo);
		
		textField = new JTextField("título");
		textField.setBounds(12, 65, 616, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblProfessorResponsvel = new JLabel("Professor responsável");
		lblProfessorResponsvel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblProfessorResponsvel.setBounds(12, 103, 215, 15);
		frame.getContentPane().add(lblProfessorResponsvel);
		
		txtProfessor = new JTextField();
		txtProfessor.setText("nome do professor");
		txtProfessor.setColumns(10);
		txtProfessor.setBounds(12, 120, 616, 19);
		frame.getContentPane().add(txtProfessor);
		
		lblValorGasto = new JLabel("Valor gasto");
		lblValorGasto.setFont(new Font("Dialog", Font.BOLD, 14));
		lblValorGasto.setBounds(640, 46, 102, 15);
		frame.getContentPane().add(lblValorGasto);
		
		txtValor = new JTextField();
		txtValor.setText("0.00");
		txtValor.setColumns(10);
		txtValor.setBounds(640, 65, 119, 19);
		frame.getContentPane().add(txtValor);
		
		JLabel lblNomeDaTabela = new JLabel("Nome da tabela de despesas");
		lblNomeDaTabela.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNomeDaTabela.setBounds(640, 103, 243, 15);
		frame.getContentPane().add(lblNomeDaTabela);
		
		txtNomeDaTabela = new JTextField();
		txtNomeDaTabela.setText("Nome da tabela");
		txtNomeDaTabela.setColumns(10);
		txtNomeDaTabela.setBounds(640, 120, 243, 19);
		frame.getContentPane().add(txtNomeDaTabela);
		
		btnNewButton = new JButton("Adicionar inform. iniciais de projeto");
		btnNewButton.setBounds(786, 62, 368, 25);
		btnNewButton.addActionListener((ActionEvent e) -> {
			String textoTitulo = textField.getText();
			String textoProfessor = txtProfessor.getText();
			double valorGasto = Double.parseDouble(txtValor.getText());
			nomeTabela = txtNomeDaTabela.getText();
			p = new ProjetoPesquisa(textoTitulo, textoProfessor, valorGasto);
			if(projetosDAO.criarListaDespesasBD(p, nomeTabela)) {
				JOptionPane.showMessageDialog(null, "TABELA DE INFORMAÇÕES BÁSICA CRIADA COM SUCESSO!");
			}else {
				JOptionPane.showMessageDialog(null, "ERRO Reveja parâmetros!!");
			}
			
			});
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblDespesasDeCapital = new JLabel("Despesas de Capital");
		lblDespesasDeCapital.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDespesasDeCapital.setBounds(12, 163, 176, 15);
		frame.getContentPane().add(lblDespesasDeCapital);
		
		txtDescrio = new JTextField();
		txtDescrio.setText("Descrição desp cap");
		txtDescrio.setColumns(10);
		txtDescrio.setBounds(12, 188, 616, 19);
		frame.getContentPane().add(txtDescrio);
		
		txtValorDespCap = new JTextField();
		txtValorDespCap.setText("0.00");
		txtValorDespCap.setColumns(10);
		txtValorDespCap.setBounds(640, 188, 160, 19);
		frame.getContentPane().add(txtValorDespCap);
		
		btnAdicionarDespCap = new JButton("Adicionar Despesa Capital");
		btnAdicionarDespCap.setBounds(812, 185, 342, 25);
		btnAdicionarDespCap.addActionListener((ActionEvent e) -> {
			try {
				String textoDescrDespCap = txtDescrio.getText();
				double valorDespCap = Double.parseDouble(txtValorDespCap.getText());
				p.adicionarNovaDespesaCapital(textoDescrDespCap, valorDespCap);
				if(projetosDAO.adicionarDespCapitalBD(nomeTabela, textoDescrDespCap, valorDespCap)) {
					JOptionPane.showMessageDialog(null, "Despesa adicionada com sucesso!!");
				}else {
					JOptionPane.showMessageDialog(null, "ERRO Reveja parâmetros!!");
				}
				
			}catch(NumeroNegativo n) {
				JOptionPane.showMessageDialog(null, "NUMERO NEGATIVO DETECTADO! CORRIJA VALORES!!");
			}
			});
		frame.getContentPane().add(btnAdicionarDespCap);
		
		JLabel lblDespesasDeMaterial = new JLabel("Despesas de Material de Consumo");
		lblDespesasDeMaterial.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDespesasDeMaterial.setBounds(12, 236, 290, 15);
		frame.getContentPane().add(lblDespesasDeMaterial);
		
		txtDescrioDespMat = new JTextField();
		txtDescrioDespMat.setText("Descrição desp mat cons");
		txtDescrioDespMat.setColumns(10);
		txtDescrioDespMat.setBounds(12, 263, 616, 19);
		frame.getContentPane().add(txtDescrioDespMat);
		
		txtValorDespMat = new JTextField();
		txtValorDespMat.setText("Valor desp mat cons");
		txtValorDespMat.setColumns(10);
		txtValorDespMat.setBounds(640, 263, 160, 19);
		frame.getContentPane().add(txtValorDespMat);
		
		btnAdicionarDespesaMaterial = new JButton("Adicionar Despesa Material de Consumo");
		btnAdicionarDespesaMaterial.setBounds(813, 260, 341, 25);
		btnAdicionarDespesaMaterial.addActionListener((ActionEvent e) -> {
			try {
				String textoDescrDespMatCons = txtDescrioDespMat.getText();
				double valorDespMatCons = Double.parseDouble(txtValorDespMat.getText());
				p.adicionarNovaDespesaMaterialConsumo(textoDescrDespMatCons, valorDespMatCons);
				if(projetosDAO.adicionarDespMatConsBD(nomeTabela, textoDescrDespMatCons, valorDespMatCons)) {
					JOptionPane.showMessageDialog(null, "Despesa adicionada com sucesso!!");
				}else {
					JOptionPane.showMessageDialog(null, "ERRO Reveja parâmetros!!");
				}
				
			}catch(NumeroNegativo n) {
				JOptionPane.showMessageDialog(null, "NUMERO NEGATIVO DETECTADO! CORRIJA VALORES!!");
			}
			});
		frame.getContentPane().add(btnAdicionarDespesaMaterial);
		
		lblServiosDeTerceiros = new JLabel("Serviços de Terceiros: Pessoa Física");
		lblServiosDeTerceiros.setFont(new Font("Dialog", Font.BOLD, 14));
		lblServiosDeTerceiros.setBounds(12, 310, 310, 15);
		frame.getContentPane().add(lblServiosDeTerceiros);
		
		txtServTercPes = new JTextField();
		txtServTercPes.setText("Descrição serv terc pes fis");
		txtServTercPes.setColumns(10);
		txtServTercPes.setBounds(12, 337, 616, 19);
		frame.getContentPane().add(txtServTercPes);
		
		txtValorDespServ = new JTextField();
		txtValorDespServ.setText("Valor serv terc pes fis");
		txtValorDespServ.setColumns(10);
		txtValorDespServ.setBounds(67, 366, 160, 19);
		frame.getContentPane().add(txtValorDespServ);
		
		lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Dialog", Font.BOLD, 14));
		lblValor.setBounds(640, 163, 53, 15);
		frame.getContentPane().add(lblValor);
		
		lblValor_1 = new JLabel("Valor");
		lblValor_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblValor_1.setBounds(640, 236, 53, 15);
		frame.getContentPane().add(lblValor_1);
		
		lblValor_2 = new JLabel("Valor");
		lblValor_2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblValor_2.setBounds(12, 368, 53, 15);
		frame.getContentPane().add(lblValor_2);
		
		lblResponsveis = new JLabel("Responsáveis");
		lblResponsveis.setFont(new Font("Dialog", Font.BOLD, 14));
		lblResponsveis.setBounds(12, 397, 125, 15);
		frame.getContentPane().add(lblResponsveis);
		
		txtNomesDosRespons = new JTextField();
		txtNomesDosRespons.setText("Nomes dos respons");
		txtNomesDosRespons.setColumns(10);
		txtNomesDosRespons.setBounds(134, 395, 494, 19);
		frame.getContentPane().add(txtNomesDosRespons);
		
		lblDia = new JLabel("Dia");
		lblDia.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDia.setBounds(640, 337, 34, 15);
		frame.getContentPane().add(lblDia);
		
		txtDia = new JTextField();
		txtDia.setText("dia");
		txtDia.setColumns(10);
		txtDia.setBounds(684, 337, 47, 19);
		frame.getContentPane().add(txtDia);
		
		lblMs = new JLabel("Mês");
		lblMs.setFont(new Font("Dialog", Font.BOLD, 14));
		lblMs.setBounds(743, 339, 34, 15);
		frame.getContentPane().add(lblMs);
		
		txtMes = new JTextField();
		txtMes.setText("mes");
		txtMes.setColumns(10);
		txtMes.setBounds(786, 337, 58, 19);
		frame.getContentPane().add(txtMes);
		
		lblAno = new JLabel("Ano");
		lblAno.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAno.setBounds(862, 339, 34, 15);
		frame.getContentPane().add(lblAno);
		
		txtAno = new JTextField();
		txtAno.setText("ano");
		txtAno.setColumns(10);
		txtAno.setBounds(914, 337, 58, 19);
		frame.getContentPane().add(txtAno);
		
		btnAdicionarServiosPessoa = new JButton("Adicionar Serviço Pessoa Física");
		btnAdicionarServiosPessoa.setBounds(813, 392, 341, 25);
		btnAdicionarServiosPessoa.addActionListener((ActionEvent e) -> {
			try {
				String textoDescrDespPesFis = txtServTercPes.getText();
				double valorDespPesFis = Double.parseDouble(txtValorDespServ.getText());
				String textoResponsaveisPesFis = txtNomesDosRespons.getText();
				int valorDia = Integer.parseInt(txtDia.getText());
				int valorMes = Integer.parseInt(txtMes.getText());
				int valorAno = Integer.parseInt(txtAno.getText());
				p.adicionarNovaDespesaServicosPessoaFisica(textoDescrDespPesFis, valorDespPesFis, textoResponsaveisPesFis, valorDia, valorMes, valorAno);
				if(projetosDAO.adicionarDespServPesFisBD(nomeTabela, textoDescrDespPesFis, valorDespPesFis, valorDia, valorMes, valorAno, textoResponsaveisPesFis)) {
					JOptionPane.showMessageDialog(null, "Despesa adicionada com sucesso!!");
				}else {
					JOptionPane.showMessageDialog(null, "[ERRO] Reveja parâmetros!!");
				}
				
			}catch(NumeroNegativo n) {
				JOptionPane.showMessageDialog(null, "NUMERO NEGATIVO DETECTADO! CORRIJA VALORES!!");
			}catch(DataInvalida d) {
				JOptionPane.showMessageDialog(null, "DATA INVALIDA DETECTADA! CORRIJA VALORES!");
			}
			});
		frame.getContentPane().add(btnAdicionarServiosPessoa);
		
		lblServiosDeTerceiros_2 = new JLabel("Serviços de Terceiros: Pessoa Jurídica");
		lblServiosDeTerceiros_2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblServiosDeTerceiros_2.setBounds(12, 447, 310, 15);
		frame.getContentPane().add(lblServiosDeTerceiros_2);
		
		txtDescrioServTerc = new JTextField();
		txtDescrioServTerc.setText("Descrição serv terc pes jur");
		txtDescrioServTerc.setColumns(10);
		txtDescrioServTerc.setBounds(12, 474, 616, 19);
		frame.getContentPane().add(txtDescrioServTerc);
		
		lblValor_3 = new JLabel("Valor");
		lblValor_3.setFont(new Font("Dialog", Font.BOLD, 14));
		lblValor_3.setBounds(12, 505, 53, 15);
		frame.getContentPane().add(lblValor_3);
		
		txtValorServTerc = new JTextField();
		txtValorServTerc.setText("Valor serv terc pes jur");
		txtValorServTerc.setColumns(10);
		txtValorServTerc.setBounds(67, 505, 160, 19);
		frame.getContentPane().add(txtValorServTerc);
		
		lblDia_1 = new JLabel("Dia");
		lblDia_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDia_1.setBounds(640, 476, 34, 15);
		frame.getContentPane().add(lblDia_1);
		
		textField_1 = new JTextField();
		textField_1.setText("dia");
		textField_1.setColumns(10);
		textField_1.setBounds(684, 474, 47, 19);
		frame.getContentPane().add(textField_1);
		
		lblMs_1 = new JLabel("Mês");
		lblMs_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblMs_1.setBounds(743, 476, 34, 15);
		frame.getContentPane().add(lblMs_1);
		
		txtMes_1 = new JTextField();
		txtMes_1.setText("mes");
		txtMes_1.setColumns(10);
		txtMes_1.setBounds(786, 474, 47, 19);
		frame.getContentPane().add(txtMes_1);
		
		lblMs_2 = new JLabel("Ano");
		lblMs_2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblMs_2.setBounds(862, 476, 34, 15);
		frame.getContentPane().add(lblMs_2);
		
		txtAno_1 = new JTextField();
		txtAno_1.setText("ano");
		txtAno_1.setColumns(10);
		txtAno_1.setBounds(914, 474, 47, 19);
		frame.getContentPane().add(txtAno_1);
		
		lblResponsveis_1 = new JLabel("Nome da Empresa");
		lblResponsveis_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblResponsveis_1.setBounds(12, 532, 160, 15);
		frame.getContentPane().add(lblResponsveis_1);
		
		textField_5 = new JTextField();
		textField_5.setText("empresa");
		textField_5.setColumns(10);
		textField_5.setBounds(164, 530, 464, 19);
		frame.getContentPane().add(textField_5);
		
		btnAdicionarServioPessoa = new JButton("Adicionar Serviço Pessoa Jurídica");
		btnAdicionarServioPessoa.setBounds(813, 527, 341, 25);
		btnAdicionarServioPessoa.addActionListener((ActionEvent e) -> {
			try {
				String textoDescrDespPesJur = txtDescrioServTerc.getText();
				double valorDespPesJur = Double.parseDouble(txtValorServTerc.getText());
				String textoResponsaveis = textField_5.getText();
				int valorDia = Integer.parseInt(textField_1.getText());
				int valorMes = Integer.parseInt(txtMes_1.getText());
				int valorAno = Integer.parseInt(txtAno_1.getText());
				p.adicionarNovaDespesaServicosPessoaJuridica(textoDescrDespPesJur, valorDespPesJur, textoResponsaveis, valorDia, valorMes, valorAno);
				if(projetosDAO.adicionarDespServPesJurBD(nomeTabela, textoDescrDespPesJur, valorDespPesJur, valorDia, valorMes, valorAno, textoResponsaveis)) {
					JOptionPane.showMessageDialog(null, "Despesa adicionada com sucesso!!");
				}else {
					JOptionPane.showMessageDialog(null, "ERRO Reveja parâmetros!!");
				}
				
			}catch(NumeroNegativo n) {
				JOptionPane.showMessageDialog(null, "NUMERO NEGATIVO DETECTADO! CORRIJA VALORES!!");
			}catch(DataInvalida d) {
				JOptionPane.showMessageDialog(null, "DATA INVALIDA DETECTADA! CORRIJA VALORES!");
			}
			});
		frame.getContentPane().add(btnAdicionarServioPessoa);
		
		lblServiosDeTerceiros_1 = new JLabel("Diárias");
		lblServiosDeTerceiros_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblServiosDeTerceiros_1.setBounds(12, 588, 310, 15);
		frame.getContentPane().add(lblServiosDeTerceiros_1);
		
		txtDescrDiarias = new JTextField();
		txtDescrDiarias.setText("Descr diarias");
		txtDescrDiarias.setColumns(10);
		txtDescrDiarias.setBounds(12, 615, 616, 19);
		frame.getContentPane().add(txtDescrDiarias);
		
		lblValor_4 = new JLabel("Valor");
		lblValor_4.setFont(new Font("Dialog", Font.BOLD, 14));
		lblValor_4.setBounds(12, 646, 53, 15);
		frame.getContentPane().add(lblValor_4);
		
		txtValorDiarias = new JTextField();
		txtValorDiarias.setText("Valor diarias");
		txtValorDiarias.setColumns(10);
		txtValorDiarias.setBounds(67, 646, 160, 19);
		frame.getContentPane().add(txtValorDiarias);
		
		lblServiosDeTerceiros_3 = new JLabel("Local");
		lblServiosDeTerceiros_3.setFont(new Font("Dialog", Font.BOLD, 14));
		lblServiosDeTerceiros_3.setBounds(12, 672, 53, 15);
		frame.getContentPane().add(lblServiosDeTerceiros_3);
		
		txtNomeLocal = new JTextField();
		txtNomeLocal.setText("nome local");
		txtNomeLocal.setColumns(10);
		txtNomeLocal.setBounds(67, 673, 561, 19);
		frame.getContentPane().add(txtNomeLocal);
		
		lblServiosDeTerceiros_4 = new JLabel("Nome do Evento");
		lblServiosDeTerceiros_4.setFont(new Font("Dialog", Font.BOLD, 14));
		lblServiosDeTerceiros_4.setBounds(12, 699, 145, 15);
		frame.getContentPane().add(lblServiosDeTerceiros_4);
		
		txtNomeEvento = new JTextField();
		txtNomeEvento.setText("nome evento");
		txtNomeEvento.setColumns(10);
		txtNomeEvento.setBounds(12, 726, 616, 19);
		frame.getContentPane().add(txtNomeEvento);
		
		lblDia_2 = new JLabel("Dia");
		lblDia_2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDia_2.setBounds(640, 617, 34, 15);
		frame.getContentPane().add(lblDia_2);
		
		textField_2 = new JTextField();
		textField_2.setText("dia");
		textField_2.setColumns(10);
		textField_2.setBounds(684, 615, 47, 19);
		frame.getContentPane().add(textField_2);
		
		lblMs_3 = new JLabel("Mês");
		lblMs_3.setFont(new Font("Dialog", Font.BOLD, 14));
		lblMs_3.setBounds(743, 617, 34, 15);
		frame.getContentPane().add(lblMs_3);
		
		textField_3 = new JTextField();
		textField_3.setText("mes");
		textField_3.setColumns(10);
		textField_3.setBounds(786, 615, 47, 19);
		frame.getContentPane().add(textField_3);
		
		lblMs_4 = new JLabel("Ano");
		lblMs_4.setFont(new Font("Dialog", Font.BOLD, 14));
		lblMs_4.setBounds(862, 617, 34, 15);
		frame.getContentPane().add(lblMs_4);
		
		textField_4 = new JTextField();
		textField_4.setText("ano");
		textField_4.setColumns(10);
		textField_4.setBounds(914, 615, 47, 19);
		frame.getContentPane().add(textField_4);
		
		btnAdicionarServiosPessoa_1 = new JButton("Adicionar Diária");
		btnAdicionarServiosPessoa_1.setBounds(813, 667, 341, 25);
		btnAdicionarServiosPessoa_1.addActionListener((ActionEvent e) -> {
			try {
				String textoDescrDiar = txtDescrDiarias.getText();
				double valorDiar = Double.parseDouble(txtValorDiarias.getText());
				String textoLocal = txtNomeLocal.getText();
				String textoEvento = txtNomeEvento.getText();
				int valorDiaDiar = Integer.parseInt(textField_2.getText());
				int valorMesDiar = Integer.parseInt(textField_3.getText());
				int valorAnoDiar = Integer.parseInt(textField_4.getText());
				p.adicionarNovaDespesaDiarias(textoDescrDiar, valorDiar, textoLocal, textoEvento, valorDiaDiar, valorMesDiar, valorAnoDiar);
				if(projetosDAO.adicionarDespDiariasBD(nomeTabela, textoDescrDiar, valorDiar, valorDiaDiar, valorMesDiar, valorAnoDiar, textoLocal, textoEvento)) {
					JOptionPane.showMessageDialog(null, "Despesa adicionada com sucesso!!");
				}else {
					JOptionPane.showMessageDialog(null, "ERRO Reveja parâmetros!!");
				}
				
			}catch(NumeroNegativo n) {
				JOptionPane.showMessageDialog(null, "NUMERO NEGATIVO DETECTADO! CORRIJA VALORES!!");
			}catch(DataInvalida d) {
				JOptionPane.showMessageDialog(null, "DATA INVALIDA DETECTADA! CORRIJA VALORES!");
			}
			});
		frame.getContentPane().add(btnAdicionarServiosPessoa_1);
		
		lblServiosDeTerceiros_5 = new JLabel("Passagens");
		lblServiosDeTerceiros_5.setFont(new Font("Dialog", Font.BOLD, 14));
		lblServiosDeTerceiros_5.setBounds(12, 779, 310, 15);
		frame.getContentPane().add(lblServiosDeTerceiros_5);
		
		txtDescrPass = new JTextField();
		txtDescrPass.setText("Descr pass");
		txtDescrPass.setColumns(10);
		txtDescrPass.setBounds(12, 806, 616, 19);
		frame.getContentPane().add(txtDescrPass);
		
		lblValor_5 = new JLabel("Valor");
		lblValor_5.setFont(new Font("Dialog", Font.BOLD, 14));
		lblValor_5.setBounds(12, 837, 53, 15);
		frame.getContentPane().add(lblValor_5);
		
		txtValorPass = new JTextField();
		txtValorPass.setText("Valor pass");
		txtValorPass.setColumns(10);
		txtValorPass.setBounds(67, 837, 160, 19);
		frame.getContentPane().add(txtValorPass);
		
		lblDia_3 = new JLabel("Dia");
		lblDia_3.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDia_3.setBounds(640, 808, 34, 15);
		frame.getContentPane().add(lblDia_3);
		
		textField_7 = new JTextField();
		textField_7.setText("dia");
		textField_7.setColumns(10);
		textField_7.setBounds(684, 806, 47, 19);
		frame.getContentPane().add(textField_7);
		
		lblMs_5 = new JLabel("Mês");
		lblMs_5.setFont(new Font("Dialog", Font.BOLD, 14));
		lblMs_5.setBounds(743, 808, 34, 15);
		frame.getContentPane().add(lblMs_5);
		
		textField_8 = new JTextField();
		textField_8.setText("mes");
		textField_8.setColumns(10);
		textField_8.setBounds(786, 806, 47, 19);
		frame.getContentPane().add(textField_8);
		
		lblMs_6 = new JLabel("Ano");
		lblMs_6.setFont(new Font("Dialog", Font.BOLD, 14));
		lblMs_6.setBounds(862, 808, 34, 15);
		frame.getContentPane().add(lblMs_6);
		
		textField_9 = new JTextField();
		textField_9.setText("ano");
		textField_9.setColumns(10);
		textField_9.setBounds(914, 806, 47, 19);
		frame.getContentPane().add(textField_9);
		
		lblServiosDeTerceiros_6 = new JLabel("Local");
		lblServiosDeTerceiros_6.setFont(new Font("Dialog", Font.BOLD, 14));
		lblServiosDeTerceiros_6.setBounds(12, 864, 53, 15);
		frame.getContentPane().add(lblServiosDeTerceiros_6);
		
		textField_10 = new JTextField();
		textField_10.setText("nome local");
		textField_10.setColumns(10);
		textField_10.setBounds(67, 864, 561, 19);
		frame.getContentPane().add(textField_10);
		
		lblServiosDeTerceiros_7 = new JLabel("Nome do Evento");
		lblServiosDeTerceiros_7.setFont(new Font("Dialog", Font.BOLD, 14));
		lblServiosDeTerceiros_7.setBounds(12, 901, 145, 15);
		frame.getContentPane().add(lblServiosDeTerceiros_7);
		
		textField_11 = new JTextField();
		textField_11.setText("nome evento");
		textField_11.setColumns(10);
		textField_11.setBounds(12, 928, 616, 19);
		frame.getContentPane().add(textField_11);
		
		btnAdicionarServiosPessoa_2 = new JButton("Adicionar Passagem");
		btnAdicionarServiosPessoa_2.setBounds(813, 859, 341, 25);
		btnAdicionarServiosPessoa_2.addActionListener((ActionEvent e) -> {
			try {
				String textoDescrPass = txtDescrPass.getText();
				double valorPass = Double.parseDouble(txtValorPass.getText());
				String textoLocalPass = textField_10.getText();
				String textoEventoPass = textField_11.getText();
				int valorDiaPass = Integer.parseInt(textField_7.getText());
				int valorMesPass = Integer.parseInt(textField_8.getText());
				int valorAnoPass = Integer.parseInt(textField_9.getText());
				String textoRespPass = textField_5.getText();
				p.adicionarNovaDespesaPassagens(textoDescrPass, textoLocalPass, textoEventoPass, textoRespPass, valorPass, valorDiaPass, valorMesPass, valorAnoPass);
				if(projetosDAO.adicionarDespPassBD(nomeTabela, textoDescrPass, valorPass, valorDiaPass, valorMesPass, valorAnoPass, textoLocalPass, textoEventoPass)) {
					JOptionPane.showMessageDialog(null, "Despesa adicionada com sucesso!!");
				}else {
					JOptionPane.showMessageDialog(null, "ERRO Reveja parâmetros!!");
				}
				
			}catch(NumeroNegativo n) {
				JOptionPane.showMessageDialog(null, "NUMERO NEGATIVO DETECTADO! CORRIJA VALORES!!");
			}catch(DataInvalida d) {
				JOptionPane.showMessageDialog(null, "DATA INVALIDA DETECTADA! CORRIJA VALORES!");
			}
			});
		frame.getContentPane().add(btnAdicionarServiosPessoa_2);
		
		btnNewButton_1 = new JButton("Finalizar cadastro");
		btnNewButton_1.setBounds(957, 921, 197, 32);
		btnNewButton_1.addActionListener((ActionEvent e) -> {
			projetosDAO.adicionarProjeto(p, txtNomeDaTabela.getText());
			JOptionPane.showMessageDialog(null, "Projeto cadastrado com sucesso!!");
			frame.dispose();
			});
		frame.getContentPane().add(btnNewButton_1);
	}

	public JFrame getFrame() {
		return frame;
	}
}

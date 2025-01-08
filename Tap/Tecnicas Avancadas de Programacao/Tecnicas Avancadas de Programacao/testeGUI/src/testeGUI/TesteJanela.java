package testeGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTree;
import javax.swing.JRadioButton;

public class TesteJanela {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteJanela window = new TesteJanela();
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
	public TesteJanela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Teste de Janela com login");
		frame.setBounds(100, 100, 577, 352);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTesteJanelaWindowbuilder = new JLabel("Teste Janela WindowBuilder PRO");
		lblTesteJanelaWindowbuilder.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 19));
		lblTesteJanelaWindowbuilder.setBounds(100, 10, 357, 23);
		frame.getContentPane().add(lblTesteJanelaWindowbuilder);
		
		JLabel lblNewLabel = new JLabel("Digite seu email:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(12, 70, 183, 15);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 14));
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(213, 68, 301, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenha.setBounds(125, 97, 70, 15);
		lblSenha.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 14));
		frame.getContentPane().add(lblSenha);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(213, 99, 301, 19);
		frame.getContentPane().add(textField_1);
		
		JRadioButton rdbtnAluno = new JRadioButton("Aluno");
		rdbtnAluno.setBounds(213, 147, 149, 23);
		rdbtnAluno.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 15));
		frame.getContentPane().add(rdbtnAluno);
		
		JRadioButton rdbtnProfessor = new JRadioButton("Professor");
		rdbtnProfessor.setBounds(213, 183, 149, 23);
		rdbtnProfessor.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 15));
		frame.getContentPane().add(rdbtnProfessor);
		
		JButton btnAcessarSistema = new JButton("Acessar sistema");
		btnAcessarSistema.setBounds(181, 234, 183, 25);
		rdbtnProfessor.setFont(new Font("Dialog", Font.PLAIN | Font.BOLD, 13));
		btnAcessarSistema.addActionListener((ActionEvent e) -> {
			TesteNovaJanela tst = new TesteNovaJanela();
			tst.getFrame().setVisible(true);
			});
		frame.getContentPane().add(btnAcessarSistema);
		
		JButton btnSobreOSistema = new JButton("Sobre o sistema...");
		btnSobreOSistema.setBounds(155, 271, 228, 25);
		btnSobreOSistema.addActionListener((ActionEvent e) -> {
			JOptionPane.showMessageDialog(null, "Sistema ainda em construção!");
			});
		frame.getContentPane().add(btnSobreOSistema);
	}

}

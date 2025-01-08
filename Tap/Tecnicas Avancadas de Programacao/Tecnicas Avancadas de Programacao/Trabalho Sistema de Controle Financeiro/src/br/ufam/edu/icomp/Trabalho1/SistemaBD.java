package br.ufam.edu.icomp.Trabalho1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SistemaBD {
	private static String url = "jdbc:mysql://localhost:3306/ProjetosBD";
	private static String user = "projetos_admin";
	private static String pass = "projetos123";
	protected static Connection conexao = null;
	
	public SistemaBD() {
		if (conexao == null) conecta();
	}
	
	private static boolean conecta() {
		try {
			conexao = DriverManager.getConnection(url, user, pass);
			return true;
		} catch (SQLException e) { return false; }
	}
	
	public static boolean desconecta() {
		try {
			conexao.close();
			return true;
			} catch (SQLException e) { return false; }
	}
}

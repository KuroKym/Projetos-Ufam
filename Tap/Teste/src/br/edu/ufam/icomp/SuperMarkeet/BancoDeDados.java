package br.edu.ufam.icomp.SuperMarkeet;
import java.sql.*;

public class BancoDeDados {
  private static String url = "jdbc:mysql://localhost:3306/superdupermart";
  private static String user = "SuperMart";
  private static String pass = "SuperMart123";
  protected static Connection conexao = null;

  public BancoDeDados() {
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

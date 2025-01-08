package testeGUI;
import java.sql.*;

public class PersonagemDAO extends BancoDeDados {
	public void listarPersonagens() {
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM personagens");
			while (rs.next()) {
				System.out.println("Personagem " + rs.getString(2) +
						" (" + rs.getString(3) + ")" +
						" do filme " + rs.getString(4));
			}
		}
		catch (SQLException e) { }
		}
		public static void main(String args[]) {
			PersonagemDAO personagemDAO = new PersonagemDAO();
			personagemDAO.listarPersonagens();
		}
}

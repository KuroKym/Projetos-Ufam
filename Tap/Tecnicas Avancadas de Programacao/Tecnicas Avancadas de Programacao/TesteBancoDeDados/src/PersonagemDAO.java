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
	public boolean adicionarPersonagem(Personagem p) {
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO personagens VALUES (NULL, '" 
			+ p.getApelido() + "'," + " '" + p.getNome()
			+ "', '" + p.getFilme() + "')");
			return true;
			} catch (SQLException e) { return false; }
	}
	
	public Personagem getPersonagem(String apelido) {
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM personagens WHERE " +
			"apelido='" + apelido + "'");
			if (rs.next()) {
			return new Personagem(rs.getString(2), rs.getString(3),
			rs.getString(4));
			}
			else return null;
			}
		catch (SQLException e) { return null; }
		}
	
	public static void main(String args[]) {
		PersonagemDAO personagemDAO = new PersonagemDAO();
		Personagem personagem = personagemDAO.getPersonagem("rocket");
		Personagem personagem2 = new Personagem("Thanos", "Thanos O Invencivel", "Guardians of The Galaxy");
		//personagemDAO.adicionarPersonagem(personagem2);
		personagemDAO.listarPersonagens();
		}
}
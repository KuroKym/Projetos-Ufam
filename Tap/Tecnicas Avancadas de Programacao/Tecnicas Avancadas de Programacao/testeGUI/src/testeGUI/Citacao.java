package testeGUI;

public class Citacao {
	private int id;
	private Personagem personagem;
	private String citacao;
	public Citacao(Personagem personagem, String citacao) {
		this.personagem = personagem;
		this.citacao = citacao;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Personagem getPersonagem() {
		return personagem;
	}
	public void setPersonagem(Personagem personagem) {
		this.personagem = personagem;
	}
	public String getCitacao() {
		return citacao;
	}
	public void setCitacao(String citacao) {
		this.citacao = citacao;
	}
}

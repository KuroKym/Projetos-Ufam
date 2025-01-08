
public class Sala {
	int bloco, sala, capacidade;
	boolean acessivel;
	
	Sala(){
		this.bloco = 0;
		this.sala = 0;
		this.capacidade = 0;
		this.acessivel = true;
	}
	
	Sala(int bloco, int sala, int capacidade, boolean acessivel){
		this.bloco = bloco;
		this.sala = sala;
		this.capacidade = capacidade;
		this.acessivel = acessivel;
	}
	
	String getDescricao() {
		String acesso;
		if (acessivel == true) {
			acesso = "acessível";
		}
		else {
			acesso = "não acessível";
		}
		return "Bloco " + bloco + ", Sala " + sala + " (" + capacidade + " lugares, " + acesso + ")";
	}
}

import java.util.ArrayList;
public class Turma {
	String nome, professor;
	int numAlunos;
	boolean acessivel;
	ArrayList<Integer> horarios;
	
	Turma(){
		this.nome = "null";
		this.professor = "null";
		this.numAlunos = 0;
		this.acessivel = true;
		this.horarios = new ArrayList<Integer>();
	}
	
	Turma(String nome, String professor, int numAlunos, boolean acessivel){
		this.nome = nome;
		this.professor = professor;
		this.numAlunos = numAlunos;
		this.acessivel = acessivel;
		this.horarios = new ArrayList<Integer>();
	}
	
	void addHorario(int horario) {
		horarios.add(horario);
	}
	
	String getHorariosString() {
		String horario = "";
		int hora;
		int espaco = horarios.size();
		for(int i  = 0; i< horarios.size(); i++){
			hora = horarios.get(i);
			switch (hora) {
				case 1:
					horario += "segunda 8hs";
					break;
				case 2 :
					horario += "segunda 10hs";
					break;
				case 3 :
					horario += "segunda 12hs";
					break;
				case 4:
					horario += "segunda 14hs";
					break;
				case 5:
					horario += "segunda 16hs";
					break;
				case 6:
					horario += "segunda 18hs";
					break;
				case 7:
					horario += "segunda 20hs";
					break;
				case 8:
					horario += "terça 8hs";
					break;
				case 9:
					horario += "terça 10hs";
					break;
				case 10:
					horario += "terça 12hs";
					break;
				case 11:
					horario += "terça 14hs";
					break;
				case 12:
					horario += "terça 16hs";
					break;
				case 13:
					horario += "terça 18hs";
					break;
				case 14:
					horario += "terça 20hs";
					break;
				case 15:
					horario += "quarta 8hs";
					break;
				case 16:
					horario += "quarta 10hs";
					break;
				case 17:
					horario += "quarta 12hs";
					break;
				case 18:
					horario += "quarta 14hs";
					break;
				case 19:
					horario += "quarta 16hs";
					break;
				case 20:
					horario += "quarta 18hs";
					break;
				case 21:
					horario += "quarta 20hs";
					break;
				case 22:
					horario += "quinta 8hs";
					break;
				case 23:
					horario += "quinta 10hs";
					break;
				case 24:
					horario += "quinta 12hs";
					break;
				case 25:
					horario += "quinta 14hs";
					break;
				case 26:
					horario += "quinta 16hs";
					break;
				case 27:
					horario += "quinta 18hs";
					break;
				case 28:
					horario += "quinta 20hs";
					break;
				case 29:
					horario += "sexta 8hs";
					break;
				case 30:
					horario += "sexta 10hs";
					break;
				case 31:
					horario += "sexta 12hs";
					break;
				case 32:
					horario += "sexta 14hs";
					break;
				case 33:
					horario += "sexta 16hs";
					break;
				case 34:
					horario += "sexta 18hs";
					break;
				case 35:
					horario += "sexta 20hs";
					break;
				default:
					break;
			}
			espaco--;
			if(espaco >0){
				horario += ", ";
			}
	}

		return horario;

	}

	String getDescricao(){
		String descricao = "Turma: " + nome + "\n";
		String acesso;
		if (acessivel == true) {
			acesso = "sim";
		}
		else{
			acesso = "não";
		}
		descricao += "Professor: " + professor + "\n";
		descricao += "Número de Alunos: " + numAlunos + "\n";
		descricao += "Horário: " + getHorariosString() + "\n";
		descricao += "Acessível: " + acesso + "\n";

		return descricao;
	}
}

import java.util.Calendar;

public class Aluno {
	
	String nome;
	int matricula;
	int anoNascimento;
	
	Aluno(){
		this.nome = "null";
		this.matricula = 0;
		this.anoNascimento = 0;
		
	}
	
	Aluno(String nome, int matricula, int anoNascimento){
		this.nome = nome;
		this.matricula = matricula;
		this.anoNascimento = anoNascimento;
		
	}
	
	int getIdade(){
			int ano_Atual = Calendar.getInstance().get(Calendar.YEAR);
			return ano_Atual - anoNascimento;
	}
	
	String getDescricao() {
		int idade = getIdade();
		return nome + " (mat=" + matricula +", idade=" +  idade + ")";
	}
	
}

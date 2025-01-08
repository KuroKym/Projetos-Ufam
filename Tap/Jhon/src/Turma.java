import java.util.ArrayList;
public class Turma {
	String disciplina;
	int ano, semestre;
	Professor professor;
	ArrayList <Aluno> alunos;
	
	Turma(String disciplina, int ano, int semestre, Professor professor){
		this.disciplina = disciplina;
		this.ano = ano;
		this.semestre = semestre;
		this.professor = professor;
		this.alunos = new ArrayList<Aluno>();
	}
	
	void addAluno(Aluno aluno) {
		for(Aluno alunoB : alunos){
			if (alunoB.matricula == aluno.matricula){
				return;
			}
		}
		alunos.add(aluno);
	
	}
	Aluno getAluno(int matricula) {
		for (Aluno aluno: alunos) {
			if(aluno.matricula == matricula) {
				return aluno;
			}
		}
		return null;
	}
	
	double getMediaIdade() {
		double media = 0.0;
		double sum = 0.0;
		double total = alunos.size();
		for(Aluno aluno: alunos) {
			sum += aluno.getIdade();
		}
		media = sum/total;
		
		return media;
	}
	
	String getDescricao() {
		String p = "Prof. " + professor.titulacao + " " +  professor.nome + " - mat " + professor.matricula;
		String retornado = "Turma " + disciplina + " - " +  ano + "/" + semestre +  " (" + p + "):\n" ;
		int n = 1;
		for(Aluno aluno: alunos) {
			retornado += "  - Aluno " + n + ": " + aluno.getDescricao() + "\n";
			n++;
		}
		return retornado;
	}
}

	


public class TurmaMain {
	public static void main(String [] args) {
		Aluno aluno1 = new Aluno("Egon Spengler", 4350, 1994);
		Aluno aluno2 = new Aluno("Peter Venkman", 4361, 1990);
		Aluno aluno3 = new Aluno("Raymond Stantz", 4372, 1992);
		Professor professor1 = new Professor("Dr.", "Henry Walton Jones Jr", 1982);
		Turma turma1 = new Turma("Parapsicologia", 2010, 2, professor1);
		turma1.addAluno(aluno1);
		turma1.addAluno(aluno2);
		turma1.addAluno(aluno3);
		System.out.println(turma1.getDescricao());
	}
}

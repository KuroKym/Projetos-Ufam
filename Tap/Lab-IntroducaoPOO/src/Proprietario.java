public class Proprietario {
	String nome;
	int cnh;
	int anoNascimento;
	
	Proprietario(){
		this.nome = "null";
		this.cnh = 0;
		this.anoNascimento = 0;
	}
	
	Proprietario(String nome, int cnh, int anoNascimento){
		this.nome = nome;
		this.cnh = cnh;
		this.anoNascimento = anoNascimento;
	}
	
	int getIdade(int anoReferencia){
		int ano = this.anoNascimento;
		return anoReferencia - ano;
	}
	String getDescricao() {
		String nome = this.nome;
		int ano = this.anoNascimento;
		int cnh = this.cnh;
		String descricao = "Proprietario: nome=" + nome + ", cnh=" + cnh + ", anoNascimento=" + ano+ ".";
		return descricao;
	}
}

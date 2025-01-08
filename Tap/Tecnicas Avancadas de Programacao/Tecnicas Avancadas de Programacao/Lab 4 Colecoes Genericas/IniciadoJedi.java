public class IniciadoJedi{
    String nome;
    String especie;
    int anoNascimento;

    IniciadoJedi(){}
    IniciadoJedi(String nome, String especie, int anoNascimento){
        this.nome = nome;
        this.especie = especie;
        this.anoNascimento = anoNascimento;
    }
    String getAnoNascimento(){
        if (anoNascimento < 0){
            return Math.abs(anoNascimento) + " ABY";
        }
        else{
            return anoNascimento + " DBY";
        }
    }

    String getDescricao(){
        return nome + "(especie=" + especie + ", nascimento=" + getAnoNascimento()+")";
    }
}
public class Sala {
    int bloco;
    int sala;
    int capacidade;
    boolean acessivel;

    Sala(){}
    Sala(int bloco, int sala, int capacidade, boolean acessivel){
        this.bloco = bloco;
        this.sala = sala;
        this.capacidade = capacidade;
        this.acessivel = acessivel;
    }
    
    String getDescricao(){
        if(acessivel){
            return "Bloco " + bloco + ", Sala " + sala + " (" + capacidade + " lugares, acessível)";
        }else{
            return "Bloco " + bloco + ", Sala " + sala + " (" + capacidade + " lugares, não acessível)";
        }
    }
}
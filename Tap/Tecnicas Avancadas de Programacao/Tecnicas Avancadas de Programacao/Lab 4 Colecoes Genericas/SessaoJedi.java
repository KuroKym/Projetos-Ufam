import java.util.*;

public class SessaoJedi {
    String nome;
    TreinadorJedi treinador;
    ArrayList<IniciadoJedi> iniciados = new ArrayList<IniciadoJedi>();

    SessaoJedi(String nome, TreinadorJedi treinador){
        this.nome = nome;
        this.treinador = treinador;
    }

    void addIniciado(IniciadoJedi iniciado){
        if(!iniciados.contains(iniciado)){
            iniciados.add(iniciado);
        }
    }
    
    IniciadoJedi getIniciado(String nome){
        for(int i = 0; i < iniciados.size(); i++){
            IniciadoJedi inic = iniciados.get(i);
            if(inic.nome.equals(nome)){
                return inic;
            }
        }
        return null;
    }

    double getMediaAnoNascimento(){
        double soma = 0;
        for(int j = 0; j < iniciados.size(); j++){
            soma = soma + iniciados.get(j).anoNascimento;
        }
        return soma/iniciados.size();
    }

    String getDescricao(){
        String res = "--> SESSÃO " + nome + " (Treinador: " + treinador.getDescricao() + ")";
        for(int k = 0; k < iniciados.size(); k++){
            res = res + "- Iniciado " + (k+1) + ": " + iniciados.get(k).getDescricao();
        }
        return res;
    }
}
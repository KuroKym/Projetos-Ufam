import java.util.ArrayList;

public class Ensalamento {
    ArrayList<Sala> salas = new ArrayList<Sala>();
    ArrayList<Turma> turmas = new ArrayList<Turma>();
    ArrayList<TurmaEmSala> ensalamento = new ArrayList<TurmaEmSala>();

    Ensalamento(){}
    void addSala(Sala sala){
        salas.add(sala);
    }

    void addTurma(Turma turma){
        turmas.add(turma);
    }

    Sala getSala(Turma turma){
        TurmaEmSala ts;
        for(int i = 0; i < ensalamento.size(); i++){
            ts = ensalamento.get(i);
            if(ts.turma.equals(turma)){
                return ts.sala;
            }
        }
        return null;
    }

    //checa se a sala esta disponivel em um dado horario
    boolean salaDisponivel(Sala sala, int horario){
        TurmaEmSala ts;
        for(int i = 0; i < ensalamento.size(); i++){
            ts = ensalamento.get(i);
            for(int j = 0; j < ts.turma.horarios.size(); j++){
                if(ts.sala.equals(sala) && ts.turma.horarios.get(j) == horario){
                    return false;
                }
            }
        }
        return true;
    }


    boolean salaDisponivel2(Sala sala, int horario){
        TurmaEmSala ts;
        for(int i = 0; i < ensalamento.size(); i++){
            ts = ensalamento.get(i);
            if(ts.sala.equals(sala)){
                for(int j = 0; j < ts.turma.horarios.size(); j++){
                    if(ts.turma.horarios.get(j) == horario){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //checa se a sala esta disponivel em todos os horarios
    boolean salaDisponivel(Sala sala, ArrayList<Integer> horarios){
        for(int i = 0; i < horarios.size(); i++){
            if(!salaDisponivel(sala, horarios.get(i))){
                return false;
            }
        }
        return true;
    } 

    boolean alocar(Turma turma, Sala sala){
        TurmaEmSala novaTurmaEmSala = new TurmaEmSala(turma, sala);
        if(turma.acessivel){
            if(turma.numAlunos <= sala.capacidade && salaDisponivel(sala, turma.horarios) && sala.acessivel){
                ensalamento.add(novaTurmaEmSala);
                return true;
            }
        }else{
            if(turma.numAlunos <= sala.capacidade && salaDisponivel(sala, turma.horarios)){
                ensalamento.add(novaTurmaEmSala);
                return true;
            }
        }
        return false;
    }

    void ordenarTurmas(ArrayList<Turma> turmas){
        int i, j;
        Turma t, t1;
        for(j = 1; j < turmas.size(); j++){
            t = turmas.get(j);
            i = j - 1;
            while(i >= 0 && t.numAlunos > turmas.get(i).numAlunos){
                t1 = turmas.get(i);
                turmas.set(i+1,t1);
                i--;
            }
            turmas.set(i+1, t);
        }
    } 

    void ordenarSalas(ArrayList<Sala> salas){
        int i, j;
        Sala s, s1;
        for(j = 1; j < salas.size(); j++){
            s = salas.get(j);
            i = j - 1;
            while(i >= 0 && s.capacidade > salas.get(i).capacidade){
                s1 = salas.get(i);
                salas.set(i+1,s1);
                i--;
            }
            salas.set(i+1, s);
        }
    }

    double taxaEnsalamento(Turma turma, Sala sala){
        return (double)turma.numAlunos/sala.capacidade;
    }

    void alocarTodas(){
        Turma t;
        Sala s;
        for(int i = 0; i < turmas.size(); i++){
            t = turmas.get(i);
            for(int j = 0; j < salas.size(); j++){
                s = salas.get(j);
                if(s.capacidade - t.numAlunos <= 60){
                    if(alocar(t, s)){
                        break;
                    }
                }
                
                
            }
        }
    }

    int getTotalTurmasAlocadas(){
        int contador = 0;
        for(int i = 0; i < ensalamento.size(); i++){
            TurmaEmSala ts = ensalamento.get(i);
            if(ts.sala != null){
                contador++;
            }
        }
        return contador;
    }

    int getTotalEspacoLivre(){
        int contador = 0;
        for(int i = 0; i < ensalamento.size(); i++){
            TurmaEmSala ts = ensalamento.get(i);
            contador += ts.sala.capacidade - ts.turma.numAlunos;
        }
        return contador;
    }

    String relatorioResumoEnsalamento(){
        return "Total de Salas: " + salas.size() + "\nTotal de Turmas: " + turmas.size() + "\nTurmas Alocadas: " + getTotalTurmasAlocadas() + "\nEspaços Livres: " + getTotalEspacoLivre() + "\n\n";
    }
    
    String relatorioTurmasPorSala(){
        TurmaEmSala ts;
        Sala s;
        int tamEnsalamento = ensalamento.size();
        String res = relatorioResumoEnsalamento();
        for(int i = 0; i < salas.size(); i++){
            s = salas.get(i);
            res += "--- ";
            res += s.getDescricao();
            res += " ---\n\n";
            for(int j = 0; j < tamEnsalamento; j++){
                ts = ensalamento.get(j);
                if(ts.sala.equals(s)){
                    res += ts.turma.getDescricao();
                }
            }
        }
        return res;
    }
    
    String relatorioSalasPorTurma(){
        Turma t;
        TurmaEmSala ts;
        int tamEnsalamento = ensalamento.size();
        String res = relatorioResumoEnsalamento();
        for(int i = 0; i < tamEnsalamento; i++){
            ts = ensalamento.get(i);
            res += ts.turma.getDescricao();
            res += "Sala: " + ts.sala.getDescricao();
        }
        for(int j = tamEnsalamento; j < turmas.size(); j++){
            t = turmas.get(j);
            res += t.getDescricao() + "SALA: SEM SALA";
        }
        return res;
    }
}

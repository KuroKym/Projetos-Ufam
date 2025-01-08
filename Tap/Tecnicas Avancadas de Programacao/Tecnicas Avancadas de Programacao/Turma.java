import java.util.ArrayList;

public class Turma {
    String nome;
    String professor;
    int numAlunos;
    boolean acessivel;
    ArrayList<Integer> horarios = new ArrayList<Integer>();
    
    Turma(){}
    Turma(String nome, String professor, int numAlunos, boolean acessivel){
        this.nome = nome;
        this.professor = professor;
        this.numAlunos = numAlunos;
        this.acessivel = acessivel;
    }

    void addHorario(int horario){
        horarios.add(horario);
    }

    String getHorariosString(){
        int hora;
        int virgulas = horarios.size();
        String res = "";
        for(int i = 0; i < horarios.size(); i++){
            hora = horarios.get(i);
            if(hora == 1){
                res = res + "segunda 8hs";
            }else if(hora == 2){
                res = res + "segunda 10hs";
            }else if(hora == 3){
                res = res + "segunda 12hs";
            }else if(hora == 4){
                res = res + "segunda 14hs";
            }else if(hora == 5){
                res = res + "segunda 16hs";
            }else if(hora == 6){
                res = res + "segunda 18hs";
            }else if(hora == 7){
                res = res + "segunda 20hs";
            }else if(hora == 8){
                res = res + "terça 8hs";
            }else if(hora == 9){
                res = res + "terça 10hs";
            }else if(hora == 10){
                res = res + "terça 12hs";
            }else if(hora == 11){
                res = res + "terça 14hs";
            }else if(hora == 12){
                res = res + "terça 16hs";
            }else if(hora == 13){   
                res = res + "terça 18hs";
            }else if(hora == 14){
                res = res + "terça 20hs";
            }else if(hora == 15){
                res = res + "quarta 8hs";
            }else if(hora == 16){
                res = res + "quarta 10hs";
            }else if(hora == 17){
                res = res + "quarta 12hs";
            }else if(hora == 18){
                res = res + "quarta 14hs";
            }else if(hora == 19){
                res = res + "quarta 16hs";
            }else if(hora == 20){
                res = res + "quarta 18hs";
            }else if(hora == 21){
                res = res + "quarta 20hs";
            }else if(hora == 22){
                res = res + "quinta 8hs";
            }else if(hora == 23){
                res = res + "quinta 10hs";
            }else if(hora == 24){
                res = res + "quinta 12hs";
            }else if(hora == 25){
                res = res + "quinta 14hs";
            }else if(hora == 26){
                res = res + "quinta 16hs";
            }else if(hora == 27){
                res = res + "quinta 18hs";
            }else if(hora == 28){
                res = res + "quinta 20hs";
            }else if(hora == 29){
                res = res + "sexta 8hs";
            }else if(hora == 30){
                res = res + "sexta 10hs";
            }else if(hora == 31){
                res = res + "sexta 12hs";
            }else if(hora == 32){
                res = res + "sexta 14hs";
            }else if(hora == 33){
                res = res + "sexta 16hs";
            }else if(hora == 34){
                res = res + "sexta 18hs";
            }else if(hora == 35){
                res = res + "sexta 20hs";
            }
            virgulas--;
            if(virgulas > 0){
                    res = res + ", ";
            }
        }
        return res;
    }

    String getDescricao(){
        if(acessivel){
            return "Turma: " + nome + "\nProfessor: " + professor + "\nNúmero de Alunos: " + numAlunos + "\nHorário: " + getHorariosString() + "\nAcessível: sim\n\n";
        }else{
            return "Turma: " + nome + "\nProfessor: " + professor + "\nNúmero de Alunos: " + numAlunos + "\nHorário: " + getHorariosString() + "\nAcessível: não\n\n";
        }
    }
}

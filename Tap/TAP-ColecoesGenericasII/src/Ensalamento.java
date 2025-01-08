import java.util.ArrayList;
import java.util.Collections;
public class Ensalamento {
	ArrayList<Sala> salas;
	ArrayList<Turma> turmas;
	ArrayList<TurmaEmSala> ensalamento;
	
	Ensalamento(){
		this.salas = new ArrayList<Sala>();
		this.turmas = new ArrayList<Turma>();
		this.ensalamento = new ArrayList<TurmaEmSala>();
	}
	
	void addSala(Sala sala) {
		salas.add(sala);
	}
	
	void addTurma(Turma turma) {
		turmas.add(turma);
	}
	
	Sala getSala(Turma turma) {
		for(TurmaEmSala turma_sala : ensalamento) {
			if(turma_sala.turma == turma) {
				return turma_sala.sala;
			}
		}
		return null;
	}
	
	boolean salaDisponivel(Sala sala, int horario) {
		int hora;
		for(TurmaEmSala turma_sala : ensalamento) {
			for(int j = 0; j < turma_sala.turma.horarios.size(); j++) {
				hora = turma_sala.turma.horarios.get(j);
				if(turma_sala.sala == sala && hora == horario) {
					return false;
				}
			}
		}
		return true;
		
	}
	
	boolean salaDisponivel(Sala sala, ArrayList<Integer> horarios) {
		for(int hora : horarios) {
			if(salaDisponivel(sala, hora) == false) {
				return false;
			}
		}
		return true;
	}
	
	boolean alocar(Turma turma, Sala sala) {
		TurmaEmSala turma_sala = new TurmaEmSala(turma, sala);
		if(turma.acessivel) {
			if(sala.acessivel && salaDisponivel(sala, turma.horarios) && turma.numAlunos <= sala.capacidade) {
				ensalamento.add(turma_sala);
				return true;
			}
		}
		else {
			if(salaDisponivel(sala, turma.horarios) && turma.numAlunos <= sala.capacidade) {
				ensalamento.add(turma_sala);
				return true;
			}
		}
		return false;
	}
	
	void alocarTodas() {
	    ArrayList<Turma> turma_nao_alocada = new ArrayList<>(turmas);
	    
	    for(Sala sala : salas) {
	        ArrayList<Turma> turma_alocada = new ArrayList<>();
	        
	        for(Turma turma : turma_nao_alocada) {
	            if (alocar(turma, sala)) {
	                turma_alocada.add(turma);
	            }
	        }
	        turma_nao_alocada.removeAll(turma_alocada);
	        
	        if (turma_nao_alocada.isEmpty()) {	
	            break;
	        }
	    }
	}
	
	int getTotalTurmasAlocadas() {
		int total = 0;
		for(TurmaEmSala turma_sala : ensalamento) {
			if(turma_sala != null) {
				total++;
			}
		}
		return total;
	}
	
	int getTotalEspacoLivre(){
        int total = 0;
        for(int i = 0; i < ensalamento.size(); i++){
            TurmaEmSala turma_sala = ensalamento.get(i);
            total += turma_sala.sala.capacidade - turma_sala.turma.numAlunos;
        }
        return total;
    }
	
	String relatorioResumoEnsalamento() {
		String relatorio = "Total de Salas: " + salas.size() + "\n";
		relatorio += "Total de Turmas: " + turmas.size() + "\n";
		relatorio += "Turmas Alocadas: " + getTotalTurmasAlocadas() + "\n";
		relatorio += "Espaços Livres: " + getTotalEspacoLivre() + "\n\n";
		return relatorio;
	}
	
	String relatorioTurmasPorSala() {
		String relatorio = relatorioResumoEnsalamento();
		for(Sala sal: salas) {
			relatorio += "--- " + sal.getDescricao() + " ---";
			for(TurmaEmSala turma_sala : ensalamento) {
				if(turma_sala.sala == sal) {
					relatorio += turma_sala.turma.getDescricao();
				}
			}
		}
		return relatorio;		
	}
	
	String relatorioSalasPorTurma() {
		String relatorio = relatorioResumoEnsalamento();
		Turma tur;
		for(TurmaEmSala turma_sala : ensalamento) {
			relatorio += turma_sala.turma.getDescricao();
			relatorio += "Sala: " + turma_sala.sala.getDescricao();
		}
		for(int j = ensalamento.size(); j < turmas.size(); j++) {
			tur = turmas.get(j);
			relatorio += tur.getDescricao() + "Sala: SEM SALA";
		}
		return relatorio;
	}
}


public class Placa {
    String placa;
    int tipo;


    Placa(){
        this.placa = "null";
        this.tipo = 0;
    }

    Placa(String placa, int tipo){
        this.placa = placa;
        this.tipo = tipo;
    }

    String getTipoString(){
        int tipo = this.tipo;
        switch (tipo) {
            case 1:
                return "Normal";
            case 2:
                return "Servico";
            case 3:
                return "Oficial";
            case 4:
                return "Auto Escola";
            case 5:
                return "Prototipo";
            case 6:
                return "Colecionador";
            default:
                return "Outros";
        }
    }

    boolean temEstacionamentoLivre(){
        int tipo = this.tipo;
        if (tipo == 2 || tipo == 3) {
            return true;
        }
        else {
            return false;
        }
    }

    String getDescricao() {
		String nome = this.placa;
        boolean estacionamento = this.temEstacionamentoLivre();
		String tipo = getTipoString();
		String descricao = "Placa: placa=" + nome + ", tipo=" + tipo + ", estacionamentoLivre=" + estacionamento + ".";
		return descricao;
	}

}

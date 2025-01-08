public class Motor {
    int tipo;
    double capacidade;
    int potencia;

    Motor(){
        this.tipo = 0;
        this.capacidade = 0.0;
        this.potencia = 0;
    }

    Motor(int tipo, double capacidade, int potencia){
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.potencia = potencia;
    }

    String getTipoString(){
        switch (this.tipo) {
            case 1:
                return "Gasolina";
            case 2:
                return "Alcool";
            case 3:
                return "Flex";
            case 4:
                return "Diesel";
            case 5:
                return "Eletrico";          
            default:
                return "Outros"; 
        }
    }

    String getDescricao(){
        int potencia = this.potencia;
		String tipo = getTipoString();
        double capacidade = this.capacidade;
		String descricao = "Motor: tipo=" + tipo + ", capacidade=" + capacidade + "L, potencia=" + potencia + "CV.";
		return descricao;
    }
    
}

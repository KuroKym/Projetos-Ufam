class Processador{
    String marca;
    String modelo;
    double velocidade;
    int numNucleos;

    Processador(){}

    Processador(String marca, String modelo, double velocidade, int numNucleos){
        this.marca = marca;
        this.modelo = modelo;
        this.velocidade = velocidade;
        this.numNucleos = numNucleos;
    }

    double getVelocidadeParalela(){
        return numNucleos*velocidade;
    }

    String getDescricao(){
        return "Processador: " + "marca=" + marca + ", modelo=" + modelo +", velocidade=" + velocidade + "GHz, numNucleos=" + numNucleos + ", velocidadeParalela=" + getVelocidadeParalela() + "GHz. ";
    }
}
public class Carro {
    String marca, modelo;
    Proprietario proprietario;
    Placa placa;
    Motor motor;
    

    Carro(String marca, String modelo, Proprietario proprietario, Placa placa, Motor motor) {
        this.marca = marca;
        this.modelo = modelo;
        this.proprietario = proprietario;
        this.placa = placa;
        this.motor = motor;
    }

    String getDescricao(){
        String marca = this.marca;
        String modelo = this.modelo;
        Proprietario proprietario = this.proprietario;
        Placa placa = this.placa;
        Motor motor = this.motor;
        String descricao = "Carro "+ marca + "/" + modelo + ". " + proprietario.getDescricao()+ " " + placa.getDescricao()+ " " + motor.getDescricao();
        return descricao;
    }
}

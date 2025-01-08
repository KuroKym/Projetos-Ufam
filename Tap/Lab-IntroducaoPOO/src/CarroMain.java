public class CarroMain {
    public static void main(String[] args) {
            Proprietario x = new Proprietario("pedro", 98008173, 2001);
            Placa plaquita = new Placa("Oat-cu", 2);
            Motor m = new Motor(1, 2.85, 130);
            Carro pica = new Carro("Ped", "frito", x, plaquita, m);
            System.out.println(pica.getDescricao());
    }
}

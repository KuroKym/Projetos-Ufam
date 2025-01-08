public class ComputadorMain {
    public static void main(String[] args){
        Processador process = new Processador();
        process.marca = "Intel";
        process.modelo = "i7";
        process.numNucleos = 8;
        process.velocidade = 3.2;
        //System.out.println(process.getDescricao());

        Memoria mem = new Memoria();
        mem.marca = "Kingston";
        mem.tipo = "DDR4";
        mem.tamanho = 8;
        mem.velocidade = 3.2;
        mem.numPentes = 4;
        //System.out.println(mem.getDescricao());

        Disco disc = new Disco();
        disc.marca = "Western Digital";
        disc.tipo = "HDD";
        disc.capacidade = 4000;
        disc.rpm = 9600;
        //System.out.println(disc.getDescricao());

        Computador comp = new Computador();
        comp.fabricante = "Dell";
        comp.processador = process;
        comp.memoria = mem;
        comp.disco = disc;
        System.out.println(comp.getDescricao());
    }
}

public class SessaoJediMain {
    public static void main(String[] args){
        IniciadoJedi IniciadoJedi = new IniciadoJedi();
        IniciadoJedi.nome = "Katooni";
        IniciadoJedi.especie = "Tholothian";
        IniciadoJedi.anoNascimento = -23;

        TreinadorJedi TreinadorJedi = new TreinadorJedi();
        TreinadorJedi.nome = "Fae Coven";
        TreinadorJedi.titulacao = "Grão-Mestre";

        SessaoJedi sessaoJedi = new SessaoJedi(null, TreinadorJedi);
        sessaoJedi.nome = "Instruções de Uso da Força";

        System.out.printf("%s\n", sessaoJedi.getDescricao());
        System.out.printf("%s\n", TreinadorJedi.getDescricao());
        System.out.printf("%s\n", IniciadoJedi.getDescricao());
    }
}
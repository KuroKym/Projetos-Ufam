import java.util.Scanner;

public class CifraCesar {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String Entrada = scan.nextLine();
        String EntradaConv[] = Entrada.split(" ");
        int deslocamento = Integer.parseInt(EntradaConv[0]);
        String texto = "";
        for(int j = 1; j < EntradaConv.length; j++){
            texto = texto + EntradaConv[j] + " ";
        }
        scan.close();

        String resposta = "";
        char TextoCifrado;
        for(int i = 0; i < texto.length(); i++){
            if(Character.isLetter(texto.charAt(i))){
                TextoCifrado = (char)(texto.charAt(i) - 'a');
                TextoCifrado = (char)((TextoCifrado + deslocamento)%26);
                TextoCifrado += 'A';
                resposta = resposta + TextoCifrado;
            }else{
                resposta = resposta + texto.charAt(i);
            }
        }
        System.out.printf("%s\n", resposta);
    }
}

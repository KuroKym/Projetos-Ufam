import java.util.Scanner;

public class CifraCesar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int desloc = scan.nextInt();
        String linha_o = scan.nextLine();
        String linha_c = codificacao(linha_o, desloc);
        String format_linha = linha_c.replaceFirst(" ","");
        System.out.println(format_linha.toUpperCase());

        scan.close();
    }

    private static String codificacao(String texto, int desloc) {
        StringBuilder linha_c = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            char cOriginal = texto.charAt(i);

            if (Character.isLetter(cOriginal)) {
                char cCifrado;
                char aux;
                if (Character.isUpperCase(cOriginal)) {
                    aux = 'A';
                } 
                else {
                    aux = 'a';
                }

                //cCifrado = (char) (((cOriginal - aux + desloc) % 26 + 26) % 26 + aux);
                cCifrado = (char) (cOriginal - aux);
                cCifrado = (char) ((cCifrado + desloc)%26);
                cCifrado += aux;
                linha_c.append(cCifrado);
            }
            else {
                linha_c.append(cOriginal);
            }
        }

        return linha_c.toString();
    }
}

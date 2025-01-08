import java.util.Scanner;

public class OperacoesString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String linha = scan.nextLine();
        int qnt_char = linha.length();
        System.out.println(qnt_char);
        System.out.println(linha.charAt(0));
        System.out.println(linha.charAt(qnt_char -1));
        System.out.println(linha.toUpperCase());
        System.out.println(linha.toLowerCase());
        System.out.println(linha.replace('a', 'e'));
        for (int i = 0; i <linha.length(); i+=2) {
            System.out.print(linha.charAt(i));
        }
        System.out.println();
        int qnt_vogal = conta_vogal(linha);
        System.out.println(qnt_vogal);
        scan.close();


    }

    private static int conta_vogal(String line) {
        int count = 0;
        for(char c : line.toCharArray()) {
            if("aeiouAEIOU".indexOf(c) != -1){
                count++;
            }
        }
        return count;

    }
}

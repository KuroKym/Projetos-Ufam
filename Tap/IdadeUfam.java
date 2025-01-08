import java.util.Scanner;
public class IdadeUfam {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int idade = scan.nextInt();
        idade = idade - 1909;
        System.err.printf("A UFAM tem %d anos de fundacao", idade);
        scan.close();    
    }
}

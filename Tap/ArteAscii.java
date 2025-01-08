import java.util.Scanner;
public class ArteAscii {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int asteristico = scan.nextInt();
        for (int i = asteristico; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            if(i >1){
                System.out.println();
            }
        }

        for (int i = 0; i <= asteristico; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        scan.close();    
    }
}

import java.util.Scanner;
public class Media {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        float n1 = scan.nextFloat();
        float n2 = scan.nextFloat();
        float n3 = scan.nextFloat();
        float media = (n1 + n2 + n3) / 3;
        System.out.printf("%.2f", media);
        scan.close();
    }
}

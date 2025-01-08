import java.util.Scanner;
public class NumeroNarcisista {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int tmp = num;
        int qnt = 0;
        int ver = 0;
        while (num != 0) {
            qnt ++;
            num /= 10;
        }
        num = tmp;
        while (num != 0){
            ver += Math.pow((num % 10), qnt);
            num /= 10;
        }
        num = tmp;
        if(num == ver){
            System.out.println("Sim");
        }
        else{
            System.out.println("Nao");
        }
        scan.close();
    }
}

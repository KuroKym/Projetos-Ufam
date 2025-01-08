import java.util.Scanner;

public class AnimaisCedulas {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int valor = scan.nextInt();
        scan.close();

        if(valor == 2){
            System.out.print("Tartaruga");
        }else if(valor == 5){
            System.out.print("Garça");
        }else if(valor == 10){
            System.out.print("Arara");
        }else if(valor == 20){
            System.out.print("Mico-leão-dourado");
        }else if(valor == 50){
            System.out.print("Onça-pintada");
        }else if(valor == 100){
            System.out.print("Garoupa");
        }else{
            System.out.print("erro");
        }
    }
}

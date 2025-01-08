import java.util.Scanner;


public class AsciiArt{
   public static void main(String[] args){
       Scanner scan = new Scanner(System.in);
       int numero = scan.nextInt();
       scan.close();


       int a;
       int b = numero;
       for(int i = 0; i < numero; i++){
           a = i*2;
           for(int j = 0; j <= numero*2; j++){
               if(j == b){
                   while(a > 0){
                       System.out.print(" ");
                       a--;
                       j++;
                   }
                   b--;
               }else{
                   System.out.print("*");
               }
              
           }
           System.out.println();
       }
   }
}

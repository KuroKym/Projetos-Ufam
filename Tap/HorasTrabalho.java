import java.util.Scanner;
public class HorasTrabalho {
    public static void main(String[] args) {
        Scanner scan = null;
        try{
            scan = new Scanner(System.in);
            int hora = scan.nextInt();
            int flag = 0;
            int sum = 0;
            while(hora != -1){ 
                flag = 0;
                sum = 0;
                while(flag < 7){
                    sum += hora;
                    hora = scan.nextInt();
                    if(hora == -1){
                        break;
                    }
                    flag++;
                }
                System.out.println(sum);               
            }

        }
        finally{
            if(scan!= null){
                scan.close();
            }
        }
    }
    
}

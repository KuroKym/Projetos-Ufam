import java.util.Scanner;

public class RaizDois {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try{   
            int n = scan.nextInt();
            double raiz = 1.0;
            double semente = 1.0;
            if(semente == 0){raiz = 1;}
            
            for(int i = 0; i < n; i++){
                semente = 1.0/(2.0 + semente);
                raiz += semente;
                System.out.printf("%.14f\n", raiz);
                raiz = 1.0;
            }

        }

        finally{
            if(scan!= null){
                scan.close();
            }
        }
    
    }
}

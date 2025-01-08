import java.util.Scanner;
public class DiaSemana {
    public static void main(String[] args) {
        Scanner scan = null;
        try{
            scan = new Scanner(System.in);
            int hora = scan.nextInt();
            int[][] data = new int[20][7];
            int[] dias = new int[7];
            int maior = 0;
            int i = 0;
            while (hora != -1) {
                for (int j = 0; j < 7; j++) {
                    data[i][j] = hora;
                    dias[j] += hora;
                    hora = scan.nextInt();
                }
                i++;
            }
            for (int k = 0; k < 7; k++) {
                if (maior < dias[k]) {
                    maior = dias[k];
                   
                }
            }
            for(int k = 0; k < 7; k++) {
                if(maior == dias[k]){
                    System.out.println(k+1);
                }
            }
        }
        finally{
            if(scan!= null){
                scan.close();
            }
        }
    }
    
}

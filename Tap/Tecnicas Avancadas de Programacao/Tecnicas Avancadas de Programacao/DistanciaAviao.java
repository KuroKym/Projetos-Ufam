import java.util.Scanner;

public class DistanciaAviao {
    static int ConverterDistancia(int num){
        if(num == 111){
            return 0;
        }else if(num == 222){
            return 1;
        }else if(num == 333){
            return 2;
        }else if(num == 444){
            return 3;
        }else if(num == 555){
            return 4;
        }else if(num == 666){
            return 5;
        }else if(num == 777){
            return 6;
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int matriz[][] = {{0,2,11,6,15,11,1},{2,0,7,12,4,2,15},{11,7,0,11,8,3,13},{6,12,11,0,10,2,1},{15,4,8,10,0,5,13},{11,2,3,2,5,0,14},{1,15,13,1,13,14,0}};
        int distancias[] = new int[100];

        int cidade = scan.nextInt();
        int i = 0;
        int tam = 0;
        while(cidade != -1){
            distancias[i] = cidade;
            i++;
            tam++;
            cidade = scan.nextInt();
        }
        scan.close();
        
        for(int j = 0; j < tam; j++){
            distancias[j] = ConverterDistancia(distancias[j]);
        }

        int soma = 0;
        for(int k = 0; k < tam-1; k++){
            soma = soma + matriz[distancias[k]][distancias[k+1]];
        }
        System.out.printf("%d\n", soma);
    }
}

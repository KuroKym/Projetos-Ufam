import java.util.Scanner;

public class AprovacaoDisciplina {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        double notas[] = new double[100];
        int frequencias[] = new int[100];

        double nota = scan.nextDouble();
        int i = 0;
        int tam = 0;
        while(nota != -1){
            notas[i] = nota;
            i++;
            tam++;
            nota = scan.nextDouble();
        }
        int frequencia = scan.nextInt();
        int j = 0;
        while(frequencia != -1){
            frequencias[j] = frequencia;
            j++;
            frequencia = scan.nextInt();
        }
        double CargaHoraria = scan.nextDouble();
        scan.close();

        int aprovados = 0;
        int reproNota = 0;
        int reproFrequencia = 0;
        for(int k = 0; k<tam; k++){
            if(notas[k] >= 5 && frequencias[k] >= 0.75*CargaHoraria){
                aprovados++;
            }else if (frequencias[k] < 0.75*CargaHoraria){
                reproFrequencia++;
            }else{
                reproNota++;
            }
        }
        System.out.printf("%d %d %d", aprovados, reproNota, reproFrequencia);
    }
}

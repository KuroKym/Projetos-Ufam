import java.util.Scanner;

public class DataExtenso{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int entrada = scan.nextInt();
        scan.close();

        int dia = entrada/1000000;
        int mes = (entrada%1000000)/10000;
        String mesConvertido = "";
        switch(mes){
            case 1:
                mesConvertido = "janeiro";
                break;
            case 2:
                mesConvertido = "fevereiro";
                break;
            case 3:
                mesConvertido = "março";
                break;
            case 4:
                mesConvertido = "abril";
                break;
            case 5:
                mesConvertido = "maio";
                break;
            case 6:
                mesConvertido = "junho";
                break;
            case 7:
                mesConvertido = "julho";
                break;
            case 8:
                mesConvertido = "agosto";
                break;
            case 9:
                mesConvertido = "setembro";
                break;
            case 10:
                mesConvertido = "outubro";
                break;
            case 11:
                mesConvertido = "novembro";
                break;
            case 12:
                mesConvertido = "dezembro";
        }
        int ano = (entrada%1000000)%10000;
        System.out.printf("%d de %s de %d", dia, mesConvertido, ano);
    }
}
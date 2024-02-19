
/******************************************************************************
 -Inserire in vettore una sequenza di stringhe,
 contenenti i giorni della settimana e scirvere se il giorno è pari
 o dispari sapendo che il lunedi è dispari.
 *******************************************************************************/
//importazione librerie
import java.util.Scanner;

public class laghi_3E_es18_Week
{
    public static void main (String[]args)
    {
        Scanner tastiera = new Scanner (System.in);
        String[] settimana = new String[7];
        for(int i=0;i< settimana.length;i++) {
            settimana[i] = tastiera.next();
        }
        Show(settimana);

    }

    private static void Show(String[] settimana){

        for(int i=0;i< settimana.length;i++){

            System.out.println(settimana[i]+" e': ");
            switch(settimana[i]){
                case "Lunedi","Mercoledi","Venerdi","Domenica":{
                    System.out.println("dispari");
                }
                break;
                case "Martedi","Giovedi","Sabato":{
                    System.out.println("pari");
                }
                break;
            }
        }
    }
}
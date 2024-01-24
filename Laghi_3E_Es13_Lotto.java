/*Consegna:
realizzare un programma in java in cui
vengono estratti 5 numeri, compresi tra 1 e 90,
inseriti in un vettore e stamparlo a schermo
*/

import java.util.Random;    //libreria per funzione random
public class Laghi_3E_Es13_Lotto
{
    public static void main(String[] args)
    {
        Random casuale = new Random();
        int [] nEstratti  = new int[5];
        System.out.println("Benvenuti alla Lotteria di Venezia\n Estraiamo i numeri:\n");

        for(int i=0; i<nEstratti.length;i++)
        {
            nEstratti[i] = casuale.nextInt(1,90)+1;
            System.out.println(+nEstratti[i]);
        }


    }
}

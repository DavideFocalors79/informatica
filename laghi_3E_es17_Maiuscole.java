
/******************************************************************************
 -Inserire in vettore una sequenza di stringhe,
 stampare a video solamente le lettere in maiuscolo.
 *******************************************************************************/
//importazione librerie

import java.lang.String;

public class laghi_3E_es17_Maiuscole
{
    public static void main (String[]args)
    {
        String[] disney = {"Pippo", "pluto", "Topolino", "minnie"};
        String[] maiuscole = new String[disney.length];
        GetUpWord(disney,maiuscole);
        Show(maiuscole);
    }
    private static String[] GetUpWord(String[] disney,String[] maiuscole){

        for (int i = 0; i < disney.length; i++){
            if (disney[i].charAt(0) >= 'A' && disney[i].charAt(0) <= 'Z') {  //restituisce in output se la lettera iniziale C( compresa tra A e Z

                maiuscole[i]=disney[i];
            }
        }
        return maiuscole;
    }
    private static void Show(String[] maiuscole){
        for(int i=0;i< maiuscole.length;i++){
            if(maiuscole[i]!=null){
                System.out.println(maiuscole[i].charAt(0));
            }
        }
    }
}
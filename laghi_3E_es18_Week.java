
/******************************************************************************
 -Inserire in vettore una sequenza di stringhe,
 contenenti i giorni della settimana e scirvere se il giorno è pari
 o dispari sapendo che il lunedi è dispari.
 *******************************************************************************/
//importazione librerie

public class laghi_3E_es18_Week
{
    public static void main (String[]args)
    {
        String[] settimana = {"Lunedi", "Martedi", "Mercoledi", "Giovedi", "Venerdi", "Sabato", "Domenica"};
        Show(settimana);
    }

    private static void Show(String[] settimana){
        int dispar=0;;
        for(int i=0;i< settimana.length;i++){
            System.out.println(settimana[i]+" e': ");
            switch(dispar){
                case(0):{
                    System.out.println("dispari");
                    dispar=1;
                }
                break;
                case(1):{
                    System.out.println("pari");
                    dispar=0;
                }
                break;
            }
        }
    }
}
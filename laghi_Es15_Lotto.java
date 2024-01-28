import java.util.Random;
import java.util.Scanner;

public class laghi_Es15_Lotto {
    public static void main(String[] args) {
        Scanner tastiera=new Scanner(System.in);
        int contatoreGioco=0;
        int scelta;
        int[] casuale=new int[5];
        int[] utente=new int[5];
        String [] opzioni = {"=== Gioco Dadi === ",
                "[1] Estrazioni ruota di Venezia",
                "[2] Giocata utente",
                "[3] Verifica vincita",
                "[4] Visualizza giocate"};


        do {
            scelta = Menu(opzioni, tastiera);

            System.out.println(Menu(opzioni, tastiera));


            switch (scelta) {

                case 1: {
                    for (int i = 0; i < 5; i++) {
                        casuale[i] = estrazionePC(1, 90);
                        System.out.println("Numeri estratti!\n");
                    }
                }
                case 2: {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Inserisci i numeri che vuoi estrarre\n");


                        for (int i = 0; i < utente.length; i++) {
                            do{
                                utente[i] = scanner.nextInt();
                                if(utente[i]>90 || utente[i]<0){
                                    System.out.println("Valore non valido inserisci di nuovo i numeri da 0 a 90");
                                   i=0;
                                }
                            }while(utente[i]>90 || utente[i]<0);
                        }



                }
                case 3: {
                    int numeriIndovinati = contaNumeriIndovinati(casuale, utente);
                    System.out.println("Hai indovinato " + numeriIndovinati + " numeri.");
                    break;

                }
            }
            contatoreGioco++;
        }while(scelta!=4);

        System.out.println("Il programma è stato eseguito " + contatoreGioco + " volte.");


    }

    private static int estrazionePC(int minValue, int maxValue) {
        Random computer = new Random();
        return computer.nextInt(maxValue - minValue + 1) + minValue;
    }


    private static int Menu (String opzioni[], Scanner tastiera)
    {
        int scelta;

        do {

            System.out.println("------------------");
            System.out.println(opzioni[0]);
            System.out.println("------------------");
            for (int i=1; i < opzioni.length; i++)
            {
                System.out.println(opzioni[i]);
            }
            scelta = tastiera.nextInt();

            if ((scelta < 1 ) || (scelta > opzioni.length -1 ))
            {
                System.out.println("Opzione Sbagliata");

            }
        }
        while ((scelta < 1 ) || (scelta > opzioni.length -1 ));

        return scelta;
    }

    private static int contaNumeriIndovinati(int[] casuale, int[] utente) {
        int numeriIndovinati = 0;

        if (casuale.length != utente.length) {
            System.out.println("Gli array hanno lunghezze diverse!");
            return 0;
        }


        for (int i = 0; i < utente.length; i++) {

            if (utente[i] == casuale[i]) {
                numeriIndovinati++;
            }
        }

        return numeriIndovinati;
    }
}
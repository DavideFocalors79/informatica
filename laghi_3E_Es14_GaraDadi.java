/******************************************************************************
=== APP Gara Dadi ===
[1]-Sfida tra due giocatori
[2]-Sfida contro il computer
[3]-Fine
*******************************************************************************/
import java.util.Scanner; //importare libreria scanner
import java.util.Random; //importare libreria scanner

public class laghi_3E_Es14_GaraDadi { //definizione classe
    public static void main(String[] args) //motodo principale
    
    {
        //dichiarazione variabili
        int dado1=0, dado2=0, caso=0;
        int scelta = 0;
        int valoreFaccia=0;
        int faccia = 0;;


        boolean exit = true;
        Scanner scanner = new Scanner(System.in); //richiamo costruttore scanner
        
        //ciclo per far ripetere la scelta fino a che utente non fa 3
        do {
            ClrScr(); //richiamo funzione per cancellare lo schermo
            Menù(); //richiamo funzione per visualizzare il Menù 

            scelta = scanner.nextInt(); // attribuire il valore di scelta

            switch (scelta) { // swich case con la scelta
                case 1:
                    {
                    caso=1;
                    System.out.printf("Estrazione dadi...\n");
                    Wait(1000);
                    dado1 = estraiDado(); // richiamo metodo estraiDado per attribuire il valore alla variabile
                    System.out.println("Giocatore 1 ha estratto: " +dado1);
                    FacceDadi(dado1);
                    Wait(1000);
                    dado2 = estraiDado(); // richiamo metodo estraiDado per attribuire il valore alla variabile
                    System.out.println("Giocatore 2 ha estratto: " +dado2);
                    FacceDadi(dado2);
                    Vincitore(dado1, dado2, caso); // richiamo metodo per dire chi ha vinto
                    Wait(2000);
                    break;
                    }
                case 2:
                    {
                    caso=2;
                    System.out.printf("Estrazione dadi...\n");
                    Wait(1000);
                    dado1 = estraiDado(); // richiamo metodo estraiDado per attribuire il valore alla variabile
                    System.out.println("Giocatore 1 ha estratto: " +dado1);
                    FacceDadi(dado1);
                    Wait(1000);
                    dado2 = estraiDado(); // richiamo metodo estraiDado per attribuire il valore alla variabile
                    System.out.println("Il computer ha estratto: " +dado2);
                    FacceDadi(dado2);
                    Vincitore(dado1, dado2, caso); // richiamo metodo per dire chi ha vinto
                    Wait(2000);
                    break;
                    }
                case 3:
                {
                System.out.println("Uscita "); // comunicare l'uscita dal ciclo
                exit = false; // attribuire il valore per uscire dal ciclo
                Wait(2000);
                    break;
                }
                default: // condizione nel caso nessuna delle 3 precedenti sia vera
                    {
                    System.out.println("Scelta errata ");
                    Wait(200);
                    }

            }

        }while (exit); // condizione


    }
    
    private static int estraiDado()  // metodo per estrarre il dado
    {

    Random num = new Random();
    return num.nextInt(6) + 1;

    }

    private static void Menù () // metodo per visualizzare il menu  
    {
        System.out.println("=== App lotto === ");
        System.out.println("[1]-Sfida tra due giocatori");
        System.out.println("[2] Sfida contro il computer");
        System.out.println("[3] Exit ");
    }
    
    private static void ClrScr(){ // metodo per cancellare lo schermo
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
   private static void Vincitore(int dado1, int dado2, int caso) //metodo estrarre vincitore
    {

    if (dado1>dado2) 
		System.out.println("\nHa vinto il G1");
		
		else if (dado1==dado2)
		System.out.println("\nPareggio");
		
		else  
		{
		if (caso==1)
		System.out.println("\nHa vinto il G2");
		else 
		System.out.println("\nHa vinto il Computer");
		}
		
    }
      
    
    private static void Wait(int attesa) // metodo per aspettare x secondi
        {
        try
        {
            Thread.sleep(attesa);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void FacceDadi(int faccia){



        switch(faccia)

        {
            case 1: {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ╚═════════╝");

                break;
            }

            case 2: {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O      ║");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║      O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");

                break;
            }

            case 3: {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O      ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║      O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 4: {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 5: {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 6: {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }
        }
    }


}
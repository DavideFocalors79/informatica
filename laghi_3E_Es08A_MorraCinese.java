import java.util.Scanner;
public class laghi_3E_Es08A_MorraCinese {
    private static void ClrScr(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        char player1;
        char player2 = 0;
        int controllo1 = 0;
        int controllo2 = 0;
        char scelta = 'S';


        do {
            ClrScr();
            do {
                System.out.println("Giocatore 1: Inserisci A per carta, S per sasso, D per forbici, o X per uscire");
                player1 = keyboard.next().charAt(0);
                ClrScr();

                if (player1 == 'X' || player1 == 'x')
                    controllo1 = 2;
                    // Gioco terminato da player1

                else if (player1 == 'A' || player1 == 'a' ||
                        player1 == 'S' || player1 == 's' ||
                        player1 == 'D' || player1 == 'd')
                {
                    do {
                        System.out.println("Giocatore 2: Inserisci J per carta, K per sasso, L per forbici, o X per uscire");
                        player2 = keyboard.next().charAt(0);
                        ClrScr();

                        if (player2 == 'X' || player2 == 'x')
                            controllo2 = 2;
                            // Gioco terminato da player2

                        else if (player2 == 'J' || player2 == 'j' ||
                                player2 == 'K' || player2 == 'k' ||
                                player2 == 'L' || player2 == 'l')
                            controllo2 = 1;

                            // Valore inserito da player2 validi, si continua con la verifica del vincitore
                        else
                            System.out.println("Input non valido per il Giocatore 2. Riprova");
                        // Valore inserito da player2 non valido, si ripete l'input

                    } while (controllo2 == 0);

                    controllo1 = 1;
                }
                // Valori inserito del player1 valido

                else
                    System.out.println("Input non valido per il Giocatore 1. Riprova");
                // Valore inserito del player1 non valido, si ripete il gioco

            } while (controllo1 == 0);

            if (controllo1 == 2 || controllo2 == 2) {
                System.out.println("Gioco terminato. Vuoi giocare ancora? S/N");
                scelta = keyboard.next().charAt(0);
            }
            //Output termine gioco

            else {
                if (player1 == 'A' || player1 == 'a') {
                    if (player2 == 'J' || player2 == 'j') {
                        System.out.println("Parità! Vuoi giocare ancora? S/N");
                        scelta = keyboard.next().charAt(0);
                    }

                    else if (player2 == 'K' || player2 == 'k') {
                        System.out.println("Giocatore 1 ha vinto! Vuoi giocare ancora? S/N");
                        scelta = keyboard.next().charAt(0);
                    }

                    else if (player2 == 'L' || player2 == 'l') {
                        System.out.println("Giocatore 2 ha vinto! Vuoi giocare ancora? S/N");
                        scelta = keyboard.next().charAt(0);
                    }
                }
                //Giocatore 1 inserisce A, controllo vincitore

                if (player1 == 'S' || player1 == 's') {
                    if (player2 == 'J' || player2 == 'j') {
                        System.out.println("Giocatore 2 ha vinto! Vuoi giocare ancora? S/N");
                        scelta = keyboard.next().charAt(0);
                    }

                    else if (player2 == 'K' || player2 == 'k') {
                        System.out.println("Parità! Vuoi giocare ancora? S/N");
                        scelta = keyboard.next().charAt(0);
                    }

                    else if (player2 == 'L' || player2 == 'l') {
                        System.out.println("Giocatore 1 ha vinto! Vuoi giocare ancora? S/N");
                        scelta = keyboard.next().charAt(0);
                    }
                }
                //Giocatore 1 inserisce S, controllo vincitore

                if (player1 == 'D' || player1 == 'd') {
                    if (player2 == 'J' || player2 == 'j') {
                        System.out.println("Giocatore 1 ha vinto! Vuoi giocare ancora? S/N");
                        scelta = keyboard.next().charAt(0);
                    }

                    else if (player2 == 'K' || player2 == 'k') {
                        System.out.println("Giocatore 2 ha vinto! Vuoi giocare ancora? S/N");
                        scelta = keyboard.next().charAt(0);
                    }

                    else if (player2 == 'L' || player2 == 'l') {
                        System.out.println("Parità! Vuoi giocare ancora? S/N");
                        scelta = keyboard.next().charAt(0);
                    }
                }
                //Giocatore 1 inserisce D, controllo vincitore
            }


        }while (scelta == 'S' || scelta == 's');
        //ciclo se continuare a giocare o no

    }
}

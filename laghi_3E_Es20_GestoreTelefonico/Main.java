import static tools.utility.*;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String[] operazioni = {"VODAFONE", "Inserimento",
                "Visualizzazione",
                "Ricerca",
                "Fine"};

        final int nMax=3;
        int contrattiVenduti=0;
        Contatto[] gestore = new Contatto[nMax];

        Scanner keyboard = new Scanner(System.in);

        boolean fine=true;
        do {
            switch(menu(operazioni, keyboard)) {
                case 1:

                    if(contrattiVenduti<nMax){
                        gestore[contrattiVenduti]=leggiPersona(true, keyboard);

                        if(!checkContratto(gestore[contrattiVenduti], gestore, contrattiVenduti))
                            contrattiVenduti++;
                        else{
                            System.out.println("Contratto già esistente");
                            Wait(5);
                        }
                    }

                    else{
                        System.out.println("Gestore telefonico pieno. Non è più possibile inserire numeri");
                        Wait(5);
                    }
                    break;
                case 2:
                    visualizzaContatti(gestore, contrattiVenduti);
                    Wait(5);
                    break;
                case 3:
                    break;
                default:
                    fine=false;
            }
        }while(fine);
    }
    private static Contatto leggiPersona(boolean siTel, Scanner keyboard){
        Contatto nuovoContatto = new Contatto();

        String[] tipologia = {"MODALITA' TELEFONO","abitazione", "cellulare", "aziendale"};
        int scelta;


        ClrScr();
        System.out.println("Inserisci nome ");
        nuovoContatto.nome=keyboard.nextLine();
        System.out.println("Inserisci cognome ");
        nuovoContatto.cognome=keyboard.nextLine();


        if(siTel)
        {

            System.out.println("Inserisci il numero di telefono");
            nuovoContatto.telefono=keyboard.nextLine();


            scelta=menu(tipologia, keyboard);
            nuovoContatto.tipo=tipoContratto.valueOf(tipologia[scelta]);
        }

        return nuovoContatto;
    }

    private static void visualizzaContatti(Contatto[] vet, int nContratti){
        ClrScr();

        if(nContratti>0){
            for(int i=0;i<nContratti;i++)
                System.out.println(vet[i].stampa());
        }

        else
            System.out.println("Non ce ancora nessun contratto");
    }

    private static boolean checkContratto(Contatto contatto, Contatto[] vet, int contrattiVenduti){

        for(int i=0;i<contrattiVenduti;i++)
        {
            if(contatto.nome.equals(vet[i].nome) && contatto.cognome.equals(vet[i].cognome))
                return true;
        }

        return false;
    }


    }
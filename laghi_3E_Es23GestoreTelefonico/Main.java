import static Tools.utility.*;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String[] operazioni = {"VODAFONE", "Inserimento",
                "Visualizzazione",
                "Ricerca",
                "Elimina inserendo il numero del contatto",
                "Elimina inserendo il nome e il cognome",
                "Ordinamento",
                "Fine",
        };

        final int nMax=3;
        int posContatto;
        int scelta1=0;
        int contrattiVenduti=0;
        Contatto[] gestore = new Contatto[nMax];

        Scanner keyboard = new Scanner(System.in);

        boolean fine=true;

        do {
            int scelta=menu(operazioni, keyboard);
            switch(scelta) {
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
                    System.out.println("[1] Carca con il numero");
                    System.out.println("[2] Carca con il nuome e cognome");
                    scelta1=keyboard.nextInt();
                    if(scelta1==1){
                        String numero;
                        System.out.println("Inserisci numero");
                        numero=keyboard.nextLine();
                        posContatto=trovaContatto(gestore,numero,null,null,scelta1,contrattiVenduti);
                        System.out.println("il contatto si trova in posizione: "+posContatto);
                    }
                    else if(scelta1==2){
                        String nome,cognome;
                        System.out.println("Inserisci nome");
                        nome=keyboard.nextLine();
                        System.out.println("Inserisci cognome");
                        cognome=keyboard.nextLine();
                        posContatto=trovaContatto(gestore,null,nome,cognome,scelta1,contrattiVenduti);
                        System.out.println("il contatto si trova in posizione: "+posContatto);
                    }
                    break;
                case 4:
                    String numero;
                    System.out.println("Inserisci numero");
                    numero=keyboard.nextLine();
                    gestore=cancellaContatto(gestore,numero,null,null,scelta,contrattiVenduti);
                    contrattiVenduti--;
                    break;
                case 5:
                    String nome,cognome;
                    System.out.println("Inserisci nome");
                    nome=keyboard.nextLine();
                    System.out.println("Inserisci cognome");
                    cognome=keyboard.nextLine();
                    gestore=cancellaContatto(gestore,null,nome,cognome,scelta,contrattiVenduti);
                    contrattiVenduti--;
                    break;
                case 6:
                    gestore=ordinamento(gestore);
                    System.out.println("il vettore è smerdato");
                    break;
                case 7:
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

    private static Contatto[] cancellaContatto(Contatto[] gestore,String numero,String nome,String cognome,int scelta,int contrattiVenduti){

        int check=0;
        if(scelta==4){
            for(int i=0;i<gestore.length-1;i++){
                if(gestore[i].telefono.equalsIgnoreCase(numero)){
                    if(contrattiVenduti<=1){
                        gestore[i]=null;
                        check=1;
                        break;
                    }else{
                        for(int k=i;k<gestore.length-1;k++){
                            gestore[i]=gestore[i+1];
                            check=1;
                        }
                    }
                }
            }
        }else{

            for(int i=0;i<gestore.length-1;i++){
                if(gestore[i].nome.equalsIgnoreCase(nome) && gestore[i].cognome.equalsIgnoreCase(cognome)){
                    if(contrattiVenduti<=1){
                        gestore[i]=null;
                        check=1;
                        break;
                    }else{
                        for(int k=i;k<gestore.length-1;k++){
                            gestore[i]=gestore[i+1];
                            check=1;
                        }
                    }
                }
            }
        }
        if(check==0){
            System.out.println("Non ci sono contatti trovati con queste specificazioni");
        }

        return gestore;

    }

    private static int trovaContatto(Contatto[] gestore,String numero,String nome,String cognome,int scelta,int contrattiVenduti){
        int pos=0;
        int check=0;
        if(scelta==1){
            for(int i=0;i<gestore.length-1;i++){
                if(gestore[i].telefono.equalsIgnoreCase(numero)){
                    if(contrattiVenduti<=1){
                        pos=i;
                        check=1;
                        break;
                    }else{
                        for(int k=i;k<gestore.length-1;k++){
                            gestore[i]=gestore[i+1];
                            check=1;
                        }
                    }
                }
                break;
            }
        }else{

            for(int i=0;i<gestore.length-1;i++){
                if(gestore[i].nome.equalsIgnoreCase(nome) && gestore[i].cognome.equalsIgnoreCase(cognome)){
                    if(contrattiVenduti<=1){
                        pos=i;
                        check=1;
                        break;
                    }else{
                        for(int k=i;k<gestore.length-1;k++){
                            gestore[i]=gestore[i+1];
                            check=1;
                        }
                    }
                }
            }
        }
        if(check==0){
            System.out.println("Non ci sono contatti trovati con queste specificazioni");
        }

        return pos;

    }

    protected static Contatto[] ordinamento(Contatto[] gestore){
        Contatto temp;
        for(int i=0;i<gestore.length-1;i++){
            for(int k=0;k<gestore.length-1;k++){
                if(gestore[i].cognome.charAt(0) < gestore[k].cognome.charAt(0)){
                    temp=gestore[i];
                    gestore[i]=gestore[k];
                    gestore[k]=temp;
                }
                else if(gestore[i].cognome.charAt(0) == gestore[k].cognome.charAt(0)){
                    if(gestore[i].nome.charAt(0) < gestore[k].nome.charAt(0)){
                        temp=gestore[i];
                        gestore[i]=gestore[k];
                        gestore[k]=temp;
                    }
                }
            }
        }

        return gestore;
    }


}
import java.util.Scanner;

public class laghi_3E_Es18_GestioneDataIntero {

    public static void main(String[] args) {

            Scanner giattiFilippo = new Scanner(System.in);
            int data;
            int day,month,year;
            int maxDay=0;
            String charMonth="";
            String[] months = {"GENNAIO","FEBBRAIO","MARZO","APRILE","MAGGIO","GIUGNO","LUGLIO","AGOSTO","SETTEMBRE","OTTOBRE","NOVEMBRE","DICEMBRE"};
            do{
                System.out.println("Inserisci la data");
                data = giattiFilippo.nextInt();

                day = data/1000000;
                month = (data/10000)%100;
                year = data % 10000;
                switch (month){
                    case 1,3,5,7,8,10,12:{
                        maxDay=31;
                        break;
                    }
                    case 4,6,9:{
                        maxDay=30;
                        break;
                    }
                    case 2:{

                        if(year%4==0){
                            maxDay=29;
                        }
                        else {
                            maxDay=28;
                        }
                        break;
                    }
                }

            }while(day<=0||day>maxDay||month<=0||month>12||year<=0||year>9999);


        getMonthInChar(month,months,charMonth);

        System.out.println
                ("giorno:"+day+"\n mese:"+charMonth+"anno:"+year);

    }
    private static String getMonthInChar(int month, String[] months, String charMonth){

        for(int i = 0; i <= months.length; i++) {
            if (i == month) {
                charMonth = months[i];
            }
        }
        return charMonth;
    }

}

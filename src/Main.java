import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int choice;
     Scanner sc = new Scanner(System.in);
        System.out.println("Välkommen! Vänligen välj ett av följande val:\n" + "1. Betala ut lön\n" + "2. Skapa ny faktura\n" + "3. Betala faktura");

        choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Vänligen mata in antal löner att betala:");
                //här matar användaren in antal löner vilket i sin tur bestämmer storleken på arrayen
                int arr_size = 0;
               if (sc.hasNextInt()) {
                   arr_size = sc.nextInt();
               }
               int [] arr = new int[arr_size];
                    System.out.println("Vänligen mata in summa på varje lön(er) att betala");
                    //här matar användaren in summan för antalet löner de angav tidigare
                    for (int i = 0; i < arr_size; i++) {
                        if (sc.hasNextInt()) {
                            arr[i] = sc.nextInt();
                        }
                    }
                System.out.println("Lön(er) att betala efter avdragen skatt är:");
                    for (int i = 0; i < arr_size; i++)
                        if (arr[i] > 0) {

                        //här skapar jag en formel som räknar ut lön(er) att betala efter avdragen skatt (30%)
                            System.out.println(arr[(int) i] * 0.7);
                    }
                break;

                case 2:
                    double accountBalance = 100000;
                    System.out.println("Vänligen mata in den totala summan på ny faktura:");
                    double faktura = sc.nextInt();
                    double netto = faktura * 0.75;
                    double moms = faktura * 0.25;

                    //Sätter en if-sats där om värdet på fakturan är över 0 så räknas momsen (25%) och netto (75%) ut
                    if (faktura > 0.0) {
                        System.out.println("Bruttosumman av nya fakturan är: " + faktura + "\n" + "Momssumman av nya fakturan är: " + moms + "\n" + "Nettosumman av nya fakturan är: " + netto);

                        //Här plussas netto värdet på kontosaldot som jag har i en annan klass (Account_balance). Skapade ett värde för nettosuman tidigare så jag bara behöver skriva netto i min system out print
                        System.out.println("Nytt kontosaldo är: ");
                        System.out.println(accountBalance + netto);
                    }
                    break;

                    case 3:
                        accountBalance = 100000;
                        System.out.println("Vänligen mata in antal fakturor att betala:");
                        //Här använder jag samma metod för användarens array input som i val 1
                        arr_size = 0;
                        if (sc.hasNextInt()) {
                            arr_size = sc.nextInt();
                        }

                        arr = new int[arr_size];
                        System.out.println("Vänligen mata in summan på varje faktura att betala: ");
                        //här matar användaren in summan för antalet fakturor de angav tidigare (samma som i val 1)

                        for (int i = 0; i < arr_size; i++) {
                            if (sc.hasNextInt()) {
                                arr[i] = sc.nextInt();

                            }
                        }

                        for (int i = 0; i < arr_size; i++)
                            if (arr[i] > 0) {

                                // Skapar en double (nettoFaktura)  för att räkna ut summan på angedda fakturor exklusive moms (25%)
                               double nettoFaktura = arr[i] * 0.75;

                                if (nettoFaktura > 100000) {

                                    System.out.println("Kan ej betala fakturor som överskrider kontosaldot!");

                                } else {

                                System.out.println("Nytt kontosaldo efter betald faktura är: ");
                                System.out.println(accountBalance -= nettoFaktura);

                                /*Här hade jag helst velat få nytt kontosaldo att bara visas en gång (alltså kunna
                                    summera alla faktura inputs från användaren (nettoFaktura) som ett tal, men jag
                                    hade problem att hitta info om hur det skulle gå)*/

                            }
        }

    }
    }

}
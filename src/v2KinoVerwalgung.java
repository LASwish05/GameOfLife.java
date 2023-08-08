import java.util.ArrayList;
import java.util.Scanner;

public class v2KinoVerwalgung {
    public static void main(String[] args) {

        int showMovieProgramm;
        int continueShopping;
        String[][] movie = {                                    //erstelle 2 dimensionallen array mit kinoprogram
                {"Filmnr", "Filmname", "Uhrzeit", "Saal", "Plätze"},
                {"1.", "Batman", "20:15", "1", "50"},
                {"2.", "Matrix", "22:00", "3", "5"},
                {"3.", "Matrix 2", "17:00", "2", "0"},
        };
        int[] movieInt = new int[movie.length - 1];          //movie string letzte Spalte bis auf erste Zeile zu movie integer
        for (int i = 0; i < movieInt.length; i++) {
            movieInt[i] = Integer.parseInt(movie[i + 1][4]);
        }

        do {                                                //continueshopping schleife bis ganz unten
            for (int j = 0; j < movieInt.length; j++) {         //hier wird der wert aus movieInt ausgelesen
                if (movieInt[j] == 0) {                         //und je nachergegnis ändert es in string movie auf "ausgebucht" ode "vefügbar"
                    movie[j + 1][4] = "ausgebucht";
                } else {
                    movie[j + 1][4] = "verfügbar";
                }
            }

            ArrayList<Integer> chosenMovies = new ArrayList<Integer>();                     //erstelle Array List chosenMovies, für die sammlung der verkauften filme

            for (int programmX = 0; programmX < movie.length; programmX++) {        //Ausgabe Film Programm
                for (int programmY = 0; programmY < movie[0].length; programmY++) {
                    //System.out.print(movie[programmX][programmY]);
                }
                //System.out.println();
                System.out.printf("%-10s - %-10s - %-8s - %-8s - %-5s\n", movie[programmX]);            //Ausgabe und Formatierung des Film Programms
            }

            int walletBalance;                         //hier wird der geld betrag gespeichert und geprüft ob genug für ein ticket vorhanden ist
            do {
                System.out.println("Wieviel Geld hast du?");
                Scanner sc = new Scanner(System.in);
                walletBalance = sc.nextInt();
                if (walletBalance < 15) {
                    System.out.println("Du hast nicht genug Geld, komm wieder wenn du mehr Geld hast.");
                }
            } while (walletBalance < 15);

            int choice;                                         //Nutzer Filmauswahl
            do {
                System.out.println("Welchen nicht ausgebuchten Film möchtest du sehen? (0 zum abbrechen)");
                Scanner sc = new Scanner(System.in);
                choice = sc.nextInt();
                if (choice == 0) {
                    break;
                } else if (choice > (movie.length - 1)) {
                    System.out.println("Diese Nummer ist nicht für einen Film vergeben.");
                } else if (movieInt[choice - 1] == 0) {
                    System.out.println("Dieser Film ist leider ausgebucht");
                }
            } while (choice > (movie.length - 1) || movieInt[choice - 1] == 0);

            if (choice == 0) {
                System.exit(0);
            }

            int ticketAmount;                                      //wieviele tickets möchte der Nutzer haben
            do {
                System.out.println("Es sind " + movieInt[choice - 1] + " Tickets um jeweils 15 € verfügbar. Wieviel möchtest du kaufen?");
                Scanner sc = new Scanner(System.in);
                ticketAmount = sc.nextInt();
                if (ticketAmount > (movieInt[choice - 1])) {
                    System.out.println("So viele Tickets sind leider nicht mehr verfügbar.");
                } else if (ticketAmount * 15 > walletBalance) {
                    System.out.println("Du hast nicht genug Geld, wähle weniger Tickets.");
                }
            } while (ticketAmount * 15 > walletBalance || ticketAmount > (movieInt[choice - 1]));

            walletBalance = (walletBalance - ticketAmount * 15);
            System.out.println("Du kaufst " + ticketAmount + " Tickets um " + ticketAmount * 15 + " €, und hast jetzt noch " + walletBalance + " €.");
            movieInt[choice - 1] = movieInt[choice - 1] - ticketAmount;
            for (int x = 0; x < ticketAmount; x++) {               //x ist hier der Vergleichswert den ich für meine Schleife brauche
                chosenMovies.add(choice);                           //diesen befehl so oft wie ticketamount ausführen
            }

            for (int i = 0; i < movieInt.length; i++) {                // i und j Hielfe für die Schleife: es wird die letzte Spalte außer die erste Zeile geändert
                if (i == movieInt.length - 2 && i > 0) {
                    movie[i + 1][4] = String.valueOf(movieInt[i]);
                }
            }

            System.out.println("Auflistung der verkauften Tickets " + chosenMovies);

            System.out.println("Möchtest du noch weitere Filme kaufen?(1 für eine weitere Wahl 0 zum abrechen)");
            Scanner sc = new Scanner(System.in);
            continueShopping = sc.nextInt();
        } while (continueShopping != 0);
    }
}

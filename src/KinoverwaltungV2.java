import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class KinoverwaltungV2 {
    public static void main(String[] args) {

        int showMovieProgramm;
        int continueShopping;
        int walletBalance;

        String[][] movie = {                                                     //erstelle 2 dimensionallen array mit kinoprogram
                {"Filmnr", "Filmname", "Uhrzeit", "Saal", "Plätze"},
                {"1.", "Batman", "20:15", "1", "50"},
                {"2.", "Matrix", "22:00", "3", "5"},
                {"3.", "Matrix 2", "17:00", "2", "0"},
        };
        int[] movieInt = new int[movie.length - 1];                              //movie string letzte Spalte bis auf erste Zeile zu movie integer
        for (int i = 0; i < movieInt.length; i++) {
            movieInt[i] = Integer.parseInt(movie[i + 1][4]);
        }
        ArrayList<Integer> chosenMovies = new ArrayList<Integer>();               //erstelle Array List chosenMovies, für die sammlung der verkauften filme

        String[][] snacks = {                                                      //erstelle 2 dimensionallen array mit snacks
                {"Nr.", "Snack", "Preis", "Auf Lager?"},
                {"1.", "Popcorn", "1", "50"},
                {"2.", "Chips", "2", "0"},
                {"3.", "Schokolade", "3", "5"},
        };
        int[] snacksStockInt = new int[snacks.length - 1];                        //snacksStock string Auf Lager? Spalte bis auf erste Zeile zu snacksStock integer
        for (int i = 0; i < snacksStockInt.length; i++) {
            snacksStockInt[i] = Integer.parseInt(snacks[i + 1][3]);
        }
        int[] snacksPriceInt = new int[snacks.length - 1];                          //snacksStock string Preis Spalte bis auf erste Zeile zu snacksStock integer
        for (int i = 0; i < snacksPriceInt.length; i++) {
            snacksPriceInt[i] = Integer.parseInt(snacks[i + 1][2]);
        }
        ArrayList<Integer> chosenSnacks = new ArrayList<Integer>();                 //erstelle Array List chosenSnacks, für die sammlung der gekauften snacks

        do {
            System.out.println("Wieviel Geld hast du?");                            //hier wird der geld betrag gespeichert und geprüft ob genug für ein ticket vorhanden ist
            Scanner sc = new Scanner(System.in);
            walletBalance = sc.nextInt();
            if (walletBalance == 0) {
                System.out.println("Mit 0 € kannst du leider nichts kaufen, komm mit mehr Geld wieder.");
            }
        } while (walletBalance == 0);


        int exitMainMenu = 0;                                        //MAINMENU
        do {                                                         //beginn schleife main menu
            System.out.println("Was möchtest du als nächstes tun? (Du hast noch " + walletBalance + "€)");
            System.out.println("1. Ticket kaufen");
            System.out.println("2. Snacks kaufen");
            System.out.println("3. Film ansehen");
            System.out.println("4. Snacks essen");
            System.out.println("5. Beim Gewinnspiel mitmachen (kostet 5 €)");
            System.out.println("6. Kino verlassen");
            Scanner scmenu = new Scanner(System.in);
            exitMainMenu = scmenu.nextInt();
            if (exitMainMenu == 0 || exitMainMenu > 6) {
                System.out.println("Diese Nummer ist nicht vergeben.");
            } else if (exitMainMenu == 6) {                                              //BEENDEN
                System.out.println("Du verlässt das Kino. Auf wiedersehen.");
                break;
            } else if (exitMainMenu == 1) {                                               //TICKET KAUFEN öffnet if für buy movie
                int choiceMovie;
                boolean exitBuyMovie = false;
                while (!exitBuyMovie) {                                                  //Hauptschleife buy movie bis exit oder ganz unten
                    for (int j = 0; j < movieInt.length; j++) {                          //hier wird der wert aus movieInt ausgelesen
                        if (movieInt[j] == 0) {                                          //und je nach ergegnis ändert es in string movie auf "ausgebucht" ode "vefügbar"
                            movie[j + 1][4] = "ausgebucht";
                        } else {
                            movie[j + 1][4] = "verfügbar";
                        }
                    }
                    for (int programmX = 0; programmX < movie.length; programmX++) {                //Filmprogramm auslesen
                        for (int programmY = 0; programmY < movie[0].length; programmY++) {
                        }
                        System.out.printf("%-10s - %-10s - %-8s - %-8s - %-5s\n", movie[programmX]);    //Ausgabe und Formatierung des Film Programms
                    }
                    do {
                        System.out.println("Welchen nicht ausgebuchten Film möchtest du sehen? (0 zum abbrechen)");         //Filmauswahl
                        Scanner sc = new Scanner(System.in);
                        choiceMovie = sc.nextInt();
                        if (choiceMovie == 0) {
                            break;
                        } else if (choiceMovie > (movie.length - 1)) {
                            System.out.println("Diese Nummer ist nicht für einen Film vergeben.");
                        } else if (movieInt[choiceMovie - 1] == 0) {
                            System.out.println("Dieser Film ist leider ausgebucht");
                        }
                    } while (choiceMovie > (movie.length - 1) || movieInt[choiceMovie - 1] == 0);
                    if (choiceMovie == 0) {
                        exitBuyMovie = true;
                        break;
                    }

                    int ticketAmount;
                    do
                    {                                                                                //wieviele tickets möchte der Nutzer haben
                        System.out.println("Es sind " + movieInt[choiceMovie - 1] + " Tickets um jeweils 15 € verfügbar. Wieviel möchtest du kaufen?");
                        Scanner sc = new Scanner(System.in);
                        ticketAmount = sc.nextInt();
                        if (ticketAmount > (movieInt[choiceMovie - 1])) {
                            System.out.println("So viele Tickets sind leider nicht mehr verfügbar.");
                        } else if (ticketAmount * 15 > walletBalance) {
                            System.out.println("Du hast nicht genug Geld, wähle weniger Tickets.");
                        }
                    } while (ticketAmount * 15 > walletBalance || ticketAmount > (movieInt[choiceMovie - 1]));

                    walletBalance = (walletBalance - ticketAmount * 15);
                    System.out.println("Du kaufst " + ticketAmount + " Tickets um " + ticketAmount * 15 + " €, und hast jetzt noch " + walletBalance + " €.");
                    movieInt[choiceMovie - 1] = movieInt[choiceMovie - 1] - ticketAmount;
                    for (int x = 0; x < ticketAmount; x++) {                                       //x ist hier der Vergleichswert den ich für meine Schleife brauche
                        chosenMovies.add(choiceMovie);                                            //diesen befehl so oft wie ticketamount ausführen
                    }

                    for (int i = 0; i < movieInt.length; i++) {                                   // i und j Hielfe für die Schleife: es wird die letzte Spalte außer die erste Zeile geändert
                        if (i == movieInt.length - 2 && i > 0) {
                            movie[i + 1][4] = String.valueOf(movieInt[i]);
                        }
                    }

                    System.out.println("Auflistung der verkauften Tickets " + chosenMovies);        //Ausgabe ist eine Kontrolle für mich
                    do {
                        System.out.println("Möchtest du noch weitere Filme kaufen?(1 für eine weitere Wahl 0 zum abrechen)");     //weitere Einkäufe
                        Scanner sc = new Scanner(System.in);
                        continueShopping = sc.nextInt();
                        if (continueShopping == 0) {
                            exitBuyMovie = true;
                        } else if (continueShopping > 1) {
                            System.out.println("Diese Auswahl ist nicht vergeben!");
                        }
                    } while (continueShopping > 1);
                }                                                                                       // Ende schleife buy movie


            } else if (exitMainMenu == 2) {                                          //SNACKS KAUFEN, ende buy movie öffnet if für buy snacks
                int choiceSnacks;
                boolean exitBuySnacks = false;
                while (!exitBuySnacks) {                                             //Hauptschleife buy snacks bis exit
                    for (int j = 0; j < snacksStockInt.length; j++) {                //hier wird der wert aus movieInt ausgelesen
                        if (snacksStockInt[j] == 0) {                               //und je nachergegnis ändert es in string movie auf "ausgebucht" ode "vefügbar"
                            snacks[j + 1][3] = "ausverkauft";
                        } else {
                            snacks[j + 1][3] = "verfügbar";
                        }
                    }
                    for (int snacksX = 0; snacksX < snacks.length; snacksX++) {                //Snacksprogramm auslesen
                        for (int snacksY = 0; snacksY < snacks[0].length; snacksY++) {
                        }
                        System.out.printf("%-10s - %-10s - %-8s - %-8s\n", snacks[snacksX]);    //Ausgabe und Formatierung des Film Programms
                    }
                    do {
                        System.out.println("Welchen nicht ausverkauften Snack möchtest du kaufen? (0 zum abbrechen)");      //snack auswählen
                        Scanner sc = new Scanner(System.in);
                        choiceSnacks = sc.nextInt();
                        if (choiceSnacks == 0) {
                            break;
                        } else if (choiceSnacks > (snacks.length - 1)) {
                            System.out.println("Diese Nummer ist nicht für einen Snack vergeben.");
                        } else if (snacksStockInt[choiceSnacks - 1] == 0) {
                            System.out.println("Dieser Snack ist leider ausverkauft");
                        }
                    } while (choiceSnacks > (snacks.length - 1) || snacksStockInt[choiceSnacks - 1] == 0);
                    if (choiceSnacks == 0) {
                        exitBuySnacks = true;
                        break;
                    }

                    int snacksAmount;                                                             //wieviele snacks möchte der Nutzer haben
                    do {
                        System.out.println("Es sind " + snacksStockInt[choiceSnacks - 1] + " x " + (snacks[choiceSnacks][1]) + " um jeweils " + snacks[3][choiceSnacks - 1] + " € verfügbar. Wieviel möchtest du kaufen?(0 zum abbrechen)"); //Preis
                        Scanner sc = new Scanner(System.in);
                        snacksAmount = sc.nextInt();
                        if (snacksAmount == 0) {
                            exitBuySnacks = true;
                            break;
                        } else if (walletBalance < snacksAmount * snacksPriceInt[choiceSnacks - 1]) {        //hier wird der kontostand kontrolliert
                            System.out.println("Du hast nicht genug Geld, wähle weniger " + snacks[choiceSnacks][1] + ".");
                        } else if (snacksAmount > (snacksStockInt[choiceSnacks - 1])) {
                            System.out.println("So viel " + snacks[choiceSnacks][1] + " ist leider nicht mehr verfügbar.");
                        }
                    } while (walletBalance < snacksAmount * snacksPriceInt[choiceSnacks - 1] || snacksAmount > snacksStockInt[choiceSnacks - 1]);

                    walletBalance = (walletBalance - snacksAmount * snacksPriceInt[choiceSnacks - 1]);
                    System.out.println("Du kaufst " + snacksAmount + " x " + snacks[choiceSnacks][1] + " um " + snacksAmount * snacksPriceInt[choiceSnacks - 1] + " €, und hast jetzt noch " + walletBalance + " €.");
                    snacksStockInt[choiceSnacks - 1] = snacksStockInt[choiceSnacks - 1] - snacksAmount;
                    for (int x = 0; x < snacksAmount; x++) {                                            //x ist hier der Vergleichswert den ich für meine Schleife brauche
                        chosenSnacks.add(choiceSnacks);                                                 //gekauften Snacks werden gespeichert
                    }
                    System.out.println(chosenSnacks);
                    for (int i = 0; i < snacksStockInt.length; i++) {                                   // i und j Hielfe für die Schleife: es wird die letzte Spalte außer die erste Zeile geändert
                        if (i == snacksStockInt.length - 2 && i > 0) {
                            snacks[i + 1][3] = String.valueOf(snacksStockInt[i]);
                        }
                    }
                }
            } else if (exitMainMenu == 3) {                                                  //FILM ANSEHEN, ende buy snacks beginn Film ansehen
                boolean exitWatchMovie = false;
                while (!exitWatchMovie) {
                    System.out.println("Welchen Film (für den du ein Ticket hast) möchtest du sehen?(0 für abbrechen");
                    for (int i = 0; i < movie.length; i++) {
                        if (chosenMovies.contains(i)) {
                            System.out.println(movie[i][0] + "  " + movie[i][1]);
                            System.out.println(chosenMovies);
                        }
                    }
                    Scanner sc = new Scanner(System.in);
                    int movieToWatch = sc.nextInt();

                    if (movieToWatch == 0) {
                        exitWatchMovie = true;
                        break;
                    } else if (!chosenMovies.contains(movieToWatch)) {                        //ich brauche wahrscheinlich die anzahl an filmen anstatt size bei nutzereingabe zu hoch funktioniert das noch nicht richtig.
                        System.out.println("Du hast kein Ticket für diesen Film.");
                    } else {
                        System.out.println("Du schaust dir den Film " + movie[movieToWatch][1] + " an. Viel Spaß");
                        chosenMovies.remove(Integer.valueOf(movieToWatch));               //hier ziehe ich von der array Liste über die gekauften Filme wieder ab
                        System.out.println(chosenMovies);
                        exitWatchMovie = true;
                    }
                }
            } else if (exitMainMenu == 4) {                                              //SNACKS ESSEN,ende film ansehen beginn snacks essen
                boolean exitEatSnacks = false;
                while (!exitEatSnacks) {
                    System.out.println("Welchen deiner Snacks willst du essen? (0 zum abbrechen)");
                    for (int i = 0; i < snacks.length; i++) {
                        if (chosenSnacks.contains(i)) {                                   //Ausgabe verfügbare Snacks
                            System.out.println(snacks[i][0] + "  " + snacks[i][1]);
                            System.out.println(chosenSnacks);
                        }
                    }
                    Scanner sc = new Scanner(System.in);
                    int snackToEat = sc.nextInt();

                    if (snackToEat == 0) {
                        exitEatSnacks = true;
                        break;
                    } else if (!chosenSnacks.contains(snackToEat)) {                           //hier mit size probiert
                        System.out.println("Du hast keinen Snack mit dieser Nummer.");
                    } else {
                        System.out.println("Du verspeist " + snacks[snackToEat][1] + ".");
                        chosenSnacks.remove(Integer.valueOf(snackToEat));                     //verspeisten Snack abziehen
                        System.out.println(chosenSnacks);
                        exitEatSnacks = true;
                    }
                }
            } else if (exitMainMenu == 5) {                                                  //GEWINNSPIEL, snacks essen ende beginn gewinnspiel
                int ticketprice = 5;
                int ticketWin = 25;
                boolean exitlottery = false;
                while (!exitlottery) {
                    System.out.println("Möchtest du beim Gewinnspiel mitmachen?(drücke 1 um ein Ticket für " + ticketprice + " € zu kaufen, 0 zum abbrechen)");
                    Scanner sc = new Scanner(System.in);
                    int ticketBuy = sc.nextInt();
                    if (ticketBuy == 0) {
                        exitlottery = true;
                        break;
                    } else if (ticketBuy == 1) {
                        if (walletBalance < 5) {
                            System.out.println("Du hast leider nicht genug Geld.");
                            exitlottery = true;
                            break;
                        }

                        else {
                            Random r = new Random();                                                    //Gewinnzahl wird ermittelt
                            int luckyNumber = r.nextInt(201);
                            System.out.println("Du machst beim Gewinnspiel mit!");
                            System.out.println("Deine Glückszahl lautet: " + luckyNumber);
                            ArrayList<Integer> winningNumbes = new ArrayList<>();
                            int a = 1;                                                                  //fibonacci berechnung
                            int b = 1;
                            int c;

                            for (int d = 1; d <= 10; d++) {

                                c = a + b;
                                winningNumbes.add(c);
                                a = b;
                                b = c;

                            }
                            System.out.println(winningNumbes);
                            if (winningNumbes.contains(luckyNumber) || luckyNumber % 10 == 0) {
                                System.out.println(luckyNumber + " ist eine Fibonacci-Nummer oder durch 10 Teilbar! Du gewinnst " + (ticketWin - ticketprice) + " €!");
                                walletBalance = walletBalance + ticketWin - ticketprice;
                                System.out.println("Dein neuer Kontostand ist: " + walletBalance + " €.");
                            } else {
                                System.out.println(luckyNumber + " ist KEINE Fibonacci-Nummer und nicht durch 10 teilbar! Leider nicht gewonnen.");
                                walletBalance = walletBalance - ticketprice;
                                System.out.println("Dein neuer Kontostand ist: " + walletBalance + " €.");
                            }
                        }
                    } else {
                        System.out.println("Falsche Eingabe!");
                    }
                }
            }
        } while (exitMainMenu != 6);                                       // Ende schleife main menu
    }
}



import java.util.ArrayList;
import java.util.Scanner;

        public class KinoVerwaltungV1 {
            public static void main(String[] args) {
                int continueShopping;
                String[][] movie = {
                        {"Filmnr", "Filmname", "Uhrzeit", "Saal", "Plätze"},
                        {"1.", "Batman", "20:15", "1", "50"},
                        {"2.", "Matrix", "22:00", "3", "5"},
                        {"3.", "Matrix 2", "17:00", "2", "0"},
                };


                ArrayList<Integer> chosenMovies = new ArrayList<Integer>();

                for (int programmX = 0; programmX < movie.length; programmX++) {        //Ausgabe Film Programm
                    for (int programmY = 0; programmY < movie[0].length; programmY++) {
                        //System.out.print(movie[programmX][programmY]);
                    }
                    //System.out.println();
                    System.out.printf("%-10s - %-10s - %-8s - %-8s - %-5s\n", movie[programmX]);            //Ausgabe und Formatierung des Film Programms
                }

                int[][] movieInt = new int[movie.length][movie[0].length];          //movie string letzte Spalte bis auf erste Zeile zu movie integer
                for (int i = 0; i < movie.length; i++) {
                    for (int j = 0; j < movie[0].length; j++) {
                        if (j == movie[0].length - 1 && i > 0) {
                            movieInt[i][j] = Integer.parseInt(movie[i][j]);
                        }
                    }
                }

                int walletBalance;                         //abfrage nach verfügbaren Geld
                do {
                    System.out.println("Wieviel Geld hast du?");
                    Scanner sc = new Scanner(System.in);
                    walletBalance = sc.nextInt();
                    if (walletBalance < 15) {
                        System.out.println("Du hast nicht genug Geld, komm wieder wenn du mehr Geld hast.");
                    }
                } while (walletBalance < 15);
                do {                                                    //schleife das der Nutzer weitere Einkäufe mit dem Restgeld (und den neuen Werten bei verfügbaren Tickets) tätigen kann
                    int choice;                                         //Nutzer Filmauswahl
                    do {
                        System.out.println("Welchen nicht ausgebuchten Film möchtest du sehen? (0 zum abbrechen)");
                        Scanner sc = new Scanner(System.in);
                        choice = sc.nextInt();
                        if (choice == 0) {
                            break;
                        } else if (choice > (movie.length - 1)) {
                            System.out.println("Diese Nummer ist nicht für einen Film vergeben.");
                        } else if (movieInt[choice][4] == 0) {
                            System.out.println("Dieser Film ist leider ausgebucht");
                        }
                    } while (choice > (movie.length - 1) || movieInt[choice][4] == 0);

                    if (choice == 0) {
                        System.exit(0);
                    }

                    int ticketAmount;                                      //wieviele tickets möchte der Nutzer haben
                    do {
                        System.out.println("Es sind " + movieInt[choice][4] + " Tickets um jeweils 15 € verfügbar. Wieviel möchtest du kaufen?");
                        Scanner sc = new Scanner(System.in);
                        ticketAmount = sc.nextInt();
                        if (ticketAmount > (movieInt[choice][4])) {
                            System.out.println("So viele Tickets sind leider nicht mehr verfügbar.");
                        } else if (ticketAmount * 15 > walletBalance) {
                            System.out.println("Du hast nicht genug Geld, wähle weniger Tickets.");
                        }
                    } while (ticketAmount * 15 > walletBalance || ticketAmount > (movieInt[choice][4]));

                    walletBalance = (walletBalance - ticketAmount * 15);
                    System.out.println("Du kaufst " + ticketAmount + " Tickets um " + ticketAmount * 15 + " €, und hast jetzt noch " + walletBalance + " €.");
                    movieInt[choice][4] = movieInt[choice][4] - ticketAmount;
                    for (int x = 0; x < ticketAmount; x++) {               //x ist hier der Vergleichswert den ich für meine Schleife brauche
                        chosenMovies.add(choice);                           //diesen befehl so oft wie ticketamount ausführen
                    }

                    for (int i = 0; i < movieInt.length; i++) {                // i und j Hielfe für die Schleife: es wird die letzte Spalte außer die erste Zeile geändert
                        for (int j = 0; j < movieInt[0].length; j++) {
                            if (j == movieInt[0].length - 1 && i > 0) {
                                movie[i][j] = String.valueOf(movieInt[i][j]);
                            }
                        }
                    }
                    for (int programmX = 0; programmX < movie.length; programmX++) {        //Ausgabe Film Programm
                        for (int programmY = 0; programmY < movie[0].length; programmY++) {
                        }
                        System.out.printf("%-10s - %-10s - %-8s - %-8s - %-5s\n", movie[programmX]);

                    }
                    System.out.println("Auflistung der verkauften Tickets " + chosenMovies);

                    System.out.println("Möchtest du noch weitere Filme kaufen?(1 für eine weitere Wahl 0 zum abrechen)");
                    Scanner sc = new Scanner(System.in);
                    continueShopping = sc.nextInt();
                } while (continueShopping != 0);                    //continueShopping muss for der do-while Schleife angelegt werden, damit es hier vom Program erkannt wird
            }
        }
import java.util.Random;
import java.util.Scanner;

public class MuenzeWerfenV3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rounds;
        do {
            System.out.println("Wie oft soll die Münze geworfen werden (ungerade Zahl 1-10)");
            rounds = sc.nextInt();
        } while (rounds < 1 || rounds > 10 || rounds%2 == 0);
        //(b == 2 || b == 4 || b == 6 || b == 8 || b == 10 || b > 10 || b < 1);

        int Kopf = 0;
        int Zahl = 0;

        for (int played = 1; played <= rounds; played++ ) {

            Random r = new Random();
            boolean kopf = r.nextBoolean();

            if (kopf == true) {
                System.out.println("Werfe Münze...Kopf");
                Kopf++;
            }
            else if (kopf == false) {
                System.out.println("Werfe Münze...Zahl");
                Zahl++;
            }
        }

        System.out.println("Summe Kopf " + Kopf);
        System.out.println("Summe Zahl " + Zahl);

        if (Kopf > Zahl) {
            System.out.println("Kopf gewinnt!");
        }
        else if (Kopf == Zahl) {
            System.out.println("unentschieden");
        }
        else
            System.out.println("Zahl gewinnt!");
    }

    }

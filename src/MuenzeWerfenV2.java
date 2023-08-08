import java.util.Random;
import java.util.Scanner;

public class MuenzeWerfenV2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Wie viele Runden wollt ihr spielen");
        int rounds = sc.nextInt();

        int Kopf = 0;
        int Zahl = 0;

        for (int played = 1; played <= rounds; played++) {
            Random r = new Random();
            boolean kopf = r.nextBoolean();
            if (kopf == true) {
                System.out.println("Werfe Münze...Kopf");
                Kopf++;
            } else if (kopf == false) {
                System.out.println("Werfe Münze...Zahl");
                Zahl++;
            }
        }
        System.out.println("Summe Kopf " + Kopf);
        System.out.println("Summe Zahl " + Zahl);

        if (Kopf > Zahl) {
            System.out.println("Kopf gewinnt!");
        } else if (Kopf == Zahl) {
            System.out.println("unentschieden");
        } else
            System.out.println("Zahl gewinnt!");
    }
}

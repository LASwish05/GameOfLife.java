import java.util.Scanner;

public class ZuweisungsUndLogischeOperatoren {
    public static void main(String[] args) {
        int luckyNumber = 7;
        Scanner sc = new Scanner(System.in);
        System.out.println("Gib eine Zahl ein.");
        int chosenNumber = sc.nextInt();
        System.out.println("Die gewählte Zahl ist " + chosenNumber);

        if (chosenNumber%10 == 0) {
            System.out.println("Es handelt sich um eine Runde Zahl.");
        }
        if (chosenNumber%2 == 0) {
            System.out.println("Es handelt sich um eine gerade Zahl.");
        }
        if (chosenNumber == luckyNumber) {
            System.out.println("Es handelt sich um deine Glückszahl.");
        }
        String chosenNumber2 = String.valueOf(chosenNumber);
        if (chosenNumber2.length() == 2) {
            System.out.println("Die Zahl ist zweistellig.");
        }
        sc.nextLine();

//Arbeit oder Freizeit
        System.out.println("Gib eine Uhrzeit ein.(hh:mm)");
        String inputHour = sc.nextLine();
        String hoursMinutesDivided [] = inputHour.split(":");
        System.out.println(hoursMinutesDivided[0]);
        System.out.println(hoursMinutesDivided[1]);
        int hour = Integer.parseInt(hoursMinutesDivided[0]);
        int minutes = Integer.parseInt(hoursMinutesDivided[1]);
        int time = 60 * hour + minutes;
        System.out.println(time);

        if (time <= 510 || time >= 930) {
            System.out.println("Die Zeit liegt nicht in deiner Arbeitszeit.");
        } else if (time >= 720 && time <= 750) {
            System.out.println("Die Zeit liegt in deiner Mittagspause.");
        } else {
            System.out.println("Die Zeit liegt in deiner Arbeitszeit.");
        }


//Noten übersetzten
        System.out.println("Gib deine Note ein.");
        int grade = sc.nextInt();
        if (grade == 1) {
            System.out.println("Sehr gut.");
        } else if (grade == 2) {
            System.out.println("Gut.");
        } else if (grade == 3) {
            System.out.println("Befriedigend.");
        } else if (grade == 4) {
            System.out.println("Genügend.");
        } else if (grade == 5) {
            System.out.println("Nicht genügend.");
        }

    }
}

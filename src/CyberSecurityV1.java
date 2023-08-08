import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class CyberSecurityV1 {
    public static void main(String[] args) {
        char[] possibleSigns = {'A', 'B', 'C', 'a', 'b', 'c', '0', '1', '2', '!'};      //diese Zeichen stehen für das PW zur verfügung
        ArrayList<String> possibilities = new ArrayList<>();                            //hier werden alle möglichkeiten gespeichert
        ArrayList<Integer> resultTrys = new ArrayList<>();                              //hier werden die Ergebnisse (wie oft probiert wurde bis PW eraten wurde) gespeichert


        int highestNumberTrys;
        int lowestNumberTrys;
        int averageTrys;
        int sumOfAllTrys = 0;
        int howManyRounds = 10;                                                         //hier können die gewünschten runden eingegeben werden

        for (int first = 0; first < possibleSigns.length; first++) {                //alle möglichkeiten erzeugen und speichern
            for (int second = 0; second < possibleSigns.length; second++) {
                for (int third = 0; third < possibleSigns.length; third++) {
                    for (int fourth = 0; fourth < possibleSigns.length; fourth++) {
                        String password = " " + possibleSigns[first] + possibleSigns[second] + possibleSigns[third] + possibleSigns[fourth];
                        possibilities.add(password);
                    }
                }
            }
        }
        //System.out.println(possibilities);                                    //wenn aktiviert gibt es alle möglichkeiten aus
        for (int rounds = 0; rounds < howManyRounds; rounds++) {                //Runde fängt an
            Random r = new Random();
            String randomPassword = possibilities.get(r.nextInt(possibilities.size()));         //Hier wird ein zufälliges PW aus der Liste gewählt
            System.out.println("Zufälliges Passwort " + randomPassword);

            String passwordguess = "";

            while (!passwordguess.equals(randomPassword)) {                                         //PW suche
                int counterTrys = 0;                                                             //hier werden die Versuche mitgezählt
                for (int first = 0; first < possibleSigns.length; first++) {
                    for (int second = 0; second < possibleSigns.length; second++) {
                        for (int third = 0; third < possibleSigns.length; third++) {
                            for (int fourth = 0; fourth < possibleSigns.length; fourth++) {
                                passwordguess = " " + possibleSigns[first] + possibleSigns[second] + possibleSigns[third] + possibleSigns[fourth];
                                counterTrys++;
                                if (passwordguess.equals(randomPassword)) {
                                    System.out.println("Das Passwort " + passwordguess + " wurde in " + counterTrys + " Versuchen gefunden.");
                                    resultTrys.add(counterTrys);
                                    break;
                                }
                            }
                            if (passwordguess.equals(randomPassword)) {
                                break;
                            }
                        }
                        if (passwordguess.equals(randomPassword)) {
                            break;
                        }
                    }
                    if (passwordguess.equals(randomPassword)) {
                        break;
                    }
                }
                if (passwordguess.equals(randomPassword)) {
                    break;
                }
            }
            //System.out.println(resultTrys);                   //hier könnte man akrivieren um gleich die Liste mit den benötigten versuchen anzuzeigen
        }
        for (int i = 0; i < resultTrys.size(); i++) {                   //addition aller ergebnisse wie viele versuche gebraucht wurden
            sumOfAllTrys += resultTrys.get(i);
        }
        highestNumberTrys = Collections.max(resultTrys);
        lowestNumberTrys = Collections.min(resultTrys);
        averageTrys = sumOfAllTrys/howManyRounds;
        System.out.println("Highest " + highestNumberTrys + " Lowest " + lowestNumberTrys + " Avarage " + averageTrys);
    }
}


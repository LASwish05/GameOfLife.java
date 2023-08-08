import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RPGV1 {
    public static void main(String[] args) {
        String[][] choices = {                                              //Array für die Spielmöglichkeiten
                // parentID, ID, choiceTxt,            resultTxt,              moveToID
                {"-1", "0", "", "Du stehst in einer Bar."},

                {"0", "1", "Geh in die Wildnis.", "Du bist in der Wildnis angekommen."},
                {"0", "2", "Trink ein Getränk", "Du lässt dir ein Getränk schmecken.", "0"},

                {"1", "3", "Kämpf gegen das Monster.", "Das Monster ist ein harter Gegner, aber du besiegst es.", "1"},
                {"1", "4", "Lauf vor dem Monster davon", "Du läufst wie ein Feigling zurück zur Bar.", "0"},
        };
        int currentChoice = 0;              //Startpunkt
        while (true) {
            ArrayList<Integer> possibleChoices = new ArrayList<>();
            //possibleChoices.clear();
            for (int i = 0; i < choices.length; i++) {                          //fori wird benutz um die Möglichkeiten am aktuellen punkt zu bekommen
                if (Integer.parseInt(choices[i][0]) == currentChoice) {
                    possibleChoices.add(Integer.parseInt(choices[i][1]));//und hier die Möglichkeiten in der ArrayList als integer zu speichern
                }
            }
            System.out.println(choices[currentChoice][3]);                      //Ausgabe resultTxt
            System.out.println("-------------------------------");
            for (int i = 0; i < possibleChoices.size(); i++) {                  //ArrayList durchsuchen
                int choiceID = possibleChoices.get(i);
                System.out.println(choices[choiceID][1] + ".)" + choices[choiceID][2]);      //Ausgabe choiceTxt
            }
            System.out.println("-------------------------------");
            System.out.println("Was willst du als nächstes tun?");

            Scanner sc = new Scanner(System.in);
            int playerChoice;
            try {
                playerChoice = sc.nextInt();                        //Nutzer gibt ein was er als nächstes machen will
                if (playerChoice == -1) {
                    System.out.println("Spiel beendet.");
                    break;
                }
                if (!possibleChoices.contains(playerChoice)) {
                    throw new InputMismatchException("Falsche Eingabe, was willst du als nächstes tun?");
                }
                int chosenOptionID = playerChoice;
                if (choices[chosenOptionID].length == 5 && !choices[chosenOptionID][4].isEmpty()) {  //prüft of länge 5 und 5[4] Spalte NICHT lehr ist
                    System.out.println(choices[chosenOptionID][3]);                                  //Ausgabe resultTxt
                    currentChoice = Integer.parseInt(choices[chosenOptionID][4]);                    //5[4] Spalte wird als Ganzzahl umgewandelt und als currentChoice gespeichert
                } else {
                    if (choices[chosenOptionID].length == 5) {                  // 5. Eintrag ist leer, nichts ausgeben
                    } else {
                        System.out.println(choices[chosenOptionID][2]);             //sonst 3[2] Spalte ausgeben
                    }
                    currentChoice = chosenOptionID;                                 //chosenOptionId auf currentChoice speichern
                }
            } catch (InputMismatchException e) {
                System.out.println("Falsche Eingabe, was willst du als nächstes tun?");
                sc.nextLine();
                continue;
            }
        }
    }
}

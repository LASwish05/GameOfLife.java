import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DatenstrukturenWörterbuch {
    public static void main(String[] args) {

        Map<String, String> gerToEng = new HashMap<>();
        Map<String, String> engToGer = new HashMap<>();

        /*addWordPairGerToEng(gerToEng, "Apfel", "apple");
        System.out.println(gerToEng);
        System.out.println();*/

        addWordPair(gerToEng, engToGer, "Apfel", "apple");
        addWordPair(gerToEng, engToGer, "Haus", "house");
        addWordPair(gerToEng, engToGer, "Auto", "car");
        addWordPair(gerToEng, engToGer, "Licht", "light");
        addWordPair(gerToEng, engToGer, "Blatt", "paper");

        /*
        1) Hinzufügen
        2) Löschen
        3) Suchen

        1) -> 1) / 2) Deutsch - Englisch / Englisch -Deutsch

        2) -> 1) / 2) wood , existiert nicht

        3) wood . holz,  holz -> wood , existiert nicht



         */

        //System.out.println(gerToEng);
        //System.out.println(engToGer);
        //System.out.println();

        // TODO nur ein wort als eingabe beim entfernen
        /*removeWordPair(gerToEng, engToGer, "Haus", "house");
        System.out.println(gerToEng);
        System.out.println(engToGer);*/

        //removeWordPair(gerToEng, engToGer, "Haus");
        //System.out.println(gerToEng);
        //System.out.println(engToGer);

        while (true) {
            System.out.println("Um ein Wort hinzuzufügen drücke 1, um ein Wort zu entfernen drücke 2, um ein Wort zu übersetzten drücke 3. Zum beenden drücke eine andere Zahl.");
            Scanner sc = new Scanner(System.in);
            int choiceToDo = sc.nextInt();
            sc.nextLine();
            if (choiceToDo == 1){
                System.out.println("Drücke 1 für Übersetzungpaar hinzufügen von deutsch auf englisch, drücke 2 für Übersetzungpaar hinzufügen von englisch auf deutsch. Andere Nummer zum beenden.");
                Scanner sc2 = new Scanner(System.in);
                int choiceAddWhichWay = sc2.nextInt();
                sc2.nextLine();
                if (choiceAddWhichWay == 1){
                    System.out.println("Gib das deutsche Wort ein.");
                    Scanner sc3 = new Scanner(System.in);
                    String addWordGerman = sc3.nextLine();
                    //sc3.nextLine();
                    System.out.println("Gib das englische Wort ein.");
                    Scanner sc4 = new Scanner(System.in);
                    String addWordEnglish = sc4.nextLine();
                    //sc4.nextLine();
                    addWordPair(gerToEng, engToGer, addWordGerman, addWordEnglish);
                } else if (choiceAddWhichWay == 2) {
                    System.out.println("Gib das englische Wort ein.");
                    Scanner sc3 = new Scanner(System.in);
                    String addWordEnglish = sc3.nextLine();
                    //sc3.nextLine();
                    System.out.println("Gib das deutsche Wort ein.");
                    Scanner sc4 = new Scanner(System.in);
                    String addWordGerman = sc4.nextLine();
                    //sc4.nextLine();
                    addWordPair(gerToEng, engToGer, addWordGerman, addWordEnglish);
                } else {
                    break;
                }
                System.out.println(gerToEng);
                System.out.println(engToGer);
                System.out.println();
            } else if (choiceToDo == 2) {
                System.out.println("Drücke 1 für Übersetzungpaar entfernen. Andere Nummer zum beenden.");
                Scanner sc5 = new Scanner(System.in);
                int choiceDeleteWhichWay = sc5.nextInt();
                sc5.nextLine();
                if (choiceDeleteWhichWay == 1){
                    System.out.println("Welches Wort soll gelöscht werden?");
                    Scanner sc6 = new Scanner(System.in);
                    String wordToDelete = sc6.nextLine();
                    //sc6.nextLine();
                    if (gerToEng.containsKey(wordToDelete) || engToGer.containsKey(wordToDelete)){
                        removeWordPair(gerToEng, engToGer, wordToDelete);
                    } else {
                        System.out.println("Wort nicht gefunden.");
                    }
                } else {
                    break;
                }
                System.out.println(gerToEng);
                System.out.println(engToGer);
                System.out.println();
            } else if (choiceToDo == 3) {
                System.out.println("Für Übersetzung von Deutsch auf English press 1. For translation from english to german press 2. Press another number for exit.");
                Scanner sc4 = new Scanner(System.in);
                int decission = sc4.nextInt();
                //sc.nextLine();
                if (decission == 1) {
                    System.out.println("Gib das Wort ein, dass du auf English übersetzen willlst.");
                    String toTranslate = sc.nextLine();
                    if (gerToEng.containsKey(toTranslate)) {
                        System.out.println(gerToEng.get(toTranslate));
                        System.out.println();
                    } else {
                        System.out.println("Das Wort ist nicht im Wörterbuch.");
                    }
                    //translateGerToEng(gerToEng, sc);
                    //String toTranslate = sc.nextLine();

                } else if (decission == 2) {
                    System.out.println("Put in the word, you want to translate to german.");
                    String toTranslate = sc.nextLine();
                    if (engToGer.containsKey(toTranslate)) {
                        System.out.println(engToGer.get(toTranslate));
                        System.out.println();
                    } else {
                        System.out.println("Das Wort ist nicht im Wörterbuch.");
                    }
                } else {
                    break;
                }
            } else {
                break;
            }

            System.out.println(gerToEng);
            System.out.println(engToGer);
            System.out.println();
        }               //Ende while Schleife


    }


    /*private static void addWordPairGerToEng(Map<String, String> gerToEng, String german, String english) {
        gerToEng.put(german, english);
    }*/

    private static void addWordPair(Map<String, String> gerToEng, Map<String, String> engToGer, String german, String english) {
        gerToEng.put(german, english);
        engToGer.put(english, german);
    }

    //Methode um mit 2 Wörtern zu löschen
    /*private static void removeWordPair(Map<String, String> gerToEng, Map<String, String> engToGer, String german, String english) {
        german = engToGer.get(english);
        engToGer.remove(english);
        english = gerToEng.get(german);
        gerToEng.remove(german);*/

    private static void removeWordPair(Map<String, String> gerToEng, Map<String, String> engToGer, String wordToDelete) {
        if (gerToEng.containsKey(wordToDelete)) {
            String english = gerToEng.get(wordToDelete);
            gerToEng.remove(wordToDelete);
            engToGer.remove(english);
        } else if (engToGer.containsKey(wordToDelete)) {
            String german = engToGer.get(wordToDelete);
            engToGer.remove(wordToDelete);
            gerToEng.remove(german);
        } else {
            System.out.println("nicht gefunden/not found");
        }

    }

}



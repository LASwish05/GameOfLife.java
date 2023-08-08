import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MineSweeperV2 {
    public static void main(String[] args) {
        int mineCount = 0;                                      //zählt mit wie oft 0 vorkommt
        boolean[][] revealed = new boolean[10][10];              //hier werden die aufgedeckten Felder gespeichert

        Random r = new Random();
        int[][] map = new int[10][10];                        //erstelle spielfeld (größe)

        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[0].length; y++) {
                int value = r.nextInt(4) - 3;       //befülle mit werten -3 bis 0
                if (value == 0) {
                    mineCount++;
                }
                map[x][y] = value;                      //Wert wird gespeichert
                revealed[x][y] = false;                 //boolean auf false gestellt
            }
        }
//Testausgabe für mich beim coden um zu sehen in welchem Feld welcher Wert ist
           /* System.out.printf("%2s", "");                 //freier Platz links oben
            for (char header = 'A'; header <= 'J'; header++)
                System.out.printf("%4s", String.valueOf(header));       //formatierte Ausgabe von A - J

            System.out.println();                               //neue Zeile
            for (int y = 0; y < 10; y++) {
                System.out.print(y + "  ");                     //print wird benutzt für die zeilen beschriftung
                for (int x = 0; x < 10; x++) {
                        System.out.print("[" + map[x][y] + "]");
                }
                System.out.println();                   //ist wieder für eine neue Zeile hier
            } */

        Scanner sc = new Scanner(System.in);
        double filedsToCheck = 100 - mineCount;
        int fieldsChecked = 0;

        while (true) {                                  //Runde beginnt
            System.out.printf("%2s", "");                 //freier Platz links oben
            for (char header = 'A'; header <= 'J'; header++)
                System.out.printf("%3s", String.valueOf(header));       //formatierte Ausgabe von A - J

            System.out.println();                               //neue Zeile
            for (int y = 0; y < 10; y++) {
                System.out.print(y + "  ");                     //print wird benutzt für die zeilen beschriftung
                for (int x = 0; x < 10; x++) {
                    if (revealed[x][y]) {                       //hier wird gecheckt ob das feld schon aufgedeckt ist und somit aufgedeckt angezeigt werden soll
                        if (map[x][y] == 0) {
                            System.out.print("[*]");
                        } else {
                            System.out.print("[-]");
                        }
                    } else {                                    //wenn noch nicht aufgedeckt
                        System.out.print("[ ]");
                    }
                }
                System.out.println();                   //ist wieder für eine neue Zeile hier
            }

            if (mineCount == 0) {
                System.out.println("Du hast gewonnen");
                break;
            }
            double percent = ((double) fieldsChecked / filedsToCheck) * 100;                //hier berrechnen wir die %Zahl der erkundeten Felder für die ausgabe
            System.out.printf("Du hast %d/%.0f %.2f%% des nicht verminten Gebiets auf Minen gecheckt.\n", fieldsChecked, filedsToCheck, percent);
            System.out.println("Es bleiben noch " + mineCount + " versteckt.");

            int letter = -1;
            int number = -1;
            while (true) {
                System.out.println("Wo willst du nach Minen suchen? (Eingabe z.B.: B4 oder G7)");
                try {
                    String input = sc.nextLine();                   //Benutzereingabe wir als string gespeichert
                    if (input.length() != 2) {
                        throw new InputMismatchException("Du musst einen Großbuchstaben von A - J und eine Zahl von 0 - 9 eingeben");
                    }
                    letter = input.charAt(0) - 'A';             //hier nehmen wir den ersten Buchstaben und machen ihn zu integer, er ist für die spalten auswahl, -'A' (-65 in ASCII Code) ist dafür da um bei null zu starten
                    number = Integer.parseInt(input.substring(1));      //hier ab 2ter character des strings, auch zu integer, ist für die zeile (dann fangen beide (letter und number) bei null an
                    if (letter > 9 || letter < 0 || number > 9 || number < 0) {
                        throw new InputMismatchException("Du musst einen Großbuchstaben von A - J und eine Zahl von 0 - 9 eingeben");
                    }
                    if (revealed[letter][number] == true) {
                        System.out.println("Dieses Feld wurde bereits aufgedeckt!");
                        continue;
                    }
                    break;                  //Wenn eingabe eben korrekt
                } catch (InputMismatchException e) {                    //wird ausgeführt wenn die Eingabe nicht genau aus 2 Zeichen besteht
                    System.out.println("Du musst einen Großbuchstaben von A - J und eine Zahl von 0 - 9 eingeben");
                    continue;
                } catch (NumberFormatException e) {                     //wird ausgeführt wenn nicht korrekt formatiert ist z.B. 1A
                    System.out.println("Du musst einen Großbuchstaben von A - J und eine Zahl von 0 - 9 eingeben");
                    continue;
                } catch (Exception e) {                                 //wird ausgeführt wenn ein sonstiger Fehler auftritt
                    System.out.println("Du musst einen Großbuchstaben von A - J und eine Zahl von 0 - 9 eingeben");
                    continue;
                }
            }

            System.out.println("User input " + letter + "/" + number);
            revealed[letter][number] = true;                //ausgewähltes feld wird auf enthüllt true gestellt

            if (map[letter][number] == -1) {
                fieldsChecked++;
            }

            if (map[letter][number] == -2) {
                fieldsChecked++;

                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (i != 0 || j != 0) { // nicht das gewählte Feld selbst
                            int newIlet = letter + i;
                            int newJnum = number + j;
                            if (newIlet >= 0 && newIlet < map.length && newJnum >= 0 && newJnum < map[0].length) {  //prüfung ob neues feld am Spielfeld liegt
                                if (!revealed[newIlet][newJnum]) {
                                    revealed[newIlet][newJnum] = true;
                                    if (map[newIlet][newJnum] == 0) {
                                        mineCount--;
                                    } else {
                                        fieldsChecked++;
                                    }
                                }
                            }
                        }
                    }
                }               //Ende for Schleife
            }
//Testausgabe für mich beim coden
            /*System.out.printf("%2s", "");                 //freier Platz links oben
            for (char header = 'A'; header <= 'J'; header++)
                System.out.printf("%4s", String.valueOf(header));       //formatierte Ausgabe von A - J

            System.out.println();                               //neue Zeile
            for (int y = 0; y < 10; y++) {
                System.out.print(y + "  ");                     //print wird benutzt für die zeilen beschriftung
                for (int x = 0; x < 10; x++) {
                    System.out.print("[" + map[x][y] + "]");
                }
                System.out.println();                   //ist wieder für eine neue Zeile hier
            }*/

            if (map[letter][number] == -3) {
                fieldsChecked++;

                for (int i = -2; i <= 2; i++) {
                    for (int j = -2; j <= 2; j++) {
                        if (i != 0 || j != 0) {
                            int newIlet = letter + i;
                            int newJnum = number + j;
                            if (newIlet >= 0 && newIlet < map.length && newJnum >= 0 && newJnum < map[0].length) {
                                if (!revealed[newIlet][newJnum]) {
                                    revealed[newIlet][newJnum] = true;
                                    if (map[newIlet][newJnum] == 0) {
                                        mineCount--;
                                    } else {
                                        fieldsChecked++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (map[letter][number] == 0) {                     //wenn Mine getroffen
                System.out.printf("%2s", "");                 //freier Platz links oben
                for (char header = 'A'; header <= 'J'; header++)
                    System.out.printf("%3s", String.valueOf(header));       //formatierte Ausgabe von A - J

                System.out.println();                               //neue Zeile
                for (int y = 0; y < 10; y++) {
                    System.out.print(y + "  ");                     //print wird benutzt für die zeilen beschriftung
                    for (int x = 0; x < 10; x++) {
                        if (revealed[x][y]) {                       //hier wird gecheckt ob das feld schon aufgedeckt ist und somit aufgedeckt angezeigt werden soll
                            if (map[x][y] == 0) {
                                System.out.print("[*]");
                            } else {
                                System.out.print("[-]");
                            }
                        } else {                                    //wenn noch nicht aufgedeckt
                            System.out.print("[ ]");
                        }
                    }
                    System.out.println();                   //ist wieder für eine neue Zeile hier
                }
                System.out.printf("Du hast %d/%.0f %.2f%% des nicht verminten Gebiets auf Minen gecheckt.\n", fieldsChecked, filedsToCheck, percent);
                System.out.println("Es bleiben noch " + mineCount + " versteckt.");
                System.out.println("Das... war eine Mine. Du hast leider verloren."); //wenn man das Spielfeld nicht nochtmal anzeigen möchte, würde beim letzen if befehl diese Zeile genügen
                break;
            }
        }                               //while Ende von Runde beginnt.
    }
}
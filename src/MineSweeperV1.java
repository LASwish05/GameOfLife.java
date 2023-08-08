import java.util.Random;
import java.util.Scanner;

public class MineSweeperV1 {
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

        Scanner sc = new Scanner(System.in);
        double fieldsLeft = 100 - mineCount;
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

            if (fieldsChecked == fieldsLeft) {
                System.out.println("Du hast gewonnen");
                break;
            }
            double percent = (fieldsChecked / fieldsLeft) * 100;                //hier berrechnen wir die %Zahl der erkundeten Felder für die ausgabe
            System.out.printf("Du hast %d/%.0f %.2f%% des nicht verminten Gebiets auf Minen gecheckt.\n", fieldsChecked, fieldsLeft, percent);
            System.out.println("Es bleiben noch " + mineCount + " versteckt.");
            System.out.println("Wo willst du nach Minen suchen? (Eingabe z.B.: B4 oder G7)");
            String input = sc.nextLine();                   //Benutzereingabe wir als string gespeichert
            int letter = input.charAt(0) - 'A';             //hier nehmen wir den ersten Buchstaben und machen ihn zu integer, er ist für die spalten auswahl, -'A' (-65 in ASCII Code) ist dafür da um bei null zu starten
            int number = Integer.parseInt(input.substring(1));      //hier ab 2ter character des strings, auch zu integer, ist für die zeile (dann fangen beide (letter und number) bei null an
            System.out.println("User input " + letter + "/" + number);

            revealed[letter][number] = true;                //ausgewähltes feld wird auf enthüllt true gestellt
            if (map[letter][number] != 0) {
                fieldsChecked++;
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
                System.out.printf("Du hast %d/%.0f %.2f%% des nicht verminten Gebiets auf Minen gecheckt.\n", fieldsChecked, fieldsLeft, percent);
                System.out.println("Es bleiben noch " + mineCount + " versteckt.");
                System.out.println("Das... war eine Mine. Du hast leider verloren."); //wenn man das Spielfeld nicht nochtmal anzeigen möchte, würde beim letzen if befehl diese Zeile genügen
                break;
            }
        }
    }
}

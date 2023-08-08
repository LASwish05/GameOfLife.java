import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class TestMineSweeperV2 {
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
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.printf("[%d]", map[i][j]);
            }
            System.out.println();
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

            int letter = -1;
            int number = -1;
            int row = -1;
            int col = -1;
            while (true) {
                System.out.println("Wo willst du nach Minen suchen? (Eingabe z.B.: B4 oder G7)");
                try {
                    String input = sc.nextLine();
                    if (input.length() != 2) {
                        throw new InputMismatchException("Du musst einen Großbuchstaben von A - J und eine Zahl von 0 - 9 eingeben");
                    }
                    row = input.charAt(0) - 'A';
                    col = Integer.parseInt(input.substring(1));
                    if (row > 9 || row < 0 || col > 9 || col < 0) {
                        throw new InputMismatchException("Du musst einen Großbuchstaben von A - J und eine Zahl von 0 - 9 eingeben");
                    }
                    if (revealed[row][col]) {
                        System.out.println("Dieses Feld wurde bereits aufgedeckt!");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (map[row][col] == 0) {
                System.out.println("Du hast verloren!");
                return;
            } else if (map[row][col] == -1) {
                revealed[row][col] = true;
            } else if (map[row][col] == -2) {
                int revealedCount = 0;
                for (int i = row - 1; i <= row + 1; i++) {
                    for (int j = col - 1; j <= col + 1; j++) {
                        if (i >= 0 && i < 10 && j >= 0 && j < 10 && !revealed[i][j]) {
                            if (map[i][j] == 0) {
                                revealed[i][j] = true;
                            } else if (map[i][j] > 0) {
                                revealed[i][j] = true;
                                revealedCount++;
                            }
                        }
                    }
                }
                if (revealedCount == 0) {
                    System.out.println("Du hast verloren!");
                    return;
                }
            } else if (map[row][col] == -3) {
                int revealedCount = 0;
                for (int i = row - 2; i <= row + 2; i++) {
                    for (int j = col - 2; j <= col + 2; j++) {
                        if (i >= 0 && i < 10 && j >= 0 && j < 10 && !revealed[i][j]) {
                            if (map[i][j] == 0) {
                                revealed[i][j] = true;
                            } else if (map[i][j] > 0) {
                                revealed[i][j] = true;
                                revealedCount++;
                            }
                        }
                    }
                }
                if (revealedCount == 0) {
                    System.out.println("Du hast verloren!");
                    return;
                }
            } else {
                revealed[row][col] = true;


                System.out.printf("Du hast %d/%.0f %.2f%% des nicht verminten Gebiets auf Minen gecheckt.\n", fieldsChecked, fieldsLeft, percent);
                System.out.println("Es bleiben noch " + mineCount + " versteckt.");
                System.out.println("Das... war eine Mine. Du hast leider verloren."); //wenn man das Spielfeld nicht nochtmal anzeigen möchte, würde beim letzen if befehl diese Zeile genügen
                break;
            }
        }
    }
}

/*
for (int dx = -1; dx <= 1; dx++) {
        for (int dy = -1; dy <= 1; dy++) {
        if (dx != 0 || dy != 0) { // nicht das gewählte Feld selbst
        int newX = x + dx;
        int newY = y + dy;
        if (newX >= 0 && newX < map.length && newY >= 0 && newY < map[0].length) { // prüfen, ob das Feld innerhalb des Spielfelds liegt
        // tue etwas mit dem angrenzenden Feld map[newX][newY]
        }
        }
        }
        }
*/




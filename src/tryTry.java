import java.util.Random;
import java.util.Scanner;
public class tryTry {
    public static void main(String[] args) {


                int mineCount = 0;
                boolean[][] revealed = new boolean[10][10];

                Random r = new Random();
                int[][] map = new int[10][10];

                // Befüllen des Arrays mit Zufallswerten
                for (int x = 0; x < map.length; x++) {
                    for (int y = 0; y < map[0].length; y++) {
                        int value = r.nextInt(4) - 3;
                        if (value == 0) {
                            mineCount++;
                        }
                        map[x][y] = value;
                        revealed[x][y] = false;
                    }
                }

                Scanner scanner = new Scanner(System.in);
                int remainingFields = 100 - mineCount;
                int revealedFields = 0;

                // Spielschleife
                while (true) {
                    // Ausgabe des aktuellen Spielfelds
                    System.out.println("    A   B   C   D   E   F   G   H   I   J");
                    for (int y = 0; y < 10; y++) {
                        System.out.print(y + "  ");
                        for (int x = 0; x < 10; x++) {
                            if (revealed[x][y]) {
                                if (map[x][y] == 0) {
                                    System.out.print("[*]");
                                } else {
                                    System.out.printf("[%2d]", map[x][y]);
                                }
                            } else {
                                System.out.print("[ ]");
                            }
                        }
                        System.out.println();
                    }

                    // Prüfung, ob Spiel gewonnen wurde
                    if (revealedFields == remainingFields) {
                        System.out.println("Herzlichen Glückwunsch! Du hast alle freien Felder entminen können!");
                        break;
                    }

                    // Eingabe des Benutzers
                    System.out.print("Bitte gib die Koordinaten des Feldes ein (z.B. A4): ");
                    String input = scanner.nextLine().toUpperCase();
                    int x = input.charAt(0) - 'A';
                    int y = Integer.parseInt(input.substring(1)) - 1;

                    // Prüfung, ob Koordinaten innerhalb des Spielfelds liegen
                    if (x < 0 || x > 9 || y < 0 || y > 9) {
                        System.out.println("Ungültige Eingabe. Bitte gib Koordinaten im Format A1 bis J10 ein.");
                        continue;
                    }

                    // Prüfung, ob das Feld schon aufgedeckt wurde
                    if (revealed[x][y]) {
                        System.out.println("Dieses Feld wurde bereits aufgedeckt. Bitte wähle ein anderes Feld.");
                        continue;
                    }

                    // Aufdecken des Feldes
                    revealed[x][y] = true;
                    revealedFields++;

                    // Prüfung, ob Mine getroffen wurde
                    if (map[x][y] == 0) {
                        System.out.println("BOOM! Du hast eine Mine erwischt und das Spiel verloren.");
                        break;
                    }

                    // Feld als aufgedeckt markieren
                    map[x][y] = -map[x][y];
                }
            }
        }

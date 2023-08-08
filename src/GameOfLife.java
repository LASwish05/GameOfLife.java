import java.util.Random;

public class GameOfLife {
    public static void main(String[] args) {
        int randomCrossSquare = 0;

        boolean[][] currentLife = new boolean[10][10];
        if (randomCrossSquare == 0) {
            deadOrAlive(currentLife);               //Methode
        } else if (randomCrossSquare == 1) {
            crosstest(currentLife);
        } else if (randomCrossSquare == 2) {
            squaretest(currentLife);
        }


        for (int rounds = 1; rounds <= 100; rounds++) {
                System.out.println("Round" + rounds + ":");

                printLifeMap(currentLife);                              //Methode

                boolean[][] nextLife = new boolean[10][10];
                int countLifeFields;

                for (int y = 0; y < currentLife.length; y++) {                  //schleife um die einzelnen Felder anzuwählen
                    for (int x = 0; x < currentLife.length; x++) {

                        countLifeFields = countNeighbours(currentLife, x, y);               //Methode
                        nextLife[x][y] = newGeneration(currentLife, nextLife, countLifeFields, x, y);           //Methode
                    }
                }                                       //schleife um einzelne Felder anzuwählen Ende

                if (compareMaps(currentLife, nextLife)) {
                    System.out.println("Map don´t change again!");
                    break;
                }
                currentLife = nextLife;
            }                                           //Ende der Schleife für die Runden
        }                                               //Ende while Schleife


    //Methoden

    public static void deadOrAlive(boolean[][] currentLife) {
        Random r = new Random();
        for (int x = 0; x < currentLife.length; x++) {
            for (int y = 0; y < currentLife[0].length; y++) {
                currentLife[x][y] = r.nextBoolean();
            }
        }

    }

    private static void squaretest(boolean[][] currentLife) {
        currentLife[3][3] = true;
        currentLife[3][4] = true;
        currentLife[4][3] = true;
        currentLife[4][4] = true;
    }

    private static void crosstest(boolean[][] currentLife) {
        currentLife[3][3] = true;
        currentLife[3][4] = true;
        currentLife[3][5] = true;
    }

    public static void printLifeMap(boolean[][] currentLife) {

        for (int y = 0; y < currentLife.length; y++) {
            for (int x = 0; x < currentLife.length; x++) {
                if (currentLife[x][y]) {
                    System.out.print(" # ");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }


    public static int countNeighbours(boolean[][] currentLife, int x, int y) {
        int neighbourY = 0;
        int neighbourX = 0;
        int counter = 0;
        for (int i = -1; i <= 1; i++) {                         //schleife um vom jeweiligen Feld die Nachbarn anzuwählen
            for (int j = -1; j <= 1; j++) {
                if (i != 0 || j != 0) {
                    neighbourX = x + i;
                    neighbourY = y + j;
                    if (neighbourX >= 0 && neighbourX < currentLife.length && neighbourY >= 0 && neighbourY < currentLife.length) {
                        if (currentLife[neighbourX][neighbourY]) {
                            counter++;
                        }
                    }
                }
            }
        }
        return counter;
    }

    public static boolean newGeneration(boolean[][] currentLife, boolean[][] nextLife, int countLifeFields, int x, int y) {
        if (currentLife[x][y]) {
            if (countLifeFields < 2 || countLifeFields > 3) {           //feld stirbt
                return false;
            } else {
                return true;
            }
        } else {
            if (countLifeFields == 3) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static boolean compareMaps (boolean[][] currentLife, boolean[][] nextLife) {
        for (int y = 0; y < currentLife.length; y++) {
            for (int x = 0; x < currentLife.length; x++) {
                if (currentLife[x][y] != nextLife[x][y]){
                    return false;
                }
            }
        }
        return true;
    }

}

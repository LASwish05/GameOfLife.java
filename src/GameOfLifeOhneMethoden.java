import java.util.Random;

public class GameOfLifeOhneMethoden {
    public static void main(String[] args) {
        boolean[][] currentLife = new boolean[25][25];
        Random r = new Random();


        for (int x = 0; x < currentLife.length; x++) {
            for (int y = 0; y < currentLife[0].length; y++) {
                currentLife[x][y] = r.nextBoolean();
            }
        }

        for (int rounds = 1; rounds <= 5; rounds++) {

            System.out.println("Round" + rounds + ":");
            for (int y = 0; y < currentLife.length; y++) {
                for (int x = 0; x < currentLife.length; x++) {
                    if (currentLife[x][y]) {
                        System.out.print("[#]");
                    } else {
                        System.out.print("[ ]");
                    }
                }
                System.out.println();
            }
            System.out.println();

            boolean[][] nextLife = new boolean[25][25];
            int countLifeFields = 0;
            int neighbourY = 0;
            int neighbourX = 0;
            for (int y = 0; y < currentLife.length; y++) {                  //schleife um die einzelnen Felder anzuwählen
                for (int x = 0; x < currentLife.length; x++) {

                    for (int i = -1; i <= 1; i++) {                         //schleife um vom jeweiligen Feld die Nachbarn anzuwählen
                        for (int j = -1; j <= 1; j++) {
                            if (i != 0 || j != 0) {
                                neighbourX = x + i;
                                neighbourY = y + j;
                                if (neighbourX >= 0 && neighbourX < currentLife.length && neighbourY >= 0 && neighbourY < currentLife.length) {
                                    if (currentLife[neighbourX][neighbourY]) {
                                        countLifeFields++;
                                    }
                                }
                            }
                        }
                    }

                    if (currentLife[x][y]) {
                        if (countLifeFields < 2 || countLifeFields > 3) {           //feld stirbt
                            nextLife[x][y] = false;
                        } else {
                            nextLife[x][y] = true;
                        }
                    } else {
                        if (countLifeFields == 3) {
                            nextLife[x][y] = true;
                        } else {
                            nextLife[x][y] = false;
                        }
                    }
                    countLifeFields = 0;
                }
            }                                       //schleife um einzelne Felder anzuwählen Ende
            currentLife = nextLife;
        }




    }
}

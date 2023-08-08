import java.util.ArrayList;
import java.util.Random;

public class BingoCardGenerator {
    public static void main(String[] args) {

        Random r = new Random();
        int[][] map = new int[5][5];//erstelle spielfeld (größe)
        int value = 0;
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int x = 0; x < map.length; x++) {

            for (int y = 0; y < map[0].length; y++) {
                int saveNewRandom = r.nextInt(15) + 1;
                while (numbers.contains(saveNewRandom) && numbers.size()< map[0].length) {
                    saveNewRandom = r.nextInt(15) + 1;
                }

                numbers.add(saveNewRandom);

                map[x][y] = saveNewRandom;
                map[x][y] = saveNewRandom + value;
            }
            value += 15;
        }
        System.out.println(numbers);

        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                if (y == 2 && x == 2){
                    System.out.printf("[%2s]", "X");
                } else {
                    System.out.printf("[%2d]", map[x][y]);
                }
            }
            System.out.println();                   //ist wieder für eine neue Zeile hier
        }
    }
}

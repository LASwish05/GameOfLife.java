import java.util.Random;

public class GaudiMitArraysV1 {
    public static void main(String[] args) {
        int[] a = {3, 5, 6, 12, 23, 32, 33, 54, 71, 91};

        Random r = new Random();
        int[] b = new int[100];
        for (int x = 0; x < b.length; x++) {
            b[x] = r.nextInt(100);
        }
        boolean[] c = new boolean[10];
        for (int y = 0; y < c.length; y++) {
            if (y%2 == 0) {
                c[y] = true;
            }
            else {
                c[y] = false;
            }
        }
    }
}

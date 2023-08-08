import java.util.Arrays;
import java.util.Random;

public class GaudiMitStatistikV2 {
    public static void main(String[] args) {
        Random r = new Random();
        int[] a = new int[100];
        for (int x = 0; x < a.length; x++) {
            a[x] = r.nextInt(100);
            System.out.print(a[x] + " ");
        }
        System.out.println();
        int c;
        for (int z = a.length-1; z > 1; z--){
            for (int y = 0; y <= z -1; y++){
                if (a[y]>=a[z]) {
                    c = a[z];
                    a[z]=a[y];
                    a[y]=c;
                }
            }
        }

        for (int i = 0; i <a.length ; i++) {
            System.out.print(a[i] + " ");
        }
        //Arrays.sort(a);
        //System.out.println(Arrays.toString(a));
    }
}

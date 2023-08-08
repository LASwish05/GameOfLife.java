import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class GaudiMitStatistikV3 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random r = new Random();
        int[] numbersArray = new int[11];
        System.out.println("Urliste:");
        for (int x = 0; x < numbersArray.length; x++) {
            numbersArray[x] = r.nextInt(10);
            numbers.add(numbersArray[x]);
            System.out.print("[" + numbersArray[x] + "] ");
        }
        System.out.println();

        Arrays.sort(numbersArray);

        System.out.println("Aufsteigende sortiert:");
        for (int i = 0; i <numbersArray.length ; i++) {
            System.out.print("[" + numbersArray[i] + "] ");
        }


        //Arithmetisches Mittel
        double aSum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            aSum += numbers.get(i);
        }
        System.out.println();
        System.out.println(aSum);
        double arithmetischesMittel = aSum/numbers.size();
        System.out.println(String.format("Arithmetische Mittel: %.2f.", arithmetischesMittel));

        //Spannweite/Bereich
        int spannweite = numbersArray[numbersArray.length -1] - numbersArray[0];
        System.out.println("Spannweite:" + spannweite);

        //Median Wert
        double median = 0;
        if (numbersArray.length%2 == 1) {
            System.out.println("Median:" + (double) numbersArray[numbersArray.length/2]);
        } else {
            System.out.println("Median:" + ((double) numbersArray[numbersArray.length/2] + (double) numbersArray[numbersArray.length/2 - 1])/2);
        }

        //Modal Wert
        int count = 0;
        int mod = 0;
        int modCount = 0;
        for (int i = 0; i < numbersArray.length; i++) {
            count = 0;
            for (int j = 0; j < numbersArray.length; j++) {
                if (numbersArray[i] == numbersArray[j]) {
                    count += 1;
                }
            }
            if (modCount < count) {
                mod = numbersArray[i];
                modCount = count;
            }
        }
        System.out.println("Modalwert:" + mod + " mit " + modCount);

        //Mittlere Absolute Abweichung
        double sum = 0;
        for (int i = 0; i < numbersArray.length; i++) {
            sum += Math.abs(numbersArray[i] - arithmetischesMittel);
        }
        double mittlereAbweichung = sum/numbersArray.length;
        System.out.println(String.format("Mittlere absolute Abweichung: %.2f.", mittlereAbweichung));
    }
}

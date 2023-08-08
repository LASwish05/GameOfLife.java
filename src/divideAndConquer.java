import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class divideAndConquer {
    public static void main(String[] args) {

        //ArrayList<Integer> numbers = new ArrayList<>();           ArrayList wird in diesem Programm nicht benögtigt
        Random r = new Random();
        int[] arrayDaC = new int[20];
        for (int x = 0; x < arrayDaC.length; x++) {
            arrayDaC[x] = r.nextInt(10000);
         //   numbers.add(arrayDaC[x]);
            System.out.print(" " + arrayDaC[x]);
        }
        System.out.println();
        int max = maxNumber(arrayDaC);
        System.out.println("Größte Nummer: " + max);

    }
    public static int maxNumber (int[] arrayM) {
        if (arrayM.length == 1){
            return arrayM[0];
        } /*else if (arrayM.length == 2) {
            return Math.max(arrayM[0], arrayM[1]);
        }*/ else {
            int mid = arrayM.length/2;
            int []leftArrayM = Arrays.copyOfRange(arrayM, 0, mid);
            int []rightArrayM = Arrays.copyOfRange(arrayM, mid, arrayM.length);
            int leftMax = maxNumber(leftArrayM);
            int rightMax = maxNumber(rightArrayM);
            if(leftMax > rightMax){
                return leftMax;
            }
            return rightMax;
            //return Math.max(leftMax, rightMax);
        }
    }

}

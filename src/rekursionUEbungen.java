public class rekursionUEbungen {
    public static void main(String[] args) {
        System.out.println(fibonacci(10));


        down1(10);
        System.out.println();

        down2(10);
        System.out.println();

        challengeOne(1);
        System.out.println();

        challenOnePointTwo(101);
        System.out.println();

        int result = challengetwo(5);
        System.out.println(result);

        System.out.println();



        //challengetwoMitIstGleich(5);



        chellengeTwoPointTwo(5);
        System.out.println();

    }


        static int fibonacci ( int n){
            if (n == 0)
                return 0;
            if (n == 1)
                return 1;
            return fibonacci(n - 1) + fibonacci(n - 2);
        }


    //Quiz 1:
        static void down1(int n) {
        if (n <=0) { //end of recursion
            return;
        }
        System.out.print(n + ", ");
        down1(n-1);
    }

//Quiz 2:
    static void down2(int n) {
        if (n <=0) { //end of recursion
            return;
        }
        down2(n-1);
        System.out.print(n + ", ");
    }

    //Rekursion Challenge 1 mit rekursion
    static void challengeOne(int n) {
        if (n > 100) {
            return;
        }
        System.out.print(n + ", ");
        challengeOne(n + 1);
    }

    //Rekursion Challenge 1 ohne rekursion
    static void challenOnePointTwo (int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(i + ", ");
        }
    }

    //Rekursion Challenge 2
    static int challengetwo (int number) {
        if (number <= 0) {
            return 0;
        }
        int giveback = number + challengetwo(number - 1);
        if (number == 5) {
            System.out.print(number + "=");
        } else {
            System.out.print(number + "+");
        }
        return giveback;
    }



    //Rekursion Challenge 2 ohne rekursion
    static void chellengeTwoPointTwo (int n) {
        int result = 0;
        for (int number = 1; number <= n; number++) {
            result = number + result;
            if (number < n) {
                System.out.print(number + "+");
            } else {
                System.out.print(number);
            }
        }
        System.out.println("=" + result);
    }

    /*static int challengetwoMitIstGleich (int n) {               //diese Methode wird verwendet um das problem mit den = zu lösen
        return challengetwoMitIstGleich(n, n);
    }

    //Rekursion Challenge 2
    private static int challengetwoMitIstGleich (int n, int i) {

        if (n <= 0) {
            return 0;
        }
        int x = n + challengetwoMitIstGleich(n - 1, i);
        if (n == i) {
            System.out.print(n + "=");
        } else {
            System.out.print(n + "+");
        }
        return x;
    }*/


}

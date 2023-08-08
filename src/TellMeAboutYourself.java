public class TellMeAboutYourself {
    public static void main(String[] args) {
        int age = 39;
        String firstName = "Alexander";
        String gender = "male";
        String lastName = "Lorenz";
        String birthday = "14.10.1983";
        double averageGrade = 2.5;
        boolean married = false;

        System.out.println("My name is " + firstName + " " + lastName + " I´m a " + gender + " and " + age + " years old.");
        System.out.println("My brithday is on " + birthday + ", my average grade is " + averageGrade + " and my married status is " + married + ".");

    //Simple Calculations

        int numberOne = 138;
        double numberTwo = 17;

        System.out.println(numberOne + " + " + numberTwo + " = " + (numberOne+numberTwo));
        System.out.println(numberOne + " - " + numberTwo + " = " + (numberOne-numberTwo));
        System.out.println(numberOne + " * " + numberTwo + " = " + (numberOne*numberTwo));
        System.out.printf("%d /  %.2f  =  %.2f" , numberOne, numberTwo, (numberOne/numberTwo));
        System.out.println();

//working with Strings

        String hello = "  Hello World!";
        char[] helloTwo = hello.toCharArray();
        int howManySigns = helloTwo.length;
        String codersBay = hello.replace("World", "Codersbay");



        System.out.println(hello);
        System.out.println(howManySigns);
        System.out.println(hello.toLowerCase());
        System.out.println(hello.toUpperCase());
        System.out.println(codersBay);
        System.out.println(hello.trim());
        System.out.println((hello + "\n").repeat(15));
        System.out.println(hello.replace("World", "Codersbay"));
    }
}

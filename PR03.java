/* AIM:
   Write a Java program that accepts two numbers as command-line arguments.
   Convert these arguments to appropriate numeric types (e.g., int or double),
   perform a simple calculation (e.g., sum or product), and print the result
   to the console.
*/

public class PR03 {
    public static void main(String[] args) {

        
        if (args.length != 2) {
            System.out.println("Please provide exactly two numbers.");
            return;
        }

        double num1 = Double.parseDouble(args[0]);
        double num2 = Double.parseDouble(args[1]);

        double sum = num1 + num2;
        double product = num1 * num2;

    
        System.out.println("First number: " + num1);
        System.out.println("Second number: " + num2);
        System.out.println("Sum = " + sum);
        System.out.println("Product = " + product);
    }
}


/* OUTPUT:

C:\Users\Mahadev> F:

F:\>cd OOP_lab_practicals

F:\OOP_lab_practicals>javac PR03.java

F:\OOP_lab_practicals>java PR03
Please provide exactly two numbers.

F:\OOP_lab_practicals>java PR03 10 5
First number: 10.0
Second number: 5.0
Sum = 15.0
Product = 50.0

*/
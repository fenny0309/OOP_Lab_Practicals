/*
AIM:
Write a Java application that defines a method average(String[] values) which:
● Accepts an array of strings as an argument.
● Converts each string element into a double and computes the average.
● If any array element is null, the method should throw a NullPointerException.
● If any element is not a valid number (e.g., "abc"), it should throw a
NumberFormatException.
● Include the throws clause in the method declaration.

● In the main method, demonstrate the working of this program with valid and invalid inputs using try-
catch-finally
*/

import java.util.Scanner;

public class PR14 {

    public static double average(String[] values)
            throws NullPointerException, NumberFormatException {

        double sum = 0;

        for (int i = 0; i < values.length; i++) {

            if (values[i] == null) {
                throw new NullPointerException("Element at index " + i + " is null");
            }

            double num = Double.parseDouble(values[i]);
            sum += num;
        }

        return sum / values.length;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] values = new String[n];

        System.out.println("Enter values (type null for null value):");

        for (int i = 0; i < n; i++) {
            System.out.print("Value " + (i + 1) + ": ");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("null")) {
                values[i] = null;
            } else {
                values[i] = input;
            }
        }

        try {
            double result = average(values);
            System.out.println("\nAverage = " + result);
        }

        catch (NullPointerException e) {
            System.out.println("\nNull Exception: " + e.getMessage());
        }

        catch (NumberFormatException e) {
            System.out.println("\nNumber Format Exception: " + e.getMessage());
        }

        finally {
            System.out.println("Program execution completed.");
            sc.close();
        }
    }
}

/*
OUTPUT

1)
Enter number of elements: 3
Enter values (type null for null value):
Value 1: 10
Value 2: 20
Value 3: 30

Average = 20.0
Program execution completed.


2)
Enter number of elements: 3
Enter values (type null for null value):
Value 1: 10
Value 2: null
Value 3: 30

Null Exception: Element at index 1 is null
Program execution completed.


3)
Enter number of elements: 3
Enter values (type null for null value):
Value 1: 10
Value 2: abc
Value 3: 30

Number Format Exception: For input string: "abc"
Program execution completed.
*/
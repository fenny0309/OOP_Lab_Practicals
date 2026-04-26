/*
AIM:
Write a Java program to demonstrate method overriding in an online payment system. Create a
superclass Payment with a method processPayment(int amount). In the subclass CreditCardPayment,
override the method to print "Payment of Rs.<amount> done using Credit Card". In the subclass
UPIPayment, override the method to print "Payment of Rs.<amount> done using UPI". Accept user
choice and amount, and display the payment result using method overriding.
*/

import java.util.Scanner;

// Superclass
class Payment {

    void processPayment(int amount) {
        System.out.println("Processing payment of Rs." + amount);
    }
}

// Subclass 1
class CreditCardPayment extends Payment {

    @Override
    void processPayment(int amount) {
        System.out.println("Payment of Rs." + amount + " done using Credit Card");
    }
}

// Subclass 2
class UPIPayment extends Payment {

    @Override
    void processPayment(int amount) {
        System.out.println("Payment of Rs." + amount + " done using UPI");
    }
}

// Main class
public class PR11 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter amount: ");
        int amount = sc.nextInt();

        System.out.println("Choose Payment Method:");
        System.out.println("1. Credit Card");
        System.out.println("2. UPI");

        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        Payment p;

        if (choice == 1) {
            p = new CreditCardPayment();
        } else if (choice == 2) {
            p = new UPIPayment();
        } else {
            System.out.println("Invalid choice!");
            sc.close();
            return;
        }

        p.processPayment(amount);

        sc.close();
    }
}

/*
SAMPLE OUTPUT

1) Enter amount: 5000
Choose Payment Method:
1. Credit Card
2. UPI
Enter choice: 2
Payment of Rs.5000 done using UPI

2) Enter amount: 10000
Choose Payment Method:
1. Credit Card
2. UPI
Enter choice: 1
Payment of Rs.10000 done using Credit Card
*/
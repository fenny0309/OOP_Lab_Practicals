/* Simulate a simple ATM or cashier. Given an integer amount to be dispensed (e.g., 787), calculate and
display the minimum number of currency notes of denominations 100, 50, 10, 5, 2, and 1 that would be
given to the user.
*/

import java.util.Scanner;

public class PR01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter amount to withdraw: ");
        int amount = sc.nextInt();

        
        int originalAmount = amount;

        
        int n100 = amount / 100;
        amount = amount % 100;

        int n50 = amount / 50;
        amount = amount % 50;

        int n10 = amount / 10;
        amount = amount % 10;

        int n5 = amount / 5;
        amount = amount % 5;

        int n2 = amount / 2;
        amount = amount % 2;

        int n1 = amount;

        
        System.out.println("\nMinimum number of notes for amount: " + originalAmount);
        System.out.println("100 = " + n100);
        System.out.println("50  = " + n50);
        System.out.println("10  = " + n10);
        System.out.println("5   = " + n5);
        System.out.println("2   = " + n2);
        System.out.println("1   = " + n1);

        sc.close();
    }
}

/* OUTPUT:

Enter amount to withdraw: 787

Minimum number of notes for amount: 787
100 = 7
50  = 1
10  = 3
5   = 1
2   = 1
1   = 0

*/
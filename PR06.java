/* Aim:
   Write a program for billing system for a shopping mall. Create a class
   BillGenerator that uses method overloading to generate bills based on
   customer type:
   generateBill(int itemTotal): For regular customers, apply no discount.
   generateBill(int itemTotal, int discount): For privileged customers,
   apply flat discount in rupees.
   generateBill(int itemTotal, double discountPercent): For festive offers,
   apply percentage discount.
   Write a program to display the final bill amount using appropriate
   overloaded method based on customer category.
*/

import java.util.Scanner;

class BillGenerator {

    void generateBill(int itemTotal) {
        System.out.println("Customer Type: Regular");
        System.out.println("Final Bill Amount: ₹" + itemTotal);
    }

    void generateBill(int itemTotal, int discount) {
        int finalAmount = itemTotal - discount;

        if (finalAmount < 0) {
            finalAmount = 0;
        }

        System.out.println("Customer Type: Privileged");
        System.out.println("Discount Applied: ₹" + discount);
        System.out.println("Final Bill Amount: ₹" + finalAmount);
    }

    void generateBill(int itemTotal, double discountPercent) {
        double discount = (itemTotal * discountPercent) / 100;
        double finalAmount = itemTotal - discount;

        if (finalAmount < 0) {
            finalAmount = 0;
        }

        System.out.println("Customer Type: Festive Offer");
        System.out.println("Discount Applied: " + discountPercent + "%");
        System.out.println("Final Bill Amount: ₹" + finalAmount);
    }
}

public class PR06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BillGenerator bill = new BillGenerator();

        System.out.print("Enter total amount: ");
        int total = sc.nextInt();

        System.out.println("\nSelect Customer Type:");
        System.out.println("1. Regular");
        System.out.println("2. Privileged (Flat Discount)");
        System.out.println("3. Festive Offer (Percentage Discount)");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                bill.generateBill(total);
                break;

            case 2:
                System.out.print("Enter flat discount amount: ");
                int discount = sc.nextInt();
                bill.generateBill(total, discount);
                break;

            case 3:
                System.out.print("Enter discount percentage: ");
                double percent = sc.nextDouble();
                bill.generateBill(total, percent);
                break;

            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
}

/* Output Case 1: Regular Customer

Enter total amount: 5000

Select Customer Type:
1. Regular
2. Privileged (Flat Discount)
3. Festive Offer (Percentage Discount)
1

Customer Type: Regular
Final Bill Amount: ₹5000


Output Case 2: Privileged Customer

Enter total amount: 5000

Select Customer Type:
1. Regular
2. Privileged (Flat Discount)
3. Festive Offer (Percentage Discount)
2
Enter flat discount amount: 500

Customer Type: Privileged
Discount Applied: ₹500
Final Bill Amount: ₹4500


Output Case 3: Festive Offer Customer

Enter total amount: 5000

Select Customer Type:
1. Regular
2. Privileged (Flat Discount)
3. Festive Offer (Percentage Discount)
3
Enter discount percentage: 10

Customer Type: Festive Offer
Discount Applied: 10.0%
Final Bill Amount: ₹4500.0

*/
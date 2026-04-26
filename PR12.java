/*
AIM:
Design a Java program for an Online Order Processing System using partial interface implementation.
Create an interface Order with three methods:
placeOrder(String item, int qty) ,cancelOrder(int orderId) ,generateBill()
Create an abstract class PartialOrder that implements the Order interface but provides implementation
only for placeOrder() (storing order details). Create a concrete class FinalOrder that extends
PartialOrder and implements the remaining methods cancelOrder() and generateBill(). Accept user
input for order details and allow user to either generate a bill or cancel the order.
*/

import java.util.Scanner;

interface Order {
    void placeOrder(String item, int qty);
    void cancelOrder(int orderId);
    void generateBill();
}

abstract class PartialOrder implements Order {

    protected String itemName;
    protected int quantity;
    protected int orderId;

    public void placeOrder(String item, int qty) {
        this.itemName = item;
        this.quantity = qty;
        this.orderId = (int) (Math.random() * 1000);

        System.out.println("\nOrder Placed Successfully!");
        System.out.println("Order ID: " + orderId);
        System.out.println("Item: " + itemName);
        System.out.println("Quantity: " + quantity);
    }
}

class FinalOrder extends PartialOrder {

    public void cancelOrder(int orderId) {
        if (this.orderId == orderId) {
            System.out.println("\nOrder Cancelled Successfully");
        } else {
            System.out.println("\nInvalid Order ID");
        }
    }

    public void generateBill() {
        int pricePerItem = 100;
        int total = quantity * pricePerItem;

        System.out.println("\nBill Details");
        System.out.println("Order ID: " + orderId);
        System.out.println("Item: " + itemName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Bill: Rs." + total);
    }
}

public class PR12 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        FinalOrder fo = new FinalOrder();

        System.out.print("Enter Item Name: ");
        String item = sc.nextLine();

        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        fo.placeOrder(item, qty);

        System.out.println("\n1 Generate Bill");
        System.out.println("2 Cancel Order");

        int choice = sc.nextInt();

        if (choice == 1) {
            fo.generateBill();
        } else if (choice == 2) {
            System.out.print("Enter Order ID: ");
            int id = sc.nextInt();
            fo.cancelOrder(id);
        } else {
            System.out.println("Invalid Choice");
        }

        sc.close();
    }
}

/*
OUTPUT

1)
Enter Item Name: Pizza
Enter Quantity: 2

Order Placed Successfully!
Order ID: 452
Item: Pizza
Quantity: 2

1 Generate Bill
2 Cancel Order

1

Bill Details
Order ID: 452
Item: Pizza
Quantity: 2
Total Bill: Rs.200


2)
Enter Item Name: Burger
Enter Quantity: 3

Order Placed Successfully!
Order ID: 781
Item: Burger
Quantity: 3

1 Generate Bill
2 Cancel Order

2
Enter Order ID: 781

Order Cancelled Successfully


3)
Enter Item Name: Sandwich
Enter Quantity: 1

Order Placed Successfully!
Order ID: 320
Item: Sandwich
Quantity: 1

1 Generate Bill
2 Cancel Order

5

Invalid Choice
*/
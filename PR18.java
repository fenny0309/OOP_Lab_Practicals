/*
Create a generic class Box<T> with a method addItem(T item) that stores items in an ArrayList<T>.
Demonstrate the class by:
● Creating a Box<String> for names.
● Creating a Box<Integer> for roll numbers.
● Display stored items for both.
*/

import java.util.ArrayList;
import java.util.Scanner;

class Box<T> {
    ArrayList<T> items = new ArrayList<>();

    void addItem(T item) {
        items.add(item);
    }

    void displayItems() {
        for (T item : items) {
            System.out.println(item);
        }
    }
}

public class PR18 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

       
        Box<String> nameBox = new Box<>();

        System.out.println("Enter 3 names:");
        for (int i = 0; i < 3; i++) {
            nameBox.addItem(sc.nextLine());
        }

        
        Box<Integer> rollBox = new Box<>();

        System.out.println("Enter 3 roll numbers:");
        for (int i = 0; i < 3; i++) {
            rollBox.addItem(sc.nextInt());
        }

        System.out.println("\nNames in Box:");
        nameBox.displayItems();

        System.out.println("\nRoll Numbers in Box:");
        rollBox.displayItems();

        sc.close();
    }
}

/*
Output:

Enter 3 names:
Rahul
Amit
Priya

Enter 3 roll numbers:
101
102
103

Names in Box:
Rahul
Amit
Priya

Roll Numbers in Box:
101
102
103

*/
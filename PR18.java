/*
AIM:
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

        System.out.print("Enter number of names: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        System.out.println("Enter names:");
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            nameBox.addItem(name);
        }

        
        Box<Integer> rollBox = new Box<>();

        System.out.print("\nEnter number of roll numbers: ");
        int m = sc.nextInt();

        System.out.println("Enter roll numbers:");
        for (int i = 0; i < m; i++) {
            int roll = sc.nextInt();
            rollBox.addItem(roll);
        }

        
        System.out.println("\nNames in Box:");
        nameBox.displayItems();

        
        System.out.println("\nRoll Numbers in Box:");
        rollBox.displayItems();

        sc.close();
    }
}

/*
 OUTPUT:
 
Enter number of names: 3
Enter names:
Rahul
Amit
Priya

Enter number of roll numbers: 3
Enter roll numbers:
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
/*
Write a generic method sortList(List<T> list) that sorts elements of an ArrayList<T>, where T extends
Comparable<T>. Demonstrate with:
● An ArrayList<Integer> of numbers.
● An ArrayList<String> of names.
● Display the list before and after sorting.
*/

import java.util.*;

public class PR18 {

    
    public static <T extends Comparable<T>> void sortList(List<T> list) {
        Collections.sort(list);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Integer list
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.print("Enter number of integers: ");
        int n = sc.nextInt();

        System.out.println("Enter integers:");
        for (int i = 0; i < n; i++) {
            numbers.add(sc.nextInt());
        }

        sc.nextLine(); 

        
        ArrayList<String> names = new ArrayList<>();

        System.out.print("\nEnter number of names: ");
        int m = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter names:");
        for (int i = 0; i < m; i++) {
            names.add(sc.nextLine());
        }

       
        System.out.println("\nBefore Sorting:");
        System.out.println("Numbers: " + numbers);
        System.out.println("Names: " + names);

        
        sortList(numbers);
        sortList(names);

        
        System.out.println("\nAfter Sorting:");
        System.out.println("Numbers: " + numbers);
        System.out.println("Names: " + names);

        sc.close();
    }
}

/*
Output:

Enter number of integers: 5
Enter integers:
5 2 9 1 3

Enter number of names: 3
Enter names:
Rahul
Amit
Priya

Before Sorting:
Numbers: [5, 2, 9, 1, 3]
Names: [Rahul, Amit, Priya]

After Sorting:
Numbers: [1, 2, 3, 5, 9]
Names: [Amit, Priya, Rahul]

*/
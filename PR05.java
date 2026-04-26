/* Aim:
   Create a class BankAccount with accountId (String), accountHolderName (String),
   and balance (double) as instance variables. Include methods assignValues()
   (for initialization) and displayValues(). Implement a search function that
   takes an accountId as input and, if found within an array of BankAccount
   objects, displays the details of that specific account. In main method,
   create an array of at least five BankAccount objects and demonstrate adding,
   displaying, and searching for accounts.
*/

import java.util.Scanner;

class BankAccount {
    String accountId;
    String accountHolderName;
    double balance;

   
    void assignValues(String id, String name, double bal) {
        accountId = id;
        accountHolderName = name;
        balance = bal;
    }

   
    void displayValues() {
        System.out.println("Account ID: " + accountId);
        System.out.println("Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
        System.out.println("---------------------------");
    }
}

public class PR05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        BankAccount[] accounts = new BankAccount[5];

       
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new BankAccount();

            System.out.println("\nEnter details for Account " + (i + 1));
            System.out.print("Account ID: ");
            String id = sc.next();

            sc.nextLine();
            System.out.print("Account Holder Name: ");
            String name = sc.nextLine();

            System.out.print("Balance: ");
            double bal = sc.nextDouble();

            accounts[i].assignValues(id, name, bal);
        }

        
        System.out.println("\n--- All Account Details ---");
        for (int i = 0; i < accounts.length; i++) {
            accounts[i].displayValues();
        }

       
        System.out.print("\nEnter Account ID to search: ");
        String searchId = sc.next();

        boolean found = false;

        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].accountId.equals(searchId)) {
                System.out.println("\nAccount Found:");
                accounts[i].displayValues();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Account not found.");
        }

        sc.close();
    }
}

/* Output:

Enter details for Account 1
Account ID: A101
Account Holder Name: Rahul
Balance: 5000

Enter details for Account 2
Account ID: A102
Account Holder Name: Priya
Balance: 7000

Enter details for Account 3
Account ID: A103
Account Holder Name: Amit
Balance: 6500

Enter details for Account 4
Account ID: A104
Account Holder Name: Neha
Balance: 8000

Enter details for Account 5
Account ID: A105
Account Holder Name: Karan
Balance: 9000

--- All Account Details ---
Account ID: A101
Holder Name: Rahul
Balance: 5000.0
---------------------------
Account ID: A102
Holder Name: Priya
Balance: 7000.0
---------------------------
Account ID: A103
Holder Name: Amit
Balance: 6500.0
---------------------------
Account ID: A104
Holder Name: Neha
Balance: 8000.0
---------------------------
Account ID: A105
Holder Name: Karan
Balance: 9000.0
---------------------------

Enter Account ID to search: A103

Account Found:
Account ID: A103
Holder Name: Amit
Balance: 6500.0
---------------------------
*/
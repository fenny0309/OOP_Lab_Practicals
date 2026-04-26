/* AIM:
Write a Java program to create a Banking Application using classes and exception handling.
Create a class BankAccount with:
● A constructor to initialize the balance with 1000.00.
● A method deposit(double amount) to add money to the account.

● A method withdraw(double amount) that subtracts money from the account.
● If withdrawal is more than the available balance, it should throw a custom exception called
NotSufficientFundException.
In the main method:
● Deposit 1000.00.
● Perform three withdrawals: 400.00, 300.00, and 500.00.
● The last withdrawal should throw the exception with the message "Not Sufficient Fund".
*/

class NotSufficientFundException extends Exception {
    public NotSufficientFundException(String msg) {
        super(msg);
    }
}

class BankAccount {
    private double balance;

    public BankAccount() {
        balance = 1000.00;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit: " + amount);
        System.out.println("Remaining Balance: " + balance);
        System.out.println();
    }

    public void withdraw(double amount) throws NotSufficientFundException {
        System.out.println("Withdraw Attempt: " + amount);

        if (amount > balance) {
            throw new NotSufficientFundException("Not Sufficient Fund");
        }

        balance -= amount;
        System.out.println("Withdrawn: " + amount);
        System.out.println("Remaining Balance: " + balance);
        System.out.println();
    }
}

public class PR15 {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();

        try {
            acc.deposit(0);        

            acc.withdraw(400.00);  
            acc.withdraw(300.00);  

            acc.withdraw(500.00);  

        } catch (NotSufficientFundException e) {
            System.out.println(e.getMessage());
        }
    }
}

        /*
        OUTPUT:
        Deposit: 1000.0
        Remaining Balance: 2000.0

        Withdraw Attempt: 400.0
        Withdrawn: 400.0
        Remaining Balance: 1600.0

        Withdraw Attempt: 300.0
        Withdrawn: 300.0
        Remaining Balance: 1300.0

        Withdraw Attempt: 500.0
        Not Sufficient Fund
        */
    

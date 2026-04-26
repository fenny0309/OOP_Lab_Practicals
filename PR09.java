/* Aim:
   Create a Java method isValidPassword(String password) that checks if a given
   string is a valid password based on the following rules:
   • It must have at least eight characters.
   • It must consist only of letters and digits.
   • It must contain at least two digits.
   The program should prompt the user to enter a password and display
   "Valid Password" or "Invalid Password" accordingly.
*/

import java.util.Scanner;

public class PR09 {


    public static boolean isValidPassword(String password) {

       
        if (password.length() < 8) {
            return false;
        }

        int digitCount = 0;

        
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isDigit(ch)) {
                digitCount++;
            }
            else if (!Character.isLetter(ch)) {
                return false; 
            }
        }

        
        if (digitCount < 2) {
            return false;
        }

        return true;
    }

    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        if (isValidPassword(password)) {
            System.out.println("Valid Password");
        } else {
            System.out.println("Invalid Password");
        }

        sc.close();
    }
}

/* Output Case 1:

Enter password: abc12345
Valid Password

*/

/* Output Case 2:

Enter password: abc12
Invalid Password

*/

/* Output Case 3:

Enter password: abc12@45
Invalid Password

*/
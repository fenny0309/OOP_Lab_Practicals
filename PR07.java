/* Aim:
   A bank wants to offer a facility to calculate EMI (Equated Monthly Installment)
   for different types of loans. Design a class LoanCalculator with the following
   overloaded methods:
   calculateEMI(int principal, int time, float rate): For home loans
   calculateEMI(double principal, int time, double rate): For vehicle loans
   calculateEMI(int principal, int time): For short-term personal loans with a fixed
   interest rate of 10%

   Demonstrate the use of all three methods in the main method by calculating EMIs
   for different loan types.
*/

import java.util.Scanner;

class LoanCalculator {

    void calculateEMI(int principal, int time, float rate) {
        float r = rate / (12 * 100);
        int n = time * 12;

        double emi = (principal * r * Math.pow(1 + r, n)) /
                     (Math.pow(1 + r, n) - 1);

        System.out.printf("Home Loan EMI: Rs. %.2f\n", emi);
    }

   
    void calculateEMI(double principal, int time, double rate) {
        double r = rate / (12 * 100);
        int n = time * 12;

        double emi = (principal * r * Math.pow(1 + r, n)) /
                     (Math.pow(1 + r, n) - 1);

        System.out.printf("Vehicle Loan EMI: Rs. %.2f\n", emi);
    }

  
    void calculateEMI(int principal, int time) {
        double rate = 10.0;
        double r = rate / (12 * 100);
        int n = time * 12;

        double emi = (principal * r * Math.pow(1 + r, n)) /
                     (Math.pow(1 + r, n) - 1);

        System.out.printf("Personal Loan EMI: Rs. %.2f\n", emi);
    }
}

public class PR07 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LoanCalculator obj = new LoanCalculator();

        System.out.println("Select Loan Type:");
        System.out.println("1. Home Loan");
        System.out.println("2. Vehicle Loan");
        System.out.println("3. Personal Loan");

        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                System.out.print("Enter Principal: ");
                int p1 = sc.nextInt();

                System.out.print("Enter Time (years): ");
                int t1 = sc.nextInt();

                System.out.print("Enter Rate (%): ");
                float r1 = sc.nextFloat();

                obj.calculateEMI(p1, t1, r1);
                break;

            case 2:
                System.out.print("Enter Principal: ");
                double p2 = sc.nextDouble();

                System.out.print("Enter Time (years): ");
                int t2 = sc.nextInt();

                System.out.print("Enter Rate (%): ");
                double r2 = sc.nextDouble();

                obj.calculateEMI(p2, t2, r2);
                break;

            case 3:
                System.out.print("Enter Principal: ");
                int p3 = sc.nextInt();

                System.out.print("Enter Time (years): ");
                int t3 = sc.nextInt();

                obj.calculateEMI(p3, t3);
                break;

            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
}

/* Output Case 1: Home Loan

Select Loan Type:
1. Home Loan
2. Vehicle Loan
3. Personal Loan
1
Enter Principal: 500000
Enter Time (years): 10
Enter Rate (%): 7.5
Home Loan EMI: Rs. 5935.56


Output Case 2: Vehicle Loan

Select Loan Type:
1. Home Loan
2. Vehicle Loan
3. Personal Loan
2
Enter Principal: 300000
Enter Time (years): 5
Enter Rate (%): 9
Vehicle Loan EMI: Rs. 6229.11


Output Case 3: Personal Loan

Select Loan Type:
1. Home Loan
2. Vehicle Loan
3. Personal Loan
3
Enter Principal: 100000
Enter Time (years): 2
Personal Loan EMI: Rs. 4614.49

*/
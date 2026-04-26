/* Aim:
   Create a Java class named University with a static data member totalStudents
   to keep track of the number of student objects created. Implement a static
   method getTotalStudents(). Also include a static block to initialize a static
   variable universityName and an instance block to print a message when an
   object is created. Demonstrate execution order.
*/

class University {

   
    static String universityName;

  
    static int totalStudents;

    String studentName;


    static {
        universityName = "Gujarat Technological University";
        totalStudents = 0;
        System.out.println("Static block executed: University initialized.");
    }


    {
        System.out.println("Instance block executed: Preparing to create student object.");
    }

 
    University(String name) {
        this.studentName = name;
        totalStudents++;
        System.out.println("Constructor executed: Student " + name + " created.");
    }

  
    static int getTotalStudents() {
        return totalStudents;
    }
}


public class PR08 {
    public static void main(String[] args) {

        System.out.println("Main method started.\n");

        University s1 = new University("Riya");
        University s2 = new University("Jiya");

        System.out.println("\nTotal Students: " + University.getTotalStudents());
        System.out.println("University Name: " + University.universityName);
    }
}

/* Output:

Static block executed: University initialized.
Main method started.

Instance block executed: Preparing to create student object.
Constructor executed: Student Riya created.
Instance block executed: Preparing to create student object.
Constructor executed: Student Jiya created.

Total Students: 2
University Name: Gujarat Technological University

*/
/* Aim:
   Design a class Time with hours (int) and minutes (int) as data members.
   Include method setTime(int h, int m) to initialize the time and displayTime() to display the time.
   Implement a method addTime(Time t1, Time t2) that takes two Time objects as arguments, adds their
   hours and minutes, and stores the result in the calling object.
   Do not use constructors for initialization in this specific practical.
*/

import java.util.Scanner;

class Time {
    int hours, minutes;

    void setTime(int h, int m) {
        hours = h;
        minutes = m;
    }

    void displayTime() {
        System.out.println(hours + " hours " + minutes + " minutes");
    }

    void addTime(Time t1, Time t2) {
        this.minutes = t1.minutes + t2.minutes;
        this.hours = t1.hours + t2.hours;

        if (this.minutes >= 60) {
            this.hours += this.minutes / 60;
            this.minutes = this.minutes % 60;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Time t1 = new Time();
        Time t2 = new Time();
        Time result = new Time();

        System.out.print("Enter hours and minutes for Time 1: ");
        t1.setTime(sc.nextInt(), sc.nextInt());

        System.out.print("Enter hours and minutes for Time 2: ");
        t2.setTime(sc.nextInt(), sc.nextInt());

        result.addTime(t1, t2);

        System.out.println("\nTime 1:");
        t1.displayTime();

        System.out.println("Time 2:");
        t2.displayTime();

        System.out.println("Added Time:");
        result.displayTime();

        sc.close();
    }
}

/* Output:
Enter hours and minutes for Time 1: 2 50
Enter hours and minutes for Time 2: 3 30

Time 1:
2 hours 50 minutes
Time 2:
3 hours 30 minutes
Added Time:
6 hours 20 minutes
*/
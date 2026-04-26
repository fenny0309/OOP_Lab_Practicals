/* Create a base class named Vehicle that contains common attributes such as vehicleNumber, brand, and
fuelType. Include a constructor to initialize these fields and a method displayDetails() to print them.
Derive a subclass Car from Vehicle which adds attributes such as numberOfSeats and ACavailable
(boolean). Override the displayDetails() method to include the car-specific details, and use the super
keyword to invoke the parent class constructor and methods. Further, derive another subclass
ElectricCar from Car that includes attributes such as batteryCapacity and chargingTime, and again
override the displayDetails() method to include electric car-specific details. Demonstrate constructor
chaining, method overriding, use of protected access specifier for inherited members, and instanceof
operator to check object type at runtime. In the main() method, create objects of all three classes and
display their details using overridden methods. Also, use upcasting (Vehicle
*/

import java.util.Scanner;


class Vehicle {
    protected String vehicleNumber;
    protected String brand;
    protected String fuelType;

    public Vehicle(String vehicleNumber, String brand, String fuelType) {
        this.vehicleNumber = vehicleNumber;
        this.brand = brand;
        this.fuelType = fuelType;
    }

    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Brand: " + brand);
        System.out.println("Fuel Type: " + fuelType);
    }
}


class Car extends Vehicle {
    protected int numberOfSeats;
    protected boolean ACavailable;

    public Car(String vehicleNumber, String brand, String fuelType,
               int numberOfSeats, boolean ACavailable) {
        super(vehicleNumber, brand, fuelType);
        this.numberOfSeats = numberOfSeats;
        this.ACavailable = ACavailable;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Seats: " + numberOfSeats);
        System.out.println("AC Available: " + ACavailable);
    }
}


class ElectricCar extends Car {
    private double batteryCapacity;
    private double chargingTime;

    public ElectricCar(String vehicleNumber, String brand, String fuelType,
                       int numberOfSeats, boolean ACavailable,
                       double batteryCapacity, double chargingTime) {
        super(vehicleNumber, brand, fuelType, numberOfSeats, ACavailable);
        this.batteryCapacity = batteryCapacity;
        this.chargingTime = chargingTime;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
        System.out.println("Charging Time: " + chargingTime + " hours");
    }
}


public class PR10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Vehicle Details:");
        System.out.print("Vehicle Number: ");
        String vNo = sc.nextLine();

        System.out.print("Brand: ");
        String brand = sc.nextLine();

        System.out.print("Fuel Type: ");
        String fuel = sc.nextLine();

        System.out.println("\nEnter Car Details:");
        System.out.print("Number of Seats: ");
        int seats = sc.nextInt();

        System.out.print("AC Available (true/false): ");
        boolean ac = sc.nextBoolean();

        System.out.println("\nEnter Electric Car Details:");
        System.out.print("Battery Capacity (kWh): ");
        double battery = sc.nextDouble();

        System.out.print("Charging Time (hours): ");
        double chargeTime = sc.nextDouble();

        Vehicle v1 = new Vehicle(vNo, brand, fuel);
        Car c1 = new Car(vNo, brand, fuel, seats, ac);
        ElectricCar e1 = new ElectricCar(vNo, brand, fuel, seats, ac, battery, chargeTime);

        System.out.println("\n===== Vehicle Object =====");
        v1.displayDetails();

        System.out.println("\n===== Car Object (Upcasting) =====");
        Vehicle v2 = new Car(vNo, brand, fuel, seats, ac);
        v2.displayDetails();

        System.out.println("\n===== Electric Car Object (Upcasting) =====");
        Vehicle v3 = new ElectricCar(vNo, brand, fuel, seats, ac, battery, chargeTime);
        v3.displayDetails();

        System.out.println("\n===== Runtime Type Checking =====");
        if (v3 instanceof ElectricCar) {
            ElectricCar ec = (ElectricCar) v3;
            System.out.println("Downcasting successful (ElectricCar detected)");
            ec.displayDetails();
        }

        sc.close();
    }
}

/*
Output:

Enter Vehicle Details:
Vehicle Number: GJ05AB1234
Brand: Tata
Fuel Type: Petrol

Enter Car Details:
Number of Seats: 5
AC Available (true/false): true

Enter Electric Car Details:
Battery Capacity (kWh): 40
Charging Time (hours): 6

===== Vehicle Object =====
Vehicle Number: GJ05AB1234
Brand: Tata
Fuel Type: Petrol

===== Car Object (Upcasting) =====
Vehicle Number: GJ05AB1234
Brand: Tata
Fuel Type: Petrol
Number of Seats: 5
AC Available: true

===== Electric Car Object (Upcasting) =====
Vehicle Number: GJ05AB1234
Brand: Tata
Fuel Type: Petrol
Number of Seats: 5
AC Available: true
Battery Capacity: 40.0 kWh
Charging Time: 6.0 hours

===== Runtime Type Checking =====
Downcasting successful (ElectricCar detected)
Vehicle Number: GJ05AB1234
Brand: Tata
Fuel Type: Petrol
Number of Seats: 5
AC Available: true
Battery Capacity: 40.0 kWh
Charging Time: 6.0 hours
*/
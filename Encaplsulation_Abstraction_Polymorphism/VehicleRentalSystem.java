import java.util.ArrayList;
import java.util.List;

// Abstraction & Encapsulation
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    // Abstraction
    public abstract double calculateRentalCost(int days);

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Encapsulation
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    // Concrete method 
    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate per day: $" + String.format("%.2f", rentalRate));
    }
}

// Abstraction
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Inheritance & Abstraction
class Car extends Vehicle implements Insurable {
    private double insurancePolicyCost;
    private int days;

    public Car(String vehicleNumber, double rentalRate, double insurancePolicyCost) {
        super(vehicleNumber, "Car", rentalRate);
        this.insurancePolicyCost = insurancePolicyCost;
    }

    // Abstraction
    @Override
    public double calculateRentalCost(int days) {
        this.days = days;
        return getRentalRate() * days;
    }

    // Abstraction
    @Override
    public double calculateInsurance() {
        return insurancePolicyCost / 30 * days;
    }

    @Override
    public String getInsuranceDetails() {
        return "Comprehensive Insurance (Daily): $" + String.format("%.2f", calculateInsurance());
    }
}

// Inheritance & Abstraction
class Bike extends Vehicle {
    private static final double DISCOUNT_RATE = 0.10;

    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    // Abstraction
    @Override
    public double calculateRentalCost(int days) {
        return (getRentalRate() * (1 - DISCOUNT_RATE)) * days;
    }
}

// Inheritance & Abstraction
class Truck extends Vehicle implements Insurable {
    private double cargoFeePerDay;
    private double insurancePolicyCost;
    private int days;

    public Truck(String vehicleNumber, double rentalRate, double cargoFeePerDay, double insurancePolicyCost) {
        super(vehicleNumber, "Truck", rentalRate);
        this.cargoFeePerDay = cargoFeePerDay;
        this.insurancePolicyCost = insurancePolicyCost;
    }

    // Abstraction
    @Override
    public double calculateRentalCost(int days) {
        this.days = days;
        return (getRentalRate() + cargoFeePerDay) * days;
    }

    // Abstraction
    @Override
    public double calculateInsurance() {
        
        return insurancePolicyCost / 30 * days;
    }

    @Override
    public String getInsuranceDetails() {
        return "Heavy-Duty Insurance (Daily): $" + String.format("%.2f", calculateInsurance());
    }
}


public class VehicleRentalSystem {
    public static void main(String[] args) {
        // Polymorphism
        List<Vehicle> vehicles = new ArrayList<>();

        // Creating instances of concrete classes
        Car sedan = new Car("C-1234", 75.00, 150.00);
        Bike cruiser = new Bike("B-5678", 30.00);
        Truck semiTruck = new Truck("T-9012", 150.00, 25.00, 300.00);

        
        vehicles.add(sedan);
        vehicles.add(cruiser);
        vehicles.add(semiTruck);

        int rentalDays = 7;

        System.out.println("--- Vehicle Rental Breakdown (" + rentalDays + " days) ---");
        // Polymorphism
        for (Vehicle vehicle : vehicles) {
            vehicle.displayDetails();
            double totalRentalCost = vehicle.calculateRentalCost(rentalDays);
            System.out.println("Total Rental Cost: $" + String.format("%.2f", totalRentalCost));

            // Polymorphism 
            if (vehicle instanceof Insurable) {
                Insurable insurableVehicle = (Insurable) vehicle;
                double insuranceCost = insurableVehicle.calculateInsurance();
                System.out.println(insurableVehicle.getInsuranceDetails());
                System.out.println("Grand Total (Rental + Insurance): $" + String.format("%.2f", totalRentalCost + insuranceCost));
            }

            System.out.println("----------------------------------------");
        }
    }
}
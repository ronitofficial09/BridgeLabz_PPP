import java.util.ArrayList;
import java.util.List;

// Abstraction & Encapsulation
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    // Abstraction
    public abstract double calculateFare(double distance);

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Concrete method for vehicle details
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
    }
    
    // Encapsulation
    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }
}

// Abstraction
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Inheritance & Abstraction
class Car extends Vehicle implements GPS {
    private String currentLocation;

    public Car(String vehicleId, String driverName, double ratePerKm, String initialLocation) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = initialLocation;
    }

    // Abstraction
    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    // Abstraction
    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
        System.out.println("Car " + getVehicleId() + " location updated to " + newLocation);
    }

    @Override
    public void getVehicleDetails() {
        super.getVehicleDetails();
        System.out.println("Type: Car");
    }
}

// Inheritance & Abstraction
class Bike extends Vehicle implements GPS {
    private static final double MINIMUM_FARE = 50.0;
    private String currentLocation;

    public Bike(String vehicleId, String driverName, double ratePerKm, String initialLocation) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = initialLocation;
    }

    // Abstraction
    @Override
    public double calculateFare(double distance) {
        double fare = getRatePerKm() * distance;
        return Math.max(fare, MINIMUM_FARE); // Ensures minimum fare
    }

    // Abstraction
    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
        System.out.println("Bike " + getVehicleId() + " location updated to " + newLocation);
    }
    
    @Override
    public void getVehicleDetails() {
        super.getVehicleDetails();
        System.out.println("Type: Bike");
    }
}

// Inheritance & Abstraction
class Auto extends Vehicle {
    private static final double FIXED_SURCHARGE = 20.0;

    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    // Abstraction
    @Override
    public double calculateFare(double distance) {
        return (getRatePerKm() * distance) + FIXED_SURCHARGE;
    }
    
    @Override
    public void getVehicleDetails() {
        super.getVehicleDetails();
        System.out.println("Type: Auto");
    }
}

// Main class to demonstrate the ride-hailing system
public class RideHailingApplication {
    public static void main(String[] args) {
        // Polymorphism
        List<Vehicle> vehicles = new ArrayList<>();

        // Creating instances of concrete classes
        Car sedan = new Car("C-1234", "Alice", 12.50, "Central Park");
        Bike scooter = new Bike("B-5678", "Bob", 8.00, "Downtown");
        Auto rickshaw = new Auto("A-9012", "Charlie", 10.00);

        // Adding vehicles to the list
        vehicles.add(sedan);
        vehicles.add(scooter);
        vehicles.add(rickshaw);

        double distance = 10.0; // Distance of the ride in km

        System.out.println("--- Ride Fare Calculation for a " + distance + " km ride ---");
        // Polymorphism
        for (Vehicle vehicle : vehicles) {
            vehicle.getVehicleDetails();
            double fare = vehicle.calculateFare(distance);
            System.out.println("Calculated Fare: $" + String.format("%.2f", fare));

            // Polymorphism with the GPS interface
            if (vehicle instanceof GPS) {
                GPS gpsVehicle = (GPS) vehicle;
                System.out.println("Current Location: " + gpsVehicle.getCurrentLocation());
            }

            System.out.println("----------------------------------------");
        }
        
        System.out.println("--- Updating Vehicle Locations ---");
        sedan.updateLocation("Midtown");
        scooter.updateLocation("Uptown");
    }
}
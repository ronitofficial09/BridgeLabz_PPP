import java.util.ArrayList;
import java.util.List;

// Interface for Department
interface Department {
    void assignDepartment(String departmentName);
    String getDepartmentDetails();
}


abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;


    public abstract double calculateSalary();

 
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }


    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
    }

    // Encapsulation: Getter methods
    public int getEmployeeId() {
        return employeeId;
    }
    public String getName() {
        return name;
    }
    public double getBaseSalary() {
        return baseSalary;
    }
}

// FullTimeEmployee 
class FullTimeEmployee extends Employee implements Department {
    private double bonus;
    private String departmentName; 

    public FullTimeEmployee(int employeeId, String name, double baseSalary, double bonus) {
        super(employeeId, name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Bonus: " + bonus);
    }

    // Implementation of Department interface methods
    @Override
    public void assignDepartment(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String getDepartmentDetails() {
        return this.departmentName;
    }
}

// PartTimeEmployee
class PartTimeEmployee extends Employee implements Department {
    private int hoursWorked;
    private double hourlyRate;
    private String departmentName; 

    public PartTimeEmployee(int employeeId, String name, double baseSalary, int hoursWorked, double hourlyRate) {
        super(employeeId, name, baseSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + (hoursWorked * hourlyRate);
    }

    // Implementation of Department interface methods
    @Override
    public void assignDepartment(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String getDepartmentDetails() {
        return this.departmentName;
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        // Polymorphism: 
        List<Employee> employees = new ArrayList<>();

        // Creating instances of subclasses
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(101, "Alice", 50000, 10000);
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee(201, "Bob", 20000, 80, 25);
        assignDepartmentAndDisplay(fullTimeEmployee, "Engineering");
        assignDepartmentAndDisplay(partTimeEmployee, "Marketing");
        
        employees.add(fullTimeEmployee);
        employees.add(partTimeEmployee);
        
        System.out.println("\n--- Processing all employees ---");
        // Polymorphism: 
        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println("Calculated Salary: " + emp.calculateSalary());
            System.out.println("---------------------------------");
        }
    }
    
    private static void assignDepartmentAndDisplay(Employee emp, String department) {
        if (emp instanceof Department) {
            Department deptEmp = (Department) emp;
            deptEmp.assignDepartment(department);
            System.out.println(emp.getName() + " assigned to department: " + deptEmp.getDepartmentDetails());
        }
    }
}

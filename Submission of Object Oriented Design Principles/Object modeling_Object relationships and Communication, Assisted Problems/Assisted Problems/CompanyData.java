import java.util.ArrayList;

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Department {
    private String deptName;
    private ArrayList<Employee> employees;

    public Department(String deptName) {
        this.deptName = deptName;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    public void showEmployees() {
        System.out.println("Department: " + deptName);
        for (Employee e : employees) {
            System.out.println(" - " + e.getName());
        }
    }
}

class Company {
    private String companyName;
    private ArrayList<Department> departments;

    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department dept) {
        departments.add(dept);
    }

    public void showDepartments() {
        System.out.println("Company: " + companyName);
        for (Department d : departments) {
            d.showEmployees();
        }
    }
}

public class CompanyData {
    public static void main(String[] args) {
        Company company = new Company("Google");

        Department d1 = new Department("IT");
        d1.addEmployee(new Employee("Alice"));
        d1.addEmployee(new Employee("Bob"));

        Department d2 = new Department("HR");
        d2.addEmployee(new Employee("Charlie"));

        company.addDepartment(d1);
        company.addDepartment(d2);

        company.showDepartments();
    }
}

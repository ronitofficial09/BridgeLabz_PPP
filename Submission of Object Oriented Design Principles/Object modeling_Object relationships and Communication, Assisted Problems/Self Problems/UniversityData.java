import java.util.*;

class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Department {
    private String deptName;

    public Department(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptName() {
        return deptName;
    }
}

class University {
    private String uniName;
    private List<Department> departments;
    private List<Faculty> faculties;

    public University(String uniName) {
        this.uniName = uniName;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    public void addDepartment(Department dept) {
        departments.add(dept);
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void showStructure() {
        System.out.println("University: " + uniName);
        System.out.println("Departments:");
        for (Department d : departments) {
            System.out.println(" - " + d.getDeptName());
        }
        System.out.println("Faculties:");
        for (Faculty f : faculties) {
            System.out.println(" - " + f.getName());
        }
    }
}

public class UniversityData {
    public static void main(String[] args) {
        University uni = new University("GLA University");

        Department d1 = new Department("Computer Science");
        Department d2 = new Department("Physics");

        Faculty f1 = new Faculty("Mr. Akash Gupta");
        Faculty f2 = new Faculty("Ms. Kajal Wankhede");

        uni.addDepartment(d1);
        uni.addDepartment(d2);

        uni.addFaculty(f1);
        uni.addFaculty(f2);

        uni.showStructure();
    }
}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Teacher extends Person {
    String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    void displayRole() {
        System.out.println(name + " is a Teacher of " + subject);
    }
}

class Student extends Person {
    String grade;

    Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    void displayRole() {
        System.out.println(name + " is a Student in grade " + grade);
    }
}

class Staff extends Person {
    String role;

    Staff(String name, int age, String role) {
        super(name, age);
        this.role = role;
    }

    void displayRole() {
        System.out.println(name + " works as " + role);
    }
}

public class SchoolDemo {
    public static void main(String[] args) {
        Teacher t = new Teacher("Mr. John", 40, "Math");
        Student s = new Student("Alice", 15, "10th");
        Staff st = new Staff("Mark", 35, "Clerk");

        t.displayRole();
        s.displayRole();
        st.displayRole();
    }
}

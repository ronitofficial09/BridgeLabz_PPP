import java.util.*;

class Course {
    private String courseName;
    private Professor professor;
    private List<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
        System.out.println("Professor " + professor.getName() + " assigned to " + courseName);
    }

    public void enrollStudent(Student student) {
        students.add(student);
        System.out.println("Student " + student.getName() + " enrolled in " + courseName);
    }

    public void showDetails() {
        System.out.println("Course: " + courseName);
        if (professor != null) {
            System.out.println("Professor: " + professor.getName());
        }
        System.out.println("Students:");
        for (Student s : students) {
            System.out.println(" - " + s.getName());
        }
    }

    public String getCourseName() { return courseName; }
}

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public void enrollCourse(Course course) {
        course.enrollStudent(this);
    }
}

class Professor {
    private String name;

    public Professor(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public void assignCourse(Course course) {
        course.assignProfessor(this);
    }
}

public class UniversityManagementData {
    public static void main(String[] args) {
        Student s1 = new Student("Rinku");
        Student s2 = new Student("Bablu");

        Professor p1 = new Professor("Dr. Bawandar");

        Course c1 = new Course("Data Structures");

        p1.assignCourse(c1);
        s1.enrollCourse(c1);
        s2.enrollCourse(c1);

        c1.showDetails();
    }
}

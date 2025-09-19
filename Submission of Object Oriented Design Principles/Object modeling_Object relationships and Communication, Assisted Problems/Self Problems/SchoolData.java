import java.util.*;

class Course {
    private String courseName;
    private List<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public void enrollStudent(Student student) {
        students.add(student);
    }

    public void showStudents() {
        System.out.println("Course: " + courseName);
        for (Student s : students) {
            System.out.println(" - " + s.getName());
        }
    }

    public String getCourseName() {
        return courseName;
    }
}

class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void enroll(Course course) {
        courses.add(course);
        course.enrollStudent(this);
    }

    public void showCourses() {
        System.out.println("Student: " + name);
        for (Course c : courses) {
            System.out.println(" - " + c.getCourseName());
        }
    }

    public String getName() {
        return name;
    }
}

class School {
    private String schoolName;
    private List<Student> students;

    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void showStudents() {
        System.out.println("School: " + schoolName);
        for (Student s : students) {
            System.out.println(" - " + s.getName());
        }
    }
}

public class SchoolData {
    public static void main(String[] args) {
        School school = new School("Sarkaari School");

        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");

        Course c1 = new Course("Math");
        Course c2 = new Course("Science");

        school.addStudent(s1);
        school.addStudent(s2);

        s1.enroll(c1);
        s1.enroll(c2);
        s2.enroll(c2);

        school.showStudents();
        s1.showCourses();
        s2.showCourses();
        c1.showStudents();
        c2.showStudents();
    }
}

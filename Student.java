public class Student extends Person {

    int studentId;
    String course;

    // Constructor
    Student(String name, int age, int studentId, String course) {
        super(name, age); // Calls the Person constructor
        this.studentId = studentId;
        this.course = course;
    }

    // Method Overriding
    @Override
    void display() {
        super.display(); // Displays name and age
        System.out.println("Student ID : " + studentId);
        System.out.println("Course : " + course);
    }
}
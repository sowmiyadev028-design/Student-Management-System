import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        try {
            File file = new File("students.txt");

            if (file.exists()) {

                Scanner fileReader = new Scanner(file);

                while (fileReader.hasNextLine()) {

                    String line = fileReader.nextLine();

                    String[] data = line.split(",");

                    String name = data[0];
                    int age = Integer.parseInt(data[1]);
                    int id = Integer.parseInt(data[2]);
                    String course = data[3];

                    students.add(new Student(name, age, id, course));
                }

                fileReader.close();

            }

        } catch (FileNotFoundException e) {

            System.out.println("File Not Found!");

        }

        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Save Students");
            System.out.println("7. Exit");

            try {

                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine();

            } catch (InputMismatchException e) {

                System.out.println("Please enter numbers only!");

                sc.nextLine(); // Clear invalid input
                choice = 0;
            }

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    students.add(new Student(name, age, id, course));

                    System.out.println("Student Added Successfully!");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No Students Found!");
                    } else {
                        System.out.println("\n===== Student List =====");
                        for (Student s : students) {
                            s.display();
                            System.out.println("-------------------");
                        }
                    }
                    break;
                case 3:

                    System.out.print("Enter Student ID to Search: ");
                    int searchId = sc.nextInt();

                    boolean found = false;

                    for (Student s : students) {
                        if (s.studentId == searchId) {
                            System.out.println("\nStudent Found!");
                            s.display();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student Not Found!");
                    }

                    break;
                case 4:

                    System.out.print("Enter Student ID to Update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    boolean updated = false;

                    for (Student s : students) {

                        if (s.studentId == updateId) {

                            System.out.print("Enter New Name: ");
                            s.name = sc.nextLine();

                            System.out.print("Enter New Age: ");
                            s.age = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter New Course: ");
                            s.course = sc.nextLine();

                            System.out.println("Student Updated Successfully!");

                            updated = true;
                            break;
                        }
                    }

                    if (!updated) {
                        System.out.println("Student Not Found!");
                    }

                    break;
                case 5:

                    System.out.print("Enter Student ID to Delete: ");
                    int deleteId = sc.nextInt();

                    boolean deleted = false;

                    for (int i = 0; i < students.size(); i++) {

                        if (students.get(i).studentId == deleteId) {

                            students.remove(i);

                            System.out.println("Student Deleted Successfully!");

                            deleted = true;
                            break;
                        }
                    }

                    if (!deleted) {
                        System.out.println("Student Not Found!");
                    }

                    break;
                case 6:

                    try {

                        FileWriter writer = new FileWriter("students.txt");

                        for (Student s : students) {

                            writer.write(
                                    s.name + "," +
                                            s.age + "," +
                                            s.studentId + "," +
                                            s.course + "\n");
                        }

                        writer.close();

                        System.out.println("Students Saved Successfully!");

                    } catch (IOException e) {

                        System.out.println("Error Saving File!");

                    }

                    break;

                case 7:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}
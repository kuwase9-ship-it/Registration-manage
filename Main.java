import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        RegistryManager manager = new RegistryManager();

    File file = new File("C:\\Users\\derri\\Documents\\Management\\Student.txt");
        manager.loadStudentsFromFile(file.getAbsolutePath());

        int choice;

     do {
            System.out.println("\nUNIVERSITY REGISTRATION SYSTEM ");
           System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Group Students by Major");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter GPA: ");
                    double gpa = scanner.nextDouble();
                    scanner.nextLine();

            System.out.println("Enter major: ");
                    String major = scanner.nextLine();

                Student student = new Student(id, name, gpa, major);

manager.addStudent(student);

manager.saveStudentToFile(
    student,
    "C:\\Users\\derri\\Documents\\Management\\Student.txt"
);    
                    break;
                case 2:
                    manager.displayAllStudents();
                    break;
                case 3:
                    manager.groupStudentsByMajor();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        scanner.close();
    }
}
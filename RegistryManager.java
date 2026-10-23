import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
public class RegistryManager {

    private List<Student> students = new ArrayList<>();

    public void loadStudentsFromFile(String fileName) {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;

         while ((line = reader.readLine()) != null) {

    String[] data = line.split(",");
        int id = Integer.parseInt(data[0].trim());
            String name = data[1].trim();
                double gpa = Double.parseDouble(data[2].trim());
            String major = data[3].trim();

              Student student = new Student(id, name, gpa, major);
                students.add(student);
            }

    System.out.println("Students loaded successfully!");

        }
         catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } 
    catch (NumberFormatException e) {
            System.out.println("Invalid number in student file: " + e.getMessage());
        }
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void groupStudentsByMajor() {
    Map<String, List<String>> groupedStudents = new HashMap<>();

    for (Student student : students) {
        groupedStudents
            .computeIfAbsent(student.getMajor(), major -> new ArrayList<>())
            .add(student.getName());
    }

    System.out.println("Students grouped by major:");

    for (String major : groupedStudents.keySet()) {
        System.out.println(major + ": " + groupedStudents.get(major));
    }
    }
    public void addStudent(Student student) {
    students.add(student);
    System.out.println("Student registered successfully!");
}
public void saveStudentToFile(Student student, String fileName) {
    try (BufferedWriter writer = new BufferedWriter(
            new FileWriter(fileName, true))) {

        writer.write(student.getId() + ", "
                + student.getName() + ", "
                + student.getGpa() + ", "
                + student.getMajor());

        writer.newLine();

        System.out.println("Student saved to file successfully!");

    } catch (IOException e) {
        System.out.println("Error writing to file: " + e.getMessage());
    }
}
}
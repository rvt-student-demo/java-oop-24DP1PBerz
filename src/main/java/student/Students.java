package student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Students {
    String filePath = "data/students.csv";
    private ArrayList<Student> students = new ArrayList<>();
    public ArrayList<Student> getStudents() {
        
        try (Scanner reader = new Scanner(new File(filePath))) {
            reader.nextLine();

            while (reader.hasNextLine()) {
                String[] row = reader.nextLine().split(",");
                Student student = new Student(row[0], row[1], row[2], row[3], row[4]);
                students.add(student);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return students;
    }
}

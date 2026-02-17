package student;

import java.io.FileWriter;
import java.util.ArrayList;


public class Remove {
    private Students studentsList;
    String filePath = "data/students.csv";                          
    ArrayList<Student> students;    

    public void remove(String personCode) {
        studentsList = new Students();
        students = studentsList.getStudents();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getPersonalCode().equals(personCode)) {
                students.remove(i);
                System.out.println("Students tika dzests.");
                save();
                return;
            }
        }
        System.out.println("Tads students neeksiste.");
    }

    private void save() {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Vards,Uzvards,E-pasts,Personal kods,laiks un datums");
            writer.write(System.lineSeparator());
            for (Student student : students) {
                writer.write(student.toCsv());
                writer.write(System.lineSeparator());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

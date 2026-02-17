package student;

import java.util.ArrayList;

public class Show { 
    private Students studentsList;

    public void show() {  
        studentsList = new Students();
        ArrayList<Student> students = studentsList.getStudents();
        String line = "+" + "-".repeat(20) + "+" + "-".repeat(20) + "+" + "-".repeat(30) + "+" + "-".repeat(15) + "+" + "-".repeat(20) + "+";

        System.out.println(line);
        System.out.printf("|%-20s|%-20s|%-30s|%-15s|%-20s|%n", "Vards", "Uzvards", "E-pasts", "Personal kods", "Laiks un datums");
        System.out.println(line);

        for(Student student: students) {
            System.out.printf("|%-20s|%-20s|%-30s|%-15s|%-20s|%n", student.getFirstName(), student.getLastName(), student.getEmail(), student.getPersonalCode(), student.getDateTime());
        }

        System.out.println(line);
    
    }
}

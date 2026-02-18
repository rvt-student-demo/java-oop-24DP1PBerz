package student;

import java.util.ArrayList;

import rvt.utils.ColorEnum;

public class Show { 
    private Students studentsList;

    public void show() {  
        studentsList = new Students();
        ArrayList<Student> students = studentsList.getStudents();
        String line = "+" + "-".repeat(20) + "+" + "-".repeat(20) + "+" + "-".repeat(30) + "+" + "-".repeat(15) + "+" + "-".repeat(20) + "+";

        System.out.println(line);
        System.out.printf("|%-20s|%-20s|%-30s|%-15s|%-20s|%n", 
        ColorEnum.GREEN.colorCode + "Vards" + ColorEnum.RESET.colorCode,
            ColorEnum.YELLOW.colorCode + "Uzvards" + ColorEnum.RESET.colorCode,
            ColorEnum.BLUE.colorCode + "E-pasts" + ColorEnum.RESET.colorCode, 
            ColorEnum.RED.colorCode + "Personal kods" + ColorEnum.RESET.colorCode, 
            ColorEnum.PURPLE.colorCode + "Laiks un datums" + ColorEnum.RESET.colorCode);
        System.out.println(line);

        for(Student student: students) {
            System.out.printf("|%-20s|%-20s|%-30s|%-15s|%-20s|%n", 
            ColorEnum.GREEN.colorCode + student.getFirstName() + ColorEnum.RESET.colorCode, 
            ColorEnum.YELLOW.colorCode + student.getLastName() + ColorEnum.RESET.colorCode, 
            ColorEnum.BLUE.colorCode + student.getEmail() + ColorEnum.RESET.colorCode, 
            ColorEnum.RED.colorCode + student.getPersonalCode() + ColorEnum.RESET.colorCode, 
            ColorEnum.PURPLE.colorCode + student.getDateTime() + ColorEnum.RESET.colorCode);
        }

        System.out.println(line);
    
    }
}

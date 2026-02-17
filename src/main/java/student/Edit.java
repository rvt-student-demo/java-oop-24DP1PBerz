package student;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Edit {
    private Students studentsList;
    private final String filePath = "data/students.csv";
    ArrayList<Student> students;    
    Scanner scanner;    
    Requirements checker;

    public Edit() {
        scanner = new Scanner(System.in);
        checker = new Requirements();
    }

    private int searchStudent(String code) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getPersonalCode().equals(code)) {
                return i;
            }
        }
        return -1;
    }

    public void edit() {
        studentsList = new Students();
        students = studentsList.getStudents();
        System.out.print("Ievadi personal kodu: ");
        String code = scanner.nextLine();
        if (checker.checkEventStringPersonalCode(code)) {
            if (searchStudent(code) != -1) {
                String firstName;
                String lastName;
                String email;

                while (true) {
                    System.out.print("Ievadi vardu:");
                    firstName = scanner.nextLine();

                    if (checker.checkEventStringName(firstName)) {
                        break;
                    }
                    System.out.print("Vards nav korekts. Megini velreiz.");
                }

                while (true) {
                    System.out.print("Ievadi uzvardu:");
                    lastName = scanner.nextLine();

                    if (checker.checkEventStringName(lastName)) {
                        break;
                    }
                    System.out.print("Uzvards nav korekts. Megini velreiz.");
                }

                while (true) {
                    System.out.print("Ievadi e-pastu:");
                    email = scanner.nextLine();

                    if (checker.checkEventStringEmail(email)) {
                        break;
                    }
                    System.out.print("E-pasts nav korekts. Megini velreiz.");
                }

                students.get(searchStudent(code)).editStudent(firstName, lastName, email);

            } else {
                System.out.println("Tads student neeksiste.");
            }
        } else {
            System.out.println("Nepareizi ierakstits personal kods.");
        }
        save();
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

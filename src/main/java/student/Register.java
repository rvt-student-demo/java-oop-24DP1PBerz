package student;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Register {
    private final ArrayList<String> students;
    private final String filePath = "data/students.csv";
    private final Requirements requirements;

    public Register() {
        this.students = new ArrayList<>();
        this.requirements = new Requirements();
        loadFromFile();
    }

    private void loadFromFile() {
        students.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                students.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }


    private boolean personalCodeExists(String personalCode) {
        for (String line : students) {
            if (line == null || line.isBlank()) continue;


            if (line.startsWith("Vards,")) continue;

            String[] parts = line.split(",");
            if (parts.length >= 4) {
                if (parts[3].trim().equals(personalCode)) {
                    return true;
                }
            }
        }
        return false;
    }


    public void register(Scanner scanner) {
        loadFromFile();

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatdate = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String formattedDate = date.format(formatdate);

        String name = "";
        String surname = "";
        String email = "";
        String personalCode = "";

        while (true) {
            System.out.print("Studenta vards: ");
            name = scanner.nextLine().trim();

            if (requirements.checkEventStringName(name)) break;

            System.out.println("Neder vārds.");
            System.out.println();
        }


        while (true) {
            System.out.print("Studenta uzvards: ");
            surname = scanner.nextLine().trim();

            if (requirements.checkEventStringName(surname)) break;

            System.out.println("Neder uzvārds.");
            System.out.println();
        }


        while (true) {
            System.out.print("Studenta e-pasts: ");
            email = scanner.nextLine().trim();

            if (!requirements.checkEventStringEmail(email)) {
                System.out.println("Neder e-pasts.");
                System.out.println();
                continue;
            }

            break;
        }


        while (true) {
            System.out.print("Studenta personas kods: ");
            personalCode = scanner.nextLine().trim();

            if (!requirements.checkEventStringPersonalCode(personalCode)) {
                System.out.println("Neder personas kods.");
                System.out.println();
                continue;
            }

            if (personalCodeExists(personalCode)) {
                System.out.println("Students ar šādu personas kodu jau eksistē!");
                System.out.println();
                continue;
            }

            break;
        }

        String newLine = name + "," + surname + "," + email + "," + personalCode + "," + formattedDate;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            
            if (students.isEmpty()) {
                bw.write("Vards,Uzvards,E-pasts,Personal kods,laiks un datums");
                bw.newLine();
            }

            bw.write(newLine);
            bw.newLine();

            
            students.add(newLine);

            System.out.println("Students veiksmīgi pievienots!");
        } catch (IOException ioe) {
            System.out.println("Error writing file: " + ioe.getMessage());
        }
    }

    public void print() {
        for (String s : students) {
            System.out.println(s);
        }
    }

    public ArrayList<String> getStudents() {
        return students;
    }
}

package student;


import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import student.Remove;

public class Register {
    private ArrayList<String> students;
    private final String filePath="src/main/java/student/students.csv";
    private Requirements requirements;
    private Remove remove;
    


    public Register(){
        this.students = new ArrayList<>();
        this.requirements = new Requirements();
        this.remove = new Remove(this);
        loadFromFile();
    }

    public void remove(String personalCode){
        this.remove.remove(personalCode);
    }

    private void loadFromFile(){
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                this.students.add(line);
            
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }


    public void register(String name, String surname, String email, String personalCode){
        if(!requirements.checkEventStringName(name)) return;
        if(!requirements.checkEventStringName(surname)) return;
        if(!requirements.checkEventStringEmail(email)) return;
        if(!requirements.checkEventStringPersonalCode(personalCode)) return;

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatdate = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String formattedDate = date.format(formatdate);
        
        this.students.add(name + "," + surname + "," + email + "," + personalCode + "," + formattedDate);

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(name + "," + surname + "," + email + "," + personalCode + "," + formattedDate);
            bw.newLine();
        } catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public void print(){
        for(int i = 0; i < students.size(); i++){
        System.out.println(students.get(i));
        }
     }

    public ArrayList<String> getStudents(){
        return this.students;
    }

    public static void main(String[] args) {
        Register register = new Register();
        Remove remove = new Remove(register);
        register.register("Janis", "Berzins", "janis.berzins@inbox.lv", "123456-78901");
        register.remove("123456-78901");
    }

}

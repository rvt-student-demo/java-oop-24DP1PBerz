package student;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class Remove {
    private Register register;
    
    public Remove(Register register){
        this.register = register;
    }
    
    public void remove(String personalCode){
        boolean removed = false;

        Iterator<String> it = register.getStudents().iterator();
        while (it.hasNext()) {
            String line = it.next();
            String[] parts = line.split(",", -1);

            if (parts.length >= 4 && parts[3].trim().equals(personalCode)) {
                it.remove();
                removed = true;
                break;
            }
        }
        updateFile();
    }

    private boolean updateFile(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/student/students.csv"))) {
            for(int i = 0; i < register.getStudents().size();i++){
            bw.write(register.getStudents().get(i));
            bw.newLine();
            
            }
            return true;
        } catch(IOException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }
}

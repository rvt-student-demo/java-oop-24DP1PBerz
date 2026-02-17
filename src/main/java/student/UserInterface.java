package student;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private Register register;
    private Remove remove;
    private Edit edit;
    private Show show;
    private Exit exit;
    
    public UserInterface(){
        this.register = new Register();
        this.remove = new Remove();
        this.edit = new Edit();
        this.show = new Show();
        this.exit = new Exit();
    }
    
    public void start() {
        String command;
        while(true) {
            System.out.println("Komandu saraksts: register, show, remove, edit, exit");
            System.out.print("Komanda: ");
            command = scanner.nextLine().trim();
            
            if (command.equals("register")){
                register.register(scanner);
            } else if(command.equals("show")) {
                show.show();
            } else if(command.equals("remove")) {
                System.out.print("Ievadi personas kodu: ");
                String code = scanner.nextLine().trim();
                remove.remove(code);
            } else if(command.equals("edit")) {
                edit.edit();
            } else if(command.equals("exit")) {
                exit.exit();
            } else {
                System.out.println("Nav tādas komandas.");
            }
        }
    }
}

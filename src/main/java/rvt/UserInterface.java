package rvt;

import java.util.Scanner;

public class UserInterface {
    TodoList todo;
    Scanner scanner;

    public UserInterface(TodoList list, Scanner scan) {
        this.todo = list;
        this.scanner = scan;
    }

    public void start(){
        while (true) {
            System.out.print("Command: ");
            String command = scanner.nextLine();

            if (command.equals("stop")) {
                break;
            } else if (command.equals("add")) {
                System.out.print("To add: ");

            } else if (command.equals("list")) {
                todo.findAll();

            } else if (command.equals("remove")) {
                System.out.print("Which one is removed? ");
                int number = Integer.valueOf(scanner.nextLine());
                todo.deleteOne(number);
            }
        }
    }
}

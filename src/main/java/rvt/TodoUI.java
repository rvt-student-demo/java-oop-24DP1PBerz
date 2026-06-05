package rvt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

//import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class TodoUI {
    private JFrame window;
    private JPanel panel;
    private JButton button;

    public TodoUI(){
        initialize();
    }

    private void initialize(){
        window = new JFrame("Todo App");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(1024, 768);
        window.setLocationRelativeTo(null);
        window.setResizable(false);

        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        panel.setBackground(new Color(69, 4, 4));
        window.add(panel);

        window.add(panel, BorderLayout.SOUTH);

        button = createbutton("Add Task", "Add a new task into the list");
        panel.add(button);

    }


    public void show(){
        window.setVisible(true);
    }

    private JButton createbutton(String X, String Y){
        JButton button = new JButton(X);
        button.setToolTipText(Y);
        return button;
    }
    // TodoList todo;
    // Scanner scanner;

    // public TodoUI(TodoList list, Scanner scan) {
    //     this.todo = list;
    //     this.scanner = scan;
    // }

    // public void start(){
    //     while (true) {
    //         System.out.print("Command: ");
    //         String command = scanner.nextLine();

    //         if (command.equals("exit")) {
    //             break;
    //         } else if (command.equals("add")) {
    //             System.out.print("To add: ");
    //             String task = scanner.nextLine();
    //             todo.add(task);
    //         } else if (command.equals("list")) {
    //             todo.findAll();
    //         } else if (command.equals("remove")) {
    //             System.out.print("Which one is removed? ");
    //             int number = Integer.valueOf(scanner.nextLine());
    //             todo.deleteOne(number);
    //         }
    //     }
    // }
}

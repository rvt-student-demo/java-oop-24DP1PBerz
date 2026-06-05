package rvt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.JLabel;

import lombok.Builder.ObtainVia;

import javax.swing.JButton;

public class TodoUI {
    private JFrame window;
    private JPanel panel;
    private JButton button;
    private JLabel label;

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

        JPanel panel2;

        panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        panel2.setBackground(new Color(69, 4, 4));
        label = new JLabel("TODO");
        //window.add(label);
        //window.add(label, BorderLayout.NORTH);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.BOTTOM);
        label.setForeground(Color.cyan);
        label.setFont(new Font("Times New Roman",Font.BOLD,36));
        panel2.add(label);
        window.add(panel2,BorderLayout.NORTH);


    }


    public void show(){
        window.setVisible(true);
    }

    private JButton createbutton(String X, String Y){
        JButton button = new JButton(X);
        button.setToolTipText(Y);
        button.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        button.setMargin(new Insets(10, 10, 10, 10));
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("button clicked");
            }
        });
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

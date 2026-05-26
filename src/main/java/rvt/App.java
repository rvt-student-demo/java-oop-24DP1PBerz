package rvt;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;
// import java.sql.Statement;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // try{
        //     Connection conn = DriverManager.getConnection("jdbc:sqlite:todo.db");
        //     Statement stmt = conn.createStatement();

        //     stmt.executeUpdate("CREATE TABLE IF NOT EXISTS todo (id INTEGER PRIMARY KEY, task TEXT NOT NULL) STRICT");
        //     stmt.executeUpdate("INSERT INTO todo(task) VALUES('Make a origami bird')");
        // }catch(SQLException e){
        //     System.out.println(e.getMessage());
        // }

        TodoList list = new TodoList();
        Scanner scanner = new Scanner(System.in);
        UserInterface user = new UserInterface(list, scanner);
        user.start();
    }
}

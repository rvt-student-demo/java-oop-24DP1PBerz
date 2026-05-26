package rvt;

// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.IOException;
import java.sql.Connection;
// import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
// import java.util.ArrayList;
// import java.util.Scanner;
import java.sql.Statement;

public class TodoList {
    // private ArrayList<String> tasks;
    //private final String filePath="data/todo.csv";

    private final TodoDB db;

    public TodoList() {
        this.db = new TodoDB();
        createTableIfNeeded();
    }
    
    private Connection getConnection() throws SQLException {
        return db.connect();
    }

    private void createTableIfNeeded(){
        String sql = "CREATE TABLE IF NOT EXISTS todo (id INTEGER PRIMARY KEY, task TEXT NOT NULL)";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch ( Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // private void loadFromFile(){
    //     try(BufferedReader br = new BufferedReader(new FileReader("data/todo.csv"))) {
    //         String line;
    //         while ((line = br.readLine()) != null) {
    //             String task = line.split(",", 2).length > 1 ? line.split(",", 2)[1] : "";
    //             if(checkEventString(task)) {
    //                 this.tasks.add(line);
    //             }
    //         }
    //     } catch (IOException e) {
    //         System.out.println("Error reading file.");
    //     }
    // }

    // private int getLastId(){
    //         return this.tasks.size() - 1;
    // }

    public void add(String task){
        if(!checkEventString(task)) {
            return;
        }

        String sql = "INSERT INTO todo(task) VALUES(?)";
        try (Connection conn = db.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, task);
            pstmt.executeUpdate();
            System.out.println("Task added: " + task);
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void findAll(){
        String sql = "SELECT id, task FROM todo ORDER BY id";
        try (Connection conn = db.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while(rs.next()){
                System.out.println(rs.getInt("id") + ": " + rs.getString("task"));
            }
        } catch(SQLException e){  
            System.out.println(e.getMessage());
        }
    }

    // private boolean updateFile(){
    //     try(BufferedWriter bw = new BufferedWriter(new FileWriter("data/todo.csv"))) {
    //         for(int i = 0; i < tasks.size();i++){
    //         bw.write(tasks.get(i).toString());
    //         bw.newLine();
            
    //         }
    //         return true;
    //     } catch(IOException e) {
    //         System.out.println(e.getMessage());
    //         return false;
    //     }

    // }
    public void deleteOne(int id){
        String sql = "DELETE FROM todo WHERE id = ?";
        try (Connection conn = db.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int deletedRows = pstmt.executeUpdate();
            if (deletedRows > 0) {
                System.out.println("Task deleted.");
            } else {
                System.out.println("No task found with id: " + id);
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }

        // this.tasks.remove(id);
        // updateFile();
    }

    public boolean checkEventString(String value){

        String input = "[a-zA-Z0-9 ]+";
        if(!value.matches(input)){
            System.out.println("Aktivitāte drīkst saturēt tikai burtus, ciparus un atstarpes.");
            return false;
        }
        if(value.length() < 3){
            System.out.println("Aktivitātes garums ir mazaks par 3 simboliem.");
            return false; 
        }
        return true;
    }

    // public static void main(String[] args) {
    //     TodoList todoList = new TodoList();
        
         
    //     todoList.add("cookk");
    //     todoList.findAll();
    //     todoList.deleteOne(1);
    //     todoList.findAll();

        
    // }
}

package rvt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

public class TodoList {
    private ArrayList<String> tasks;
    //private final String filePath="data/todo.csv";

    public TodoList(){
        this.tasks = new ArrayList<>();
        loadFromFile();
    }
    
    private void loadFromFile(){
        try(BufferedReader br = new BufferedReader(new FileReader("data/todo.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String task = line.split(",", 2).length > 1 ? line.split(",", 2)[1] : "";
                if(checkEventString(task)) {
                    this.tasks.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }

    private int getLastId(){
            return this.tasks.size() - 1;
    }
    public void add(){
        try{
            Connection conn = DriverManager.getConnection("jdbc:sqlite:todo.db");
            Statement stmt = conn.createStatement();

            
            stmt.executeUpdate("INSERT INTO todo(task) VALUES('Make an art painting')");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        // if(!checkEventString(task)) return;
        // int nextId = getLastId()+1;
        // this.tasks.add(nextId + "," + task);

        // try(BufferedWriter bw = new BufferedWriter(new FileWriter("data/todo.csv", true))) {
        //     bw.write(nextId + "," + task);
        //     bw.newLine();
        // } catch(IOException ioe) {
        //     System.out.println(ioe.getMessage());
        // }
    }
    public void findAll(){
        try{
            Connection conn = DriverManager.getConnection("jdbc:sqlite:todo.db");
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM todo");

            while(rs.next()){
                System.out.println(rs.getString("task"));
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
       
        // for(int i = 0; i < tasks.size(); i++){
        // System.out.println(tasks.get(i));
        // }
    }

    private boolean updateFile(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("data/todo.csv"))) {
            for(int i = 0; i < tasks.size();i++){
            bw.write(tasks.get(i).toString());
            bw.newLine();
            
            }
            return true;
        } catch(IOException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }
    public void deleteOne(int id){
        try{
            Connection conn = DriverManager.getConnection("jdbc:sqlite:todo.db");
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM todo WHERE id = ?");

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }catch(SQLException e){
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

    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        todoList.deleteOne(3);
        // todoList.add();
        // todoList.findAll();


        
    }
}

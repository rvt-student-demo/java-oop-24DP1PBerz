package rvt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TodoList {
    private ArrayList<String> tasks;
    private final String filePath="data/todo.csv";

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
    public void add(String task){
        if(!checkEventString(task)) return;
        int nextId = getLastId()+1;
        this.tasks.add(nextId + "," + task);

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("data/todo.csv", true))) {
            bw.write(nextId + "," + task);
            bw.newLine();
        } catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
    public void print(){
        for(int i = 0; i < tasks.size(); i++){
        System.out.println(tasks.get(i));
        }
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
    public void remove(int id){
        this.tasks.remove(id);
        updateFile();
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
        todoList.add("buy groceries");
        todoList.add("wash the car");
        todoList.print();
        System.out.println("Last ID: " + todoList.getLastId());
        todoList.remove(5);
        System.out.println();
        todoList.print();
        System.out.println();
        
    }
}

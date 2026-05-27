package rvt;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TodoDB {
    private static final String DB_URL = "jdbc:sqlite:todo.db";

    public TodoDB(){
        initSchema();
    }

    public Connection connect() throws SQLException{
        return DriverManager.getConnection(DB_URL);
    }
    private void initSchema(){
        String sql = "CREATE TABLE IF NOT EXISTS todo (id INTEGER PRIMARY KEY, task TEXT NOT NULL)";
        try(Connection conn = connect(); Statement stmt = conn.createStatement()){
            stmt.execute(sql);
        } catch(SQLException e){
            throw new RuntimeException("Schema init failed: " + e.getMessage());
        }
    }

    private void add(String task){
        String sql = "INSERT INTO todo(task) VALUES(?)";
        try(Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql) ){
            pstmt.setString(1, task);
            pstmt.executeUpdate();
            System.out.println("task added");
        }catch(SQLException e){
            e.getMessage();
        }
    }

    private void findAll(){
        String sql = "SELECT id, task  FROM todo ORDER BY id";
        try(
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            PreparedStatement pstmt = conn.prepareStatement(sql); 
            ResultSet rs = pstmt.executeQuery();
        ){
            while(rs.next()){
                int id = rs.getInt("id");
                String task = rs.getString("task");

                System.out.println(id + "\t|" + task + "\t|");
            }
        }catch(SQLException e){
            e.getMessage();
        }
        
        
    }

    private void removeById(int id){
        String sql = "DELETE FROM todo WHERE id = ?";
        try(Connection conn = connect();PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, id);
            int deletedRows = pstmt.executeUpdate();
            if (deletedRows > 0) {
                System.out.println("Task deleted.");
            } else {
                System.out.println("No task found with id: " + id);
            }
        }catch(SQLException e){
            e.getMessage();
        }
    }

    public static void main(String[] args) {
        TodoDB db = new TodoDB();
        db.findAll();
        //db.removeById(6);
        //db.add("Make a sand castle");
    }
}

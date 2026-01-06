package rvt;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Pasutijuma_vesture {
    public static void main(String[] args) {    
        try{
            Scanner scanner = new Scanner(new File("data/orders.csv"));
            scanner.nextLine();

            double overall = 0.0;
            while(scanner.hasNextLine()){
                String row = scanner.nextLine();
                String[] parts = row.split(",");

                int id = Integer.valueOf(parts[0]);
                String customer = parts[1];
                String product = parts[2];
                int quantity = Integer.valueOf(parts[3]);
                double price = Double.valueOf(parts[4]);

                double sum = price * quantity;
                System.out.println("Pasūtījums #"+ id + ": " + customer + "pasūtīja " + quantity + " x " + product + " (" + price + " EUR)  ->  Kopā: " + sum +"EUR" );

                overall += sum;
            }
            scanner.close();
            System.out.println("Kopējā pasūtījumu summa: "+ overall + "EUR ");
        } catch(Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
    }
}

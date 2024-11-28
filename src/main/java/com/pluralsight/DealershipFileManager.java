package com.pluralsight;

import java.io.*;
import java.util.ArrayList;

public class DealershipFileManager {
    public static Dealership getDealership(){
        return null;
    }

    public static void saveToCSV(Dealership dealership, String fineName){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fineName));){
            bufferedWriter.write(dealership.getName() + dealership.getAddress() + dealership.getPhone());
            bufferedWriter.newLine();

            for(Vehicle vehicle : dealership.displayAllVehicle()){
                bufferedWriter.write(vehicle.getVin() + "|"
                        + vehicle.getYear() + "|"
                        + vehicle.getMake() + "|"
                        + vehicle.getModel() + "|"
                        + vehicle.getVehicleType() + "|"
                        + vehicle.getColor() + "|"
                        + vehicle.getOdometer() + "|"
                        + vehicle.getPrice());
            }
            bufferedWriter.newLine();
        }catch(Exception e){
            System.out.println("Error while saving Transactions: " + e.getMessage());
        }
    }
}


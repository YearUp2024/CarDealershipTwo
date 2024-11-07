package com.pluralsight.Contracts;

import com.pluralsight.Dealership.Vehicle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ContractFileManager {
    private static String fileName = "contracts.csv";

    public static ArrayList<Contract> getContract(){
        ArrayList<Contract> result = new ArrayList<>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            String line;

            while((line = bufferedReader.readLine()) != null){
                String[] newLine = line.split("\\|");

                if(newLine.length >= 16){
                    if(newLine[0].equalsIgnoreCase("Sale")){
                        SalesContract salesContract = new SalesContract(
                                newLine[1], // date
                                newLine[2], // name
                                newLine[3], // email
                                new Vehicle(
                                        Integer.parseInt(newLine[4]), // vin
                                        Integer.parseInt(newLine[5]), // year
                                        newLine[6], // make
                                        newLine[7], // model
                                        newLine[8], // vehicle type
                                        newLine[9], // color
                                        Integer.parseInt(newLine[10]), // miles
                                       Double.parseDouble(newLine[11]) // price
                                ),
                                Double.parseDouble(newLine[12]),
                                Double.parseDouble(newLine[13]),
                                Double.parseDouble(newLine[14]),
                                Boolean.parseBoolean(newLine[16])
                        );
                        result.add(salesContract);
                    }else if(newLine[0].equalsIgnoreCase("Lease")){
                        LeaseContract leaseContract = new LeaseContract(
                                newLine[1], // date
                                newLine[2], // name
                                newLine[3], // email
                                new Vehicle(
                                        Integer.parseInt(newLine[4]), // vin
                                        Integer.parseInt(newLine[5]), // year
                                        newLine[6], // make
                                        newLine[7], // model
                                        newLine[8], // vehicle type
                                        newLine[9], // color
                                        Integer.parseInt(newLine[10]), // miles
                                        Double.parseDouble(newLine[11]) // price
                                ),
                                Double.parseDouble(newLine[12]),
                                Double.parseDouble(newLine[13])
                        );
                        result.add(leaseContract);
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return result;
    }
}

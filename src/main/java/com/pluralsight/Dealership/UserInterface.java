package com.pluralsight.Dealership;

import com.pluralsight.Console;
import com.pluralsight.Contracts.Contract;
import com.pluralsight.Contracts.LeaseContract;
import com.pluralsight.Contracts.SalesContract;

import java.util.Currency;

public class UserInterface {
    private Dealership dealership;

    public UserInterface(){
        this.dealership = DealershipFileManager.getDealership();
    }

    public void display(){
        for(Vehicle vehicle : dealership.getAllVehicles()){
            System.out.println(vehicle);
        }
    }

    public void processGetByPriceRequest(){
        double min = Console.PromptForDouble("Enter the minimum price of a vehicle: ");
        double max = Console.PromptForDouble("Enter the maximum price of a vehicle: ");

        dealership.getVehiclesByPrice(min, max).forEach(System.out::println);
    }

    public void processGetByMakeModelRequest(){
        String make = Console.PromptForString("Enter car company that you are looking for: ");
        String model = Console.PromptForString("Enter car model that you are looking for: ");

        dealership.getVehiclesByModel(make, model).forEach(System.out::println);
    }

    public void processGetByYearRequest(){
        int min = Console.PromptForInt("Enter the minimum year of a vehicle: ");
        int max = Console.PromptForInt("Enter the maximum year of a vehicle: ");

        dealership.getVehiclesByYear(min, max).forEach(System.out::println);
    }

    public void processGetByColorRequest(){
        String color = Console.PromptForString("Enter a color that you want the vehicle to be in: ");

        dealership.getVehiclesByColor(color).forEach(System.out::println);
    }

    public void processGetByMileageRequest(){
        int min = Console.PromptForInt("Enter the minimum mileage of a vehicle: ");
        int max = Console.PromptForInt("Enter the maximum mileage of a vehicle:: ");

        dealership.getVehiclesByMileage(min, max).forEach(System.out::println);
    }

    public void processGetByVehicleTypeRequest(){
        String type = Console.PromptForString("Enter what type of vehicle you are looking for: ");

        dealership.getVehiclesByType(type).forEach(System.out::println);
    }

    public void processGetAllVehicleRequest(){
        for(Vehicle vehicle : dealership.getAllVehicles()){
            System.out.println(vehicle);
        }
    }

    public void processAddVehicleRequest(){
        int vin = Console.PromptForInt("Enter your Vin number: ");
        int year = Console.PromptForInt("Enter make year: ");
        String make = Console.PromptForString("Enter Car company name: ");
        String model = Console.PromptForString("Enter model name: ");
        String type = Console.PromptForString("Enter type name: ");
        String color = Console.PromptForString("Enter color: ");
        int mileage = Console.PromptForInt("Enter mileage: ");
        double price = Console.PromptForInt("Enter price: ");

        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, mileage, price);
        this.dealership.addVehicle(vehicle);
        DealershipFileManager.saveDealership(this.dealership);

        boolean added = dealership.addVehicle(vehicle);
        if(added){
            System.out.println("New vehicle added");
        }else{
            System.out.println("New vehicle was not added");
        }
    }

    public void processRemoveVehicleRequest(){
        int vin = Console.PromptForInt("Enter vin number of the vehicle you want to remove: ");

        Vehicle vehicleToRemove = null;
        for(Vehicle vehicle : dealership.getInventory()){
            if(vehicle.getVin() == vin){
                vehicleToRemove = vehicle;
                break;
            }
        }

        if(vehicleToRemove != null){
            boolean remove = dealership.removeVehicle(vehicleToRemove);

            if(remove){
                System.out.println("Vehicle was removed");
            }else{
                System.out.println("There was something wrong with remove the vehicle");
            }
        }
    }

    public void processSellOrLease(){
        int vin = 0;
        String input;

        do{
            input = Console.PromptForString("Enter a VIN of the vehicle to sell/less (or 'v' to view all vehicles or 'q' to cancel): ");

            if(input.equalsIgnoreCase("q")){
                return;
            }

            if(input.equalsIgnoreCase("v")){
                display();
                input = "";
                continue;
            }

            try{
                vin = Integer.parseInt(input);

                Vehicle vehicle = dealership.getVehicleByVin(vin);
                if(vehicle == null){
                    System.out.println("Vehicle not found. Please try again.");
                    input = "";
                    continue;
                }
                break;
            }catch(Exception e){
                System.out.println("Invalid input. Please enter a valid number.");
                input = "";
            }
        }while(input.isEmpty());
        System.out.println("\n" + dealership.getVehicleByVin(vin));

        String contractType;
        do{
            contractType = Console.PromptForString("Enter contract type (sale/lease) (or 'q' to cancel): ");

            if(contractType.equalsIgnoreCase("q")){
                return;
            }
            if(!contractType.equalsIgnoreCase("sale") && !contractType.equalsIgnoreCase("lease")){
                System.out.println("Invalid contract type. Please enter 'sale' or 'lease'");
                contractType = "";
            }
        }while(contractType.isEmpty());

        String customerName;
        do{
            customerName = Console.PromptForString("Enter your name (or 'q' to cancel): ");
            if(customerName.equalsIgnoreCase("q")){
                return;
            }
        }while(customerName.isEmpty());

        String customerEmail;
        do{
            customerEmail = Console.PromptForString("Enter your email (or 'q' to cancel): ");
            if(customerName.equalsIgnoreCase("q")){
                return;
            }
        }while(customerEmail.isEmpty());

        String date;
        do{
            date = Console.PromptForString("Enter date (YYYYMMDD) (or 'q' to cancel): ");
            if(date.equalsIgnoreCase("q")){
                return;
            }
            if(date.length() != 8 || !date.matches("\\d{8}")){
                System.out.println("Invalid data format. Please use YYYYMMDD");
                date = "";
            }
        }while(date.isEmpty());

        Vehicle vehicle = dealership.getVehicleByVin(vin);
        Contract contract = null;

        if(contractType.equalsIgnoreCase("sale")){
            String financeInput;
            boolean isFinanced;

            do{
                financeInput = Console.PromptForString("Will this be financed? (yes/no) (or 'q' to cancel): ");
                if(financeInput.equalsIgnoreCase("q")){
                    return;
                }
                if(financeInput.equalsIgnoreCase("yes")){
                    isFinanced = true;
                    break;
                } else if(financeInput.equalsIgnoreCase("no")){
                    isFinanced = false;
                    break;
                }
                System.out.println("Please enter 'yes' or 'no'");
            }while(true);
            contract = new SalesContract(date, customerName, customerEmail, vehicle, isFinanced);
        }else{
            contract = new LeaseContract(date, customerName, customerEmail, vehicle);
        }
        System.out.println(contract);
        System.out.println(contract.getTotalPrice());
        System.out.println(contract.getMonthlyPayment());
    }

    public void displayAll(){
        int userChoice;
        do{
            System.out.println("Please choose from the options");
            System.out.println(" 1 - Display All vehicle ");
            System.out.println(" 2 - Display by Price:[P] ");
            System.out.println(" 3 - Display by Company:[C] ");
            System.out.println(" 4 - Display by make Year:[Y] ");
            System.out.println(" 5 - Display by Millage:[M] ");
            System.out.println(" 6 - Display by Car Color:[CC] ");
            System.out.println(" 7 - Display by Car Type:[T] ");
            System.out.println(" 8 - Add a vehicle:[Add] ");
            System.out.println(" 9 - Remove a vehicle:[Remove] ");
            System.out.println(" 10 - Sell or Lease a vehicle: ");
            System.out.println(" 99 - Enter [E] to exit");

            userChoice = Console.PromptForInt("Please enter your choice: ");
            System.out.println("\n");

            switch (userChoice){
                case 1:
                    display();
                    System.out.println("\n");
                    break;
                case 2:
                    processGetByPriceRequest();
                    System.out.println("\n");
                    break;
                case 3:
                    processGetByMakeModelRequest();
                    System.out.println("\n");
                    break;
                case 4:
                    processGetByYearRequest();
                    System.out.println("\n");
                    break;
                case 5:
                    processGetByMileageRequest();
                    System.out.println("\n");
                    break;
                case 6:
                    processGetByColorRequest();
                    System.out.println("\n");
                    break;
                case 7:
                    processGetByVehicleTypeRequest();
                    System.out.println("\n");
                    break;
                case 8:
                    processAddVehicleRequest();
                    System.out.println("\n");
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    System.out.println("\n");
                    break;
                case 10:
                    processSellOrLease();
                    System.out.println("\n");
                    break;
                default:
                    System.out.println("You choice does not match!!");
            }
        }while (userChoice != 99);
    }
}
package com.pluralsight;

public class UserInterface {
    private Dealership dealership;
    private static String fineNameDealership = "inventory.csv";

    public UserInterface(Dealership dealership) {
        this.dealership = dealership;
    }

    public UserInterface() {
        init();
    }

    private void init() {
        this.dealership = DealershipFileManager.getDealership();
    }

    public void display(){
        int options;
        do{
            System.out.println("Please select from the following choices:");
            System.out.println("1 - Find vehicles within a price range");
            System.out.println("2 - Find vehicles by make / model");
            System.out.println("3 - Find vehicles by year");
            System.out.println("4 - Find vehicles by color");
            System.out.println("5 - Find vehicles by mileage range");
            System.out.println("6 - Find vehicles by type (car, truck, SUV, van)");
            System.out.println("7 - List ALL vehicles");
            System.out.println("8 - Add a vehicle");
            System.out.println("9 - Remove a vehicle");
            System.out.println("10 - Sell or Lease vehicle");
            System.out.println("11 - Display Contracts");
            System.out.println("99 - Quit");
            options = Console.PromptForInt("Enter your choice: ");

            switch(options){
                case 1 -> processVehicleByPrice();
                case 2 -> processVehicleByMake();
                case 3 -> processVehicleByYear();
                case 4 -> processVehicleByColor();
                case 5 -> processVehicleByMileage();
                case 6 -> processVehicleByType();
                case 7 -> displayAllVehicle();
                case 8 -> addVehicle();
                case 9 -> removeVehicleByVin();
            }
        }while(options != 99);
    }

    public void processVehicleByPrice(){
        int minPrice = Console.PromptForInt("Enter Min price: ");
        int maxPrice = Console.PromptForInt("Enter Max price: ");
        dealership.getVehicleByPrice(minPrice, maxPrice).forEach(System.out::println);
    }

    public void processVehicleByMake(){
        String vehicleMake = Console.PromptForString("Enter Vehicle make: ");
        for(Vehicle vehicle : dealership.getVehicleByModel(vehicleMake)){
            System.out.println(vehicle);
        }
    }

    public void processVehicleByYear(){
        int vehicleYear = Console.PromptForInt("Enter Vehicle Year: ");
        for(Vehicle vehicle : dealership.getVehicleByYear(vehicleYear)){
            System.out.println(vehicle);
        }
    }

    public void processVehicleByColor(){
        String vehicleColor = Console.PromptForString("Enter Vehicle Color: ");
        for(Vehicle vehicle : dealership.getVehicleByColor(vehicleColor)){
            System.out.println(vehicle);
        }
    }

    public void processVehicleByMileage(){
        int vehicleMileage = Console.PromptForInt("Enter Vehicle Mileage: ");
        for(Vehicle vehicle : dealership.getVehicleByMileage(vehicleMileage)){
            System.out.println(vehicle);
        }
    }

    public void processVehicleByType(){
        String vehicleType = Console.PromptForString("Enter Vehicle Type: ");
        for(Vehicle vehicle : dealership.getVehicleByType(vehicleType)){
            System.out.println(vehicle);
        }
    }

    public void displayAllVehicle(){
        for(Vehicle vehicle : dealership.displayAllVehicle()){
            System.out.println(vehicle);
        }
    }

    public void addVehicle(){
        int vehicleVin = Console.PromptForInt("Enter Vehicle VIN: ");
        int vehicleYear = Console.PromptForInt("Enter Vehicle Year: ");
        String vehicleMake = Console.PromptForString("Enter Vehicle Make: ");
        String vehicleModel = Console.PromptForString("Enter Vehicle Model: ");
        String vehicleType = Console.PromptForString("Enter Vehicle Type: ");
        String vehicleColor = Console.PromptForString("Enter Vehicle Color: ");
        int vehicleOdometer = Console.PromptForInt("Enter Vehicle Mileage: ");
        double vehiclePrice = Console.PromptForDouble("Enter Vehicle Price: ");

        Vehicle vehicle = new Vehicle(vehicleVin, vehicleYear, vehicleMake, vehicleModel, vehicleType, vehicleColor, vehicleOdometer, vehiclePrice);
        dealership.addVehicle(vehicle);
        DealershipFileManager.saveDealership(this.dealership);

        boolean added = dealership.addVehicle(vehicle);
        if(added){
            System.out.println("New Vehicle Added");
        }else{
            System.out.println("New Vehicle was not able to be added");
        }
    }

    public void removeVehicleByVin(){
        int vehicleVin = Console.PromptForInt("Enter VIN of Vehicle you want to remove: ");
        boolean removeVehicle = dealership.removeVehicle(vehicleVin);
        if(removeVehicle){
            System.out.println("Vehicle with VIN: " + vehicleVin + " was not found.");
        }
    }
}












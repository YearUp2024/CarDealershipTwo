package com.pluralsight;


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

    public void displayAll(){
        String userChoice;
        do{
            System.out.println("Please choose from the options");
            System.out.println("Display All vehicle:[A] ");
            System.out.println("Display by Price:[P] ");
            System.out.println("Display by Company:[C] ");
            System.out.println("Display by make Year:[Y] ");
            System.out.println("Display by Millage:[M] ");
            System.out.println("Display by Car Color:[CC] ");
            System.out.println("Display by Car Type:[T] ");
            System.out.println("Add a vehicle:[Add] ");
            System.out.println("Remove a vehicle:[Remove] ");
            System.out.println("Enter [E] to exit");

            userChoice = Console.PromptForString("Please enter your choice: ");
            System.out.println("\n");

            switch (userChoice){
                case "A":
                    display();
                    System.out.println("\n");
                    break;
                case "P":
                    processGetByPriceRequest();
                    System.out.println("\n");
                    break;
                case "C":
                    processGetByMakeModelRequest();
                    System.out.println("\n");
                    break;
                case "Y":
                    processGetByYearRequest();
                    System.out.println("\n");
                    break;
                case "M":
                    processGetByMileageRequest();
                    System.out.println("\n");
                    break;
                case "CC":
                    processGetByColorRequest();
                    System.out.println("\n");
                    break;
                case "T":
                    processGetByVehicleTypeRequest();
                    System.out.println("\n");
                    break;
                case "Add":
                    processAddVehicleRequest();
                    System.out.println("\n");
                    break;
                case "remove":
                    processRemoveVehicleRequest();
                    System.out.println("\n");
                    break;
                default:
                    System.out.println("You choice does not match!!");
            }
        }while (!userChoice.equalsIgnoreCase("E"));
    }
}
package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    /**
     * This is a contracture.
     * @param name
     * @param address
     * @param phone
     * @param inventory
     */
    public Dealership(String name, String address, String phone, ArrayList<Vehicle> inventory) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = inventory;
    }

    /**
     * This is setting the name of the dealership
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This is setting address of the dealership.
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * This is setting phone number of the dealership.
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * This is setting inventory of vehicles
     * @param inventory
     */
    public void setInventory(ArrayList<Vehicle> inventory) {
        this.inventory = inventory;
    }

    /**
     * This is getting name of a dealership.
     * @return dealership name.
     */
    public String getName() {
        return name;
    }

    /**
     * This is getting dealership address.
     * @return dealership address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * This is getting dealership phone number
     * @return phone number.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This is getting vehicle inventory
     * @return vehicle inventory
     */
    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }

    /**
     * This is adding vehicle by price into a ArrayList and returning that into a List.
     * @param min
     * @param max
     * @return vehicles by price.
     */
    public List<Vehicle> getVehiclesByPrice(double min, double max){
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        for(Vehicle vehicle : inventory){
            if(vehicle.getPrice() > min && vehicle.getPrice() < max){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    /**
     * This is adding vehicle by model into a ArrayList and returning that into a List.
     * @param make
     * @param model
     * @return vehicles by model.
     */
    public List<Vehicle> getVehiclesByModel(String  make, String model){
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        for(Vehicle vehicle : inventory){
            if(vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max){
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        for(Vehicle vehicle : inventory){
            if(vehicle.getYear() > min && vehicle.getYear() < max){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    /**
     * This is adding vehicle by millage into a ArrayList and returning that into a List.
     * @param color
     * @return vehicles by color.
     */
    public List getVehiclesByColor(String color){
        ArrayList<Vehicle> listOfVehicles = new ArrayList<>();

        for(Vehicle vehicle : inventory){
            if(vehicle.getColor().equals(color)){
                listOfVehicles.add(vehicle);
            }
        }
        return listOfVehicles;
    }

    /**
     * This is adding vehicles by millage into a ArrayList and retuning that into a List.
     * @param min
     * @param max
     * @return vehicles by mileage.
     */
    public List<Vehicle> getVehiclesByMileage(int min, int max){
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        for(Vehicle vehicle : inventory){
            if(vehicle.getOdometer() > min && vehicle.getOdometer() < max){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    /**
     * This is adding all vehicle by type into a List.
     * @param vehicleType
     * @return vehicles by type
     */
    public List<Vehicle> getVehiclesByType(String vehicleType){
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        for(Vehicle vehicle : inventory){
            if(vehicle.getVehicleType().equalsIgnoreCase(vehicleType)){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    /**
     * This is adding all vehicle into a List.
     * @return all vehicle in the inventory.
     */
    public List<Vehicle> getAllVehicles(){
        return inventory;
    }

    /**
     * This is adding vehicle to dealership
     * @param vehicle
     * @return add vehicle to dealership
     */
    public boolean addVehicle(Vehicle vehicle){
        if(inventory == null){
            return false;
        }

        boolean add = inventory.add(vehicle);
        return add;
    }

    /**
     * This is removing vehicle from dealership
     * @param vehicle
     * @return removed vehicle
     */
    public boolean removeVehicle(Vehicle vehicle){
        if(inventory == null){
            return false;
        }

        boolean remove = inventory.add(vehicle);
        return remove;
    }
}

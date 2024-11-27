package com.pluralsight;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Dealership {
    private List<Vehicle> inventory;

    public Dealership(List<Vehicle> inventory) {
        this.inventory = inventory;
    }

    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }

    public boolean removeVehicle(int vin){
        Iterator<Vehicle> iterator = inventory.iterator();
        while(iterator.hasNext()){
            if(iterator.next().getVin() == vin){
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public List<Vehicle> getAllVehicles(){
        return new ArrayList<>(inventory);
    }

    public List<Vehicle> getVehicleByPrice(double minPrice, double maxPrice){
        List<Vehicle> result = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice){
                result.add(vehicle);
            }
        }
        return result;
    }

    public List<Vehicle> getVehicleByMake(String make){
        List<Vehicle> result = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getMake().equalsIgnoreCase(make)){
                result.add(vehicle);
            }
        }
        return result;
    }

    public List<Vehicle> getVehicleByColor(String color){
        List<Vehicle> result = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getColor().equalsIgnoreCase(color)){
                result.add(vehicle);
            }
        }
        return result;
    }

    public List<Vehicle> getVehicleBYType(String vehicleType){
        List<Vehicle> result = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getVehicleType().equalsIgnoreCase(vehicleType)){
                result.add(vehicle);
            }
        }
        return result;
    }

    public List<Vehicle> getVehicleByMileage(int mileage){
        List<Vehicle> result = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getOdometer() == mileage){
                result.add(vehicle);
            }
        }
        return result;
    }

    public List<Vehicle> getVehicleByYear(int year){
        List<Vehicle> result = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getYear() == year){
                result.add(vehicle);
            }
        }
        return result;
    }
}

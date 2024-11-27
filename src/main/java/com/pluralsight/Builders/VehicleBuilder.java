package com.pluralsight.Builders;

import com.pluralsight.Vehicle;

public class VehicleBuilder {
    private int vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;

    public VehicleBuilder setVin(int vin) {
        this.vin = vin;
        return this;
    }

    public VehicleBuilder setYear(int year) {
        this.year = year;
        return this;
    }

    public VehicleBuilder setMake(String make) {
        this.make = make;
        return this;
    }

    public VehicleBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public VehicleBuilder setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
        return this;
    }

    public VehicleBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public VehicleBuilder setOdometer(int odometer) {
        this.odometer = odometer;
        return this;
    }

    public VehicleBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public Vehicle build(){
        return new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
    }
}

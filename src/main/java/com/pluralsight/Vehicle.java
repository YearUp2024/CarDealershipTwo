package com.pluralsight;

public class Vehicle {
    private int vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;

    /**
     * This is a Contracture.
     * @param vin
     * @param year
     * @param make
     * @param model
     * @param vehicleType
     * @param color
     * @param odometer
     * @param price
     */
    public Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    /**
     * This is a vin number setter.
     * @param vin
     */
    public void setVin(int vin) {
        this.vin = vin;
    }

    /**
     * This is a make year setter.
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * This is a make setter.
     * @param make
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * This is a model setter.
     * @param model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * This is a vehicleType setter.
     * @param vehicleType
     */
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    /**
     * This is a color setter.
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * This is a odometer setter.
     * @param odometer
     */
    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    /**
     * This is a price setter.
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * This is a vin number getter.
     * @return
     */
    public int getVin() {
        return vin;
    }

    /**
     * This is a make year getter.
     * @return
     */
    public int getYear() {
        return year;
    }

    /**
     * This is a make getter.
     * @return
     */
    public String getMake() {
        return make;
    }

    /**
     * This is a model getter.
     * @return
     */
    public String getModel() {
        return model;
    }

    /**
     * This is a vehicleType getter.
     * @return
     */
    public String getVehicleType() {
        return vehicleType;
    }

    /**
     * This is a color getter.
     * @return
     */
    public String getColor() {
        return color;
    }

    /**
     * This is a odometer getter.
     * @return
     */
    public int getOdometer() {
        return odometer;
    }

    /**
     * This is a price getter.
     * @return
     */
    public double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "Vehicle{" +
                "vin=" + vin +
                ", year=" + year +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", color='" + color + '\'' +
                ", odometer=" + odometer +
                ", price=" + price +
                '}';
    }
}

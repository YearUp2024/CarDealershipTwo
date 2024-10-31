package com.pluralsight;

public abstract class SalesContract extends Contract{
    private double salesTex = 0.05;
    private int recordingFee = 100;
    private double processingFee;
    private double totlaPrice;
    private boolean financed;
    private double monthlyPayment;

    public SalesContract(){}

    public SalesContract(int date, String customerName, String customerEmail, Vehicle vehicleSold, double totalPrice, double monthlyPayment, double processingFee, boolean financed) {
        super(date, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
        this.totlaPrice = totalPrice;
        this.financed = financed;
        this.processingFee = processingFee;
    }

    public SalesContract(double monthlyPayment, boolean financed, double totlaPrice, double processingFee) {
        this.monthlyPayment = monthlyPayment;
        this.financed = financed;
        this.totlaPrice = totlaPrice;
        this.processingFee = processingFee;
    }

    public double getProcessingFee() {
        return super.isVehicleSold().getPrice() >= 10000 ? 495 : 295;
    }

    public boolean isFinanced() {
        return financed;
    }

    public void setFinanced(boolean financed) {
        this.financed = financed;
    }

    public double getSalesTex() {
        return salesTex;
    }

    public int getRecordingFee() {
        return recordingFee;
    }

    @Override
    public double getMonthlyPayment() {
        Vehicle vehicle = super.isVehicleSold();

        if(!financed){
            return 0;
        }

        double rate = vehicle.getPrice() >= 10000 ? 0.0425 : 0.0525;
        int leaseTime = vehicle.getPrice() > 10000 ? 48 : 24;
        double monthlyRate = rate / 12;

        return (totlaPrice * monthlyRate) / (1 - Math.pow(1 + monthlyRate, - leaseTime));
    }

    @Override
    public double getTotalPrice() {
        Vehicle vehicle = super.isVehicleSold();
        double vehiclePrice = vehicle.getPrice();
        double salesTax = vehiclePrice * salesTex;
        return vehiclePrice + salesTax + recordingFee + processingFee;
    }

}










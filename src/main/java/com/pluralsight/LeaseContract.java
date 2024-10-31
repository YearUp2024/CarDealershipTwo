package com.pluralsight;

public abstract class LeaseContract extends Contract{
    private double endingValue;
    private double leaseFee;
    private double monthlyPayment;
    private double originalPrice;

    public LeaseContract(){}

    public LeaseContract(double endingValue, double leaseFee, double originalPrice) {
        this.endingValue = endingValue;
        this.leaseFee = leaseFee;
        this.originalPrice = originalPrice;
    }

    public LeaseContract(int date, String customerName, String customerEmail, Vehicle vehicleSold, double totalPrice, double monthlyPayment, double endingValue, double leaseFee, double originalPrice) {
        super(date, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
        this.endingValue = endingValue;
        this.leaseFee = leaseFee;
        this.originalPrice = originalPrice;
    }

    public double getEndingValue() {
        return super.isVehicleSold().getPrice() * 0.50;
    }

    public void setEndingValue(double endingValue){
        this.endingValue = 0.05 * originalPrice;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = 0.07 * originalPrice;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    @Override
    public double getTotalPrice(){
        return originalPrice + leaseFee;
    }

    @Override
    public double getMonthlyPayment(){
        double principleAmount = getTotalPrice();
        double monthlyInterestRate = 0.04 / 12;
        int numberOfPayment = 36;
        double monthlyPayment = (principleAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, - numberOfPayment));

        return monthlyPayment;
    }
}

package com.pluralsight.Contracts;

import com.pluralsight.Main;
import com.pluralsight.Vehicle;

public class LeaseContract extends Contract{
    private double expectedEndingValue;
    private final double expectedEndingValueOfOriginalPrice = 0.50;
    private double leaseFee;
    private final double leaseFeePercentage = 0.07;

    public LeaseContract(int dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.expectedEndingValue = vehicleSold.getPrice() * expectedEndingValueOfOriginalPrice;
        this.leaseFee = vehicleSold.getPrice() * leaseFeePercentage;
    }

    public LeaseContract(int dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold, double expectedEndingValue, double leaseFee) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.expectedEndingValue = expectedEndingValue;
        this.leaseFee = leaseFee;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getExpectedEndingValueOfOriginalPrice() {
        return expectedEndingValueOfOriginalPrice;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    public double getLeaseFeePercentage() {
        return leaseFeePercentage;
    }

    @Override
    public double getTotalPrice(){
        return (this.expectedEndingValue * this.getLeaseFee());
    }

    @Override
    public double getMonthlyPayment(){
        double loanAmount = getVehicleSold().getPrice() - expectedEndingValue + leaseFee;
        double interestRate = 0.04;
        int loanMonth = 36;
        double monthlyInterestRate = interestRate / 12;
        return (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, - loanMonth));
    }
}

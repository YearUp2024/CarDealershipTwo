package com.pluralsight.Contracts;

import com.pluralsight.BankingCalculators;
import com.pluralsight.Dealership.Vehicle;

public class SalesContract extends Contract{
    private double recordingFee;
    private double salesTaxAmount;
    private final double salesTaxPercentage = 0.05;
    private double processingFee;
    private  boolean wantsToFinance;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, boolean wantsToFinance) {
        super (date, customerName, customerEmail, vehicleSold);
        this.salesTaxAmount = vehicleSold.getPrice() * salesTaxPercentage;
        this.recordingFee = 100;
        this.processingFee = (vehicleSold.getPrice() < 10000) ? 295 : 495;
        this.wantsToFinance = wantsToFinance;
    }

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, double salesTaxAmount, double recordingFee, double processingFee, boolean wantsToFinance) {
        super(date, customerName, customerEmail, vehicleSold);
        this.recordingFee = recordingFee;
        this.salesTaxAmount = salesTaxAmount;
        this.processingFee = processingFee;
        this.wantsToFinance = wantsToFinance;
    }

    public double getRecordingFee() {
        return recordingFee;

    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isWantsToFinance() {
        return wantsToFinance;
    }

    public void setWantsToFinance(boolean wantsToFinance) {
        this.wantsToFinance = wantsToFinance;
    }

    @Override
    public double getTotalPrice() {
        return (super.getVehicleSold().getPrice() + this.salesTaxAmount + this.processingFee + this.recordingFee);
    }

    @Override
    public double getMonthlyPayment() {
        if(this.wantsToFinance){
            double finalceRate = (super.getVehicleSold().getPrice() < 10000) ? 0.0525 : 0.0425;
            double finalceTerm = (super.getVehicleSold().getPrice() < 10000) ? 24 : 48;
            return BankingCalculators.calculateLoanPayment(this.getTotalPrice(), finalceRate, finalceTerm);
        }
        return 0;
    }

    @Override
    public String toString(){
        return "Contract for " + super.getCustomerName() + " to Purchase " + super.getVehicleSold();
    }
}

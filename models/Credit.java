package models;

import java.io.Serializable;

public class Credit implements Serializable {
    private String bankName;
    private double interestRate;
    private double maxLoanAmount;
    private int maxLoanTermMonths;

    public Credit(String bankName, double interestRate, double maxLoanAmount, int maxLoanTermMonths) {
        this.bankName = bankName;
        this.interestRate = interestRate;
        this.maxLoanAmount = maxLoanAmount;
        this.maxLoanTermMonths = maxLoanTermMonths;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getMaxLoanAmount() {
        return maxLoanAmount;
    }

    public void setMaxLoanAmount(double maxLoanAmount) {
        this.maxLoanAmount = maxLoanAmount;
    }

    public int getMaxLoanTermMonths() {
        return maxLoanTermMonths;
    }

    public void setMaxLoanTermMonths(int maxLoanTermMonths) {
        this.maxLoanTermMonths = maxLoanTermMonths;
    }

    @Override
    public String toString() {
        return "Банк: " + bankName +
                "\nВiдсоткова ставка: " + interestRate + "%" +
                "\nМаксимальна сума кредиту: $" + maxLoanAmount +
                "\nМаксимальний строк погашення: " + maxLoanTermMonths + " мiсяцiв";
    }
}

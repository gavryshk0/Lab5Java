package models;

public class PersonalLoan extends Credit {
    private String purpose;

    public PersonalLoan(String bankName, double interestRate, double maxLoanAmount, int maxLoanTermMonths, String purpose) {
        super(bankName, interestRate, maxLoanAmount, maxLoanTermMonths);
        this.purpose = purpose;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Override
    public String toString() {
        return super.toString() + "\nЦiль використання: " + purpose;
    }
}

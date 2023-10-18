package models;

public class MortgageLoan extends Credit {
    private String propertyType;

    public MortgageLoan(String bankName, double interestRate, double maxLoanAmount, int maxLoanTermMonths, String propertyType) {
        super(bankName, interestRate, maxLoanAmount, maxLoanTermMonths);
        this.propertyType = propertyType;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    @Override
    public String toString() {
        return super.toString() + "\nТип нерухомостi: " + propertyType;
    }
}

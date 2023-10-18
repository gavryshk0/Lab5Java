package services;

import models.Credit;

import java.util.ArrayList;
import java.util.List;

public class LoanManager {
    private List<Credit> availableCredits;

    public LoanManager() {
        availableCredits = new ArrayList<>();
    }

    public List<Credit> getAvailableCredits() {
        return availableCredits;
    }

    public void addCredit(Credit credit) {
        availableCredits.add(credit);
    }

    public void setAvailableCredits(List<Credit> credits) {
        availableCredits = credits;
    }

    public void removeCredit(Credit credit) {
        availableCredits.remove(credit);
    }

    public List<Credit> searchCredits(double maxLoanAmount, int maxLoanTermMonths) {
        List<Credit> matchingCredits = new ArrayList<>();
        for (Credit credit : availableCredits) {
            if (credit.getMaxLoanAmount() >= maxLoanAmount && credit.getMaxLoanTermMonths() >= maxLoanTermMonths) {
                matchingCredits.add(credit);
            }
        }
        return matchingCredits;
    }
}

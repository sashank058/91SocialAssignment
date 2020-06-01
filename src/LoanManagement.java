import constants.LoanConstants;

import java.time.LocalDate;
import java.util.ArrayList;

public class LoanManagement {
    private double loanAmount;
    private int noOfEMI;
    private LocalDate loanCreationDate;
    private double loanInterest;
    private ArrayList<EMIDetails> emiDetails;
    private double totalPayableAmount;

    public LoanManagement(double loanAmount, int noOfEMI) {
        this.loanAmount = loanAmount;
        this.noOfEMI = noOfEMI;
        this.loanCreationDate = LocalDate.now();
        this.loanInterest = (LoanConstants.LOAN_INTEREST_RATE * loanAmount) / 100;
        this.totalPayableAmount = loanAmount + (LoanConstants.LOAN_INTEREST_RATE * loanAmount) / 100;
        this.emiDetails = this.emiCalculation();
    }

    public ArrayList<EMIDetails> emiCalculation() {
        double principalEmi = loanAmount / noOfEMI;
        double interestEmi = loanInterest / noOfEMI;
        double totalEmi = principalEmi + interestEmi;
        ArrayList<EMIDetails> emiDetails = new ArrayList<>();
        for (int emiNum = 1; emiNum <= noOfEMI; emiNum++) {
            LocalDate emiDate = LocalDate.now().plusMonths(emiNum);
            double principalRemaining = totalPayableAmount - (totalEmi * emiNum);
            EMIDetails detail = new EMIDetails(emiNum, principalEmi, interestEmi, totalEmi,
                    emiDate, principalRemaining);
            emiDetails.add(detail);
        }
        return emiDetails;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public int getNoOfEMI() {
        return noOfEMI;
    }

    public LocalDate getLoanCreationDate() {
        return loanCreationDate;
    }

    public double getLoanInterest() {
        return loanInterest;
    }

    public ArrayList<EMIDetails> getEmiDetails() {
        return emiDetails;
    }

    public double getTotalPayableAmount() {
        return totalPayableAmount;
    }
}

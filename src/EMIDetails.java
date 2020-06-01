import java.time.LocalDate;

public class EMIDetails {
    private int emiNo;
    private double principalEmi;
    private double interestEmi;
    private double totalEmi;
    private LocalDate emiDate;
    private double principalRemaining;

    public EMIDetails(int emiNo, double principalEmi, double interestEmi, double totalEmi,
                      LocalDate emiDate, double principalRemaining) {
        this.emiNo = emiNo;
        this.principalEmi = principalEmi;
        this.interestEmi = interestEmi;
        this.totalEmi = totalEmi;
        this.emiDate = emiDate;
        this.principalRemaining = principalRemaining;
    }

    public int getEmiNo() {
        return emiNo;
    }

    public double getPrincipalEmi() {
        return principalEmi;
    }

    public double getInterestEmi() {
        return interestEmi;
    }

    public double getTotalEmi() {
        return totalEmi;
    }

    public LocalDate getEmiDate() {
        return emiDate;
    }

    public double getPrincipalRemaining() {
        return principalRemaining;
    }
}

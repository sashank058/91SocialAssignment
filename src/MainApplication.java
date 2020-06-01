import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.time.LocalDate;

public class MainApplication {

    public static LocalDate getLoanCreationDate(LoanManagement loanManagement){
        return loanManagement.getLoanCreationDate();
    }

    public static double getLoanAmount(LoanManagement loanManagement){
        return loanManagement.getLoanAmount();
    }

    public static int getNoOfEMI(LoanManagement loanManagement){
        return loanManagement.getNoOfEMI();
    }

    public static double getTotalPayableAmount(LoanManagement loanManagement){
        return loanManagement.getTotalPayableAmount();
    }

    public static ArrayList<EMIDetails> getEmiDetails(LoanManagement loanManagement){
        return loanManagement.getEmiDetails();
    }

    public static void printDetails(LoanManagement loanManagement){
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("1. Loan Creation Date: "+getLoanCreationDate(loanManagement));
        System.out.println("2. Principal Amount: "+getLoanAmount(loanManagement));
        System.out.println("3. No of EMI's: "+getNoOfEMI(loanManagement));
        System.out.println("4. Total Payable Amount: "+getTotalPayableAmount(loanManagement));
        System.out.println("5. EMI Details: ");
        System.out.println();
        ArrayList<EMIDetails> emiDetails = getEmiDetails(loanManagement);
        for(EMIDetails detail: emiDetails){
            System.out.println(("EMI No: "+detail.getEmiNo()+
                    ",Principal EMI: "+df.format(detail.getPrincipalEmi())+
                    ",Interest EMI: "+df.format(detail.getInterestEmi())+
                    ",Total EMI: "+df.format(detail.getTotalEmi())+
                    ", EMI Date: "+detail.getEmiDate()+
                    ",Principal Remaining: "+df.format(detail.getPrincipalRemaining())));
            System.out.println();
        }
    }

    public static LoanManagement setupLoanManagement(double loanAmount,int noOfEMI){
        return new LoanManagement(loanAmount, noOfEMI);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the loan amount: \t");
        double loanAmount = sc.nextDouble();
        System.out.print("Enter the no of EMI's: \t");
        int noOfEMI = sc.nextInt();
        sc.close();
        if(noOfEMI <=0 | loanAmount <= 0){
            System.out.println("Both of these inputs cannot be negative and must be greater than 0.");
            System.out.println("Please try again later");
            return;
        }
        LoanManagement loanManagement = setupLoanManagement(loanAmount,noOfEMI);
        printDetails(loanManagement);
    }
}

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

public class MainApplicationTest {
    @Test
    public void testEMI() {
        double loanAmount = 1000;
        int noOfEMI = 12;
        ArrayList<EMIDetails> expectedResult = new ArrayList<>();
        expectedResult.add(new EMIDetails(1, 83.33, 10.00, 93.33,
                LocalDate.now().plusMonths(1), 1026.67));
        expectedResult.add(new EMIDetails(2, 83.33, 10.00, 93.33,
                LocalDate.now().plusMonths(2), 933.33));
        expectedResult.add(new EMIDetails(3, 83.33, 10.00, 93.33,
                LocalDate.now().plusMonths(3), 840.00));
        expectedResult.add(new EMIDetails(4, 83.33, 10.00, 93.33,
                LocalDate.now().plusMonths(4), 746.67));
        expectedResult.add(new EMIDetails(5, 83.33, 10.00, 93.33,
                LocalDate.now().plusMonths(5), 653.33));
        expectedResult.add(new EMIDetails(6, 83.33, 10.00, 93.33,
                LocalDate.now().plusMonths(6), 560.00));
        expectedResult.add(new EMIDetails(7, 83.33, 10.00, 93.33,
                LocalDate.now().plusMonths(7), 466.67));
        expectedResult.add(new EMIDetails(8, 83.33, 10.00, 93.33,
                LocalDate.now().plusMonths(8), 373.33));
        expectedResult.add(new EMIDetails(9, 83.33, 10.00, 93.33,
                LocalDate.now().plusMonths(9), 280.00));
        expectedResult.add(new EMIDetails(10, 83.33, 10.00, 93.33,
                LocalDate.now().plusMonths(10), 186.67));
        expectedResult.add(new EMIDetails(11, 83.33, 10.00, 93.33,
                LocalDate.now().plusMonths(11), 93.33));
        expectedResult.add(new EMIDetails(12, 83.33, 10.00, 93.33,
                LocalDate.now().plusMonths(12), .00));
        LoanManagement management = new LoanManagement(loanAmount, noOfEMI);
        for(int i=0;i<12;i++) {
            Assert.assertEquals(expectedResult.get(i).getEmiNo(), management.getEmiDetails().get(i).getEmiNo());
            Assert.assertEquals(expectedResult.get(i).getEmiDate(), management.getEmiDetails().get(i).getEmiDate());
        }
    }
}

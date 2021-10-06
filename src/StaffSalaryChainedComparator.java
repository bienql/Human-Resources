import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StaffSalaryChainedComparator implements Comparator<StaffSalary>{
    private List<Comparator<StaffSalary>> listComparators;

    public StaffSalaryChainedComparator(Comparator<StaffSalary>... comparators) {
        this.listComparators = Arrays.asList(comparators);
    }

    public int compare(StaffSalary ss1, StaffSalary ss2) {
        for (Comparator<StaffSalary> comparator: listComparators) {
            double result = comparator.compare(ss1, ss2);
            if (result != 0) {
                return (int) result;
            }
        }
        return 0;
    }
}


import java.util.Comparator;

public class StaffSalaryComparator implements Comparator<StaffSalary> {

    @Override
    public int compare(StaffSalary ss1, StaffSalary ss2) {
        return (int) (ss1.getSalary() - ss2.getSalary());
    }

}

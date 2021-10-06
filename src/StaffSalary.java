public class StaffSalary extends Staff {
    private double salary;

    public StaffSalary(String id, String name, int age, double payrate, String startingdate, String department, double vacation, String position, double salary) {
        super(id, name, age, payrate, startingdate, department, vacation);
        this.salary = salary;

    }
    public StaffSalary() {
        super();
    }
    public double getSalary() {
        return salary;
    }

    public void displayInformation() {
    }

    public String toString() {
        return String.format("%-20s\t%-20s\t%-20s", this.getName(), this.getDepartment(), "VND " + String.format("%,.0f",salary));
    }


}

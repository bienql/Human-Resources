public class Employee extends Staff {
    private double overtime;


    public Employee(String id, String name, int age, double payrate, String startingdate, String department, double vacation, double overtime) {
        super(id, name, age, payrate, startingdate, department, vacation);
        this.overtime = overtime;

    }

    public Employee() {
        super();
    }

    public double getOvertime() {
        return overtime;
    }


    @Override
    public void displayInformation() {
        System.out.println(String.format(
                "%-5s\t%-20s\t%-22s\t%-7s\t%-10s\t%-20s\t%-17s\t%-18s\t%-12s",
                this.getId(),
                this.getName(),
                "",
                String.valueOf(this.getAge()),
                String.valueOf(this.getPayrate()),
                String.valueOf(this.getStartingdate()),
                this.getDepartment(),
                String.valueOf(this.getVacation()),
                overtime));
    }

    public double calculateSalary() {
        double salary = this.getPayrate() * 3000000 + this.overtime * 200000;


        return salary;
    }

}

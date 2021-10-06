public class Manager extends Staff {
    private String position;

    public Manager(String id, String name, int age, double payrate, String startingdate, String department, double vacation, String position) {
        super(id, name, age, payrate, startingdate, department, vacation);
        this.position = position;
    }

    public Manager() {
        super();
    }

    public String getPosition() {
        return position;
    }


    @Override
    public void displayInformation() {
        System.out.println(String.format(
                        "%-5s\t%-20s\t%-22s\t%-7s\t%-10s\t%-20s\t%-17s\t%-18s\t%-12s",
                        this.getId(),
                        this.getName(),
                        position,
                        String.valueOf(this.getAge()),
                        String.valueOf(this.getPayrate()),
                        String.valueOf(this.getStartingdate()),
                        this.getDepartment(),
                        String.valueOf(this.getVacation()),
                        ""));

    }

    public double calculateSalary() {
        double salary = 0.0;
        if (this.position.equals("Business Leader")) {
            calBusinessleader businessleader = new calBusinessleader();
            salary = businessleader.pay(this.getPayrate());

        }

        if (this.position.equals("Project Leader")) {
            calProjectleader projectleader = new calProjectleader();
            salary = projectleader.pay(this.getPayrate());

        }

        if (this.position.equals("Tech Leader")) {
            calTechleader techleader = new calTechleader();
            salary = techleader.pay(this.getPayrate());

        }

        return salary;
    }

}

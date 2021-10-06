public abstract class Staff {
    private String id;
    private String name;
    private int age;
    private double payrate;
    private String startingdate;
    private String department;
    private double vacation;


    public Staff (String id, String name, int age, double payrate, String startingdate, String department, double vacation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.payrate = payrate;
        this.startingdate = startingdate;
        this.department = department;
        this.vacation = vacation;
    }

    public Staff() {
        super();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getPayrate() {
        return payrate;
    }

    public String getStartingdate() {
        return startingdate;
    }

    public String getDepartment() {
        return department;
    }

    public double getVacation() {
        return vacation;
    }


    public abstract void displayInformation();
}

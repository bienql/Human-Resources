public class Department {
    private String departmentid;
    private String departmentname;
    private int staffcount = 0;

    public Department(String departmentid, String departmentname) {
        this.departmentid = departmentid;
        this.departmentname = departmentname;
        this.staffcount = staffcount;
    }

    public int addStaffcount(int number) {
        staffcount+=number;
        return staffcount;
    }

    public String getDepartmentname() {
        return departmentname;
    }
    public String getDepartmentid() { return departmentid; }

    public String toString() {
        return (String.format("%-5s\t%-20s\t%-20s", departmentid, departmentname, String.valueOf(staffcount)));
    }

}

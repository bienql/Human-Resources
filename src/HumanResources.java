import java.util.*;

public class HumanResources {
    static ArrayList<Employee> employeelist = new ArrayList<Employee>();
    static ArrayList<Manager> managerlist = new ArrayList<Manager>();
    static ArrayList<Department> departmentlist = new ArrayList<Department>();
    static ArrayList<StaffSalary> staffSalaryOrd = new ArrayList<StaffSalary>();
    static long idCounter = 4;

    public static void main (String[] args) {

        //Department list
        departmentlist.add(new Department("EX1", "External Affair"));
        departmentlist.add(new Department("MKT", "Marketing"));
        departmentlist.add(new Department("FRE", "Frontend"));
        departmentlist.add(new Department("BKE", "Backend"));
        departmentlist.add(new Department("SAL", "Sales"));
        departmentlist.add(new Department("CSV", "Customer Service"));

        // initiate some entries for testing purpose
        Employee jackiechan = new Employee("001", "Jackie Chan", 55, 4.0, "11-12-09", "External Affair", 3.5, 12.3);
        Employee wujing = new Employee("002", "Wu Jing", 45, 3.0, "10-06-09", "Marketing", 6.0, 10.0);
        Manager festong = new Manager("003", "Fest Ong", 55, 6.0, "05-03-03", "Marketing", 2.0, "Business Leader");
        employeelist.add(jackiechan);
        employeelist.add(wujing);
        managerlist.add(festong);
        departmentlist.get(0).addStaffcount(1);
        departmentlist.get(1).addStaffcount(2);


        int input;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("<<<WELCOME TO HRM SOFT>>>");
            System.out.println("1. Staff list");
            System.out.println("2. Department list");
            System.out.println("3. Staff list based on department");
            System.out.println("4. Add staff");
            System.out.println("5. Search for staff by name or staff code");
            System.out.println("6. Display staff salary");
            System.out.println("7. Display staff salary (in an ascending order)");
            System.out.println("8. Display staff salary (in an descending order)");
            System.out.print("PLEASE CHOOSE AN ACCORDING FUNCTION: ");
            input = sc.nextInt();

            switch (input) {
                case 1:
                    showStafflist();
                    break;
                case 2:
                    showDepartmentlist();
                    break;
                case 3:
                    showStaffDepbasedlist();
                    break;
                case 4:
                    addStaff();
                    break;
                case 5:
                    searchStaff();
                    break;
                case 6:
                    staffSalary();
                    break;
                case 7:
                    staffSalaryOrder();
                    break;
                case 8:
                    staffSalaryOrderDes();
                    break;

            }
            System.out.println();

        }
        while (input != 9);
    }

    private static synchronized String createId() {
        return String.format("%03d", idCounter++);
    }

    // CASE 1
    private static void showStafflist() {
        System.out.println();
        System.out.println(String.format("%-5s\t%-20s\t%-22s\t%-7s\t%-10s\t%-20s\t%-17s\t%-18s\t%-12s", "ID", "NAME", "POSITION", "AGE", "PAYRATE", "DATE STARTED WORKING", "DEPARTMENT", "DAYS TAKEN OFF", "OVERTIME"));
        for (Manager m: managerlist) {
            m.displayInformation();
        }

        for (Employee e : employeelist) {
            e.displayInformation();
        }
    }

    // CASE 2
    public static void showDepartmentlist() {
        System.out.println();
        System.out.println(String.format("%-5s\t%-20s\t%-20s", "ID", "DEPARTMENT", "NUMBER OF STAFF"));
        for (Department d: departmentlist) {
            System.out.println(d.toString());
        }
    }

    // CASE 3
    private static void showStaffDepbasedlist() {
        System.out.println();
        System.out.println(String.format("%-20s\t%-5s\t%-20s\t%-22s\t%-7s\t%-10s\t%-20s\t%-17s\t%-18s\t%-12s", "DEPARTMENT", "ID", "NAME", "POSITION", "AGE", "PAYRATE", "DATE STARTED WORKING", "DEPARTMENT", "DAYS TAKEN OFF", "OVERTIME"));
        for (int i = 0; i < departmentlist.size(); i++) {
            System.out.println(String.format("%-20s\t%-20s", departmentlist.get(i).getDepartmentname(), " -----------------------"));
            for (int j = 0; j < managerlist.size(); j++) {
                if (managerlist.get(j).getDepartment().equals(departmentlist.get(i).getDepartmentname())) {
                    System.out.print("                       ");
                    managerlist.get(j).displayInformation();
                }
            }
            for (int j = 0; j < employeelist.size(); j++) {
                if (employeelist.get(j).getDepartment().equals(departmentlist.get(i).getDepartmentname())) {
                    System.out.print("                       ");
                    employeelist.get(j).displayInformation();
                }
            }
        }
    }

    // CASE 4
    private static void addStaff() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please choose what you would like to add   1. Employee  2. Manager  : ");
        int input = sc.nextInt();

        switch (input) {
            case 1: addEmployee();
                break;
            case 2: addManager();
                break;
        }
    }

    private static void addEmployee() {
        int input;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please provide the following information:");
            System.out.print("Employee name: ");
            String name = sc.nextLine();
            String id = createId(); // generate a unique ID
            System.out.println("ID (auto-generated): " + id);
            System.out.print("Age: ");
            int age = sc.nextInt();
            System.out.print("Payrate: ");
            double payrate = sc.nextDouble();
            System.out.print("Date started working (DD-MM-YY): ");
            String startingdate = sc.next();
            /*input date and validate it here*/
            String department = "";
            System.out.print("Department: ");
            department = sc.nextLine();
            department = sc.nextLine(); //fix skipping user input


            for (int i = 0; i < departmentlist.size(); i++) {
                if (department.equals(departmentlist.get(i).getDepartmentname())) {
                    departmentlist.get(i).addStaffcount(1);
                }
            }

            System.out.print("Number of days off work: ");
            double vacation = sc.nextDouble();
            System.out.print("Overtime: ");
            double overtime = sc.nextDouble();

            Employee e = new Employee(id, name, age, payrate, startingdate, department, vacation, overtime);
            employeelist.add(e);

            System.out.println("Employee successfully added!");
            System.out.print("Do you want to add another employee? (Yes = 1) ");
            input = sc.nextInt();
        }
        while (input == 1);
    }

    private static void addManager() {
        int input;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please provide the following information:");
            System.out.print("Manager name: ");
            String name = sc.nextLine();
            String id = createId(); // generate a unique ID
            System.out.println("ID (auto-generated): " + id);
            System.out.print("Age: ");
            int age = sc.nextInt();
            System.out.print("Payrate: ");
            double payrate = sc.nextDouble();
            System.out.print("Date started working (DD-MM-YY): ");
            String startingdate = sc.next();
            /*input date and validate it here*/
            String department = "";
            System.out.print("Department: ");
            department = sc.nextLine();
            department = sc.nextLine(); //fix skipping user input

            for (int i = 0; i < departmentlist.size(); i++) {
                if (department.equals(departmentlist.get(i).getDepartmentname())) {
                    departmentlist.get(i).addStaffcount(1);
                }
            }

            //may consider adding validation if department name unmatched

            System.out.print("Number of days off work: ");
            double vacation = sc.nextDouble();
            System.out.print("Position: ");
            String position = sc.nextLine();
            position = sc.nextLine();

            Manager m = new Manager(id, name, age, payrate, startingdate, department, vacation, position);
            managerlist.add(m);

            System.out.println("Manager successfully added!");
            System.out.print("Do you want to add another manager? (Yes = 1) ");
            input = sc.nextInt();
        }
        while (input == 1);
    }

    // CASE 5
    private static void searchStaff() {
        int input;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.print("Please input staff name or staff ID: ");
            String check = sc.nextLine();
            int searchcount = 0;
            System.out.println();
            System.out.println(String.format("%-5s\t%-20s\t%-22s\t%-7s\t%-10s\t%-20s\t%-17s\t%-18s\t%-12s", "ID", "NAME", "POSITION", "AGE", "PAYRATE", "DATE STARTED WORKING", "DEPARTMENT", "DAYS TAKEN OFF", "OVERTIME"));

            for (int i = 0; i < managerlist.size(); i++) {
                if (managerlist.get(i).getName().toLowerCase().contains(check.toLowerCase()) || managerlist.get(i).getId().toLowerCase().contains(check.toLowerCase())) {
                    managerlist.get(i).displayInformation();
                    searchcount++;
                }
            }
            for (int i = 0; i < employeelist.size(); i++) {
                if (employeelist.get(i).getName().toLowerCase().contains(check.toLowerCase()) || employeelist.get(i).getId().toLowerCase().contains(check.toLowerCase())) {
                    employeelist.get(i).displayInformation();
                    searchcount++;
                }
            }
            System.out.println(searchcount + " record(s) found!");
            System.out.print("Do you want to search for another staff? (Yes = 1): ");
            input = sc.nextInt();
        }
        while (input == 1);
    }

    // CASE 6
    private static void staffSalary() {
        System.out.println();
        System.out.println(String.format("%-20s\t%-20s\t%-20s", "NAME", "DEPARTMENT", "SALARY"));
        for (int i = 0; i < managerlist.size(); i++) {
            String department = managerlist.get(i).getDepartment();
            String name = managerlist.get(i).getName();
            double salary = managerlist.get(i).calculateSalary();

            System.out.println(String.format("%-20s\t%-20s\t%-20s", name, department, "VND " + String.format("%,.0f", salary)));
        }

        for (int i = 0; i < employeelist.size(); i++) {
            String department = employeelist.get(i).getDepartment();
            String name = employeelist.get(i).getName();
            double salary = employeelist.get(i).calculateSalary();
            System.out.println(String.format("%-20s\t%-20s\t%-20s", name, department, "VND " + String.format("%,.0f", salary)));
        }
    }

    // CASE 7
    private static void staffSalaryOrder() {
        staffSalaryOrd.clear();

        for (int i = 0; i < managerlist.size(); i++) {
            String department = managerlist.get(i).getDepartment();
            String name = managerlist.get(i).getName();
            double salary = managerlist.get(i).calculateSalary();
            staffSalaryOrd.add(new StaffSalary("", name, 0, 0.0, "", department,0.0,"", salary));
        }

        for (int i = 0; i < employeelist.size(); i++) {
            String department = employeelist.get(i).getDepartment();
            String name = employeelist.get(i).getName();
            double salary = employeelist.get(i).calculateSalary();
            staffSalaryOrd.add(new StaffSalary("", name, 0, 0.0, "", department,0.0,"", salary));
        }

        Collections.sort(staffSalaryOrd, new StaffSalaryChainedComparator(new StaffSalaryComparator()));
        System.out.println();
        System.out.println(String.format("%-20s\t%-20s\t%-20s", "NAME", "DEPARTMENT", "SALARY"));
        for (StaffSalary ss: staffSalaryOrd) {
            System.out.println(ss);
        }
    }

    // CASE 8
    private static void staffSalaryOrderDes() {
        staffSalaryOrd.clear();

        for (int i = 0; i < managerlist.size(); i++) {
            String department = managerlist.get(i).getDepartment();
            String name = managerlist.get(i).getName();
            double salary = managerlist.get(i).calculateSalary();
            staffSalaryOrd.add(new StaffSalary("", name, 0, 0.0, "", department,0.0,"", salary));
        }

        for (int i = 0; i < employeelist.size(); i++) {
            String department = employeelist.get(i).getDepartment();
            String name = employeelist.get(i).getName();
            double salary = employeelist.get(i).calculateSalary();
            staffSalaryOrd.add(new StaffSalary("", name, 0, 0.0, "", department,0.0,"", salary));
        }

        Collections.sort(staffSalaryOrd, Collections.reverseOrder(new StaffSalaryChainedComparator(new StaffSalaryComparator())));
        System.out.println();
        System.out.println(String.format("%-20s\t%-20s\t%-20s", "NAME", "DEPARTMENT", "SALARY"));
        for (StaffSalary ss: staffSalaryOrd) {
            System.out.println(ss);
        }
    }

}

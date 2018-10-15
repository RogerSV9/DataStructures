import java.util.Date;

public class EmployeeClass {
    //Attributes
    String name, username, companyName;
    Date birthday;
    double salary;

    //Constructor

    public EmployeeClass(String name, String username, String companyName, Date birthday, double salary) {
        this.name = name;
        this.username = username;
        this.companyName = companyName;
        this.birthday = birthday;
        this.salary = salary;
    }

    //Method
    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public double getSalary() {
        return salary;
    }

    //We have to implement this compareTo to return the name that we will use later in MyManager class
    public int compareTo(EmployeeClass o) {
        return this.getName().compareTo(o.getName());
    }

}

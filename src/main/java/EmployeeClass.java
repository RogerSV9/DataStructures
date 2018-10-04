import java.util.Date;

public class EmployeeClass {
    public String name;
    public String surname;
    public Date birthday;
    public double salary;
    public String companyName;

    public EmployeeClass(String name, String surname, Date birthday, double salary, String companyName){
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.salary = salary;
        this.companyName = companyName;
    }

    public String getName(){
        return this.name;
    }

    public String getSurname() {
        return this.surname;
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

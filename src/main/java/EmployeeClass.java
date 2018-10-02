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

    public void addEmployee(String name, String surname, Date birthday, double salary, String companyName) throws MyException{
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.salary = salary;
        this.companyName = companyName;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

import java.util.LinkedList;
import java.util.List;

public class CompanyClass {
    public String companyName;
    public String description;
    private List<EmployeeClass> employees;

    public CompanyClass (String name, String description){
        this.companyName = name;
        this.description = description;
        this.employees=new LinkedList<EmployeeClass>();
    }
    public void addCompany (String name, String description){
        this.companyName = name;
        this.description = description;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getDescription() {
        return description;
    }

    public List<EmployeeClass> employees() {
        return this.employees;
    }

    public void addEmployee(EmployeeClass e) {
        this.employees.add(e);
    }
}

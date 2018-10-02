import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public abstract class Manager implements CompanyManager{
    HashMap<Integer,CompanyClass> CompanyMap = new HashMap<Integer, CompanyClass>();
    List<EmployeeClass> EmployeeList = new LinkedList<EmployeeClass>();
    public List<Employee> findAllEmployeesOrderedByName(){
        return null;
    }

    public List<Employee> findAllEmployeesOrderedBySalary() {
        return null;
    }

    public List<Employee> employees(String company) {
        return null;
    }

    public List<Company> findAllCompanies() {
        return null;
    }
}

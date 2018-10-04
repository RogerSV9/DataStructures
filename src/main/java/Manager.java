import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public abstract class Manager implements CompanyManager{
    HashMap<Integer,CompanyClass> CompanyMap = new HashMap<Integer, CompanyClass>();
    List<EmployeeClass> EmployeeList = new LinkedList<EmployeeClass>();
    public List<EmployeeClass> findAllEmployeesOrderedByName(){
        return null;
    }

    public List<EmployeeClass> findAllEmployeesOrderedBySalary() {
        return null;
    }

    public List<EmployeeClass> employees(String company) {
        return null;
    }

    public List<CompanyClass> findAllCompanies() {
        return null;
    }
}

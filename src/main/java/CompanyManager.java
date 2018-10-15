import java.util.Date;
import java.util.List;


public interface CompanyManager {

    public void addCompany(String companyName, String description);
    public void addEmployee(String name, String surname, Date birthday, double salary, String companyName) throws CompanyNotFoundException, CompanyNotFoundException;
    public List<EmployeeClass> findAllEmployeesOrderedByName();
    public List<EmployeeClass> findAllEmployeesOrderedBySalary();
    public List<EmployeeClass> employees(String company) throws CompanyNotFoundException;
    public List<CompanyClass> findAllCompanies();
}

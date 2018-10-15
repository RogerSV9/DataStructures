import java.util.*;

public class Manager implements CompanyManager{
    //Initialize the linkedlist of employees
    private List<EmployeeClass> employees = new LinkedList<EmployeeClass>();

    //Initialize the hashmap(key: integer; value: Company) of companies
    private HashMap<String, CompanyClass> companies = new HashMap<String, CompanyClass>();

    //Add a company
    public void addCompany(String companyName, String description) {
        companies.put(companyName, new CompanyClass(companyName, description));
    }

    //Add an employee(We have to add the paramaters in order by type. In my case I've ordered first Strings, then Dates and finally doubles)
    //This method has to throw an Exception for one reason: if the Employee that we want to add, its company doesn't exist
    //in the HashMap, it has to throw an Exception, saying that the company doesn't exist. If the company exist,
    //we will add an Employee normally.
    public void addEmployee(String name, String username, Date birthday, double salary, String companyName) throws CompanyNotFoundException {
        //First we have to obtain the value of the especified key, which is the companyName. If the value is null, we have to throw an exception
        CompanyClass theCompany = this.companies.get(companyName);
        if (theCompany==null) throw new CompanyNotFoundException();

        //If it isn't null, we have to add it
        EmployeeClass e = new EmployeeClass(name, username, companyName, birthday, salary);
        this.employees.add(e);
        theCompany.addEmployee(e);
    }

    //Find all employees in the linkedlist and show them ordered by Name(Ascending or descending)
    public List<EmployeeClass> findAllEmployeesOrderedByName(){
        //We want to create a copy of the actual list of Employees, because it will be better not to modify the list.
        List<EmployeeClass> ret = new LinkedList<EmployeeClass>();
        ret.addAll(this.employees);
        //This method sort, by default sort the strings in ascending order. We don't have to create an especific function to order these names
        //Collections.sort(ret);

        return ret;
    }


    //Find all employees in the linkedlist and show them ordered by salaray(Ascending or descending)
    public List<EmployeeClass> findAllEmployeesOrderedBySalary() {
        //Again we will create a copy of the list
        List<EmployeeClass> ret = new LinkedList<EmployeeClass>();
        ret.addAll(this.employees);

        //As we did in figures, we have to tell to the sort method, which criteria has to apply
        Collections.sort(ret, new Comparator<EmployeeClass>() {
            //Function to compare the salary
            public int compare(EmployeeClass o1, EmployeeClass o2) {
                return (int)(o1.getSalary()-o2.getSalary());
            }
        });

        return ret;
    }

    //Show all the employees in the linkedlist given a company name
    public List<EmployeeClass> employees(String company) throws CompanyNotFoundException{
        List<EmployeeClass> employees=null;

        //We want theCompany value, given a company entered by the user
        CompanyClass theCompany = this.companies.get(company);
        if (theCompany!=null) {
            employees = theCompany.employees();
        }
        else throw new CompanyNotFoundException();

        return employees;
    }

    //Show all the companies in the hashmap
    public List<CompanyClass> findAllCompanies() {
        //We have to cast the value
        List<CompanyClass> c = new LinkedList<CompanyClass>();

        //By default they will add the values in alphabetical order
        c.addAll(this.companies.values());

        return c;
    }
}

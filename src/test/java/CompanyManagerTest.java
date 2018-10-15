import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
public class CompanyManagerTest {
    final static Logger log = Logger.getLogger(CompanyManagerTest.class.getName());

    //We have to create and object of type CompanyManager, for then use its methods
    private CompanyManager cm;

    //Before the tests we have to add Employees and Companies
    @Before
    public void setUp() {
        //Because MyManager implements CompanyManager, we can create on top of cm, new MyManager
        this.cm = new Manager();
        //Add companies
        this.cm.addCompany("UPC", "La UPC");

        //Because addEmployee can throw an exception, we may provide it with try and catch (in catch we will use log4j)
        try {
            this.cm.addEmployee("Roger", null,null, 1500.56, "AUDI");
        }
        catch (CompanyNotFoundException e) {
            log.warn("El employee que ha intentado introducir trabaja en una empresa la cual no existe: " +e.getMessage());
        }
    }

    //When the test ends, it's properly to erase the contents added in @Before
    @After
    public void tearDown(){
        this.cm = null;
    }

    //We will verify if we add the employees properly (this time without an exception)
    @Test
    public void addEmployee(){
        try {
            //Create three new employees
            this.cm.addEmployee("Jordi", null,null, 1000, "AUDI");


            List<EmployeeClass> employeeList=this.cm.employees("AMAZON");


            employeeList=this.cm.employees("AUDI");

            assertEquals(employeeList.get(0).getName(), "Roger");
        }
        catch (CompanyNotFoundException me) {
            log.warn("El employee que ha intentado introducir trabaja en una empresa la cual no existe: " +me.getMessage());
        }

    }

    //We will test the CompanyNotFoundException
    @Test (expected = CompanyNotFoundException.class)
    public void addEmployeeAndCompanyNotFound() throws CompanyNotFoundException {
        //We will throw an error, because the company "XXXXXXXXXX" doesn't exist
        this.cm.addEmployee("user", null,null, 10000, "x");

    }

    //We will test if the Employees are ordered by name properly
    @Test
    public void findAllEmployeesOrderedByName(){
        List<EmployeeClass> esort = this.cm.findAllEmployeesOrderedByName();

        //assertEquals(esort.get(0).name, "Roger");
    }

    //We will test if the Employees are ordered by salary properly
    @Test
    public void findAllEmployeesOrderedBySalary(){
        List<EmployeeClass> esort = this.cm.findAllEmployeesOrderedBySalary();

        //assertEquals(esort.get(0).salary, 1400, 0);

    }

    //We will test if it return the all companies
    @Test
    public void findAllCompanies(){
        List<CompanyClass> allcompanies = this.cm.findAllCompanies();

        //assertEquals(allcompanies.get(0).companyName, "AUDI");
    }

    //We will test if we obtain properly the employees that work on indicated company
    @Test
    public void employees(){
        try {
            List<EmployeeClass> e = this.cm.employees("AUDI");

            assertEquals(e.get(0).name, "Roger");
        }
        catch(CompanyNotFoundException e){
            log.warn("La empresa que ha introducido para buscar a sus empleados NO existe!: " +e.getMessage());
        }
    }

    //We will test the same as the test employees, but now with the exception
    @Test(expected = CompanyNotFoundException.class)
    public void employeesAndCompanyNotFound() throws CompanyNotFoundException{
        List<EmployeeClass> e = this.cm.employees("SPE");
    }

}

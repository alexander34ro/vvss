package aair2039MV;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import aair2039MV.enumeration.DidacticFunction;
import aair2039MV.model.Employee;
import aair2039MV.repository.interfaces.EmployeeRepositoryInterface;
import aair2039MV.repository.mock.EmployeeCacheRepo;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void TC1() {
        EmployeeRepositoryInterface employeesRepository = new EmployeeCacheRepo();
        assertEquals(6, employeesRepository.getEmployeeList().size());

        Employee employee = new Employee("Ion", "123456789aaaa", DidacticFunction.TEACHER, 100);
        employeesRepository.addEmployee(employee);
        assertEquals(7, employeesRepository.getEmployeeList().size());
    }

    @Test
    public void TC2() {
        EmployeeRepositoryInterface employeesRepository = new EmployeeCacheRepo();
        assertEquals(6, employeesRepository.getEmployeeList().size());

        Employee employee = new Employee("123", "123456789aaaa", DidacticFunction.ASSISTANT, 100);
        employeesRepository.addEmployee(employee);
        assertEquals(6, employeesRepository.getEmployeeList().size());
    }

    @Test
    public void TC3() {
        EmployeeRepositoryInterface employeesRepository = new EmployeeCacheRepo();
        assertEquals(6, employeesRepository.getEmployeeList().size());

        Employee employee = new Employee("Ion", "123456789aaaa", DidacticFunction.LECTURER, 100);
        employeesRepository.addEmployee(employee);
        assertEquals(7, employeesRepository.getEmployeeList().size());
    }

    @Test
    public void TC4() {
        EmployeeRepositoryInterface employeesRepository = new EmployeeCacheRepo();
        assertEquals(6, employeesRepository.getEmployeeList().size());

        Employee employee = new Employee("Ion", "123456789aaaa", DidacticFunction.LECTURER, 0);
        employeesRepository.addEmployee(employee);
        assertEquals(6, employeesRepository.getEmployeeList().size());
    }
}

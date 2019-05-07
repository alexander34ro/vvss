package aair2039MV;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import aair2039MV.controller.EmployeeController;
import aair2039MV.enumeration.DidacticFunction;
import aair2039MV.model.Employee;
import aair2039MV.repository.interfaces.EmployeeRepositoryInterface;
import aair2039MV.repository.mock.EmployeeCacheRepo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void F01_TC01() {
        EmployeeRepositoryInterface employeesRepository = new EmployeeCacheRepo();
        assertEquals(6, employeesRepository.getEmployeeList().size());

        Employee employee = new Employee("Ion", "123456789aaaa", DidacticFunction.TEACHER, 100);
        employeesRepository.addEmployee(employee);
        assertEquals(7, employeesRepository.getEmployeeList().size());
    }

    @Test
    public void F01_TC02() {
        EmployeeRepositoryInterface employeesRepository = new EmployeeCacheRepo();
        assertEquals(6, employeesRepository.getEmployeeList().size());

        Employee employee = new Employee("123", "123456789aaaa", DidacticFunction.ASSISTANT, 100);
        employeesRepository.addEmployee(employee);
        assertEquals(6, employeesRepository.getEmployeeList().size());
    }

    @Test
    public void F01_TC03() {
        EmployeeRepositoryInterface employeesRepository = new EmployeeCacheRepo();
        assertEquals(6, employeesRepository.getEmployeeList().size());

        Employee employee = new Employee("Ion", "123456789aaaa", DidacticFunction.LECTURER, 100);
        employeesRepository.addEmployee(employee);
        assertEquals(7, employeesRepository.getEmployeeList().size());
    }

    @Test
    public void F01_TC04() {
        EmployeeRepositoryInterface employeesRepository = new EmployeeCacheRepo();
        assertEquals(6, employeesRepository.getEmployeeList().size());

        Employee employee = new Employee("Ion", "123456789aaaa", DidacticFunction.LECTURER, 0);
        employeesRepository.addEmployee(employee);
        assertEquals(6, employeesRepository.getEmployeeList().size());
    }

    @Test
    public void F02_TC01() {
        EmployeeRepositoryInterface employeesRepository = new EmployeeCacheRepo();
        EmployeeController employeeController = new EmployeeController(employeesRepository);

        Employee employee = new Employee("LastName", "1234567894321", DidacticFunction.ASSISTANT, 3400);
        assertEquals(DidacticFunction.ASSISTANT, employee.getDidacticFunction());

        employeeController.modifyDidacticFunction(employee, "READER");
        assertEquals(DidacticFunction.READER, employee.getDidacticFunction());
    }

    @Test
    public void F02_TC02() {
        EmployeeRepositoryInterface employeesRepository = new EmployeeCacheRepo();
        EmployeeController employeeController = new EmployeeController(employeesRepository);

        Employee employee = new Employee("LastName", "1234567894321", DidacticFunction.ASSISTANT, 3400);
        assertEquals(DidacticFunction.ASSISTANT, employee.getDidacticFunction());

        employeeController.modifyDidacticFunction(employee, "TEACHER");
        assertEquals(DidacticFunction.TEACHER, employee.getDidacticFunction());
    }

    @Test
    public void F02_TC03() {
        EmployeeRepositoryInterface employeesRepository = new EmployeeCacheRepo();
        EmployeeController employeeController = new EmployeeController(employeesRepository);

        Employee employee = new Employee("LastName", "1234567894321", DidacticFunction.ASSISTANT, 3400);
        assertEquals(DidacticFunction.ASSISTANT, employee.getDidacticFunction());

        employeeController.modifyDidacticFunction(employee, "LECTURER");
        assertEquals(DidacticFunction.LECTURER, employee.getDidacticFunction());
    }

    @Test
    public void F02_TC04() {
        EmployeeRepositoryInterface employeesRepository = new EmployeeCacheRepo();
        EmployeeController employeeController = new EmployeeController(employeesRepository);

        Employee employee = new Employee("LastName", "1234567894321", DidacticFunction.ASSISTANT, 3400);
        assertEquals(DidacticFunction.ASSISTANT, employee.getDidacticFunction());

        employeeController.modifyDidacticFunction(employee, "ASSISTANT");
        assertEquals(DidacticFunction.ASSISTANT, employee.getDidacticFunction());
    }

    @Test
    public void F03_TC01() {
        EmployeeRepositoryInterface employeesRepository = new EmployeeCacheRepo();
        EmployeeController employeeController = new EmployeeController(employeesRepository);

        ArrayList<Employee> original = (ArrayList<Employee>) employeeController.getEmployeesList();
        ArrayList<Employee> sorted = (ArrayList<Employee>) employeeController.getEmployeesList().stream().sorted().collect(Collectors.toList());

        for (int i = 0; i < original.size(); i++) {
            assertEquals(original.get(i).getSalary(), sorted.get(i).getSalary(), 0.1);
            assertEquals(original.get(i).getCnp(), sorted.get(i).getCnp());
        }
    }

    @Test
    public void F03_TC02() {
        EmployeeRepositoryInterface employeesRepository = new EmployeeCacheRepo();
        EmployeeController employeeController = new EmployeeController(employeesRepository);

        employeeController.getEmployeesList().get(0).setCnp("0000");
        ArrayList<Employee> original = (ArrayList<Employee>) employeeController.getEmployeesList();
        ArrayList<Employee> sorted = (ArrayList<Employee>) employeeController.getEmployeesList().stream().sorted().collect(Collectors.toList());

        for (int i = 0; i < original.size(); i++) {
            assertEquals(original.get(i).getSalary(), sorted.get(i).getSalary(), 0.1);
            assertEquals(original.get(i).getCnp(), sorted.get(i).getCnp());
        }
    }
}

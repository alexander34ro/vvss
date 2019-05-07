package aair2039MV;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import aair2039MV.controller.EmployeeController;
import aair2039MV.enumeration.DidacticFunction;
import aair2039MV.main.StartApp;
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
public class AppIntegration {

    @Test
    public void F01_I() {
        AppTest appTest = new AppTest();
        appTest.F01_TC01();
        appTest.F01_TC02();
        appTest.F01_TC03();
        appTest.F01_TC04();
    }

    @Test
    public void F02_I() {
        AppTest appTest = new AppTest();
        appTest.F02_TC01();
        appTest.F02_TC02();
        appTest.F02_TC03();
        appTest.F02_TC04();
    }

    @Test
    public void F03_I() {
        AppTest appTest = new AppTest();
        appTest.F03_TC01();
        appTest.F03_TC02();
    }

    @Test
    public void BBIntT() {
        F03_I();
        F02_I();
        F01_I();

        int count = StartApp.employeeController.getEmployeesList().size();
        StartApp.main(null);
        assertEquals(count + 1, StartApp.employeesRepository.getEmployeeList().size());

        Employee employee = new Employee("Ion", "123456789aaaa", DidacticFunction.TEACHER, 100);
        StartApp.employeesRepository.addEmployee(employee);
        StartApp.employeeController.modifyDidacticFunction(employee, "READER");
        ArrayList<Employee> original = (ArrayList<Employee>) StartApp.employeeController.getEmployeesList();
        ArrayList<Employee> sorted = (ArrayList<Employee>) StartApp.employeeController.getEmployeesList().stream().sorted().collect(Collectors.toList());

        assertEquals(count + 2, StartApp.employeesRepository.getEmployeeList().size());
        assertEquals(DidacticFunction.READER, employee.getDidacticFunction());
        for (int i = 0; i < original.size(); i++) {
            assertEquals(original.get(i).getSalary(), sorted.get(i).getSalary(), 0.1);
            assertEquals(original.get(i).getCnp(), sorted.get(i).getCnp());
        }
    }

    @Test
    public void TDIntT() {
        F03_I();
        F02_I();
        F01_I();

        int count = StartApp.employeeController.getEmployeesList().size();
        StartApp.main(null);
        assertEquals(count + 1, StartApp.employeesRepository.getEmployeeList().size());

        Employee employee = new Employee("Ion", "123456789aaaa", DidacticFunction.TEACHER, 100);
        StartApp.employeesRepository.addEmployee(employee);
        assertEquals(count + 2, StartApp.employeesRepository.getEmployeeList().size());

        StartApp.employeeController.modifyDidacticFunction(employee, "READER");
        assertEquals(DidacticFunction.READER, employee.getDidacticFunction());

        ArrayList<Employee> original = (ArrayList<Employee>) StartApp.employeeController.getEmployeesList();
        ArrayList<Employee> sorted = (ArrayList<Employee>) StartApp.employeeController.getEmployeesList().stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < original.size(); i++) {
            assertEquals(original.get(i).getSalary(), sorted.get(i).getSalary(), 0.1);
            assertEquals(original.get(i).getCnp(), sorted.get(i).getCnp());
        }
    }
}

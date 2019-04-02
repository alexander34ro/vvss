package aair2039MV.main;

import aair2039MV.controller.EmployeeController;
import aair2039MV.enumeration.DidacticFunction;
import aair2039MV.model.Employee;
import aair2039MV.repository.interfaces.EmployeeRepositoryInterface;
import aair2039MV.repository.mock.EmployeeCacheRepo;
import aair2039MV.validator.EmployeeValidator;

//functionalitati
//F01.	 adaugarea unui nou angajat (nume, prenume, CNP, functia didactica, salariul de incadrare);
//F02.	 modificarea functiei didactice (asistent/lector/conferentiar/profesor) a unui angajat;
//F03.	 afisarea salariatilor ordonati descrescator dupa salariu si crescator dupa varsta (CNP).

public class StartApp {

	public static void main(String[] args) {
		
		EmployeeRepositoryInterface employeesRepository = new EmployeeCacheRepo();
		EmployeeController employeeController = new EmployeeController(employeesRepository);
		
		for(Employee _employee : employeeController.getEmployeesList())
			System.out.println(_employee.toString());
		System.out.println("-----------------------------------------");
		
		Employee employee = new Employee("LastName", "1234567894321", DidacticFunction.ASSISTANT, 3400);
		employeeController.addEmployee(employee);
		
		for(Employee _employee : employeeController.getEmployeesList())
			System.out.println(_employee.toString());
		
		EmployeeValidator validator = new EmployeeValidator();
		System.out.println( validator.isValid(new Employee("Last-Name", "1234567894322", DidacticFunction.TEACHER, 3400)) );
		
	}

}

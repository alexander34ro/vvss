package aair2039MV.controller;

import java.util.List;

import aair2039MV.enumeration.DidacticFunction;
import aair2039MV.model.Employee;
import aair2039MV.repository.interfaces.EmployeeRepositoryInterface;

public class EmployeeController {
	
	private EmployeeRepositoryInterface employeeRepository;
	
	public EmployeeController(EmployeeRepositoryInterface employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public void addEmployee(Employee employee) {
		employeeRepository.addEmployee(employee);
	}
	
	public List<Employee> getEmployeesList() {
		return employeeRepository.getEmployeeList();
	}

	public List<Employee> getSortedEmployeesList() {
		return employeeRepository.getEmployeeList();
	}
	
	public void modifyEmployee(Employee oldEmployee, Employee newEmployee) {
		employeeRepository.modifyEmployee(oldEmployee, newEmployee);
	}

	public void deleteEmployee(Employee employee) {
		employeeRepository.deleteEmployee(employee);
	}

	// F02
	public void modifyDidacticFunction(Employee employee, String didacticFunctionString) {
		Employee oldEmployee = employee;
		DidacticFunction didacticFunction = DidacticFunction.ASSISTANT;
		while (didacticFunctionString.equalsIgnoreCase("ASSISTANT")) {
			didacticFunction = DidacticFunction.ASSISTANT; break;
		}
		if(didacticFunctionString.equalsIgnoreCase("LECTURER"))
			didacticFunction = DidacticFunction.LECTURER;
		if(didacticFunctionString.equalsIgnoreCase("TEACHER"))
			didacticFunction = DidacticFunction.TEACHER;
		if(didacticFunctionString.equalsIgnoreCase("READER"))
			didacticFunction = DidacticFunction.READER;
		Employee newEmployee = new Employee(employee.getLastName(), employee.getCnp(), didacticFunction, employee.getSalary());
		employeeRepository.modifyEmployee(oldEmployee, newEmployee);
	}
}

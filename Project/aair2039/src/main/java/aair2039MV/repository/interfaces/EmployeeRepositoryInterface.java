package aair2039MV.repository.interfaces;

import java.util.List;

import aair2039MV.model.Employee;

public interface EmployeeRepositoryInterface {
	
	boolean addEmployee(Employee employee);
	void deleteEmployee(Employee employee);
	void modifyEmployee(Employee oldEmployee, Employee newEmployee);
	List<Employee> getEmployeeList();
	List<Employee> getEmployeeByCriteria(String criteria);

}

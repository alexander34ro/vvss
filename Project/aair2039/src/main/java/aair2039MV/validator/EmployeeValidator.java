package aair2039MV.validator;

import aair2039MV.enumeration.DidacticFunction;
import aair2039MV.model.Employee;

public class EmployeeValidator {
	
	public EmployeeValidator(){}

	public boolean isValid(Employee employee) {
		boolean isLastNameValid  = employee.getLastName().matches("[a-zA-Z-]+") && (employee.getLastName().length() > 2);
		boolean isCNPValid       = employee.getCnp().matches("[a-z0-9]+") && (employee.getCnp().length() == 13);
		boolean isFunctionValid  = employee.getDidacticFunction().equals(DidacticFunction.ASSISTANT) ||
								   employee.getDidacticFunction().equals(DidacticFunction.LECTURER) ||
								   employee.getDidacticFunction().equals(DidacticFunction.TEACHER);
		boolean isSalaryValid    = employee.getSalary() > 0;
		
		return isLastNameValid && isCNPValid && isFunctionValid && isSalaryValid;
	}

	
}

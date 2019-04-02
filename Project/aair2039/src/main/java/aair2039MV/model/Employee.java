package aair2039MV.model;

import aair2039MV.enumeration.DidacticFunction;
import aair2039MV.exception.EmployeeException;
import aair2039MV.validator.EmployeeValidator;

public class Employee {

	/** The first name of the employee */
	private String firstName;

	/** The last name of the employee */
	private String lastName;
	
	/** The unique id of the employee */
	private String cnp;
	
	/** The didactic didacticFunction of the employee inside the university */
	private DidacticFunction didacticFunction;
	
	/** The salary of the employee */
	private double salary;
	
	/**
	 * Default constructor for employee
	 */
	public Employee() {
		this.lastName  = "";
		this.cnp       = "";
		this.didacticFunction = DidacticFunction.ASSISTANT;
		this.salary    = 0;
	}
	
	/**
	 * Constructor with fields for employee
	 */
	public Employee(String lastName, String cnp, DidacticFunction didacticFunction, double salary) {
		this.lastName  = lastName;
		this.cnp       = cnp;
		this.didacticFunction = didacticFunction;
		this.salary    = salary;
	}

	/**
	 * Getter for the employee last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Setter for the employee last name
	 * 
	 * @param lastName the last name to be set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Getter for the employee CNP
	 */
	public String getCnp() {
		return cnp;
	}

	/**
	 * Setter for the employee CNP
	 * 
	 * @param cnp the CNP to be set
	 */
	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	/**
	 * Getter for the employee didactic didacticFunction
	 */
	public DidacticFunction getDidacticFunction() {
		return didacticFunction;
	}

	/**
	 * Setter for the employee didacticFunction
	 * 
	 * @param didacticFunction the didacticFunction to be set
	 */
	public void setDidacticFunction(DidacticFunction didacticFunction) {
		this.didacticFunction = didacticFunction;
	}

	/**
	 * Getter for the employee salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * Setter for the salary
	 * 
	 * @param salary the salary to be set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	/**
	 * toString didacticFunction for employee
	 */
	@Override
	public String toString() {
		String employee = "";
		
		employee += lastName + ";";
		employee += cnp + ";";
		employee += didacticFunction.toString() + ";";
		employee += salary;
		
		return employee;
	}
	
	/**
	 * equals didacticFunction for employee
	 */
	public boolean equals(Employee comparableEmployee) {
		boolean hasSameLastName  = this.lastName.equals(comparableEmployee.getLastName()),
				hasSameCNP       = this.cnp.equals(comparableEmployee.getCnp()),
				hasSameFunction  = this.didacticFunction.equals(comparableEmployee.getDidacticFunction()),
				hasSameSalary    = this.salary == comparableEmployee.getSalary();
		return hasSameLastName && hasSameCNP && hasSameFunction && hasSameSalary;
	}
	
	/**
	 * Returns the Employee after parsing the given line
	 * 
	 * @param _employee
	 *            the employee given as String from the input file
	 * @param line
	 *            the current line in the file
	 * 
	 * @return if the given line is valid returns the corresponding Employee
	 * @throws EmployeeException
	 */
	public static Employee getEmployeeFromString(String _employee, int line) throws EmployeeException {
		Employee employee = new Employee();
		
		String[] attributes = _employee.split("[;]");
		
		if( attributes.length != 5 ) {
			throw new EmployeeException("Invalid line at: " + line);
		} else {
			EmployeeValidator validator = new EmployeeValidator();
			employee.setLastName(attributes[1]);
			employee.setCnp(attributes[2]);
			
			if(attributes[3].equals("ASSISTANT"))
				employee.setDidacticFunction(DidacticFunction.ASSISTANT);
			if(attributes[3].equals("LECTURER"))
				employee.setDidacticFunction(DidacticFunction.LECTURER);
			if(attributes[3].equals("TEACHER"))
				employee.setDidacticFunction(DidacticFunction.TEACHER);
			
			employee.setSalary(Double.parseDouble(attributes[4]));
			
			if( !validator.isValid(employee) ) {
				throw new EmployeeException("Invalid line at: " + line);
			}
		}
		
		return employee;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}

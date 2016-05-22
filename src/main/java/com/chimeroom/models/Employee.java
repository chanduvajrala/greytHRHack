package com.chimeroom.models;

public class Employee {

	private int employeeID;
	private String employeeName;
	private int employeePriority;
	private String employeeDesignation;
	
	public Employee()
	{
		
	}
	
	public Employee( String employeeName, int employeePriority, String employeeDesignation) {
		super();
		
		this.employeeName = employeeName;
		this.employeePriority = employeePriority;
		this.employeeDesignation = employeeDesignation;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getEmployeePriority() {
		return employeePriority;
	}
	public void setEmployeePriority(int employeePriority) {
		this.employeePriority = employeePriority;
	}
	public String getEmployeeDesignation() {
		return employeeDesignation;
	}
	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}
	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", employeeName=" + employeeName + ", employeePriority="
				+ employeePriority + ", employeeDesignation=" + employeeDesignation + "]";
	}
	
	
	
	
	
}

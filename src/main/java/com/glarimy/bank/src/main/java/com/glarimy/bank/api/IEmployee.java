package com.glarimy.bank.api;

import com.glarimy.bank.domain.Employee;
import com.glarimy.bank.exceptions.EmployeeException;

public interface IEmployee {
	public Employee add(Employee employee) throws EmployeeException;

	public Employee getEmployee(int number) throws EmployeeException;
	
	public boolean deleteEmployee(int number) throws EmployeeException;
	
	public Employee updateEmployee(Employee employee) throws EmployeeException;
}

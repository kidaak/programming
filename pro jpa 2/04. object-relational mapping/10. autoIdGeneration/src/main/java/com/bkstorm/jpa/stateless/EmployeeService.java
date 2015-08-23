package com.bkstorm.jpa.stateless;

import java.util.Collection;

import com.bkstorm.jpa.model.Employee;

public interface EmployeeService {
	public Employee createEmployee(String name, int salary);

	public Collection<Employee> findAllEmployees();
}

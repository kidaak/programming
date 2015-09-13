package com.bkstorm.jpa.stateless;

import java.util.Collection;

import com.bkstorm.jpa.model.Employee;
import javax.ejb.Remote;

@Remote
public interface EmployeeService {

    public Employee createEmployee(String name, int salary) throws Exception;

    public Collection<Employee> findAllEmployees();
}

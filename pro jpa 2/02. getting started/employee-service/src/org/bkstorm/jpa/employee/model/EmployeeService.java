package org.bkstorm.jpa.employee.model;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class EmployeeService {
	private EntityManager entityManager;

	public EmployeeService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Employee createEmployee(int id, String name, long salary) {
		Employee employee = new Employee(id);
		employee.setName(name);
		employee.setSalary(salary);
		entityManager.persist(employee);
		return employee;
	}

	public Employee findEmployee(int id) {
		return entityManager.find(Employee.class, id);
	}

	public void removeEmployee(int id) {
		Employee employee = findEmployee(id);
		if (employee != null) {
			entityManager.remove(employee);
		}
	}

	public Employee raiseEmployeeSalary(int id, long raise) {
		Employee employee = findEmployee(id);
		if (employee != null) {
			employee.setSalary(employee.getSalary() + raise);
		}
		return employee;
	}

	public Collection<Employee> findAllEmployees() {
		Query query = entityManager.createQuery("SELECT e FROM Employee e");
		return (Collection<Employee>) query.getResultList();
	}

}

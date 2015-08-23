package com.bkstorm.jpa.stateless;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.bkstorm.jpa.model.Employee;

@Stateless
public class EmployeeServiceBean implements EmployeeService {

	@PersistenceContext(unitName = "EmployeeService")
	protected EntityManager em;

	public Employee createEmployee(String name, int salary) {
		Employee emp = new Employee();
		emp.setName(name);
		emp.setSalary(salary);
		em.persist(emp);
		return emp;
	}

	@SuppressWarnings("unchecked")
	public Collection<Employee> findAllEmployees() {
		Query query = em.createQuery("SELECT e FROM Employee e");
		return (Collection<Employee>) query.getResultList();
	}

}
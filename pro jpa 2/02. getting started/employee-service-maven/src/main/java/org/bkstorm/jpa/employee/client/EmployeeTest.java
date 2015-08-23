package org.bkstorm.jpa.employee.client;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.bkstorm.jpa.employee.model.Employee;
import org.bkstorm.jpa.employee.model.EmployeeService;

public class EmployeeTest {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeeService");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EmployeeService service = new EmployeeService(entityManager);

        // create and persist an employee
        entityManager.getTransaction().begin();
        Employee emp = service.createEmployee(158, "John Doe", 45000);
        entityManager.getTransaction().commit();
        System.out.println("Persisted " + emp);

        // find a specific employee
        emp = service.findEmployee(158);
        System.out.println("Found " + emp);

        // find all employees
        Collection<Employee> emps = service.findAllEmployees();
        for (Employee e : emps) {
            System.out.println("Found Employee: " + e);
        }

        // update the employee
        entityManager.getTransaction().begin();
        emp = service.raiseEmployeeSalary(158, 1000);
        entityManager.getTransaction().commit();
        System.out.println("Updated " + emp);

        // remove an employee
        entityManager.getTransaction().begin();
        service.removeEmployee(158);
        entityManager.getTransaction().commit();
        System.out.println("Removed Employee 158");

        // close the EM and EMF when done
        entityManager.close();
        entityManagerFactory.close();
    }
}

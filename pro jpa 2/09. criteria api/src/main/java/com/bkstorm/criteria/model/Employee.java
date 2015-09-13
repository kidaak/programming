package com.bkstorm.criteria.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Employee implements Serializable {

    @Id
    private int id;
    private String name;
    private long salary;
    // @Temporal(TemporalType.DATE)
    // private Date startDate;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "employee")
    private Collection<Phone> phones;

    @ManyToOne
    private Department dept;
    @ManyToMany(mappedBy = "employees")
    private Collection<Project> projects;

    public Employee() {
        this.projects = new ArrayList<>();
        this.phones = new ArrayList<>();
    }

    public Employee(int id) {
        this.projects = new ArrayList<>();
        this.phones = new ArrayList<>();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int empNo) {
        this.id = empNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    // public Date getStartDate() {
    // return startDate;
    // }
    //
    // public void setStartDate(Date startDate) {
    // this.startDate = startDate;
    // }
    public Collection<Phone> getPhones() {
        return phones;
    }

    public void addPhone(Phone phone) {
        if (!getPhones().contains(phone)) {
            getPhones().add(phone);
            if (phone.getEmployee() != null) {
                phone.getEmployee().getPhones().remove(phone);
            }
            phone.setEmployee(this);
        }
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        if (this.dept != null) {
            this.dept.getEmployees().remove(this);
        }
        this.dept = dept;
        this.dept.getEmployees().add(this);
    }

	// public Collection<Employee> getDirects() {
    // return directs;
    // }
    // public void addDirect(Employee employee) {
    // if (!getDirects().contains(employee)) {
    // getDirects().add(employee);
    // if (employee.getManager() != null) {
    // employee.getManager().getDirects().remove(employee);
    // }
    // employee.setManager(this);
    // }
    // }
    // public Employee getManager() {
    // return manager;
    // }
    //
    // public void setManager(Employee manager) {
    // this.manager = manager;
    // }
    //
    public Collection<Project> getProjects() {
        return projects;
    }

    public void addProject(Project project) {
        if (!getProjects().contains(project)) {
            getProjects().add(project);
        }
        if (!project.getEmployees().contains(this)) {
            project.getEmployees().add(this);
        }
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String toString() {
        return "Employee " + getId() + ": name: " + getName() + ", salary: " + getSalary() + ", city: "
                + ((getAddress() == null) ? null : getAddress().getCity()) + ", deptName: "
                + ((getDept() == null) ? null : getDept().getName());
    }

}

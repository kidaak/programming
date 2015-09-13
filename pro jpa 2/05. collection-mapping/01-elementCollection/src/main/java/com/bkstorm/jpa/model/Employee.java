package com.bkstorm.jpa.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import javax.persistence.CollectionTable;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int salary;

    // Using a targetClass instead of generics
    @ElementCollection(targetClass = VacationEntry.class)
    @CollectionTable(name = "vacation", joinColumns = @JoinColumn(name = "emp_id"))
    private Collection<VacationEntry> vacationBookings;

    // Using generics in place of a targetClass
    @ElementCollection
    @CollectionTable(name = "employee_nicknames", joinColumns = @JoinColumn(name = "emp_id"))
    private Set<String> nickname;

    public Collection<VacationEntry> getVacationBookings() {
        return vacationBookings;
    }

    public void setVacationBookings(Collection<VacationEntry> vacationBookings) {
        this.vacationBookings = vacationBookings;
    }

    public Set<String> getNickName() {
        return nickname;
    }

    public void setNickName(Set<String> nickName) {
        this.nickname = nickName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee id: " + getId() + " name: " + getName()
                + " salary: " + getSalary()
                + " nickNames: " + nickname;
    }
}

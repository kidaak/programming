package com.example.model;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Dog implements HttpSessionBindingListener {

    private String name;
    private Toy[] toys;
    private String breed;

    public Dog() {

    }

    public Dog(String breed) {
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Toy[] getToys() {
        return toys;
    }

    public void setToys(Toy[] toys) {
        this.toys = toys;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent arg0) {

    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent arg0) {

    }
}

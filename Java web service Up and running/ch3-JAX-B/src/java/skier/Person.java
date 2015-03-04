/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skier;

import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author hoangnv
 */
@XmlType
public class Person {
    private String name;
    private int age;
    private String gender;
    
    public Person(){
        
    }
    
    public Person(String name, int age, String gender){
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 *
 * @author hoangnv
 */
public class PersonProps {
    
    private String name;
    private int age;
    private String gender;

    //constructor
    public PersonProps() {
        
    }
    //properties

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

class Main {
    
    public static void main(String[] args) {
        //Create a person and set only the name
        PersonProps person = new PersonProps();
        person.setName("Bruno");
        XStream xstream = new XStream(new DomDriver());
        xstream.registerConverter(new PersonPropsConverter());
        xstream.alias("name", PersonProps.class);
        String xml = xstream.toXML(person);
        System.out.println(xml);
        PersonProps clone = (PersonProps)xstream.fromXML(xml);
        System.out.println(clone.getName());
    }
}

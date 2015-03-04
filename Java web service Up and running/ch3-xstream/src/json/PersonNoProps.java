package json;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 *
 * @author hoangnv
 */
public class PersonNoProps {
    
    private String name;
    private int age;
    private String gender;
    
    public PersonNoProps(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}

class Main {
    
    public static void main(String[] args) {
        PersonNoProps bd = new PersonNoProps("Bjoern Deahlie", 49, "Male");
        //setup
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("skier", PersonNoProps.class);//for readability
        //serialize
        String xml = xstream.toXML(bd);
        //deserialize and confirm
        PersonNoProps bdClone = (PersonNoProps) xstream.fromXML(xml);
        System.out.println(xstream.toXML(bdClone));
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;

/**
 *
 * @author hoangnv
 */
public class JsonTest {

    public static void main(String[] args) {
        PersonNoProps bd = new PersonNoProps("hoangnv28", 24, "Male");
        XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
        String json = xstream.toXML(bd);//it's really toJson now
        System.out.println(json);
    }
}

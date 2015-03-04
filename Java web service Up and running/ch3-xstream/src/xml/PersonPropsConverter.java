/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 *
 * @author hoangnv
 */
public class PersonPropsConverter implements Converter{

    @Override
    public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext mc) {
        PersonProps person = (PersonProps)o;
        writer.startNode("Person");
        writer.setValue(person.getName());
        writer.endNode();
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext uc) {
        PersonProps person = new PersonProps();
        reader.moveDown();
        person.setName(reader.getValue());
        reader.moveUp();
        return person;
    }

    @Override
    public boolean canConvert(Class type) {
        return type.equals(PersonProps.class);
    }
   
}

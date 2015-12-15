package bkstorm.org.list_expandable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nguyen on 8/13/2015.
 */
public class Group {

    public String string;
    public final List<String> children = new ArrayList<String>();

    public Group(String string) {
        this.string = string;
    }
}

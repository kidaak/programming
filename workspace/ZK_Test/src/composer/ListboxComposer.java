package composer;

import java.util.Random;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.CheckEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Listbox;

public class ListboxComposer extends SelectorComposer<Component> {

    /**
     *
     */
    private static final long serialVersionUID = 3034575490767183133L;

    Random random = new Random();
    
    @Wire
    private Listbox oListBox;
    
    @Listen("onCheckSelectAll = #oListBox")
    public void onCheckSelectAll(CheckEvent event){
        System.out.println("Select All");
    }

    public String random() {
        return String.valueOf(random.nextInt());
    }

    public String random(int index) {
        return "click " + index;
    }
}

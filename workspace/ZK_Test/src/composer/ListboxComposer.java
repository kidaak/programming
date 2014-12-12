package composer;

import java.util.Random;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;

public class ListboxComposer extends SelectorComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3034575490767183133L;

	Random random = new Random();

	public String random() {
		return String.valueOf(random.nextInt());
	}

	public String random(int index) {
		return "click " + index;
	}
}

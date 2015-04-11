package composer;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;

public class RelateComponentsComposer extends SelectorComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1621061992031797141L;

	public String getCurrentTime() {
		return String.valueOf(System.currentTimeMillis());
	}
}

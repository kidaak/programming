package composer;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.A;

public class AComponentComposer extends SelectorComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4156282007038155457L;

	@Wire
	private A a;

	// @Listen("onClick = button")
	// public void onClick() {
	// a.setHref("/file/test.pdf");
	// Events.sendEvent(Events.ON_CLICK, a, null);
	// }

}

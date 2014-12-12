package composer;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Intbox;

public class IntboxComposer extends SelectorComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5585206762814851876L;

	@Wire
	private Intbox intbox;

	@Listen("onChange = #intbox")
	public void onChangeIntbox(InputEvent evt) {
		System.out.println("onChange: " + evt.getValue());
	}

	@Listen("onChanging = #intbox")
	public void onChangingIntbox(InputEvent evt) {
		System.out.println("onChanging: " + evt.getValue());
		try {
			Integer.getInteger(evt.getValue());
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
		}
	}

}

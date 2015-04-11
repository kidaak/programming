package composer;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;

public class TextboxComposer extends SelectorComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3493365405847165434L;

	@Wire
	private Textbox tb1, tb2;
	@Wire
	private Label lb1;

	@Listen("onClick = button")
	public void onChangeTextbox() {
//		tb1.setValue(tb2.getValue());
		tb1.setValue("line1...\nline2...");
	}
}

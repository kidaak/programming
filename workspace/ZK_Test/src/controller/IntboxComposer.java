package controller;

import org.zkoss.zk.ui.Component;
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
	public void onChangeIntbox() {
		System.out.println(intbox.getValue());
	}
	
	@Listen("onChanging = #intbox")
	public void onChangingIntbox() {
		System.out.println(intbox.getValue());
	}

}

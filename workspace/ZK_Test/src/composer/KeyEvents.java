package composer;

import java.awt.event.KeyEvent;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;

public class KeyEvents extends SelectorComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7642175458021874785L;

	@Wire
	private Button button;

	public void showKeyEvent(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_F6:
			button.setLabel("F6");
			break;
		case KeyEvent.VK_F7:
			button.setLabel("F7");
			break;
		case KeyEvent.VK_F8:
			button.setLabel("F8");
			break;
		}
	}
}

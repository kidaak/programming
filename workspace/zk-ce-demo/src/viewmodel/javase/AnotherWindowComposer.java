package viewmodel.javase;

import java.util.Map;

import model.User;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Window;

public class AnotherWindowComposer extends SelectorComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3368559993718418845L;
	private Window parentWindow;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		Map arguments = Executions.getCurrent().getArg();
		parentWindow = (Window) arguments.get("parentWindow");
		User user = (User) arguments.get("user");
		user.setName("hoangnv");
	}

	@Listen("onClick = #button3")
	public void showUserName() {
		Events.sendEvent("onShowUserName", parentWindow, null);
	}

}

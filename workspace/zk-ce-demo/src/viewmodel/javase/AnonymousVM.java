package viewmodel.javase;

import java.util.HashMap;
import java.util.Map;

import model.User;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Button;
import org.zkoss.zul.Window;

public class AnonymousVM extends SelectorComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6724567754028003765L;
	@Wire
	private Button button;
	@Wire
	private Button button2;
	@Wire
	private Window window1st;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		User user = new User("hoangnv28", "full stack developer", "");
		EventListener<Event> el = new EventListener<Event>() {
			@Override
			public void onEvent(Event event) throws Exception {
				// Map<String, Object> arguments = new HashMap<String,
				// Object>();
				// arguments.put("user", user);
				// arguments.put("parentWindow", window1st);
				// Window window = (Window) Executions.createComponents(
				// "/Pages/javase/anotherWindow.zul", null, arguments);
				// window.doModal();
				user.setName("hoangnv");
			}
		};
		button.addEventListener(Events.ON_CLICK, el);
	}

	public EventListener<Event> setUserName(User user) {
		return new EventListener<Event>() {

			@Override
			public void onEvent(Event event) throws Exception {
				user.setName("123");
			}
		};
	}
	//
	// @Listen("onClick = button#button2; onShowUserName = window#window1st")
	// public void showUserName() {
	// Clients.showNotification(user.getName(), "info", null, "middle_center",
	// 2000);
	// }
}

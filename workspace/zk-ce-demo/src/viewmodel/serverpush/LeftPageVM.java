package viewmodel.serverpush;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.EventQueue;
import org.zkoss.zk.ui.event.EventQueues;

public class LeftPageVM {
	private List<String> messages;

	private EventQueue<Event> chatQueue;

	public LeftPageVM() {
		messages = new ArrayList<String>();
		initEventQueue();
	}

	private void initEventQueue() {
		chatQueue = EventQueues.lookup("chat", EventQueues.SESSION, true);
		chatQueue.subscribe(new EventListener<Event>() {
			@Override
			public void onEvent(Event event) throws Exception {
				switch (event.getName()) {
				case "TO A":
					receiveMessage(event.getData().toString());
					break;
				}
			}
		});
	}

	private void receiveMessage(String message) {
		messages.add("FROM B: " + message);
		BindUtils.postNotifyChange(null, null, this, "messages");
	}

	@Command
	@NotifyChange("messages")
	public void sendMessage(@BindingParam("message") String message) {
		chatQueue.publish(new Event("TO B", null, message));
		messages.add("FROM ME: " + message);

	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
}

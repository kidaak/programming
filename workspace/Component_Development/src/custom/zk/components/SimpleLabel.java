package custom.zk.components;

import org.zkoss.zk.ui.event.Events;

public class SimpleLabel extends org.zkoss.zk.ui.HtmlBasedComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String _value = ""; // a data member
	@SuppressWarnings("unused")
	private boolean _cleared = false;

	static {
		addClientEvent(SimpleLabel.class, ClearEvent.NAME, CE_IMPORTANT);
	}

	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		if (!_value.equals(value)) {
			_value = value;
			smartUpdate("value", _value);
		}
	}

	protected void renderProperties(org.zkoss.zk.ui.sys.ContentRenderer renderer)
			throws java.io.IOException {
		super.renderProperties(renderer);
		render(renderer, "value", _value);
	}

	public void service(org.zkoss.zk.au.AuRequest request, boolean everError) {
		final String cmd = request.getCommand();

		if (cmd.equals(ClearEvent.NAME)) {
			ClearEvent evt = ClearEvent.getClearEvent(request);
			_cleared = evt.getCleared();
			Events.postEvent(evt);
		} else
			super.service(request, everError);
	}
}
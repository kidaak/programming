package custom.zk.components;

import java.util.Map;

import org.zkoss.zk.au.AuRequest;
import org.zkoss.zk.au.AuRequests;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;

public class ClearEvent extends Event {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String NAME = "onClear";

	private String cmd;
	private Component comp;
	private boolean _cleared;

	public ClearEvent(String cmd, Component comp, boolean cleared) {
		super(cmd, comp, cleared);
		this.cmd = cmd;
		this.comp = comp;
		this._cleared = cleared;
	}

	public static final ClearEvent getClearEvent(AuRequest request) {
		final Component comp = request.getComponent();
		final Map<String, Object> data = request.getData();

		boolean cleared = AuRequests.getBoolean(data, "cleared");
		return new ClearEvent(request.getCommand(), comp, cleared);
	}

	public boolean getCleared() {
		return _cleared;
	}

	public void setCleared(boolean _cleared) {
		this._cleared = _cleared;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public Component getComp() {
		return comp;
	}

	public void setComp(Component comp) {
		this.comp = comp;
	}
}
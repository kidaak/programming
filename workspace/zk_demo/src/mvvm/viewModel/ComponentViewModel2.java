package mvvm.viewModel;

import java.util.Map;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;

public class ComponentViewModel2 {
	private String message;

	@SuppressWarnings("rawtypes")
	@Init
	public void init() {
		Map arguments = Executions.getCurrent().getArg();
		message = (String) arguments.get("message");
	}

	@AfterCompose
	public void afterCompose() {

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

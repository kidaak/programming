package mvvm.viewModel;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;

public class ComponentViewModel1 {

	@Init
	public void init() {

	}

	@Command
	public void openNewWindow() {
		Map arguments = new HashMap<>();
		arguments.put("message", "Hello Honda");
		Window window = (Window) Executions.createComponents("component2.zul",
				null, arguments);
	}
}

package viewmodel.component;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;

public class ComboboxVM {
	private String[] models = { "Apple", "Google", "Microsoft", "Facebook", "Twitter" };

	@Init
	public void init() {

	}

	public String[] getModels() {
		return models;
	}

	public void setModels(String[] models) {
		this.models = models;
	}

	@Command
	public void select() {
		System.out.println("onSelect");
	}
}

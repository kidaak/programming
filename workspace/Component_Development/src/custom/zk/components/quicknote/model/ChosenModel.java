package custom.zk.components.quicknote.model;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class ChosenModel {

	private List model;
	
	public ChosenModel(List model) {
		if(model == null) {
			model = new ArrayList<>();
		}
		this.model = model;
	}

	public void add(String data) {
		model.add(data);
	}

	public void add(int index, String data) {
		model.add(index, data);
	}
	
	public void update(int index, String data) {
		model.remove(index);
		add(index, data);
	}
	
	public void remove(String data) {
		model.remove(data);
	}

	public List getModel() {
		return model;
	}
}

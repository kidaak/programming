package custom.zk.components;

import org.zkoss.zul.impl.XulElement;

import custom.zk.components.quicknote.model.ChosenModel;

public class Chosen extends XulElement{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3798154178308293595L;
	private ChosenModel model;
	
	public ChosenModel getModel() {
		return model;
	}
	public void setModel(ChosenModel model) {
		this.model = model;
	}
	
	

}

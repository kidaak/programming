package com.bkstorm.zk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zk.ui.event.KeyEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zkmax.zul.Chosenbox;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.SimpleListModel;

public class ChosenboxComposer extends SelectorComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5582437516748319706L;

	@Wire
	private Chosenbox cbx;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		cbx.setModel(new SimpleListModel(Collections.emptyList()) {
			@Override
			public ListModel getSubModel(Object value, int nRows) {
				System.out.println("getSubModel");
				return createModel(value.toString());
			}
		});
	}

	private ListModel<?> createModel(String value) {
		List<String> data = new ArrayList<>();
		switch (value) {
		case "aa":
			data.add("aab");
			data.add("aa-bb");
			break;
		case "bb":
			data.add("bbcd");
			data.add("bb-bb");
			break;
		case "cc":
			data.add("ccc");
			data.add("cc-bb");
			break;
		case "ddd":
			data.add("dddd");
			data.add("ddee");
			break;
		default:
			data.add(value);
			break;
		}
		return new SimpleListModel<>(data);
	}

	@Listen("onSearch = #cbx")
	public void onSearchCbx(InputEvent event) {
		System.out.println(event.getValue());
	}

	@Listen("onSearching = #cbx")
	public void onSearchingCbx(InputEvent event) {
		System.out.println(event.getValue());
		// cbx.setModel(createModel(event.getValue()));
		// cbx.addItemToSelection(event.getValue());
	}
}

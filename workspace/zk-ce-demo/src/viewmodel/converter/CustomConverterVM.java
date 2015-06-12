package viewmodel.converter;

import java.util.ArrayList;
import java.util.List;

import model.Number;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

import utils.converter.NumberToStringConverter;

public class CustomConverterVM {
	private NumberToStringConverter converter = new NumberToStringConverter();

	private List<Number> model;

	@Init
	public void init() {
		model = new ArrayList<>();
		model.add(new Number(1));
		model.add(new Number(2));
		model.add(new Number(3));
	}

	@Command
	@NotifyChange("model")
	public void plusOne(@BindingParam("number") Number number) {
		int value = number.getNumber() + 1;
		if (value > 3) {
			value = 1;
		}
		number.setNumber(value);
	}

	public NumberToStringConverter getConverter() {
		return converter;
	}

	public List<Number> getModel() {
		return model;
	}

	public void setModel(List<Number> model) {
		this.model = model;
	}
}

package utils.converter;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.Converter;
import org.zkoss.zk.ui.Component;

public class NumberToStringConverter implements
		Converter<String, Integer, Component> {

	@Override
	public String coerceToUi(Integer beanProp, Component component,
			BindContext ctx) {
		switch (beanProp.intValue()) {
		case 1:
			return "One";
		case 2:
			return "Two";
		case 3:
			return "Three";
		}
		return null;
	}

	@Override
	public Integer coerceToBean(String compAttr, Component component,
			BindContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}
}

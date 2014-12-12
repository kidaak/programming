package org.zkoss.zul;

import java.util.Date;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;

public class DateboxConstraint implements Constraint {
	private Datebox datebox;

	public DateboxConstraint(Datebox datebox) {
		this.datebox = datebox;
	}

	public DateboxConstraint(Datebox datebox, String constraint) {
		this.datebox = datebox;
	}

	@Override
	public void validate(Component comp, Object value)
			throws WrongValueException {
		if (((Date) value).before(datebox.getValue())) {
			throw new WrongValueException(comp, "ABC");
		}
	}
}

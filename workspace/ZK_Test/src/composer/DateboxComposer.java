package composer;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Spinner;

public class DateboxComposer extends SelectorComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2490997507521961886L;

	@Wire
	private Datebox startDatebox, endDatebox;
	@Wire
	private Spinner spinner;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		// endDatebox.setConstraint(new DateboxConstraint(startDatebox,
		// "no future"));
	}

	@Listen("onChange = #startDatebox, #endDatebox")
	public void onChange() {
		if (endDatebox.getValue() != null && startDatebox.getValue() != null) {
			if (endDatebox.getValue().before(startDatebox.getValue())) {
				throw new WrongValueException(endDatebox, "ABC");
			}
		}
	}
}

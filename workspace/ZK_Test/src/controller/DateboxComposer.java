package controller;

import java.util.Calendar;
import org.zkoss.zk.ui.Component;
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

	@Listen("onChange = #startDatebox, #endDatebox")
	public void onChangeTime() {
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDatebox.getValue());
		int startDay = startCal.get(Calendar.DAY_OF_WEEK);
		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDatebox.getValue());
		endCal.set(Calendar.HOUR_OF_DAY, 23);
		endCal.set(Calendar.MINUTE, 59);
		endCal.set(Calendar.SECOND, 59);
		endCal.set(Calendar.MILLISECOND, 0);

		double daysBetween = ((double) (endCal.getTimeInMillis() - startCal
				.getTimeInMillis())) / (24 * 60 * 60 * 1000);
		int weeks = (int) Math.floor(daysBetween / 7) * 5;
		int remainDays = (int) Math.ceil(daysBetween % 7);
		int numberOfWorkingDays = weeks + remainDays;

		if (Calendar.SUNDAY == startDay) {
			startDay = Calendar.MONDAY;
			numberOfWorkingDays--;
		}
		int offset = startDay + remainDays - 1 - Calendar.SATURDAY;
		if (offset == 0) {
			numberOfWorkingDays -= 1;
		} else if (offset >= 1) {
			numberOfWorkingDays -= 2;
		}

		spinner.setValue(numberOfWorkingDays);
	}

	@Listen("onChange = #spinner")
	public void onChangeWorkingDay() {
		int numberOfWorkingDays = spinner.getValue();
		int numberOfWeek = numberOfWorkingDays / 5;
		int remainDays = numberOfWorkingDays % 5;
		int numberOfDaysToAdd = numberOfWeek * 7 + remainDays;

		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDatebox.getValue());
		int startDay = startCal.get(Calendar.DAY_OF_WEEK);

		// Vì nếu kop phải thứ 7, chủ nhật thì ngày hiện tại đã được coi là 1
		// ngày làm việc
		// Nên số ngày thêm vào bị trừ đi 1
		if (!(Calendar.SUNDAY == startDay || Calendar.SATURDAY == startDay)) {
			numberOfDaysToAdd--;
			remainDays--;
		}

		int offset = startDay + remainDays - Calendar.SATURDAY;
		if (offset >= 0) {
			numberOfDaysToAdd += 2;
		}
		startCal.add(Calendar.DAY_OF_YEAR, numberOfDaysToAdd);
		endDatebox.setValue(startCal.getTime());
	}
}

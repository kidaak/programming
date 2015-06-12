package viewmodel.international;

import java.util.Date;

import org.zkoss.bind.annotation.Init;

public class TimeZoneVM {
	private Date date;
	
	@Init
	public void init() {
		date = new Date();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}

package model;

import org.zkoss.bind.annotation.NotifyChange;

public class Number {
	private int number;

	public Number() {
		
	}
	
	public Number(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	@NotifyChange(".")
	public void setNumber(int number) {
		this.number = number;
	}

}

package javase;

public class Holder {

	private Anonymous anonymous;

	public Holder() {

	}

	public void run() {
		anonymous.anonymousMethod();
	}

	public Anonymous getAnonymous() {
		return anonymous;
	}

	public void setAnonymous(Anonymous anonymous) {
		this.anonymous = anonymous;
	}
}

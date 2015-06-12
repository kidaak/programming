package javase;

import static org.junit.Assert.*;
import javase.model.User;

import org.junit.Test;

public class AnonymousTest {

	@Test
	public void test() {
		User user = new User("hoangnv28");
		Holder holder = new Holder();
		holder.setAnonymous(new Anonymous() {
			@Override
			public void anonymousMethod() {
				user.setName("hoangnv");
			}
		});
		holder.run();
		boolean result = "hoangnv".equals(user.getName());
		assertTrue(result);
	}
}

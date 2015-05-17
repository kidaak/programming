package iloveyouboss;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProfileTest {
	private Profile profile;
	private Question question;
	private Criteria criteria;

	@Before
	public void create() {
		profile = new Profile("Bull, Hockey Inc.");
		question = new BooleanQuestion(1, "Get bonuses?");
		criteria = new Criteria();
	}

	@Test
	public void matchAnswersFalseWhenMustMatchCriteriaNotMet() {
		profile.add(new Answer(question, Bool.FALSE));

		criteria.add(new Criterion(new Answer(question, Bool.TRUE),
				Weight.MustMatch));

		boolean match = profile.matches(criteria);
		assertFalse(match);
	}

	@Test
	public void matchAnswersTrueForAnyDontCareCriteria() {
		profile.add(new Answer(question, Bool.FALSE));

		criteria.add(new Criterion(new Answer(question, Bool.TRUE),
				Weight.DontCare));

		boolean match = profile.matches(criteria);
		assertTrue(match);
	}

}

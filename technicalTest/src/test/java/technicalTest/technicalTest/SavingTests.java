package technicalTest.technicalTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import technicalTest.beans.Saving;

public class SavingTests {

	private Saving save;
	private Saving save2;

	@Before
	public void setUp() {
		save = new Saving();
		save2 = new Saving();
	}

	@Test
	public void equalsHashTest() {
		save.setDescription("Fruity drink");
		save2.setDescription("Fruity drink");

		assertTrue(save.equals(save2));
		assertTrue(save.hashCode() == save2.hashCode());

		save2.setDescription("Coke");

		assertFalse(save.equals(save2));
		assertFalse(save.hashCode() == save2.hashCode());
	}
}

package technicalTest.technicalTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import technicalTest.beans.Sku;
import technicalTest.beans.Till;
import technicalTest.exception.ProducNotFoundException;

public class TillTests {

	private Till till;
	private Till till2;

	@Before
	public void setUp() {
		till = new Till(new ArrayList<Sku>());
		till2 = new Till(new ArrayList<Sku>());

	}

	@Test
	public void equalHashTest() {

		assertFalse(till.equals(till2));
		assertFalse(till.hashCode() == till2.hashCode());

		till2 = till;

		assertTrue(till.equals(till2));
		assertTrue(till.hashCode() == till2.hashCode());

	}

	@Test(expected = ProducNotFoundException.class)
	public void testException() throws ProducNotFoundException {
		till.scan("321");
	}

	@Test
	public void tilTests() {
		assertNotNull(till.getRecipt());
	}

}

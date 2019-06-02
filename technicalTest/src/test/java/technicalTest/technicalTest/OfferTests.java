package technicalTest.technicalTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import technicalTest.impl.HalfPriceOffer;
import technicalTest.impl.MultipleOffer;

public class OfferTests {

	private HalfPriceOffer half;
	private HalfPriceOffer half2;

	private MultipleOffer multiple;
	private MultipleOffer multiple2;

	@Before
	public void setUp() {
		half = new HalfPriceOffer();
		half2 = new HalfPriceOffer();

		// 2 for 1
		multiple = new MultipleOffer(2, new BigDecimal(1));
		multiple2 = new MultipleOffer(2, new BigDecimal(1));
	}

	@Test
	public void equalsHashTest() {

		assertFalse(multiple.equals(multiple2));
		assertFalse(multiple.hashCode() == multiple2.hashCode());
		multiple2 = multiple;
		assertTrue(multiple.hashCode() == multiple2.hashCode());
		assertTrue(multiple.equals(multiple2));


		assertFalse(half.equals(half2));
		assertFalse(half.hashCode() == half2.hashCode());

		half = half2;

		assertTrue(half.equals(half2));
		assertTrue(half.hashCode() == half2.hashCode());

	}

	@Test
	public void testOffers() {
		assertNotNull(half.totalSavings(1, new BigDecimal(3.0)));
		assertNull(multiple.totalSavings(1, new BigDecimal(2.0)));
		assertNotNull(multiple.totalSavings(2, new BigDecimal(2.0)));

	}

}

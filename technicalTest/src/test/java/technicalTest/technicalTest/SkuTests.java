package technicalTest.technicalTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import technicalTest.beans.Sku;

public class SkuTests {

	private Sku sku;

	@Before
	public void setUp() {
		sku = new Sku();
	}

	@Test
	public void equalsHashTest() {

		Sku sku2 = new Sku();
		sku2.setProductCode("12345");
		sku.setProductCode("12345");
		
		assertTrue(sku.equals(sku2));

		assertTrue(sku.hashCode() == sku2.hashCode());
		sku2.setProductCode("1234");
		
		assertFalse(sku2.hashCode() == sku.hashCode());

		assertFalse(sku2.equals(sku));

	}

	@Test
	public void productParse() {
		// Products with tabs
		sku = Sku.parse("12345			Coke			12.12			Half price");
		assertNotNull(sku.getOffer());
		sku = Sku.parse("12345			Coke			12.12");
		assertNotNull(sku);
	}
}

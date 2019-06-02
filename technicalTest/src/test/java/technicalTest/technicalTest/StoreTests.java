package technicalTest.technicalTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import technicalTest.beans.Store;

public class StoreTests {

	Store store;

	@Before
	public void setUp() {
		store = new Store();
	}

	@Test
	public void equalHashTest() {

		Store store2 = new Store();

		assertFalse(store.equals(store2));
		assertFalse(store.hashCode() == store2.hashCode());

		store2 = store;

		assertTrue(store2.equals(store));
		assertTrue(store2.hashCode() == store.hashCode());

	}

	@Test
	public void store() throws IOException {
		store.readFile(getClass().getClassLoader().getResource("test.txt").getFile());
		assertNotNull(store.getFile());
		assertNotNull(store.getReader());
		store.createProducts();
		assertTrue(store.getSkus().size() > 0);
	}

}

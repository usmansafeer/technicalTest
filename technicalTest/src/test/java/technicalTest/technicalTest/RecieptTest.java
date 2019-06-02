package technicalTest.technicalTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import technicalTest.beans.Reciept;
import technicalTest.beans.Sku;

public class RecieptTest {

	private Reciept reciept;
	private Reciept reciept2;

	@Before
	public void setUp() {
		reciept = new Reciept(new ArrayList<Sku>());
		reciept2 = new Reciept(new ArrayList<Sku>());
	}
	
	@Test
	public void Test() {
		
		assertFalse(reciept.equals(reciept2));
		assertFalse(reciept.hashCode()==reciept2.hashCode());
		
		reciept2 = reciept;
		
		assertTrue(reciept.equals(reciept2));
		assertTrue(reciept.hashCode()==reciept2.hashCode());
		
	}
}

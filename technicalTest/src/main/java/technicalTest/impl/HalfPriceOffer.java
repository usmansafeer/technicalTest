package technicalTest.impl;

import java.math.BigDecimal;

import technicalTest.interfaces.Offer;

public class HalfPriceOffer implements Offer {

	@Override
	public BigDecimal totalSavings(int quantity, BigDecimal itemPrice) {
		return (new BigDecimal(quantity).multiply(itemPrice)).divide(new BigDecimal(2));
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}

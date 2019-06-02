package technicalTest.impl;

import java.math.BigDecimal;

import technicalTest.interfaces.Offer;

public class BogOfOffer extends MultipleOffer implements Offer {

	
	
	public BogOfOffer(int count, BigDecimal totalPrice) {
		super(count, totalPrice);
	}

	public BogOfOffer(BigDecimal totalPrice) {
		super(2, totalPrice);
	}

	@Override
	public BigDecimal totalSavings(int quantity, BigDecimal itemPrice) {
		// TODO Auto-generated method stub
		return null;
	}

}

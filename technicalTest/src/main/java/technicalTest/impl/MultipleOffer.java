package technicalTest.impl;

import java.math.BigDecimal;

import technicalTest.interfaces.Offer;

public class MultipleOffer implements Offer {

	private int count;
	private BigDecimal totalPrice;

	public MultipleOffer(int count, BigDecimal totalPrice) {
		this.count = count;
		this.totalPrice = totalPrice;
	}

	@Override
	public BigDecimal totalSavings(int quantity, BigDecimal itemPrice) {

		if (quantity < count) {
			return null;
		} else {
			int times = quantity / count;
			BigDecimal totalSave = itemPrice.multiply
					(new BigDecimal(times * count)).subtract(totalPrice.multiply(
							new BigDecimal(times)));	
			return totalSave;

		}

	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
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

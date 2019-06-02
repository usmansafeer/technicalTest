package technicalTest.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import technicalTest.impl.MultipleOffer;

public class Reciept {

	private List<Saving> saving;

	private List<Sku> basket;

	private BigDecimal totalPrice;

	public Reciept(List<Sku> basket) {
		this.basket = basket;
		this.totalPrice = new BigDecimal(0);
		this.saving = new ArrayList<Saving>();
	}

	public void createReciept() {
		String offerType;
		for (Sku sku : basket) {
			// Products without offer
			if (sku.getOffer() == null) {
				totalPrice = totalPrice.add(sku.getPrice());
			} else {
				if (sku.getOffer().getClass().getName().contains("Multiple")) {
					// Once for product type
					if (!saving.contains(new Saving(sku.getDescription()))) {
						MultipleOffer offer = (MultipleOffer) sku.getOffer();

						// All products of same type
						int a = Collections.frequency(basket, sku);

						BigDecimal totalSave = offer.totalSavings(a, sku.getPrice());
						if (totalSave != null) {
							Saving save = new Saving();
							save.setDescription(sku.getDescription());
							save.setSavingType(offer.getClass().getSimpleName() + " " + offer.getCount() + " for "
									+ offer.getTotalPrice());
							save.setTotalSaving(totalSave);
							saving.add(save);
						}

						// Products price with offer (same type)
						totalPrice = totalPrice
								.add(new BigDecimal(a / offer.getCount()).multiply(offer.getTotalPrice()));
						// Products price without offer (same type)
						totalPrice = totalPrice.add(new BigDecimal((a % offer.getCount())).multiply(sku.getPrice()));
					}

				} else {
					// Products with half offer
					if ((offerType = sku.getOffer().getClass().getSimpleName()).contains("Half")) {
						Saving save = new Saving();
						save.setDescription(sku.getDescription());
						save.setSavingType(offerType);
						save.setTotalSaving(sku.getOffer().totalSavings(1, sku.getPrice()));
						saving.add(save);
						totalPrice = totalPrice.add(sku.getPrice().divide(new BigDecimal(2)));
					}

				}

			}

		}

	}

	public List<Saving> getSaving() {
		return saving;
	}

	public void setSaving(List<Saving> saving) {
		this.saving = saving;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<Sku> getBasket() {
		return basket;
	}

	public void setBasket(List<Sku> basket) {
		this.basket = basket;
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

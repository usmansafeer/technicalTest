package technicalTest.beans;

import java.math.BigDecimal;

import technicalTest.impl.BogOfOffer;
import technicalTest.impl.HalfPriceOffer;
import technicalTest.impl.MultipleOffer;
import technicalTest.interfaces.Offer;

public class Sku {

	private String productCode;
	private String description;
	private BigDecimal price;
	private Offer offer;

	public Sku() {

	}

	public Sku(String productCode, String description, BigDecimal price, Offer offer) {
		this.productCode = productCode;
		this.description = description;
		this.price = price;
		this.offer = offer;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public static Sku parse(String info) {
		info = info.replaceAll("\t{1,}", "-");
		String[] split = info.split("-");
		Offer offer = null;
		if (split.length == 4) {
			String offerType = split[3];
			if (offerType.contains("Half")) {
				offer = new HalfPriceOffer();
			} else {
				if (offerType.contains("for")) {
					String[] obj = offerType.split(" for ");
					offer = new MultipleOffer(Integer.parseInt(obj[0]), new BigDecimal(obj[1]));

				} else {
					if (offerType.contains("BOG")) {
						offer = new BogOfOffer(2, new BigDecimal(split[2]));
					}

				}

			}
		}

		return new Sku(split[0], split[1], new BigDecimal(split[2]), offer);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productCode == null) ? 0 : productCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sku other = (Sku) obj;
		if (productCode == null) {
			if (other.productCode != null)
				return false;
		} else if (!productCode.equals(other.productCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sku [productCode=" + productCode + ", description=" + description + ", price=" + price + "]";
	}

}

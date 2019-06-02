package technicalTest.beans;

import java.util.ArrayList;
import java.util.List;

import technicalTest.exception.ProducNotFoundException;

public class Till {

	List<Sku> storeProducts;
	List<Sku> basket;

	public Till(List<Sku> storeProducts) {
		basket = new ArrayList<Sku>();
		this.storeProducts = storeProducts;
	}

	public void scan(String productCode) throws ProducNotFoundException {
		Sku sku = new Sku();
		sku.setProductCode(productCode);
		if (storeProducts.contains(sku)) {
			basket.add(storeProducts.get(storeProducts.indexOf(sku)));
			System.out.println("Scanned: " + basket.get(basket.size() - 1).toString());
		} else {
			throw new ProducNotFoundException("Error! product not found.");
		}

	}

	public Reciept getRecipt() {
		Reciept reciept = new Reciept(basket);
		return reciept;
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

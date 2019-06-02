package technicalTest.beans;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

import technicalTest.exception.ProducNotFoundException;

public class Main {

	public static void main(String[] args) {

		System.out.println("*** Store ***");
		Scanner enter = new Scanner(System.in);

		
		Store store = new Store();

		try {
			store.readFile(args[0]);
			store.createProducts();
			Till till = store.getTill();
			System.out.println("Scan products");
			String productCode = "";
			while (true) {
				productCode = enter.next().toUpperCase();
				if (productCode.equals("*"))
					break;
				try {
					till.scan(productCode);

				} catch (ProducNotFoundException e) {
					System.err.println(e.getMessage());
				}
			}

			Reciept reciept = till.getRecipt();
			reciept.createReciept();

			System.out.println("- All products: ");
			for (Sku products : reciept.getBasket()) {
				System.out.println(" - " + products);
			}
			System.out.println();

			BigDecimal totalSaving = new BigDecimal(0);
			System.out.println("- Savings: ");
			
			for (Saving save : reciept.getSaving()) {
				System.out.println(" - " + save.toString());
				totalSaving = totalSaving.add(save.getTotalSaving());
			}
			System.out.println();
			System.out.println("- Total savings in this reciept:" + totalSaving);

			System.out.println("- Total price:" + reciept.getTotalPrice());

		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

	}
}

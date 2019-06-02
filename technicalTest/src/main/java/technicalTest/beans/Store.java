package technicalTest.beans;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Store {

	private List<Sku> skus;

	private FileReader file;
	private BufferedReader reader;

	public Store() {

	}

	public void createProducts() throws IOException {
		skus = new ArrayList<Sku>();
		if (reader != null) {
			reader.readLine();
			String read;
			while ((read = reader.readLine()) != null) {
				Sku sku = Sku.parse(read);
				skus.add(sku);
			}
			reader.close();
			file.close();
		}
	}

	public void readFile(String fileName) throws FileNotFoundException {
		file = new FileReader(fileName);
		reader = new BufferedReader(file);
	}

	public Till getTill() {
		return new Till(skus);
	}

	public List<Sku> getSkus() {
		return skus;
	}

	public FileReader getFile() {
		return file;
	}

	public BufferedReader getReader() {
		return reader;
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

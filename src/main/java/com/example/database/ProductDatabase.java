package com.example.database;

import java.util.ArrayList;
import java.util.List;

public class ProductDatabase extends AbstractProductDatabase{

	private final List<Product> productList = new ArrayList<>();

	public ProductDatabase() {
		setUpProductsForDb();
	}

	@Override
	public List<Product> getProductList() {
		return productList;
	}

	@Override
	public void setUpProductsForDb() {
		Product[] productsForDemoDb = {
				new Product(123, "Butter", 5.00), new Product(234, "Milk", 2.50),
				new Product(345, "Bread", 2.20), new Product(456, "Juice", 3.00)};
		for (Product tempProduct : productsForDemoDb) {
			this.productList.add(tempProduct);
		}
	}
	
	@Override
	public Product getProductByBarcode(int barcode) {
		for (Product tempProduct : productList) {
			if(tempProduct.getBarcode() == barcode) {
				return tempProduct;
			}
		}
		return null;
	}
	
	@Override
	public boolean isProductInDatabase(int barcode) {
		for (Product tempProduct : productList) {
			if(tempProduct.getBarcode() == barcode) {
				return true;
			}
		}
		return false;
	}
	
}

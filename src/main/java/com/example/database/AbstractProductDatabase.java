package com.example.database;

import java.util.List;

public abstract class AbstractProductDatabase {

	public abstract List<Product> getProductList();
	public abstract void setUpProductsForDb();
	public abstract Product getProductByBarcode(int barcode);
	public abstract boolean isProductInDatabase(int barcode);
	
}

package com.example.database;

import java.util.List;

public abstract class AbstractBasket {

	public abstract List<Product> getProductsInBasket();
	public abstract void addProductToBasket(Product product);
	public abstract double getTotalPrice();
	public abstract String printReceipt();
	
}

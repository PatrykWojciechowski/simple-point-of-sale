package com.example.database;

import java.util.ArrayList;
import java.util.List;

public class Basket extends AbstractBasket{

	private final List<Product> productsInBasket = new ArrayList<>();

	@Override
	public List<Product> getProductsInBasket() {
		return productsInBasket;
	}

	@Override
	public void addProductToBasket(Product theProduct) {
		productsInBasket.add(theProduct);
	}
	
	@Override
	public double getTotalPrice() {
		double totalPrice = 0;
		for (Product tempProduct : productsInBasket) {
			double priceOfProduct = tempProduct.getPrice();
			totalPrice += priceOfProduct;
		}
		return totalPrice;
	}
	
	@Override
	public String printReceipt() {
		String receipt ="\nSALES RECEIPT\n"
				+ "_________________________________"
				+ toString()
				+ "\n_________________________________\n"
				+ "Total price: \t\t" + getTotalPrice() + " PLN \n";
		return receipt;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("");
		for (Product tempProduct : productsInBasket) {
			result.append("\n" + tempProduct.toString());
		}
		return result.toString();
	}
	
}

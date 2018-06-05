package com.example.database;

public class Product {

	private final int barcode;
	private final String name;
	private final double price;
	
	public int getBarcode() {
		return barcode;
	}

	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public Product(int barcode, String name, double price) {
		this.barcode = barcode;
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return getName() + "\t\t\t" + getPrice() + " PLN";
	}
	
	@Override
	public int hashCode() {
		return 31 * Integer.valueOf(barcode).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof Product) {
			Product otherProduct = (Product) obj;
			return barcode == otherProduct.getBarcode();
		}
		return false;
	}
	
}

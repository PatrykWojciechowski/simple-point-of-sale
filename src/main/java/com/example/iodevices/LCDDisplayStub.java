package com.example.iodevices;

import com.example.database.AbstractBasket;
import com.example.database.Product;

public class LCDDisplayStub extends AbstractLCDDisplay {

	@Override
	public String showProductNotFound() {
		return LCD_DISPLAY + "Product not found";
	}

	@Override
	public String showInvalidBarcode() {
		return LCD_DISPLAY + "Invalid Barcode";
	}

	@Override
	public String showProductInfo(Product theProduct) {
		return LCD_DISPLAY + theProduct;
	}

	@Override
	public String showTotalPrice(AbstractBasket theBasket) {
		return LCD_DISPLAY + "Total price: \t\t" + theBasket.getTotalPrice() + " PLN \n";
	}

}

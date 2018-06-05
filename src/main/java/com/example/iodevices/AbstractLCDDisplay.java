package com.example.iodevices;

import com.example.database.AbstractBasket;
import com.example.database.Product;

public abstract class AbstractLCDDisplay {

	public static final String LCD_DISPLAY = "---- LCD Display: ----\n";
	
	public abstract String showProductNotFound();
	public abstract String showInvalidBarcode();
	public abstract String showProductInfo(Product theProduct);
	public abstract String showTotalPrice(AbstractBasket theBasket);
	
}

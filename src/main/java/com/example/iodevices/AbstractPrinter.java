package com.example.iodevices;

import com.example.database.AbstractBasket;

public abstract class AbstractPrinter {
	
	public static final String PRINTER = "---- Printer: ----\n";
	
	public abstract String printReceipt(AbstractBasket theBasket);
	
}

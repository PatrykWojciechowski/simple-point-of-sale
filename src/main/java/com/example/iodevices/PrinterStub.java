package com.example.iodevices;

import com.example.database.AbstractBasket;

public class PrinterStub extends AbstractPrinter {

	@Override
	public String printReceipt(AbstractBasket theBasket) {
		return PRINTER + theBasket.printReceipt();
	}

}

package com.example.iodevices;

public abstract class AbstractBarcodeScanner {
	
	public abstract void startScanning();
	public abstract String validateInput(String input);
	public abstract String validateBarcode(int barcode);
	public abstract void printEnterYourInput();
	public abstract void printWelcomeMessage();
	
}

package com.example.iodevices;

import java.util.Scanner;

import com.example.database.Basket;
import com.example.database.Product;
import com.example.database.ProductDatabase;

public class BarcodeScannerStub extends AbstractBarcodeScanner {
	
	private Basket basket;
	private ProductDatabase productDatabase;
	private PrinterStub printer;
	private LCDDisplayStub displayLCD;
	private boolean continueScanning = true;
	
	public boolean isContinueScanning() {
		return continueScanning;
	}
	
	public void setContinueScanning(boolean continueScanning) {
		this.continueScanning = continueScanning;
	}

	@Override
	public void startScanning() {
		printWelcomeMessage();
		try (Scanner inputReader = new Scanner(System.in)){
			while(isContinueScanning()) {
				printEnterYourInput();
				String input = inputReader.nextLine();
				System.out.println(validateInput(input));
			}
		}
	}

	public BarcodeScannerStub() {
		this.basket = new Basket();
		this.productDatabase = new ProductDatabase();
		this.printer = new PrinterStub();
		this.displayLCD = new LCDDisplayStub();
	}

	@Override
	public void printWelcomeMessage() {
		System.out.println("---- Welcome to Point of sale ----");
	}
	
	@Override
	public void printEnterYourInput() {
		System.out.println("\nEnter barcode of a product or \"exit\" to finish scanning:");
	}

	@Override
	public String validateInput(String input) {
		if(input.equalsIgnoreCase("exit")) {
			setContinueScanning(false);
			return printer.printReceipt(basket)
					+ "\n" + displayLCD.showTotalPrice(basket);
		} else if (input.isEmpty()) {
			return displayLCD.showInvalidBarcode();
		} else {
			try {
				int productBarcode = Integer.parseInt(input);
				return validateBarcode(productBarcode);
			} catch (NumberFormatException e) {
				return displayLCD.showInvalidBarcode();
			}
		}
	}

	@Override
	public String validateBarcode(int productBarcode) {
		if(productDatabase.isProductInDatabase(productBarcode)) {
			Product scannedProduct = productDatabase.getProductByBarcode(productBarcode);
			basket.addProductToBasket(scannedProduct);
			return displayLCD.showProductInfo(scannedProduct);
		} else {
			return displayLCD.showProductNotFound();
		}
	}

}
package com.example.testiodevices;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.database.Basket;
import com.example.database.Product;
import com.example.database.ProductDatabase;
import com.example.iodevices.BarcodeScannerStub;
import com.example.iodevices.LCDDisplayStub;
import com.example.iodevices.PrinterStub;

@RunWith(MockitoJUnitRunner.class)
public class BarcodeScannerStubTest {

	private static Product defaultProduct;
	@Mock private PrinterStub mockedPrinter;
	@Mock private LCDDisplayStub mockedLCDDisplay;
	@Mock private Basket mockedBasket;
	@Mock private ProductDatabase mockedDatabase;
	@InjectMocks private BarcodeScannerStub testBcScanner = new BarcodeScannerStub();

	@BeforeClass
	public static void setUpBeforeClass() {
		defaultProduct = new Product(123, "Butter", 5.00);
	}

	@Before
	public void setUp() {
		when(mockedPrinter.printReceipt(mockedBasket)).thenReturn("SALES RECEIPT:");
		when(mockedLCDDisplay.showTotalPrice(mockedBasket)).thenReturn("Total price: 0.00 PLN");
		when(mockedLCDDisplay.showInvalidBarcode()).thenReturn("Invalid Barcode");
		when(mockedLCDDisplay.showProductNotFound()).thenReturn("Product not found");
		when(mockedLCDDisplay.showProductInfo(defaultProduct)).thenReturn("Butter 5 PLN");
		when(mockedDatabase.isProductInDatabase(123)).thenReturn(true);
		when(mockedDatabase.isProductInDatabase(999)).thenReturn(false);
		when(mockedDatabase.getProductByBarcode(123)).thenReturn(defaultProduct);
	}
	
	@Test
	public void testValidateInputExitPrintReceiptWhileBasketIsEmpty() {
		assertEquals("SALES RECEIPT:\nTotal price: 0.00 PLN",
				testBcScanner.validateInput("exit"));
		verify(mockedPrinter).printReceipt(mockedBasket);
		verify(mockedLCDDisplay).showTotalPrice(mockedBasket);
	}
	
	@Test
	public void testValideEmptyInputShouldShowInvalidBarcode() {
		assertEquals("Invalid Barcode",
				testBcScanner.validateInput(""));
		verify(mockedLCDDisplay).showInvalidBarcode();
	}
	
	@Test
	public void testValideRandomInputShouldShowInvalidBarcode() {
		assertEquals("Invalid Barcode",
				testBcScanner.validateInput("java?#-$+@"));
		verify(mockedLCDDisplay).showInvalidBarcode();
	}
	
	@Test
	public void testValideProperInputShouldShowProductInfo() {
		assertEquals("Butter 5 PLN",
				testBcScanner.validateInput("123"));
		verify(mockedLCDDisplay).showProductInfo(defaultProduct);
		verify(mockedDatabase).isProductInDatabase(123);
		verify(mockedDatabase).getProductByBarcode(123);
	}
	
	@Test
	public void testValideProperBarcodeShouldShowProductInfo() {
		assertEquals("Butter 5 PLN",
				testBcScanner.validateBarcode(123));
		verify(mockedLCDDisplay).showProductInfo(defaultProduct);
		verify(mockedDatabase).isProductInDatabase(123);
		verify(mockedDatabase).getProductByBarcode(123);
	}
	
	@Test
	public void testValideBadBarcodeShouldShowProductNotFound() {
		assertEquals("Product not found",
				testBcScanner.validateBarcode(999));
		verify(mockedLCDDisplay).showProductNotFound();
		verify(mockedDatabase).isProductInDatabase(999);
	}
	
}
package com.example.testiodevices;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.database.Basket;
import com.example.database.Product;
import com.example.iodevices.AbstractLCDDisplay;
import com.example.iodevices.LCDDisplayStub;

@RunWith(MockitoJUnitRunner.class)
public class LCDDisplayStubTest {
	
	private static Product defaultProduct;
	private static LCDDisplayStub testLCDDisplay;
	@Mock private Basket mockedBasket;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		defaultProduct = new Product(123, "Butter", 2.00);
		testLCDDisplay = new LCDDisplayStub();
	}
	
	@Before
	public void setUp() {
		when(mockedBasket.getTotalPrice()).thenReturn(2.00);
	}
	
	@Test
	public void testShowProductNotFound() {
		assertNotNull(testLCDDisplay.showProductNotFound());
		assertEquals(AbstractLCDDisplay.LCD_DISPLAY+ "Product not found",
				testLCDDisplay.showProductNotFound());
	}

	@Test
	public void testShowInvalidBarcode() {
		assertNotNull(testLCDDisplay.showInvalidBarcode());
		assertEquals(AbstractLCDDisplay.LCD_DISPLAY + "Invalid Barcode",
				testLCDDisplay.showInvalidBarcode());
	}

	@Test
	public void testShowProductInfo() {
		assertNotNull(testLCDDisplay.showProductInfo(defaultProduct));
		assertEquals(AbstractLCDDisplay.LCD_DISPLAY + defaultProduct,
				(testLCDDisplay.showProductInfo(defaultProduct)));
	}
	
	@Test
	public void testShowTotalPriceOfDefProduct() {
		assertEquals(AbstractLCDDisplay.LCD_DISPLAY + "Total price: \t\t2.0 PLN \n",
				testLCDDisplay.showTotalPrice(mockedBasket));
		verify(mockedBasket).getTotalPrice();
	}

}

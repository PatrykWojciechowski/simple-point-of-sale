package com.example.testiodevices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.database.Basket;
import com.example.iodevices.AbstractPrinter;
import com.example.iodevices.PrinterStub;

@RunWith(MockitoJUnitRunner.class)
public class PrinterStubTest {

	private static PrinterStub testPrinter;
	@Mock private Basket mockedBasket;

	@BeforeClass
	public static void setUpBefore() {
		testPrinter = new PrinterStub();
	}
	
	@Before
	public void setUp() {
		when(mockedBasket.printReceipt()).thenReturn("SALES RECEIPT:");
	}
	
	@Test
	public void testPrintReceipt() {
		assertNotNull(testPrinter.printReceipt(mockedBasket));
		assertEquals(AbstractPrinter.PRINTER + "SALES RECEIPT:",
				testPrinter.printReceipt(mockedBasket));
		verify(mockedBasket, atLeast(1)).printReceipt();
	}

}

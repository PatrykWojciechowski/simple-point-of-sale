package com.example.testdatabase;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.database.Basket;
import com.example.database.Product;

public class BasketTest {
	
	private Basket testBasket;
	private static Product defaultProduct;
	private static Product[] defaultTestProducts;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		defaultProduct = new Product(123, "Butter", 5.00);
		defaultTestProducts = new Product[]{new Product(123, "Butter", 5.00), new Product(234, "Milk", 2.70),
				new Product(345, "Bread", 2.30)};
	}
	
	@Before
	public void setUp() {
		testBasket = new Basket();
	}
	
	@Test
	public void testAddToBasketOneProduct() {
		testBasket.addProductToBasket(defaultProduct);
		assertTrue(testBasket.getProductsInBasket().size() == 1);
		assertTrue(testBasket.getProductsInBasket().contains(defaultProduct));
	}
	
	@Test
	public void testAddToBasketBunchOfProducts() {
		for (Product tempProduct : defaultTestProducts) {
			testBasket.addProductToBasket(tempProduct);
		}
		assertFalse(testBasket.getProductsInBasket().isEmpty());
		assertTrue(testBasket.getProductsInBasket().size() == 3);
	}
	
	@Test
	public void testGetTotalPriceWithEmptyBasket() {
		assertTrue(testBasket.getProductsInBasket().isEmpty());
		assertTrue(0.00 == testBasket.getTotalPrice());
	}
	
	@Test
	public void testGetTotalPriceOfOneProduct() {
		testBasket.addProductToBasket(defaultProduct);
		assertTrue(5.00 == testBasket.getTotalPrice());
	}
	
	@Test
	public void testGetTotalPriceOfManyProducts() {
		for (Product tempProduct : defaultTestProducts) {
			testBasket.addProductToBasket(tempProduct);
		}
		assertTrue(testBasket.getProductsInBasket().size() == 3);
		assertTrue(10.00 == testBasket.getTotalPrice());
	}
	
	@Test
	public void testPrintReceiptWithOneProduct() {
		testBasket.addProductToBasket(defaultProduct);
		assertTrue(testBasket.getProductsInBasket().size() == 1);
		assertNotNull(testBasket.printReceipt());
	}

	@Test
	public void testPrintReceiptWhileBasketIsEmpty() {
		assertTrue(testBasket.getProductsInBasket().isEmpty());
		assertNotNull(testBasket.printReceipt());
	}

}

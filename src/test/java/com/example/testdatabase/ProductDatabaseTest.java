package com.example.testdatabase;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.database.Product;
import com.example.database.ProductDatabase;

public class ProductDatabaseTest {

	private ProductDatabase testDatabase;
	private static Product defaultProduct;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		defaultProduct = new Product(123, "Butter", 2.00);
	}
	
	@Before
	public void setUp() {
		testDatabase = new ProductDatabase();
	}
	
	@Test
	public void testGetDefProductByBarcode() {
		assertNotNull(testDatabase.getProductByBarcode(123));
		assertEquals(defaultProduct, testDatabase.getProductByBarcode(123));
	}

	@Test
	public void testGetProductWithWrongBarcode() {
		assertFalse(testDatabase.isProductInDatabase(999));
	}
	
	@Test
	public void testSetUpProductsForDb() {
		assertFalse(testDatabase.getProductList().isEmpty());
		assertTrue(testDatabase.getProductList().size() == 4);
	}
	
	@Test
	public void testIsDefProductInDb() {
		assertTrue(testDatabase.isProductInDatabase(123));
	}
	
	@Test
	public void testIsProductWithWrongBarcodeInDb() {
		assertFalse(testDatabase.isProductInDatabase(999));
	}

}

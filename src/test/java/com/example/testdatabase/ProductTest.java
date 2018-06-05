package com.example.testdatabase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.example.database.Product;

public class ProductTest {
	
	private static Product testProduct1;
	private static Product testProduct2;
	private static Product testProduct3;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		testProduct1 = new Product(123, "Butter", 5.00);
		testProduct2 = new Product(234, "Butter", 5.00);
		testProduct3 = new Product(123, "Butter", 5.00);
	}
	
	@Test
	public void testEquals() {
		assertFalse(testProduct1.equals(testProduct2));
		assertTrue(testProduct1.equals(testProduct3));
	}
	
	@Test
	public void testHashCode() {
		assertFalse(testProduct1.hashCode() == testProduct2.hashCode());
		assertTrue(testProduct1.hashCode() == testProduct3.hashCode());
	}

}

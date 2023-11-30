package com.phatvo.economic.utils;

import java.util.HashMap;

import com.phatvo.economic.entities.Products;

public class DataSharing {
	
	public static HashMap<Integer, Products> products = new HashMap<>();
	
	static {
		// Add product into products list
		products.put(1, new Products(1, "Laptop Dell Inspiron", 15000000, 15, 
										"This is Laptop Gaming", "Dell.jpg"));
		products.put(2, new Products(2, "Laptop Asus TUF", 18000000, 10, 
										"This is Laptop Gaming","AsusTUF.jpg"));
		products.put(3, new Products(3, "Laptop Asus ROG", 25000000, 25, 
										"This is Laptop Gaming","AsusROG.jpg"));
		products.put(4, new Products(4, "Iphone 13 Pro Max", 32000000, 30, 
										"This is phone of Apple ","Iphone13.jpg"));
		products.put(5, new Products(5, "Samsung 22 Ultra", 28000000, 27, 
										"This is phone of Samsung","Samsung21U.jpg"));
	}
	
	
	
}

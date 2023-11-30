package com.phatvo.economic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.phatvo.economic.utils.DataSharing;

@Controller
public class ProductsController {

	@GetMapping("/products")
	public String getProducts(Model model) {
		model.addAttribute("products", DataSharing.products.values());
		return "index"; //products (cũ) giống lab
	}

}

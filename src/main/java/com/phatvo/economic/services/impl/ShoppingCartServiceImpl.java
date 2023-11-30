package com.phatvo.economic.services.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.phatvo.economic.entities.Products;
import com.phatvo.economic.services.ShoppingCartService;
import com.phatvo.economic.utils.DataSharing;

@Service
@SessionScope
public class ShoppingCartServiceImpl implements ShoppingCartService {

	private static HashMap<Integer, Products> orders = new HashMap<>();

	@Override
	public void addProduct(Integer id) {
		Products prod = DataSharing.products.get(id).orderProduct(1);
		if (!orders.containsKey(id)) {
			orders.put(prod.getId(), prod);
		} else if(prod != null){
			int oldQuantity = orders.get(id).getQuantity();
			orders.get(id).setQuantity(oldQuantity + 1);
		}
	}

	@Override
	public void removeProduct(Integer id) {
		// Remove product
		Products prod = orders.get(id);
		// Return quantity order into products list
		DataSharing.products.get(id).orderProduct(0 - prod.getQuantity());
		orders.remove(id);
	}

	@Override
	public void updateProduct(Integer id, int qty) {
		Products prod = orders.get(id);
		Products prodCheck = DataSharing.products.get(id).orderProduct(qty - prod.getQuantity());
		// Update or remove product
		if (qty > 0) {
			if (prodCheck != null) {
				prod.setQuantity(qty);
			}
		} else {
			orders.remove(id);
		}
			
	}

	@Override
	public void clear() {
		for (Integer id : orders.keySet()) {
			Products prod = orders.get(id);
			// Return quantity order into products list
			DataSharing.products.get(id).orderProduct(0 - prod.getQuantity());
		}
		orders.clear();
	}

	@Override
	public Map<Integer, Products> getProducts() {
		return orders;
	}

	@Override
	public int getCount() {
		int count = 0;
		for (Products prod : orders.values()) {
			count += prod.getQuantity();
		}
		return count;
	}

	@Override
	public double getAmount() {
		double amount = 0;
		for (Products prod : orders.values()) {
			amount += prod.getPrice() * prod.getQuantity();
		}
		return amount;
	}

}

package com.phatvo.economic.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.phatvo.economic.services.ShoppingCartService;

@WebFilter(urlPatterns = "/*")
public class CartFilter extends HttpFilter {
	
	private static final long serialVersionUID = 1L;

	@Autowired
	ShoppingCartService cart;
	
	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setAttribute("cartAmount", cart.getAmount());
		request.setAttribute("cartQuantity", cart.getCount());
		chain.doFilter(request, response);
	}
}

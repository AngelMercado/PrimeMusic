package com.primeStore.musicStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.primeStore.musicStore.domain.Cart;
import com.primeStore.musicStore.domain.CartItem;
import com.primeStore.musicStore.domain.Customer;
import com.primeStore.musicStore.domain.Product;
import com.primeStore.musicStore.service.CartItemService;
import com.primeStore.musicStore.service.CartService;
import com.primeStore.musicStore.service.CustomerService;
import com.primeStore.musicStore.service.ProductService;

@Controller
@RequestMapping("/rest/cart")
public class CartResources {
	@Autowired
	CartService cartService;

	@Autowired
	CustomerService customerService;

	@Autowired
	ProductService productService;

	@Autowired
	CartItemService cartItemService;

	@RequestMapping("/{cartId}")
	public @ResponseBody Cart getCartById(@PathVariable("cartId") int cartId) {
		return cartService.getCartById(cartId);
	}

	@RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addItems(@PathVariable(value = "productId") int productId, @AuthenticationPrincipal User activeUser) {
		Customer customer = customerService.getCustomerByUserName(activeUser.getUsername());
		Cart cart = customer.getCart();
		Product product = productService.getProductById(productId);
		List<CartItem> cartItemList = cart.getCartItems();
		for (int i = 0; i < cartItemList.size(); i++) {
			if (product.getIdProduct() == cartItemList.get(i).getProduct().getIdProduct()) {
				CartItem cartItem = cartItemList.get(i);
				cartItem.setQuatity(cartItem.getQuatity() + 1);
				cartItem.setTotalPrice(product.getProductPrice() * cartItem.getQuatity());
				cartItemService.addCartItem(cartItem);
				return ;
			}

		}
		CartItem cartItem = new CartItem();
		cartItem.setQuatity(1);
		cartItem.setProduct(product);
		cartItem.setTotalPrice(product.getProductPrice() * cartItem.getQuatity());
		cartItem.setCart(cart);
		cartItemService.addCartItem(cartItem);
	}

	@RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteItem(@PathVariable("productId") int productId) {
		CartItem cartItem = cartItemService.getCartItemByProductId(productId);
		cartItemService.removeCartItem(cartItem);
	}
	
	@RequestMapping(value="/{cartId}", method=RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void clearCart(@PathVariable(value="cartId") int cartId) {
		Cart cart = cartService.getCartById(cartId);
		cartItemService.removeAllCartItems(cart);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST,reason="Illegal request, please verify your payload")
	public void handleClientErrors(Exception ex) {}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR,reason="Internal server error")
	public void handleServerErrors(Exception ex) {}
	
}

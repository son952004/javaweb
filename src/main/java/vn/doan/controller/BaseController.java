package vn.doan.controller;

import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import vn.doan.dto.Cart;

@Controller
public class BaseController {
	//những cái nào bên view ghi ${title} thì set cái title cho web đó
	@ModelAttribute("title")
	public String title() {
		return "ManCiTy"; 
	}
	
	@ModelAttribute("totalCartProducts")
	public BigInteger totalCart(final HttpServletRequest request) {
		BigInteger total = BigInteger.ZERO;
		HttpSession session = request.getSession();
		if(session.getAttribute("cart") != null) {
			Cart cart = (Cart) session.getAttribute("cart");
			total = cart.totalProduct();
		}
		return total; 
	}
	
}
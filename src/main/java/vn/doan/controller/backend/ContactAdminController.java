package vn.doan.controller.backend;

import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.doan.controller.BaseController;
import vn.doan.dto.Cart;

@Controller
@RequestMapping("/admin/contact/")
public class ContactAdminController extends BaseController {
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public String contactUser(final Model model,
			final HttpServletRequest request ){
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		
		return "redirect:/cart-view";
	}
	
	
}

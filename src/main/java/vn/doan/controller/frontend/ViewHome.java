package vn.doan.controller.frontend;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.doan.controller.BaseController;
import vn.doan.model.Product;
import vn.doan.service.ProductService;

@Controller
@RequestMapping("/home/")
public class ViewHome extends BaseController{
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "view", method =RequestMethod.GET )
	public String viewHome() {
		return "frontend/MCI_Home";
	}
	@RequestMapping(value = "rodri", method =RequestMethod.GET )
	public String playerView(final Model model, final HttpServletRequest request) {
		List<Product> products = productService.findActive();
		model.addAttribute("products", products);
		return "frontend/rodri";
	}
}

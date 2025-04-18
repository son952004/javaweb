package vn.doan.controller.backend;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.doan.controller.BaseController;
import vn.doan.model.SaleOderProduct;
import vn.doan.model.User;
import vn.doan.service.ProductService;
import vn.doan.service.SaleOderProductService;
import vn.doan.service.UserService;

	@Controller
	@RequestMapping("/admin/orderProduct/")
public class OderProductAdminController extends BaseController {
	@Autowired
	private SaleOderProductService saleOderProduct;
	
	@Autowired
	private ProductService productService;
		
	@Autowired
	private UserService userService;
		
	@RequestMapping(value = "view")
	public String oderProductList( final HttpServletRequest request,final Model model){
		List<SaleOderProduct> saleOderProducts = saleOderProduct.findActive(); 
			model.addAttribute("SaleOrderProduct", saleOderProducts);
			return "backend/productOder-list";
		}
}

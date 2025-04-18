package vn.doan.controller.backend;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.doan.controller.BaseController;
import vn.doan.model.Category;
import vn.doan.model.SaleOder;
import vn.doan.service.SaleOderService;

@Controller
@RequestMapping("/admin/order/")
public class OrderAdminController extends BaseController {
	@Autowired
	private SaleOderService saleOderService;

	@RequestMapping(value = "view")
	public String userList(final Model model, final HttpServletRequest request){
		List<SaleOder> saleOder = saleOderService.findAll();
		  
		model.addAttribute("saleOrders", saleOder);
		return "backend/order-list";
	}
}

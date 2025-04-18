package vn.doan.controller.backend;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.doan.controller.BaseController;
import vn.doan.model.User;
import vn.doan.service.ProductService;
import vn.doan.service.UserService;

@Controller
@RequestMapping("/admin/user/")
public class UserAdminController extends BaseController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "view")
	public String userList( final HttpServletRequest request,final Model model){
		List<User> users = userService.findActive(); 
		model.addAttribute("users", users);
		return "backend/user-list";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String userAdd(final Model model, final HttpServletRequest request){
		
		return "backend/user-add";
	}
}

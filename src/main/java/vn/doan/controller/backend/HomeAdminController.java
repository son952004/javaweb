package vn.doan.controller.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.doan.controller.BaseController;



@Controller
@RequestMapping("/admin/home/")
public class HomeAdminController extends BaseController {
	
	@RequestMapping(value = "view", method = RequestMethod.GET)
	public String homeView() {
		return "backend/home";
	}
}

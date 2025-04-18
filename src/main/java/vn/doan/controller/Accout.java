package vn.doan.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.doan.dto.Cart;
import vn.doan.model.Category;
import vn.doan.model.Role;
import vn.doan.model.User;
import vn.doan.service.UserService;

@Controller
public class Accout extends BaseController {	
	@Autowired
	private UserService userService;  // Service để lưu thông tin người dùng

	@Autowired
	private PasswordEncoder passwordEncoder;  // Tiêm PasswordEncoder từ Spring
	    
	@RequestMapping("/login")
	public String logIn(@ModelAttribute User user, Model model, final HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		return "login";
	}
	
	 @RequestMapping("/signup")
	    public String signUp(Model model) {
		 model.addAttribute("user", new User());
	        return "sigup";  // Chuyển đến trang signup.jsp
	    }

	@RequestMapping(value="signupAction", method = RequestMethod.POST)
	public String saveAdd(@ModelAttribute User user, Model model ,final HttpServletRequest request){
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
		String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setId(4);
        userService.saveOrUpdate(user);
        return "redirect:/login";
		}
}

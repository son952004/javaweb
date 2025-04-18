package vn.doan.controller.backend;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.doan.controller.BaseController;
import vn.doan.model.Category;
import vn.doan.model.User;
import vn.doan.service.CategoryService;
import vn.doan.service.UserService;


@Controller
@RequestMapping("/admin/category/")
public class CategoryAdminController extends BaseController{
	
// khai báo service
@Autowired
private CategoryService categoryService;

@Autowired
private UserService userService;
	

	@RequestMapping(value = "view", method = RequestMethod.GET)
	public String categoryList(final Model model, final HttpServletRequest request){
		
		List<Category> categories = categoryService.findActive();
		  
		model.addAttribute("categories", categories);
		
		return "backend/category-list";
	}
	
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String categoryAdd(final Model model){
		
		List<User> users = userService.findAll();
		
		Category category = new Category();
		
		category.setCreateDate(new Date());
		
		model.addAttribute("users", users);
		
		model.addAttribute("category",category);
		
		return "backend/category-add";
	}
	
	
	@RequestMapping(value="add-save", method = RequestMethod.POST)
	public String saveAdd(@ModelAttribute("category") Category category){
		categoryService.saveOrUpdate(category);
		return "redirect:/admin/category/add"; 
		}
	
	
	
	//edit 1 sp
	@RequestMapping(value = "edit/{giCungDuoc}", method = RequestMethod.GET)// dấu {} để lấy giá trị trong ngoặc url bên view là: edit/${category.id}
	public String categoryEdit(final Model model, 
			@PathVariable int giCungDuoc){   // edit 1 sp
		
		//lấy dữ liệu data trộn với view trả v�? browser
		List<User> users = userService.findAll();
		
		//phải đẩy 1 đối tượng qua bên sf bắt buộc đối tượng rộng cũng được
		Category category = categoryService.getById(giCungDuoc);// khác với cái thêm mới (sửa bằng id bản ghi)
		//set ngay hien tai cho category khong co cung duoc
		category.setCreateDate(new Date());
		
		
		// service trả model, rồi model trả v�? cho view, bên trái là tên dùng ở view, phải là 1 list biến data  
		model.addAttribute("users", users);
		model.addAttribute("category",category);
		return "backend/category-edit";
	}
	
	//co 1 cai controller de luu rieng cua edit
	@RequestMapping(value="edit-save", method = RequestMethod.POST)
	public String saveEdit(@ModelAttribute("category") Category category){ //ModelAtribute (chỉ) ánh xạ đến đối tượng trong () để gán các thuộc tính đó là lý do tạo đt
		categoryService.saveOrUpdate(category);
		return "redirect:/admin/category/view";
	}
	
	
	
	// xóa 1 bản ghi( bằng cách set status sp v�?(sai, unactive) và chỉ hiện những bản active = where
	@RequestMapping(value = "delete/{giCungDuoc}", method = RequestMethod.GET)// dấu {} để lấy giá trị trong ngoặc url bên view là: edit/${category.id}
	public String categoryDete(final Model model, 
			@PathVariable int giCungDuoc){   // path phải giống value
		Category category = categoryService.getById(giCungDuoc);
		category.setStatus(false);
		categoryService.saveOrUpdate(category);
		return "redirect:/admin/category/view";
	}
}

package vn.doan.controller.backend;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vn.doan.controller.BaseController;
import vn.doan.dto.JW31;
import vn.doan.dto.SearchModel;
import vn.doan.model.Category;
import vn.doan.model.Product;
import vn.doan.model.User;
import vn.doan.service.CategoryService;
import vn.doan.service.ProductService;
import vn.doan.service.UserService;


@Controller
@RequestMapping(value = "/admin/product/")
public class ProductAdminController extends BaseController implements JW31{
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "view", method = RequestMethod.GET)
	public String view(final Model model ,final HttpServletRequest request) {
		SearchModel search = new SearchModel();
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		// tim theo status
		search.setStatus(2);
		String str = request.getParameter("status");
		// set value ben view ma nguoi dung chon cho status
		if(str != null && !StringUtils.isEmpty(str)) search.setStatus(Integer.parseInt(str));
		
		//tim theo category
		String str1 = request.getParameter("categoryId");
		if(str1 != null && !StringUtils.isEmpty(str1)) search.setCategoryId(Integer.parseInt(str1));
		
		//tim keyword
		String str2 = request.getParameter("keyword");
		if(str2 != null && !StringUtils.isEmpty(str1)) search.setKeyword(str2);
		
		List<Product> products = productService.findSearch(search.getStatus(),search.getCategoryId(), str2);
		
		
		//total item
		search.setTotalItems(products.size());

		
		//size page
		search.setSizeOfPage(SIZE_OF_PAGE);
		
		//total page 
		if(search.getTotalItems() % SIZE_OF_PAGE == 0) search.setTotalPages(search.getTotalItems() / SIZE_OF_PAGE);
		else  search.setTotalPages(search.getTotalItems() / SIZE_OF_PAGE +1);
		
		// current page
		search.setCurrentPage(1);//default = 1
		str = request.getParameter("currentPage");
		if(str != null && !StringUtils.isEmpty(str)) search.setCurrentPage( Integer.parseInt(str));
		
		//set new page current page =1 
		if((str != null && !StringUtils.isEmpty(str)) && (Integer.parseInt(str) != products.size())) search.setCurrentPage(1);
		
		
		//sub list items
		int firstIteam = (search.getCurrentPage() - 1) * 3;
		int lastIteam = firstIteam + 3;
		
		if(lastIteam > search.getTotalItems()) model.addAttribute("products", products.subList(firstIteam, search.getTotalItems()) );
		else model.addAttribute("products", products.subList(firstIteam, lastIteam));
		
		model.addAttribute("searchModel", search);
		
		return "backend/product-list";	
	}
	

	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String productAdd(final Model model){
		
		//lấy dữ liệu data trộn với view trả về browser
		List<User> users = userService.findAllAdmin();
		List<Category> categories = categoryService.findActive();
		//phải đẩy 1 đối tượng qua bên sf bắt buộc đối tượng rộng cũng được
		Product product = new Product();
		//set ngay hien tai cho category khong co cung duoc
		product.setCreateDate(new Date());
		
		
		// service trả model, rồi model trả về cho view, bên trái là tên dùng ở view, phải là 1 list biến data  
		model.addAttribute("users", users);
		model.addAttribute("product",product);
		model.addAttribute("categories",categories);
		return "backend/product-add";
	}
	
	@RequestMapping(value="add-save", method = RequestMethod.POST)
	public String productSave(@ModelAttribute("product") Product product
			,@RequestParam("avatarFile") MultipartFile avatarFile // tìm avatarFile và gán cho đối tượng file bên phải
			,@RequestParam("imageFiles") MultipartFile[] imageFiles) throws IOException {
			
		productService.saveProduct(product, avatarFile, imageFiles);
		return "redirect:/admin/product/add";
	}
	@RequestMapping(value = "edit/{giCungDuoc}", method = RequestMethod.GET)// dấu {} để lấy giá trị trong ngoặc url bên view là: edit/${category.id}
	public String categoryEdit(final Model model, 
			@PathVariable int giCungDuoc){   // edit 1 sp bang id 
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		//lấy dữ liệu data trộn với view trả về browser
		List<User> users = userService.findAll();
		//phải đẩy 1 đối tượng qua bên sf bắt buộc đối tượng rộng cũng được
		Product product = productService.getById(giCungDuoc);// khác với cái thêm mới (sửa bằng id bản ghi)
		//set ngay hien tai cho category khong co cung duoc
		product.setCreateDate(new Date());
		
		
		// service trả model, rồi model trả về cho view, bên trái là tên dùng ở view, phải là 1 list biến data  
		model.addAttribute("users", users);
		model.addAttribute("product", product);
		return "backend/product-edit";
	}
	
	@RequestMapping(value="edit-save", method = RequestMethod.POST)
	public String saveEditProduct(@ModelAttribute("product") Product product,
	@RequestParam("avatarFile") MultipartFile avatarFile // tìm avatarFile và gán cho đối tượng file bên phải
	,@RequestParam("imageFiles") MultipartFile[] imageFiles
			) throws IOException{ //ModelAtribute (chỉ) ánh xạ đến đối tượng trong () để gán các thuộc tính đó là lý do tạo đt
		productService.saveEditProduct(product, avatarFile, imageFiles);
		return "redirect:/admin/product/view";
	}
	
	@RequestMapping(value = "delete/{giCungDuoc}", method = RequestMethod.GET)// dấu {} để lấy giá trị trong ngoặc url bên view là: edit/${category.id}
	public String categoryDete(final Model model, 
			@PathVariable int giCungDuoc){   // path phải giống value
		Product product = productService.getById(giCungDuoc);
		product.setStatus(false);
		productService.saveOrUpdate(product);
		return "redirect:/admin/product/view";
	}
	
	
}


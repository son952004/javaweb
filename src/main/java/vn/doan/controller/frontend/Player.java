package vn.doan.controller.frontend;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.doan.controller.BaseController;
import vn.doan.model.Product;
import vn.doan.model.ProductImage;
import vn.doan.service.CategoryService;
import vn.doan.service.ProductImageService;
import vn.doan.service.ProductService;

@Controller
@RequestMapping(value = "/player/")
public class Player extends BaseController{
	
	@Autowired
	private ProductService productService;	
	@Autowired
	private ProductImageService productImageService;
	
	// đẩy ảnh qua frontend theo id của cầu thủ
	@RequestMapping(value = "pl/{giCungDuoc}", method = RequestMethod.GET)
	public String categoryEdit(final Model model, 
			@PathVariable int giCungDuoc){
		Product product = productService.getById(giCungDuoc);
		
		List<ProductImage> images = productImageService.getImagesByProductId(giCungDuoc);
		model.addAttribute("product", product);
		model.addAttribute("images", images);
		return"frontend/halland";
	}
}

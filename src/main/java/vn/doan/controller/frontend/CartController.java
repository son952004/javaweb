package vn.doan.controller.frontend;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.http.HttpRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.doan.controller.BaseController;
import vn.doan.dto.Cart;
import vn.doan.dto.CartProduct;
import vn.doan.dto.JW31;
import vn.doan.model.Category;
import vn.doan.model.Product;
import vn.doan.model.SaleOder;
import vn.doan.model.SaleOderProduct;
import vn.doan.model.User;
import vn.doan.service.ProductService;
import vn.doan.service.SaleOderService;

@Controller
public class CartController extends BaseController implements JW31 {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private SaleOderService saleOderService;
	
	@RequestMapping(value = "/add-to-cart", method = RequestMethod.POST)
	public ResponseEntity<Map<String ,Object>> addToCart(
			@RequestBody CartProduct cartProduct
			,final HttpServletRequest request){
		Map<String,Object> jsonResult = new HashMap<String, Object>();// vứt list product vào jsonResult để dùng bên client
		// ktra so luong
		if(cartProduct.getQuantity().intValue() < 1) { 
			jsonResult.put("code", 120);
			jsonResult.put("message", "so luong k hop le");
			}
		else {// ktra co gio hang chua
			Cart cart = new Cart();
			HttpSession session = request.getSession();
			if(session.getAttribute("cart") == null) {// chua co gio hang, create cart
				session.setAttribute("cart", cart);
			}
			else cart = (Cart) session.getAttribute("cart");
			//add product in cart
			int index = cart.findIdProduct(cartProduct.getId());
			if (index == -1) {//product null in cart, use product in data
				Product product = productService.getById(cartProduct.getId());
				cartProduct.setAvatar(product.getavatar());//set cac thuoc tinh tu product cho cartProduct
				cartProduct.setPrice(product.getPrice());
				cartProduct.setSale(product.getSalePrice());
				cart.getCartProducts().add(cartProduct); //set product cho list cartProducts trong cart
			}
			//sp co in cart , update quantity
			else cart.getCartProducts().get(index).updateQuantity(cartProduct.getQuantity());
			
			
			jsonResult.put("code", 420);
			jsonResult.put("message", "add oke" + cartProduct.getQuantity()+" '" +cartProduct.getName() + "' in cart");
			jsonResult.put("totalCartProducts", cart.totalProduct());
		}
		return ResponseEntity.ok(jsonResult);
	}
	
	@RequestMapping(value = "/cart-view", method = RequestMethod.GET)
	public String view(final HttpServletRequest request 
			,final Model model) {
	    return "frontend/cart";   
	}
	
	@RequestMapping(value = "/update-product-quantity", method = RequestMethod.POST)
	//Dữ liệu JSON trong yêu cầu HTTP sẽ được tự động chuyển thành đối tượng CartProduct
	public ResponseEntity<Map <String,Object> >UpdateQuantity( @RequestBody CartProduct cartProduct, 
			final Model model, final HttpServletRequest request){
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			int index = cart.findIdProduct(cartProduct.getId());
			CartProduct productInCart = cart.getCartProducts().get(index);
			
			if(cartProduct.getQuantity().intValue() == -1) {
				if (productInCart.getQuantity().intValue() > 1) {
					cart.getCartProducts().get(index).updateQuantity(cartProduct.getQuantity());	
				}
			}	
			else cart.getCartProducts().get(index).updateQuantity(cartProduct.getQuantity());
			
            
			Map<String, Object> jsonResult = new HashMap<String, Object>();
			
			jsonResult.put("newQuantity", cart.getCartProducts().get(index).getQuantity());
			jsonResult.put("totalCartPrice",toCurrency(cart.totalPrice() ) );//prices = (x * quantity)+(y * quantity)+...
			jsonResult.put("totalPrice",toCurrency( cart.getCartProducts().get(index).totalPrice()) );//1 price = get(a) * quantity
			jsonResult.put("totalCartProducts", cart.totalProduct());// total quantity product
			jsonResult.put("productId", cartProduct.getId());
			jsonResult.put("totalPriceNoSale",toCurrency(cart.totalPriceNoSale()) );
			jsonResult.put("sale",toCurrency(cart.totalSale() ) );
			
			return ResponseEntity.ok(jsonResult);
	}
	
	public String toCurrency(BigDecimal price) {
		//bigdecimal tostring sẽ bị có 2 số 0 ở sau phải đưa về long
		StringBuffer buff = new StringBuffer((price.longValue()+"").toString());
		int n = buff.length();
		while(n > 0) {
			n -= 3;
			if (n<=0) break;
			buff.insert(n, ".");
		}
		buff.append(" VND");
		return buff.toString();
	}
	
	@RequestMapping(value = "cart-view/delete/{giCungDuoc}", method = RequestMethod.GET)// dấu {} để lấy giá trị trong ngoặc url bên view là: edit/${category.id}
	public String categoryDete(final Model model,final HttpServletRequest request, 
			@PathVariable int giCungDuoc){   // path phải giống value
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		cart.getCartProducts().get(giCungDuoc).setQuantity(new BigInteger("0"));
		return "redirect:/cart-view";
	}

	@RequestMapping(value = "/cartct", method = RequestMethod.GET)
	public String cartViev() {
		return "frontend/inforCart";
	}
	
	@RequestMapping(value = "/place-order", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> contactUser(final HttpServletRequest request 
			, @RequestBody SaleOder saleOder){
		Map<String, Object> json = new HashMap<String, Object>();
		if(saleOder.getCtName().trim() == null) {
			json.put("message", "Null Name");
			return ResponseEntity.ok(json);
		}
		if (saleOder.getCtMobile().trim() == null){
			json.put("message", "Null Mobile");
			return ResponseEntity.ok(json);
		}
		if (saleOder.getCtAdress().trim() == null){
			json.put("message", "Null Adress");
			return ResponseEntity.ok(json);
		}
		else {
			HttpSession session = request.getSession();
			if(session.getAttribute("cart") == null) {
				json.put("message", "Null Products");
				return ResponseEntity.ok(json);
			}
			else {
				User user = new User();
				user.setId(4);
				saleOder.setUserSaleOder(user);
				Cart cart = (Cart) request.getSession().getAttribute("cart");
				for (CartProduct cartProduct : cart.getCartProducts()) {
					SaleOderProduct saleOderProduct = new SaleOderProduct();
					 Product dbProduct = productService.getById(cartProduct.getId());
					saleOderProduct.setName(dbProduct.getName());
					saleOderProduct.setQuantity(cartProduct.getQuantity().intValue());
					saleOderProduct.setSaleOder(saleOder);
					saleOderProduct.setProduct(dbProduct);
					saleOder.addSaleOderProducts(saleOderProduct);// save 1 list saleOderProduct in class saleOder
				}
				saleOder.setTotal(cart.totalPrice());
				Date date = new Date();
				Long time = date.getTime();
				saleOder.setCode(saleOder.getCtMobile() + time);
				saleOderService.saveSaleOder(saleOder);
				
				// xoa gio hang
				cart = new Cart();
				session.setAttribute("cart",cart);
				json.put("message", "Thank Kiu");
				return ResponseEntity.ok(json);
			}		
		}
	}
}

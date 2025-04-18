package vn.doan.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

import vn.doan.controller.frontend.CartController;

public class CartProduct {
	private int id;
	private String name;
	private BigInteger quantity;
	private BigDecimal price;
	private String avatar;
	private BigDecimal sale;
	
	
	
	public CartProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartProduct(int id, String name, BigInteger quantity, BigDecimal price, String avatar, BigDecimal sale) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.avatar = avatar;
		this.sale = sale;
	}

	public String saleCurrency(){
		CartController currency = new CartController();
		return "- " + currency.toCurrency(this.sale);
	}
	
// lưu ý Bigdecimal không thao tác trực tiếp với int , float,..
// muốn dùng với int ,.. phải methos(new bigdecimal(1,2,..)) nên multiply nhân với 1 số gọi new	

	//tinh tong? tien\
	public BigDecimal totalPrice() {
		BigDecimal a=this.price.multiply(new BigDecimal(this.quantity));//price * quantity
		BigDecimal b=this.sale.multiply(new BigDecimal(this.quantity)) ;//sale * quantity
		
		if (this.sale != null && this.sale.compareTo(BigDecimal.ZERO) > 0) return a.subtract(b);
		
		 else return a;
	}
	
	//tinh tong? tien chua sale
	public BigDecimal totalPriceProduct() {
		return this.price.multiply(new BigDecimal(this.quantity));
	}
		
	//tinh tong sale
	public BigDecimal totalSale() {
		
		if (this.sale != null && this.sale.compareTo(BigDecimal.ZERO) > 0) return  this.sale.multiply(new BigDecimal(this.quantity));
		    // Nếu không có salePrice hoặc salePrice <= 0, sale = 0
		
		 else return this.sale.multiply(new BigDecimal(this.quantity)) ;
	}
	
	//tang giam? sp
	public void updateQuantity(BigInteger quantity) {
		BigInteger tam = this.quantity;
		this.quantity = tam.add(quantity);
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public BigInteger getQuantity() {
		return quantity;
	}


	public void setQuantity(BigInteger quantity) {
		this.quantity = quantity;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public String getAvatar() {
		return avatar;
	}


	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public BigDecimal getSale() {
		return sale;
	}

	public void setSale(BigDecimal sale) {
		this.sale = sale;
	}
	
}

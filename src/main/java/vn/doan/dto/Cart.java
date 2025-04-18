package vn.doan.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class Cart {
	// bên controller nó sẽ vứt vào cartProduct những thông số cần thiết từ avata,sale
	
	private ArrayList<CartProduct> cartProducts = new ArrayList<CartProduct>();
	
	//tim trong gio hang
	public int findIdProduct(int id) {
		for (int i=0 ;i < this.cartProducts.size() ;i++) {
			if(cartProducts.get(i).getId() == id) return i;
		}
		return -1;
	}
		
	//tinh/ tong? tien\
	public BigDecimal totalPrice() {
		BigDecimal price = BigDecimal.ZERO;// price = 0
		for (CartProduct c : this.cartProducts) {
			price = price.add(c.totalPrice());
		}
		return price;
	}	
	
	//tinh/ tong? tien\ chua sale
	public BigDecimal  totalPriceNoSale() {
		BigDecimal price = BigDecimal.ZERO;// price = 0
		for (CartProduct c : this.cartProducts) {
			price = price.add(c.totalPriceProduct());
		}
		return price;
	}

	//tinh/ tong? sale
		public BigDecimal totalSale() {
			BigDecimal sale = BigDecimal.ZERO;// sale = 0
			for (CartProduct c : this.cartProducts) {
				sale = sale.add(c.totalSale());
			}
			return sale;
		}	
	
		
	//tinh' tong? so' luong.
	public BigInteger totalProduct() {
		BigInteger total = BigInteger.ZERO;
		for (CartProduct c : this.cartProducts) {
			total = total.add(c.getQuantity());
		}
		return total;
	}
	
		public Cart(ArrayList<CartProduct> cartProducts) {
		super();
		this.cartProducts = cartProducts;
	}

		public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	public ArrayList<CartProduct> getCartProducts() {
		return cartProducts;
	}

	public void setCartProducts(ArrayList<CartProduct> cartProducts) {
		this.cartProducts = cartProducts;
	}
	
}

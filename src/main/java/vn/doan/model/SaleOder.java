package vn.doan.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="tbl_sale_oder")
public class SaleOder extends BaseModel {
	
	public SaleOder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SaleOder(Integer id, Date createDate, Date updateDate, Boolean status, BigDecimal total, String code,
			String ctName, String ctAdress, String ctEmail, String ctMobile, User userSaleOder,
			List<SaleOderProduct> saleOderProducts) {
		super(id, createDate, updateDate, status);
		this.total = total;
		this.code = code;
		this.ctName = ctName;
		this.ctAdress = ctAdress;
		this.ctEmail = ctEmail;
		this.ctMobile = ctMobile;
		this.userSaleOder = userSaleOder;
		this.saleOderProducts = saleOderProducts;
	}

	
	@Column(name="total", nullable= true)
	private BigDecimal total;
	
	@Column(name="code", length = 45, nullable= true)
	private String code;
	
	@Column(name = "ct_name",length=45,nullable=true)
	private String ctName;
	
	@Column(name = "ct_adress",length=45,nullable=true)
	private String ctAdress;
	
	@Column(name = "ct_email",length=45,nullable=true)
	private String ctEmail;
	
	@Column(name = "ct_mobile",length=45,nullable=true)
	private String ctMobile;
	
	//to user
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User userSaleOder;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "saleOder")
	private List<SaleOderProduct> saleOderProducts = new ArrayList<SaleOderProduct>();

	
	public void addSaleOderProducts(SaleOderProduct s) {
		saleOderProducts.add(s);
		s.setSaleOder(this);
	}
	
	public void deteSaleOderProducts(SaleOderProduct s) {
		saleOderProducts.remove(s);
		s.setSaleOder(this);
	}
	
	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCtName() {
		return ctName;
	}

	public void setCtName(String ctName) {
		this.ctName = ctName;
	}

	public String getCtAdress() {
		return ctAdress;
	}

	public void setCtAdress(String ctAdress) {
		this.ctAdress = ctAdress;
	}

	public String getCtEmail() {
		return ctEmail;
	}

	public void setCtEmail(String ctEmail) {
		this.ctEmail = ctEmail;
	}

	public String getCtMobile() {
		return ctMobile;
	}

	public void setCtMobile(String ctMobile) {
		this.ctMobile = ctMobile;
	}

	public User getUserSaleOder() {
		return userSaleOder;
	}

	public void setUserSaleOder(User userSaleOder) {
		this.userSaleOder = userSaleOder;
	}

	public List<SaleOderProduct> getSaleOderProducts() {
		return saleOderProducts;
	}

	public void setSaleOderProducts(List<SaleOderProduct> saleOderProducts) {
		this.saleOderProducts = saleOderProducts;
	}
	
}

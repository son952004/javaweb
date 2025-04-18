package vn.doan.model;

import java.math.BigInteger;
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
@Table(name="tbl_sale_oder_product")
public class SaleOderProduct extends BaseModel {
	
	public SaleOderProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SaleOderProduct(Integer id, Date createDate, Date updateDate, Boolean status, String name, Integer quantity,
			String description, Product product, SaleOder saleOder) {
		super(id, createDate, updateDate, status);
		this.name = name;
		this.quantity = quantity;
		this.description = description;
		//this.createSaleOder = createSaleOder;
		//this.updateSaleOder = updateSaleOder;
		this.product = product;
		this.saleOder = saleOder;
	}

	@Column(name="product_name", length = 45, nullable= true)
	private String name;
	
	@Column(name="quantity", nullable= true)
	private Integer quantity;
	
	@Column(name="description", length = 45, nullable= true)
	private String description;
		
//	//one to many saleOderProduct to saleOder
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "saleOderProductCreate")
//	private List<SaleOder> createSaleOder = new ArrayList<SaleOder>();
//	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "saleOderProductUpdate")
//	private List<SaleOder> updateSaleOder = new ArrayList<SaleOder>();
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="product_id")// lưu cột product_id in table class saleOderProduct 
	private Product product;//not save product
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="sale_oder_id")
	private SaleOder saleOder;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public List<SaleOder> getCreateSaleOder() {
//		return createSaleOder;
//	}
//
//	public void setCreateSaleOder(List<SaleOder> createSaleOder) {
//		this.createSaleOder = createSaleOder;
//	}
//
//	public List<SaleOder> getUpdateSaleOder() {
//		return updateSaleOder;
//	}
//
//	public void setUpdateSaleOder(List<SaleOder> updateSaleOder) {
//		this.updateSaleOder = updateSaleOder;
//	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public SaleOder getSaleOder() {
		return saleOder;
	}

	public void setSaleOder(SaleOder saleOder) {
		this.saleOder = saleOder;
	}
	
	
}	

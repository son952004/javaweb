package vn.doan.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import vn.doan.model.BaseModel;
import vn.doan.model.Category;
import vn.doan.model.ProductImage;
import vn.doan.model.User;

@Entity
@Table(name = "tbl_product")
public class Product extends BaseModel{
	
	public Product(Integer id, Date createDate, Date updateDate, Boolean status, String avatar, String name,
			BigDecimal price, BigDecimal salePrice, String detailDescription, String shortDescription, Boolean isHot,
			String seo, User userCreateProduct, User userUpdateProduct, Category category) {
		super(id, createDate, updateDate, status);
		this.avatar = avatar;
		this.name = name;
		this.price = price;
		this.salePrice = salePrice;
		this.detailDescription = detailDescription;
		this.shortDescription = shortDescription;
		this.isHot = isHot;
		this.seo = seo;
		this.userCreateProduct = userCreateProduct;
		this.userUpdateProduct = userUpdateProduct;
		this.category = category;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(Integer id, Date createDate, Date updateDate, Boolean status) {
		super(id, createDate, updateDate, status);
		// TODO Auto-generated constructor stub
	}
	
	@Column(name="avatar", length = 45, nullable= true)
	private String avatar;
	
	@Column(name="name", length = 45, nullable= true)
	private String name;
	
	@Column(name="price", nullable= true)
	private BigDecimal price;
	
	@Column(name="sale_price", nullable= true)
	private BigDecimal salePrice;
	
	@Column(name="detail_description", length = 45, nullable= true)
	private String detailDescription;
	
	@Column(name = "short_description",length=45,nullable=true)
	private String shortDescription;
	
	@Column(name="is_hot", nullable= true)
	private Boolean isHot = Boolean.FALSE;
	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "category")
//	private List<Product> products = new ArrayList<Product>();
//	public void addProduct(Product p) {
//		products.add(p);
//		p.setCategory(this);
//	}
//	
//	public void deteProduct(Product p) {
//		products.remove(p);
//		p.setCategory(null);
//	}
	
	//---------Mapping one-to-many: tbl_product-to-tbl_ProductImage  luu file-----------	
		@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
		private Set<ProductImage> productImages = new HashSet<ProductImage>();

		// Methods add and remove elements in relational product list
		public void addRelationalProductImage(ProductImage productImage) {
			productImages.add(productImage);
			productImage.setProduct(this); // 1 la add hoac sua? 1 img
		}

		public void removeRelationalProductImage(ProductImage productImage) {
			productImages.remove(productImage);
			productImage.setProduct(this); // xoa = null hoac  xoa het
		}
		
	
	public Set<ProductImage> getProductImages() {
		return productImages;
		}
	public void setProductImages(Set<ProductImage> productImages) {
		this.productImages =  productImages;
		}
	public String getavatar() {
		return avatar;
	}

	public void setavatar(String avatar) {
		this.avatar = avatar;
	}

	public User getUserCreateProduct() {
		return userCreateProduct;
	}

	public void setUserCreateProduct(User userCreateProduct) {
		this.userCreateProduct = userCreateProduct;
	}

	public User getUserUpdateProduct() {
		return userUpdateProduct;
	}

	public void setUserUpdateProduct(User userUpdateProduct) {
		this.userUpdateProduct = userUpdateProduct;
	}

	@Column(name="seo", length = 45, nullable= true)
	private String seo;
			
	//many to one category to user create_by 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="create_by",referencedColumnName = "id")
	private User userCreateProduct;
	
	//many to one category to user update_by 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="update_by",referencedColumnName = "id")
	private User userUpdateProduct;
	
	//many to one
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="category_id",referencedColumnName = "id")
	private Category category;//map voi tbl category
	
	//product to saleOderProduct
	//1 list những đơn hàng tham chiếu đến product này
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
	private Set<SaleOderProduct> saleOderProducts = new HashSet<SaleOderProduct>();
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}
	public String getDetailDescription() {
		return detailDescription;
	}
	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public Boolean getIsHot() {
		return isHot;
	}
	public void setIsHot(Boolean isHot) {
		this.isHot = isHot;
	}
	public String getSeo() {
		return seo;
	}
	public void setSeo(String seo) {
		this.seo = seo;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
}
	


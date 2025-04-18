package vn.doan.model;

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
@Table(name="tbl_category")
public class Category extends BaseModel{
	@Column(name="name", length = 45, nullable= true)
	private String name;
	
	@Column(name="description", length = 45, nullable= true)
	private String description;
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(Integer id, Date createDate, Date updateDate, Boolean status) {
		super(id, createDate, updateDate, status);
		// TODO Auto-generated constructor stub
	}

	public Category(Integer id, Date createDate, Date updateDate, Boolean status, String name, String description,
					User userCreateCategory, User userUpdateCategory, List<Product> products) {
		super(id, createDate, updateDate, status);
		this.name = name;
		this.description = description;
		this.userCreateCategory = userCreateCategory;
		this.userUpdateCategory = userUpdateCategory;
		this.products = products;
	}

		//many to one category to user create_by 
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name="create_by")
		private User userCreateCategory;
		
	//many to one category to user update_by 
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name="update_by")
		private User userUpdateCategory;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "category")
	private List<Product> products = new ArrayList<Product>();
	
	
	public void addProduct(Product p) {
		products.add(p);
		p.setCategory(this);
	}
	
	public void deteProduct(Product p) {
		products.remove(p);
		p.setCategory(null);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUserCreateCategory() {
		return userCreateCategory;
	}

	public void setUserCreateCategory(User userCreateCategory) {
		this.userCreateCategory = userCreateCategory;
	}

	public User getUserUpdateCategory() {
		return userUpdateCategory;
	}

	public void setUserUpdateCategory(User userUpdateCategory) {
		this.userUpdateCategory = userUpdateCategory;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}

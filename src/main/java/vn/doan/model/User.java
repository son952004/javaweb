package vn.doan.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



@Entity
@Table(name="tbl_user")
public class User extends BaseModel implements UserDetails{
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, Date createDate, Date updateDate, Boolean status, String username, String mobile,
			String password, String name, String email, String address, String avatar, String description,
			List<Category> createCategories, List<Category> updateCategories, List<Product> createProducts,
			List<Product> updateProducts, List<Role> roles, List<SaleOder> saleOder) {
		super(id, createDate, updateDate, status);
		this.username = username;
		this.mobile = mobile;
		this.password = password;
		this.name = name;
		this.email = email;
		this.address = address;
		this.avatar = avatar;
		this.description = description;
		this.createCategories = createCategories;
		this.updateCategories = updateCategories;
		this.createProducts = createProducts;
		this.updateProducts = updateProducts;
		this.roles = roles;
		this.saleOder = saleOder;
	}


	public User(Integer id, Date createDate, Date updateDate, Boolean status) {
		super(id, createDate, updateDate, status);
		// TODO Auto-generated constructor stub
	}

	@Column(name="username", length = 222, nullable= true)
	private String username;
	
	@Column(name="mobile", length = 222, nullable= true)
	private String mobile;
	
	@Column(name="password", length = 222, nullable= true)
	private String password;

	@Column(name="name", length = 45, nullable= true)
	private String name;
	
	@Column(name="email", length = 45, nullable= true)
	private String email;
	
	@Column(name="address", length = 45, nullable= true)
	private String address;
	
	@Column(name="avatar", length = 45, nullable= true)
	private String avatar;
	
	@Column(name="description", length = 45, nullable= true)
	private String description;
	
	//one to many user Create Category
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userCreateCategory")
	private List<Category> createCategories = new ArrayList<Category>();
	
	//one to many user update Category
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userUpdateCategory")
	private List<Category> updateCategories = new ArrayList<Category>();
	
	
	// one to many user create Product
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userCreateProduct")
	private List<Product> createProducts = new ArrayList<Product>();
	
	
	//one to many user update Product
		@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userUpdateProduct")
		private List<Product> updateProducts = new ArrayList<Product>();
	
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "users")
	private List<Role> roles = new ArrayList<Role>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userSaleOder")
	private List<SaleOder> saleOder = new ArrayList<SaleOder>();
	
	public void addUserRole(Role role) {
		role.getUsers().add(this);
		roles.remove(role);
	}
	
	public void removeUserRole(Role role) {
		role.getUsers().remove(this);
		roles.remove(role);
	}
		

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public List<SaleOder> getSaleOder() {
		return saleOder;
	}

	public void setSaleOder(List<SaleOder> saleOder) {
		this.saleOder = saleOder;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Category> getCreateCategories() {
		return createCategories;
	}

	public void setCreateCategories(List<Category> createCategories) {
		this.createCategories = createCategories;
	}

	public List<Category> getUpdateCategories() {
		return updateCategories;
	}

	public void setUpdateCategories(List<Category> updateCategories) {
		this.updateCategories = updateCategories;
	}
	


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public List<Product> getCreateProducts() {
		return createProducts;
	}

	public void setCreateProducts(List<Product> createProducts) {
		this.createProducts = createProducts;
	}

	public List<Product> getUpdateProducts() {
		return updateProducts;
	}

	public void setUpdateProducts(List<Product> updateProducts) {
		this.updateProducts = updateProducts;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.roles;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
}

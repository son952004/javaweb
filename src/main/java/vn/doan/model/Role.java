package vn.doan.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.FetchType;

@Entity
@Table(name="tbl_role")
public class Role  extends BaseModel implements GrantedAuthority{
	
	public Role(Integer id, Date createDate, Date updateDate, Boolean status, String name, String description,
			List<User> user) {
		super(id, createDate, updateDate, status);
		this.name = name;
		this.description = description;
		this.users = user;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	@Column(name="name", length = 45, nullable= true)
	private String name;
	
	@Column(name="description", length = 45, nullable= true)
	private String description;
	
	//many to many tbl_role to tbl_user
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="tbl_user_role", joinColumns = @JoinColumn(name="role_id"),inverseJoinColumns = @JoinColumn(name="user_id"))
	private List<User> users = new ArrayList<User>() ;

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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.name;
	}


	
	
}

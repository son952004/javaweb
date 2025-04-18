package vn.doan.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tbl_contact")
public class Contact extends BaseModel{
	private String name;
	private String email;
	private String mobile;
	private String address;
	private String message;
	
	
	public Contact() {
		super();
	}
	
	
	public Contact(String name, String email, String mobile, String address, String message) {
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.message = message;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMessage() {
		return  message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}

package com.neelkamal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="user")
public class User {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message="name should not be empty")
	@Size(min=2, max =50, message="name should be have min 2 character and max 50 characater ")
	private String  name;
	
	@NotEmpty(message="address should not be empty")
	@Size(min=5, max =50, message="address should be have min 5 character and max 50 characater ")
	private String address;
	
	
	@Size(min=5, max =50, message="email should be have min 5 character and max 50 characater ")
	@Email(message="email should be a valid email")
	@Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address")
	private String email;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + "]";
	}
	
	
	
}

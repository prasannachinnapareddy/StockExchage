package com.cts.training.userservice;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

//import org.springframework.stereotype.Component;

@Entity
@Table(name = "registers")
@XmlRootElement(name="item")
public class Register implements Serializable
{
	
	private static final long serialVersionUID = 1967529524143269471L;
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String username;
	private String email;
	private String password;
	private String repeatpassword;
	private boolean active=false;
	private String userType="ROLE_USER";
	
	@Transient
	private String regstatus;
	public Register() {
		super();
	}
	
	
	public Register(int id, String name, String username, String email, String password, String repeatpassword,
			boolean active, String userType, String regstatus) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.repeatpassword = repeatpassword;
		this.active = active;
		this.userType = userType;
		this.regstatus = regstatus;
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


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRepeatpassword() {
		return repeatpassword;
	}


	public void setRepeatpassword(String repeatpassword) {
		this.repeatpassword = repeatpassword;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}


	public String getRegstatus() {
		return regstatus;
	}


	public void setRegstatus(String regstatus) {
		this.regstatus = regstatus;
	}


	@Override
	public String toString() {
		return "Register [id=" + id + ", name=" + name + ", username=" + username + ", email=" + email + ", password="
				+ password + ", repeatpassword=" + repeatpassword + ", active=" + active + ", userType=" + userType
				+ ", regstatus=" + regstatus + "]";
	}	
	
}
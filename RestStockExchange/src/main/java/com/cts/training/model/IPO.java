package com.cts.training.model;

import java.io.Serializable;
//import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

//import org.springframework.stereotype.Component;

@Entity
@Table(name = "ipo")
@XmlRootElement(name="item")
public class IPO implements Serializable 
{
	private static final long serialVersionUID = 3719275936154288270L;
	@Id
	@GeneratedValue
	private int id;
	private String cname;
	private long price;
	private String remarks;
	private String se;
	private long tshares;
	public IPO() { 
		
	}
	public IPO(int id, String cname, long price, String remarks, String se, long tshares) {
		super();
		this.id = id;
		this.cname = cname;
		this.price = price;
		this.remarks = remarks;
		this.se = se;
		this.tshares = tshares;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getSe() {
		return se;
	}
	public void setSe(String se) {
		this.se = se;
	}
	public long getTshares() {
		return tshares;
	}
	public void setTshares(long tshares) {
		this.tshares = tshares;
	}
	@Override
	public String toString() {
		return "IPO [id=" + id + ", cname=" + cname + ", price=" + price + ", remarks=" + remarks + ", se=" + se
				+ ", tshares=" + tshares + "]";
	}
}
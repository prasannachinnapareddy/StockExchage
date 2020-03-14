package com.cts.training.stockexchangeservice;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@Table(name = "stock")
@XmlRootElement(name="item")
public class StockExchange implements Serializable
{
	private static final long serialVersionUID = -8737683254790537250L;
	@Id
	@GeneratedValue
	private int id;
	private String[] se;
	private String breif;
	private String address;
	private String remarks;
	public StockExchange() {
		super();
	}
	public StockExchange(int id, String[] se, String breif, String address,String remarks) {
		super();
		this.id = id;
		this.se = se;
		this.breif = breif;
		this.address = address;
		this.remarks = remarks;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String[] getSe() {
		return se;
	}
	public void setSe(String[] se) {
		this.se = se;
	}
	public String getBreif() {
		return breif;
	}
	public void setBreif(String breif) {
		this.breif = breif;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "StockExchange [id=" + id + ", se=" + Arrays.toString(se) + ", breif=" + breif + ", address=" + address
				+ ", remarks=" + remarks + "]";
	}
}

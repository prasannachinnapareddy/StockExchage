
package com.cts.training.ipo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "ipo")
@XmlRootElement(name="item")
public class InitialPublicOffering  implements Serializable 
{
	private static final long serialVersionUID = 3719275936154288270L;
	@Id
	@GeneratedValue
	private int id;
	private String companyname;
	private String[] lse;
	private double pps;
	private int tnos;
	private Date odate;
	private String remarks;
	public InitialPublicOffering () { 
		
	}
	public InitialPublicOffering (int id, String companyname, String[] lse, double pps, int tnos, Date odate, String remarks) {
		super();
		this.id = id;
		this.companyname = companyname;
		this.lse = lse;
		this.pps = pps;
		this.tnos = tnos;
		this.odate = odate;
		this.remarks = remarks;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String[] getLse() {
		return lse;
	}
	public void setLse(String[] lse) {
		this.lse = lse;
	}
	public double getPps() {
		return pps;
	}
	public void setPps(double pps) {
		this.pps = pps;
	}
	public int getTnos() {
		return tnos;
	}
	public void setTnos(int tnos) {
		this.tnos = tnos;
	}
	public Date getOdate() {
		return odate;
	}
	public void setOdate(Date odate) {
		this.odate = odate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "IPO [id=" + id + ", companyname=" + companyname + ", lse=" + Arrays.toString(lse) + ", pps=" + pps
				+ ", tnos=" + tnos + ", odate=" + odate + ", remarks=" + remarks + "]";
	}
	
}
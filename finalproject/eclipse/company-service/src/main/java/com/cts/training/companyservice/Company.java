package com.cts.training.companyservice;

import java.io.Serializable;
//import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

//import org.springframework.stereotype.Component;

@Entity
@Table(name="cmp")
@XmlRootElement(name="item")
public class Company implements Serializable{
	
	
	private static final long serialVersionUID = -5022938299008248454L;
	@Id
	@GeneratedValue
	private int id;
	private String cname;
	private String ceo;
	private String bms;
	private double tover;
	private String se;
	private String bdec;
	private String cmpcode;
	
	
	public String getCmpcode() {
		return cmpcode;
	}



	public void setCmpcode(String cmpcode) {
		this.cmpcode = cmpcode;
	}



	public Company() {
		
		
	}

	

	public Company(int id, String cname, String ceo, String bms, double tover, String se, String bdec, String cmpcode) {
		super();
		this.id = id;
		this.cname = cname;
		this.ceo = ceo;
		this.bms = bms;
		this.tover = tover;
		this.se = se;
		this.bdec = bdec;
		this.cmpcode = cmpcode;
	}



	public void setBdec(String bdec) {
		this.bdec = bdec;
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
	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public String getBms() {
		return bms;
	}

	public void setBms(String bms) {
		this.bms = bms;
	}

	public double getTover() {
		return tover;
	}

	public void setTover(double tover) {
		this.tover = tover;
	}

	public String getSe() {
		return se;
	}

	public void setSe(String se) {
		this.se = se;
	}

	public String getBdec() {
		return bdec;
	}

	public void setBdesc(String bdec) {
		this.bdec = bdec;
	}

	

	@Override
	public String toString() {
		return "Company [id=" + id + ", cname=" + cname + ", ceo=" + ceo + ", bms=" + bms + ", tover=" + tover + ", se="
				+ se + ", bdec=" + bdec + "]";
	}

	}
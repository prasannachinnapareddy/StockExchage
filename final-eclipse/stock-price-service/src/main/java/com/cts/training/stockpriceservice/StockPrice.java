package com.cts.training.stockpriceservice;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@Table(name="stockPrice")
@XmlRootElement(name="item")
public class StockPrice implements Serializable
{
	
	private static final long serialVersionUID = -5090042820824192594L;
	@Id
	@GeneratedValue
	private int id;
	private String companyCode;
	private String stockExchangeName;
	private double currentPrice;
	private LocalDate date;
	private LocalTime time;
	public StockPrice() {
		super();
	}
	public StockPrice(int id,String companyCode, String stockExchangeName, double currentPrice, LocalDate date, LocalTime time) {
		super();
		this.id=id;
		this.companyCode = companyCode;
		this.stockExchangeName = stockExchangeName;
		this.currentPrice = currentPrice;
		this.date = date;
		this.time = time;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getStockExchangeName() {
		return stockExchangeName;
	}
	public void setStockExchangeName(String stockExchangeName) {
		this.stockExchangeName = stockExchangeName;
	}
	
	public double getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "StockPrice [companyCode=" + companyCode + ", stockExchangeName=" + stockExchangeName + ", currentPrice="
				+ currentPrice + ", date=" + date + ", time=" + time + "]";
	}
}

package com.cts.training.stockpriceservice;

import java.time.LocalDate;

public class Charts
{
	private String companyCode;
	private String stockExchangeName;
	private String dataPoint;
	private double dataValue;
	public Charts() {
		super();
	}
	public Charts(String companyCode, String stockExchangeName, String dataPoint, double dataValue) {
		super();
		this.companyCode = companyCode;
		this.stockExchangeName = stockExchangeName;
		this.dataPoint = dataPoint;
		this.dataValue = dataValue;
	}
	public Charts(String companyCode, String stockExchangeName, LocalDate dataPoint, double dataValue) {
		super();
		this.companyCode = companyCode;
		this.stockExchangeName = stockExchangeName;
		this.dataPoint = dataPoint.toString();
		this.dataValue = dataValue;
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
	public String getDataPoint() {
		return dataPoint;
	}
	public void setDataPoint(String dataPoint) {
		this.dataPoint = dataPoint;
	}
	public double getDataValue() {
		return dataValue;
	}
	public void setDataValue(double dataValue) {
		this.dataValue = dataValue;
	}
	
}

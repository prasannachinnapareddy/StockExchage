package com.cts.training.stockpriceservice;

import java.util.List;

public interface StockPriceService 
{
	public StockPrice insert(StockPrice stockPrice);
	
	public void delete(int id);
	
	public StockPrice updateStockPrice(StockPrice stockPrice);
	
	public List<StockPrice> getAllStockPrices();
	
	public StockPrice getStockPriceById(int id);
}

package com.cts.training.stockexchangeservice;

import java.util.List;


public interface StockExchangeService 
{
	public StockExchange insert(StockExchange stockExchange);
	
	public void delete(int id);
	
	public StockExchange updateStockExchange(StockExchange stockExchange);
	
	public List<StockExchange> getAllStockExchanges();
	
	public StockExchange getStockExchangeById(int id);
}

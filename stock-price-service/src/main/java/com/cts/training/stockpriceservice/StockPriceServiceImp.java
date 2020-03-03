package com.cts.training.stockpriceservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class StockPriceServiceImp implements StockPriceService
{
	@Autowired
	StockPriceDAO stockPriceDAO;
	@Autowired
	StockPriceService stockPriceService;

	@Override
	public StockPrice insert(StockPrice stockPrice) 
	{
		stockPriceDAO.save(stockPrice);
		return stockPrice;
	}

	@Override
	public void delete(int id) 
	{
		stockPriceDAO.deleteById(id);
	}

	@Override
	public StockPrice updateStockPrice(StockPrice stockPrice)
	{
		stockPriceDAO.save(stockPrice);
		return stockPrice;
	}

	@Override
	public List<StockPrice> getAllStockPrices() 
	{
		return stockPriceDAO.findAll();
	}

	@Override
	public StockPrice getStockPriceById(int id) {
		Optional<StockPrice> stockPrice=stockPriceDAO.findById(id);
		return stockPrice.orElse(null);
	}

}

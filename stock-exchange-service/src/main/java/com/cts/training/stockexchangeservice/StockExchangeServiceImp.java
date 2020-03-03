package com.cts.training.stockexchangeservice;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class StockExchangeServiceImp implements StockExchangeService
{
	@Autowired
	StockExchangeDAO stockExchangeDAO;
	
	@Autowired
	StockExchangeService stockExchangeService;

	@Override
	public StockExchange insert(StockExchange stockExchange) {
		stockExchangeDAO.save(stockExchange);
		return stockExchange;
	}

	@Override
	public void delete(int id)
	{
		 stockExchangeDAO.deleteById(id);
	}

	@Override
	public StockExchange updateStockExchange(StockExchange stockExchange) {
		stockExchangeDAO.save(stockExchange);
		return stockExchange;
	}

	@Override
	public List<StockExchange> getAllStockExchanges() {
		return stockExchangeDAO.findAll();
	}

	@Override
	public StockExchange getStockExchangeById(int id) {
		Optional<StockExchange> stockExchange =stockExchangeDAO.findById(id);
		return stockExchange.orElse(null);
	}
	
	
}

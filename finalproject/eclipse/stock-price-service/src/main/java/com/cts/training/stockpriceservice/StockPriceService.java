package com.cts.training.stockpriceservice;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface StockPriceService 
{
	public StockPrice insert(StockPrice stockPrice);
	
	public void delete(int id);
	
	public StockPrice updateStockPrice(StockPrice stockPrice);
	
	public List<StockPrice> getAllStockPrices();
	
	public StockPrice getStockPriceById(int id);

	public ImportSummary addStockPriceformExcelSheet(MultipartFile file) throws IOException,Exception;

	public List<Charts> getCompanyStockPriceBetween(String companyCode, String stockExchangeName, LocalDate startDate,
			LocalDate endDate);
}

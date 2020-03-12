package com.cts.training.stockpriceservice;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface StockPriceDAO extends JpaRepository<StockPrice,Integer>
{
	@Query("From StockPrice where companyCode = ?1 and stockExchangeName =?2 and date =?3 and time =?4")
	public Optional<StockPrice> getIfAlreadyExists(String companyCode, String stockExchangeName, LocalDate date,
			LocalTime time);
	
	@Query("SELECT new com.cts.training.stockpriceservice.Charts(companyCode,stockExchange,date,AVG(currentPrice))"
			+"FROM StockPrice"
			+"WHERE companyCode=?1 AND stockExchnage=?2 AND date BETWEEN ?3 AND ?4"
			+"GROUP BY date")
	public List<Charts> getStockPriceBetweenDates(String companyCode,String stockExchange,LocalDate startDate,LocalDate endDate);
	
}

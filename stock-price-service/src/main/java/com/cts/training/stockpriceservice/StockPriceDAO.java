package com.cts.training.stockpriceservice;

import org.springframework.data.jpa.repository.JpaRepository;


public interface StockPriceDAO extends JpaRepository<StockPrice,Integer> {

}

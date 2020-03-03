package com.cts.training.stockexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;


public interface StockExchangeDAO extends JpaRepository<StockExchange,Integer> {

}

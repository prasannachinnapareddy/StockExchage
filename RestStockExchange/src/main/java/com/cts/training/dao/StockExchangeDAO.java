package com.cts.training.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.training.model.StockExchange;

public interface StockExchangeDAO extends JpaRepository<StockExchange,Integer> {

}

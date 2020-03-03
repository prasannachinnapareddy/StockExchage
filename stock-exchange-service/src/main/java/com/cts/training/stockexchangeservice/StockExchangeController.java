package com.cts.training.stockexchangeservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*")
@RestController
public class StockExchangeController 
{
	@Autowired
	StockExchangeDAO stockExchangeDAO;
	
	@Autowired
	StockExchangeService stockExchangeService;
	
    @GetMapping(value="/allStockExchanges")
	public ResponseEntity<?>getallStockExchanges()
	  {
			List<StockExchange> list = stockExchangeService.getAllStockExchanges();
			if(list.size()>0)
			{
				return new ResponseEntity<List<StockExchange>>(list , HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<String>("No Companies found",HttpStatus.NOT_FOUND);
			}
		}
	
    @GetMapping("/stockExchangeById/{id}")
	public ResponseEntity<StockExchange> getById(@PathVariable int id){
    	StockExchange stockExchange = stockExchangeService.getStockExchangeById(id);
		return new ResponseEntity<StockExchange>(stockExchange,HttpStatus.OK);
	}
  
  @DeleteMapping("/deletestockExchange/{id}")
	public void delete(@PathVariable int id) {
	  stockExchangeService.delete(id);
	}

  @PutMapping("/updatestockExchange")
	public ResponseEntity<StockExchange> update(@RequestBody StockExchange stockExchanges){
	    stockExchangeService.updateStockExchange(stockExchanges);
		return new ResponseEntity<StockExchange>(stockExchanges,HttpStatus.OK);
	}

  @RequestMapping(value = "/allStockExchanges",method = RequestMethod.POST)
	public ResponseEntity<StockExchange> save(@RequestBody StockExchange stockExchange){
	    stockExchangeService.insert(stockExchange);
		return new ResponseEntity<StockExchange>(stockExchange,HttpStatus.CREATED);
	}
  }

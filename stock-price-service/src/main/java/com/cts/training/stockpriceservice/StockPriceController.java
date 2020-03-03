package com.cts.training.stockpriceservice;

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
public class StockPriceController 
{
	@Autowired
	StockPriceDAO stockPriceDAO;
	
	@Autowired
	StockPriceService stockPriceService;
	
    @GetMapping(value="/allStockPrices")
	public ResponseEntity<?>getallStockPrices()
	  {
			List<StockPrice> list = stockPriceService.getAllStockPrices();
			if(list.size()>0)
			{
				return new ResponseEntity<List<StockPrice>>(list , HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<String>("No Companies found",HttpStatus.NOT_FOUND);
			}
		}
	
    @GetMapping("/stockPriceById/{id}")
	public ResponseEntity<StockPrice> getById(@PathVariable int id){
    	StockPrice stockPrice = stockPriceService.getStockPriceById(id);
		return new ResponseEntity<StockPrice>(stockPrice,HttpStatus.OK);
	}
  
  @DeleteMapping("/deletestockPrice/{id}")
	public void delete(@PathVariable int id) {
	  stockPriceService.delete(id);
	}

  @PutMapping("/updatestockPrice")
	public ResponseEntity<StockPrice> update(@RequestBody StockPrice stockPrices){
	    stockPriceService.updateStockPrice(stockPrices);
		return new ResponseEntity<StockPrice>(stockPrices,HttpStatus.OK);
	}

  @RequestMapping(value = "/allStockPrices",method = RequestMethod.POST)
	public ResponseEntity<StockPrice> save(@RequestBody StockPrice stockPrice){
	    stockPriceService.insert(stockPrice);
		return new ResponseEntity<StockPrice>(stockPrice,HttpStatus.CREATED);
	}
}

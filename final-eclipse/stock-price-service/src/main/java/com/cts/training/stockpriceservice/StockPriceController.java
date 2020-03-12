package com.cts.training.stockpriceservice;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*")
@RestController
public class StockPriceController {
	@Autowired
	StockPriceDAO stockPriceDAO;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StockPriceService stockPriceService;

	@GetMapping(value = "/allStockPrices")
	public ResponseEntity<?> getallStockPrices() {
		List<StockPrice> list = stockPriceService.getAllStockPrices();
		if (list.size() > 0) {
			return new ResponseEntity<List<StockPrice>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("No stockpriceses found", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/allStockPrices/{id}")
	public ResponseEntity<StockPrice> getById(@PathVariable int id) {
		StockPrice stockPrice = stockPriceService.getStockPriceById(id);
		return new ResponseEntity<StockPrice>(stockPrice, HttpStatus.OK);
	}

	@DeleteMapping("/allStockPrices/{id}")
	public void delete(@PathVariable int id) {
		stockPriceService.delete(id);
	}

	@PutMapping("/allStockPrices")
	public ResponseEntity<StockPrice> update(@RequestBody StockPrice stockPrices) {
		stockPriceService.updateStockPrice(stockPrices);
		return new ResponseEntity<StockPrice>(stockPrices, HttpStatus.OK);
	}

	@RequestMapping(value = "/allStockPrices", method = RequestMethod.POST)
	public ResponseEntity<StockPrice> save(@RequestBody StockPrice stockPrice) {
		stockPriceService.insert(stockPrice);
		return new ResponseEntity<StockPrice>(stockPrice, HttpStatus.CREATED);
	}

	@PostMapping(value = "allStockPrices/uploadStockSheet", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> uploadStockSheet(@RequestParam("stockSheet") MultipartFile file) {
		logger.info("File Received : {} ", file.getOriginalFilename());
		if (file.getOriginalFilename().endsWith(".xls") || file.getOriginalFilename().endsWith(".xlsx")) {
			try {
				return new ResponseEntity<ImportSummary>(stockPriceService.addStockPriceformExcelSheet(file),
						HttpStatus.OK);
			} catch (IOException e) {
				e.printStackTrace();
				return new ResponseEntity<String>("Error Reading File :", HttpStatus.BAD_REQUEST);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}

		}
		return null;

	}

	@GetMapping(value = "/stockPrices/companyStockPriceBetween/{companyCode}/{stockExchange}/{startDate}/{endDate}/{periodicity}", produces = "application/json")
	public ResponseEntity<?> getCompanyStockPricePerDayBetween(@PathVariable String companyCode,
			@PathVariable String stockExchange, @PathVariable String startDate, @PathVariable String endDate) {
		return new ResponseEntity<List<Charts>>(stockPriceService.getCompanyStockPriceBetween(companyCode,
				stockExchange, LocalDate.parse(startDate), LocalDate.parse(endDate)), HttpStatus.OK);
	}

}

package com.cts.training.middle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cts.training.dao.StockPriceDAO;
import com.cts.training.model.StockPrice;

@Controller
public class StockPriceController {
	@Autowired
	StockPriceDAO stockPriceDAO;

	@GetMapping("/stockPrice-home")
	public String stockPricePage(Model model) {
		List<StockPrice> stockPrice = stockPriceDAO.getAllStockPrices();
		model.addAttribute("list", stockPrice);
		model.addAttribute("stockPrice", new StockPrice());
		return "stockPrice";
	}

	@PostMapping("/stockPrice/save")
	public String saveUser(@ModelAttribute("stockPrice") StockPrice stockPrice) {
		stockPriceDAO.addOrUpdateStockPrice(stockPrice);
		return "redirect:/stockPrice-home";
	}

	@GetMapping("/stockPrice/remove/{id}") // {}->path variable
	public String deleteStockPrice(@PathVariable("id") int id) {
		StockPrice user = stockPriceDAO.getStockPriceById(id);
		stockPriceDAO.deleteStockPrice(user);
		return "redirect:/stockPrice-home";
	}

	@GetMapping("/stockPrice/update/{id}")
	public String updateStockPrice(@PathVariable("id") int id, Model model) {

		StockPrice user = stockPriceDAO.getStockPriceById(id);
		model.addAttribute("stockPrice", user);
		List<StockPrice> stockPrice = stockPriceDAO.getAllStockPrices();
		model.addAttribute("list", stockPrice);
		return "stockPrice";
	}

}

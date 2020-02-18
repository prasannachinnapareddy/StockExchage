package com.cts.training.middle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cts.training.dao.StockExchangeDAO;
import com.cts.training.model.StockExchange;

@Controller
public class StockExchangeController {
	@Autowired
	StockExchangeDAO stockExchangeDAO;

	@GetMapping("/stockExchange-home")
	public String stockExchangePage(Model model) {
		List<StockExchange> stockExchange = stockExchangeDAO.getAllStockExchanges();
		model.addAttribute("list", stockExchange);
		model.addAttribute("stockExchange", new StockExchange());
		return "stockExchange";
	}

	@PostMapping("/stockExchange/save")
	public String saveUser(@ModelAttribute("stockExchange") StockExchange stockExchange) {
		stockExchangeDAO.addOrUpdateStockExchange(stockExchange);
		return "redirect:/stockExchange-home";
	}

	@GetMapping("/stockExchange/remove/{id}") // {}->path variable
	public String deleteStockExchange(@PathVariable("id") int id) {
		StockExchange user = stockExchangeDAO.getStockExchangeById(id);
		stockExchangeDAO.deleteStockExchange(user);
		return "redirect:/stockExchange-home";
	}

	@GetMapping("/stockExchange/update/{id}")
	public String updateSector(@PathVariable("id") int id, Model model) {

		StockExchange user = stockExchangeDAO.getStockExchangeById(id);
		model.addAttribute("stockExchange", user);
		List<StockExchange> stockExchange = stockExchangeDAO.getAllStockExchanges();
		model.addAttribute("list", stockExchange);
		return "stockExchange";
	}
}

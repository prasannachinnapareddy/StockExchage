package com.cts.training.middle.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cts.training.dao.CompanyDAO;
import com.cts.training.dao.IPODAO;
import com.cts.training.dao.RegisterDAO;
import com.cts.training.dao.SectorDAO;
import com.cts.training.dao.StockExchangeDAO;
import com.cts.training.dao.StockPriceDAO;
import com.cts.training.model.Company;
import com.cts.training.model.IPO;
import com.cts.training.model.Register;
import com.cts.training.model.Sector;
import com.cts.training.model.StockExchange;
import com.cts.training.model.StockPrice;

@Controller
public class HomeController {

	// @GetMapping("/") --> In spring 4.3 version
	@RequestMapping("/")
	public String indexPage(Model model) {
		model.addAttribute("message", "Welcome to Spring MVC");

		List<String> names = new ArrayList<String>();
		addNames(names);
		model.addAttribute("list", names);
		return "index";

	}

	private void addNames(List<String> names) {
		names.add("Divya");
		names.add("Hameemsha");
		names.add("Aneena");
		names.add("Malavika");
		names.add("Sindhu");

	}

	@Autowired
	private RegisterDAO registerDAO;

	@RequestMapping("/register")
	public String registerpage(Model model) {
		List<Register> register = registerDAO.getAllUsers();
		model.addAttribute("list", register);
		return "register";
	}

	@Autowired
	private CompanyDAO companyDAO;

	@RequestMapping("/company")
	public String companypage(Model model) {
		List<Company> company = companyDAO.getAllCompany();
		model.addAttribute("list", company);
		return "company";
	}

	@Autowired
	private IPODAO ipoDAO;

	@RequestMapping("/ipo")
	public String ipopage(Model model) {
		List<IPO> ipo = ipoDAO.getAllIPOs();
		model.addAttribute("list", ipo);
		return "ipo";
	}

	@Autowired
	private SectorDAO sectorDAO;

	@RequestMapping("/sector")
	public String sectorpage(Model model) {
		List<Sector> sector = sectorDAO.getAllSectors();
		model.addAttribute("list", sector);
		return "sector";
	}

	@Autowired
	private StockExchangeDAO stockExchangeDAO;

	@RequestMapping("/stockExchange")
	public String stockExchangepage(Model model) {
		List<StockExchange> stockExchange = stockExchangeDAO.getAllStockExchanges();
		model.addAttribute("list", stockExchange);
		return "stockExchange";
	}

	@Autowired
	private StockPriceDAO stockPriceDAO;

	@RequestMapping("/stockPrice")
	public String stockPricepage(Model model) {
		List<StockPrice> stockPrice = stockPriceDAO.getAllStockPrices();
		model.addAttribute("list", stockPrice);
		return "stockPrice";
	}
}

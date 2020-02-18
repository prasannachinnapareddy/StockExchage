package com.cts.training.middle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cts.training.dao.IPODAO;
import com.cts.training.model.IPO;

@Controller
public class IPOController {
	@Autowired
	IPODAO ipoDAO;

	@GetMapping("/ipo-home")
	public String ipoPage(Model model) {
		List<IPO> ipo = ipoDAO.getAllIPOs();
		model.addAttribute("list", ipo);
		model.addAttribute("ipo", new IPO());
		return "ipo";
	}

	@PostMapping("/ipo/save")
	public String saveUser(@ModelAttribute("ipo") IPO ipo) {
		ipoDAO.addOrUpdateIPO(ipo);
		return "redirect:/ipo-home";
	}

	@GetMapping("/ipo/remove/{id}") // {}->path variable
	public String deleteIPO(@PathVariable("id") int id) {
		IPO user = ipoDAO.getIPOById(id);
		ipoDAO.deleteIPO(user);
		return "redirect:/ipo-home";
	}

	@GetMapping("/ipo/update/{id}")
	public String updateIPO(@PathVariable("id") int id, Model model) {

		IPO user = ipoDAO.getIPOById(id);
		model.addAttribute("ipo", user);
		List<IPO> ipo = ipoDAO.getAllIPOs();
		model.addAttribute("list", ipo);
		return "ipo";
	}
}

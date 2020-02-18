package com.cts.training.middle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cts.training.dao.SectorDAO;
import com.cts.training.model.Sector;

@Controller
public class SectorController {
	@Autowired
	SectorDAO sectorDAO;

	@GetMapping("/sector-home")
	public String sectorPage(Model model) {
		List<Sector> sector = sectorDAO.getAllSectors();
		model.addAttribute("list", sector);
		model.addAttribute("sector", new Sector());
		return "sector";
	}

	@PostMapping("/sector/save")
	public String saveUser(@ModelAttribute("sector") Sector sector) {
		sectorDAO.addOrUpdateSector(sector);
		return "redirect:/sector-home";
	}

	@GetMapping("/sector/remove/{id}") // {}->path variable
	public String deleteSector(@PathVariable("id") int id) {
		Sector user = sectorDAO.getSectorById(id);
		sectorDAO.deleteSector(user);
		return "redirect:/sector-home";
	}

	@GetMapping("/sector/update/{id}")
	public String updateSector(@PathVariable("id") int id, Model model) {

		Sector user = sectorDAO.getSectorById(id);
		model.addAttribute("sector", user);
		List<Sector> sector = sectorDAO.getAllSectors();
		model.addAttribute("list", sector);
		return "sector";
	}

}

package com.cts.training.middle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cts.training.dao.CompanyDAO;
import com.cts.training.model.Company;


@Controller
public class CompanyController {
	@Autowired
	CompanyDAO companyDAO;

	@GetMapping("/company-home")
	public String companyPage(Model model) {
		List<Company> company = companyDAO.getAllCompany();
		model.addAttribute("list", company);
		model.addAttribute("company", new Company());
		return "company";
	}

	@PostMapping("/company/save")
	public String saveCompany(@ModelAttribute("company") Company company) {
		companyDAO.saveOrUpdateCompany(company);
		return "redirect:/company-home";
	}

	@GetMapping("/company/remove/{id}") // {}->path variable
	public String deleteCompany(@PathVariable("id") int id) {
		Company user = companyDAO.getUserById(id);
		companyDAO.deleteCompany(user);
		return "redirect:/company-home";
	}

	@GetMapping("/company/update/{id}")
	public String updateCompany(@PathVariable("id") int id, Model model) {

		Company user = companyDAO.getUserById(id);
		model.addAttribute("company", user);
		List<Company> company = companyDAO.getAllCompany();
		model.addAttribute("list", company);
		return "company";
	}
}

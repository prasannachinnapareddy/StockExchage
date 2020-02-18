package com.cts.training.middle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cts.training.dao.RegisterDAO;
import com.cts.training.model.Register;

@Controller
public class UserController {

	@Autowired
	RegisterDAO registerDAO;

	@GetMapping("/user-home")
	public String userPage(Model model) {
		List<Register> register = registerDAO.getAllUsers();
		model.addAttribute("list", register);
		model.addAttribute("user", new Register());
		return "users";
	}

	@PostMapping("/user/save")
	public String saveUser(@ModelAttribute("user") Register user) {
		registerDAO.saveOrUpdateUser(user);
		return "redirect:/user-home";
	}

	@GetMapping("/remove/{id}") // {}->path variable
	public String deleteUser(@PathVariable("id") int id) {
		Register user = registerDAO.getUserById(id);
		registerDAO.deleteUser(user);
		return "redirect:/user-home";
	}

	@GetMapping("/update/{id}")
	public String updateUser(@PathVariable("id") int id, Model model) {

		Register user = registerDAO.getUserById(id);
		model.addAttribute("user", user);
		List<Register> register = registerDAO.getAllUsers();
		model.addAttribute("list", register);
		return "users";
	}
}

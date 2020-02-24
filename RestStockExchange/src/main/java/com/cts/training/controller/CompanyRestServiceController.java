package com.cts.training.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.dao.CompanyDAO;
import com.cts.training.model.Company;
@CrossOrigin(origins="*")
@RestController
public class CompanyRestServiceController 
{
	@Autowired
	CompanyDAO cmpDao;
    @RequestMapping(value = "/cmp", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Company> findAll() {
		return cmpDao.findAll();
	}
	@RequestMapping(value = "/cmp/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Company finedone(@PathVariable int id) {
		Optional<Company> cmp = cmpDao.findById(id);
		Company cmp1 = cmp.get();
		return cmp1;
	}
	@RequestMapping(value = "/cmp", method = RequestMethod.POST)
	public Company save(@RequestBody Company cmp) {
		Company cmp2 = cmpDao.save(cmp);
		return cmp2;
	}
	@RequestMapping(value = "/cmp/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable int id) {
		cmpDao.deleteById(id);
	}
	@RequestMapping(value = "/cmp", method = RequestMethod.PUT)
	public Company update(@RequestBody Company cmp) {
		Company cmp2 = cmpDao.save(cmp);
		return cmp2;
	}
}

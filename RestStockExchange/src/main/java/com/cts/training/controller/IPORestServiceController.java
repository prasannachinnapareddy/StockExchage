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

import com.cts.training.dao.IPODAO;
import com.cts.training.model.IPO;
@CrossOrigin(origins="*")
@RestController
public class IPORestServiceController
{
	@Autowired
	IPODAO ipoDao;
    @RequestMapping(value = "/ipo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<IPO> findAll() {
		return ipoDao.findAll();
	}
	@RequestMapping(value = "/ipo/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public IPO finedone(@PathVariable int id) {
		Optional<IPO> ipo = ipoDao.findById(id);
		IPO ipo1 = ipo.get();
		return ipo1;
	}
	@RequestMapping(value = "/ipo", method = RequestMethod.POST)
	public IPO save(@RequestBody IPO ipo) {
		System.out.println("save.."+ipo.getCname());
		IPO ipo2 = ipoDao.save(ipo);
		return ipo2;
	}
	@RequestMapping(value = "/ipo/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable int id) {
		ipoDao.deleteById(id);
	}
	@RequestMapping(value = "/ipo", method = RequestMethod.PUT)
	public IPO update(@RequestBody IPO ipo) {
		IPO ipo2 = ipoDao.save(ipo);
		return ipo2;
	}
}

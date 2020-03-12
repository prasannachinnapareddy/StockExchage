package com.cts.training.ipo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins="*")
@RestController
public class InitialPublicOfferingController
{
	
	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	InitialPublicOfferingDAO initialPublicOfferingDAO;
	
	@Autowired
	InitialPublicOfferingService initialPublicOfferingService;
	
    @GetMapping(value="/allInitialPublicOfferings")
	public ResponseEntity<?>getallInitialPublicOfferings()
	  {
			List<InitialPublicOffering> list = initialPublicOfferingService.getAllInitialPublicOfferings();
			if(list.size()>0)
			{
				return new ResponseEntity<List<InitialPublicOffering>>(list , HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<String>("No ininitialPublicOfferings found",HttpStatus.NOT_FOUND);
			}
		}
	
    @GetMapping("/allInitialPublicOfferings/{id}")
	public ResponseEntity<InitialPublicOffering> getById(@PathVariable int id)
    {
		InitialPublicOffering initialPublicOffering = initialPublicOfferingService.getInitialPublicOfferingById(id);
		return new ResponseEntity<InitialPublicOffering>(initialPublicOffering,HttpStatus.OK);
	}
  
  @DeleteMapping("/allInitialPublicOfferings/{id}")
	public void delete(@PathVariable int id)
  	{
		initialPublicOfferingService.delete(id);
	}

  @PutMapping("/allInitialPublicOfferings")
	public ResponseEntity<InitialPublicOffering> update(@RequestBody InitialPublicOffering initialPublicOfferings)
  	{
		initialPublicOfferingService.updateInitialPublicOffering(initialPublicOfferings);
		return new ResponseEntity<InitialPublicOffering>(initialPublicOfferings,HttpStatus.OK);
	}

  @RequestMapping(value = "/allInitialPublicOfferings",method = RequestMethod.POST)
	public ResponseEntity<InitialPublicOffering> save(@RequestBody InitialPublicOffering initialPublicOffering){
		initialPublicOfferingService.insert(initialPublicOffering);
		return new ResponseEntity<InitialPublicOffering>(initialPublicOffering,HttpStatus.CREATED);
	}
}

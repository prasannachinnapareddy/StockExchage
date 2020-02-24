 package com.cts.training.controller;
  
  import java.util.List; import java.util.Optional;
  
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable; 
  import org.springframework.web.bind.annotation.RequestBody; 
  import org.springframework.web.bind.annotation.RequestMapping; 
  import org.springframework.web.bind.annotation.RequestMethod; 
  import org.springframework.web.bind.annotation.RestController;
  import com.cts.training.dao.RegisterDAO; 
  import com.cts.training.model.Register;
  @CrossOrigin(origins="*")
  @RestController 
  
  public class RegisterRestServiceController 
  {
  
	  @Autowired 
	  
	  RegisterDAO regDao;
  
	  @RequestMapping(value = "/reg", method = RequestMethod.GET, produces =MediaType.APPLICATION_JSON_VALUE) 
	  public List<Register> findAll() 
	  {
		  return regDao.findAll(); 
	  }
	 
	  @RequestMapping(value = "/reg/{id}", method = RequestMethod.GET, produces =MediaType.APPLICATION_JSON_VALUE) 
	  public Register finedone(@PathVariable int id) 
	  { 
		  Optional<Register> reg = regDao.findById(id); 
		  Register reg1 = reg.get(); 
		  return reg1;
	  }
  
	  @RequestMapping(value = "/reg", method = RequestMethod.POST)
	  public Register save(@RequestBody Register reg) 
	  { 
		  Register reg2 = regDao.save(reg); 
		  return reg2;
	  }

	 @RequestMapping(value = "/reg/{id}", method = RequestMethod.DELETE) 
	 public void delete(@PathVariable int id)
	 { 
		 regDao.deleteById(id); 
	 }
 
	 @RequestMapping(value = "/reg", method = RequestMethod.PUT)
	 public Register update(@RequestBody Register reg)
	 {
		 System.out.println("update   "+"  id"+reg.getId()+"\t"+reg.getEmail()+"\t"+reg.getName());
		 Register reg2 = regDao.save(reg); 
		 return reg2; 
		 
	 }
	 
 }
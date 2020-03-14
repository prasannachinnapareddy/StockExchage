 package com.cts.training.userservice;
  
  import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
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
  public class RegisterRestServiceController 
  {
  
	  @Autowired 
	  RegisterDAO registerDAO;
	  
	  Logger logger = LoggerFactory.getLogger(this.getClass()); 
	  
	  @Autowired
	  RegisterService registerService;
	  
	  @Autowired 
	  JavaMailSender javaMailSender;
  
	  @GetMapping("/registerall")
	  public ResponseEntity<?>getallusers()
	  {
			List<Register> list = registerService.getAllUsers();
			if(list.size()>0)
			{
				return new ResponseEntity<List<Register>>(list , HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<String>("No users found",HttpStatus.NOT_FOUND);
			}
		}
	 
	  @GetMapping("/registerall/{id}")
		public ResponseEntity<Register> getById(@PathVariable int id)
	  	{
			Register register = registerService.getUserById(id);
			return new ResponseEntity<Register>(register,HttpStatus.OK);
		}
	  
	  @DeleteMapping("/registerall/{id}")
		public void delete(@PathVariable int id)
	  	{
			registerService.delete(id);
		}

	  @PutMapping("/registerall")
		public ResponseEntity<Register> update(@RequestBody Register register)
	  	{
			registerService.updateUser(register);
			return new ResponseEntity<Register>(register,HttpStatus.OK);
		}

	  @RequestMapping(value = "/registerall",method = RequestMethod.POST)
		public ResponseEntity<Register> save(@RequestBody Register register)
	  	{
			registerService.insert(register);
			return new ResponseEntity<Register>(register,HttpStatus.CREATED);
		}
	  
	  @RequestMapping(value="/activate",method= RequestMethod.PUT)
		public ResponseEntity<String> activate(@RequestBody String email)
	  	{
			registerService.activate(email);
			return new ResponseEntity<String>(email,HttpStatus.CREATED);
		}
	  
	  @GetMapping(value="/login")
	  	public ResponseEntity<?> login(HttpServletRequest httpServletRequest)
	  	{
		  // It returns the value of request header as a string
		  	String authorization=httpServletRequest.getHeader("Authorization");
		  	logger.info("Login with token-->{}",authorization);
		  	String username=null;
		  	String password=null;
		  	if(authorization!=null && authorization.startsWith("Basic"))
		  	{
		  		String base64Credentials=authorization.substring("Basic".length()).trim();
		  		byte[] credDecoded=Base64.getDecoder().decode(base64Credentials);
		  		String credentails=new String(credDecoded,StandardCharsets.UTF_8);
		  		username=credentails.split(":")[0];
		  		password=credentails.split(":")[1];
		  	}
		  	try
		  	{
		  		RegisterDTO registerDTO=registerService.getUserByUsernameAndPassword(username,password);
		  		logger.info("User Logged in Using Username --> {}",username);
		  		return new ResponseEntity<RegisterDTO>(registerDTO,HttpStatus.OK);
		  	}
		  	catch(Exception e)
		  	{
		  		System.out.println(e.getStackTrace());
		  		logger.info("Unauthorized access Stack Trace-->{}",e.getStackTrace().toString());
		  		return new ResponseEntity<String>("No user found",HttpStatus.NOT_FOUND);
		  	}
	  	}
	 
 }
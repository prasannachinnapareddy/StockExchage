package com.cts.training.userservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
@Service
public class RegisterServiceImp implements RegisterService
{
	@Autowired
	RegisterDAO registerDAO;
	
	@Autowired
	RegisterService registerService;

	@Autowired
	JavaMailSender javaMailSender;
	
	@Override
	public Register insert(Register register)
	{
		registerDAO.save(register);
		try
		{
			SimpleMailMessage sm = new SimpleMailMessage();
			sm.setFrom("prasannasvvl@gmail.com");
			sm.setTo(register.getEmail());
			sm.setSubject("verfication mail");
			sm.setText("Account created click on <a href='http://localhost:4200/activate?"+register.getEmail()+"'>Click</a>");
			javaMailSender.send(sm);
			System.out.println("sending mail.....");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return register;
	}

	@Override
	public void delete(int id) 
	{
		registerDAO.deleteById(id);
	}
	
	@Override
	public List<Register> getAllUsers()
	{

		return registerDAO.findAll();
	}
	
	@Override
	public Register updateUser(Register users)
	{
		registerDAO.save( users);
		return users;
	}
	
	@Override
	public Register getUserById(int id)
	{
		Optional<Register> user =registerDAO.findById(id);
		return user.orElse(null);
	}

	@Override
	public String activate(@RequestBody String email)
	{
			String str=email.substring(email.indexOf(":")+2,email.lastIndexOf("\""));
			System.out.println("email ::"+str);
			Register register= registerDAO.findByEmail(str);
			System.out.println("username :"+register.getEmail());
			register.setActive(true);
		    register = registerDAO.save(register);
		    return "{\"status\":\"ok\"}";
	}

	@Override
	public RegisterDTO getUserByUsernameAndPassword(String username, String password) 
	{
		Register register=registerDAO.findByUsernameAndPassword(username,password);
		RegisterDTO registerDTO=new RegisterDTO();
		BeanUtils.copyProperties(register, registerDTO);
		return registerDTO;
	}
	
}
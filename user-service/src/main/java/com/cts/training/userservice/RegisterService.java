package com.cts.training.userservice;

import java.util.List;



public interface RegisterService 
{
	public Register insert(Register registerDTO);
	
	public String activate(String email);
	
	public void delete(int id);
	
	public Register updateUser(Register users);
	
	public List<Register> getAllUsers();
	
	public Register getUserById(int id);
	
}

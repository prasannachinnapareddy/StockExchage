package com.cts.training.userservice;

import java.util.List;

public interface RegisterService 
{
	public Register insert(Register register);
	
	public String activate(String email);
	
	public void delete(int id);
	
	public Register updateUser(Register register);
	
	public List<Register> getAllUsers();
	
	public Register getUserById(int id);

	public RegisterDTO getUserByUsernameAndPassword(String username, String password);
	
}

package com.cts.training.companyservice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

class CompanyControllerIntegrationTest {

	@LocalServerPort
	private int port;
	
	HttpHeaders headers=new HttpHeaders();
	
	TestRestTemplate restTemplate=new TestRestTemplate();
	
	@Test
	public void getAllCompanies() throws Exception
	{
		String url="http://localhost:"+port+"/allCompanies";
		System.out.println("Port is ::"+url);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity=new HttpEntity<String>(null,headers);
		ResponseEntity<String> response=restTemplate.exchange(url,HttpMethod.GET,entity,String.class);
		String expected="{\"id\":62,\"bdec\":\"SoftwareCompany\",\"bms\":\"saipriya\"";
		System.out.println("TEST AllCompanies:: Response Body :::: " +response.getBody());
		assertTrue(response.getBody().contains(expected));
	}
//	@Test
//	public void getById() throws Exception
//	{
//		String url="http://localhost:"+port+"/userById/126";
//		System.out.println("Port is ::"+url);
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//		HttpEntity<String> entity=new HttpEntity<String>(null,headers);
//		ResponseEntity<String> response=restTemplate.exchange(url,HttpMethod.GET,entity,String.class);
//		String expected="{\"id\":126,\"name\":\"supriya\",\"email\":\"saipriya@gmail.com\"";
//		System.out.println("TEST UserById :: Response Body :::: " +response.getBody());
//		assertTrue(response.getBody().contains(expected));
//	}
//	
//	@Test
//	public void addUser() throws Exception
//	{
//		String url="http://localhost:"+port+"/allUsers";
//		System.out.println("Port is ::"+url);
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//		Register register=new Register(129,"saketh","saketh@gmail.com","saketh123","saketh123");
//		HttpEntity<Register> entity=new HttpEntity<Register>(register,headers);
//		ResponseEntity<String> response=restTemplate.exchange(url,HttpMethod.POST,entity,String.class);
//		String expected="\"id\":129,\"name\":\"saketh\",\"email\":\"saketh@gmail.com\",\"psw\":\"saketh123\",\"rpsw\":\"saketh123\"";
//		System.out.println("TEST1 :: Response Body :::: " +response.getBody());
//		assertTrue(response.getBody().contains(expected));
//	}
//	
//	@Test
//	public void deleteUser() throws Exception
//	{
//		String url="http://localhost:"+port+"/deleteUser/134";
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//		HttpEntity<Register> entity=new HttpEntity<Register>(null,headers);
//		ResponseEntity<String> response=restTemplate.exchange(url,HttpMethod.DELETE,entity,String.class);
//		System.out.println("TEST1 :: Response Body :::: " +response.getBody());
//		assertEquals(HttpStatus.OK,response.getStatusCode());
//	}
//	
//	@Test
//	public void updateUser() throws Exception
//	{
//		String url="http://localhost:"+port+"/updateUser";
//		System.out.println("Port is ::"+url);
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//		Register register=new Register(134,"sakethRam","saketh@gmail.com","saketh123","saketh123");
//		HttpEntity<Register> entity=new HttpEntity<Register>(register,headers);
//		ResponseEntity<String> response=restTemplate.exchange(url,HttpMethod.PUT,entity,String.class);
//		String expected="\"id\":134,\"name\":\"sakethRam\"";
//		System.out.println("Test Update:: Response Body :::: " +response.getBody());
//		assertTrue(response.getBody().contains(expected));
//	}
	
}

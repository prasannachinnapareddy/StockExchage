package com.cts.training.companyservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CompanyServiceImp implements CompanyService 
{

	@Autowired
	CompanyDAO companyDAO;
	
	@Autowired
	CompanyService companyService;
	
	@Override
	public Company insert(Company company)
	{
		companyDAO.save(company);
		return company;
	}

	@Override
	public void delete(int id)
	{
		companyDAO.deleteById(id);
	}

	@Override
	public Company updateCompany(Company company)
	{
		companyDAO.save(company);
		return company;
	}

	@Override
	public List<Company> getAllCompanies()
	{
		return companyDAO.findAll();
	}
	
	@Override
	public Company getCompanyById(int id)
	{	
		Optional<Company> company =companyDAO.findById(id);
		return company.orElse(null);
	}

}

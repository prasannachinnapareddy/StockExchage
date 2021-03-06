package com.cts.training.companyservice;
import java.util.List;


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
public class CompanyRestServiceController 
{
	@Autowired
	CompanyDAO companyDao;
	
	@Autowired
	CompanyService companyService;
	
    @GetMapping(value="/allCompanies")
	public ResponseEntity<?>getallusers()
	  {
			List<Company> list = companyService.getAllCompanies();
			if(list.size()>0)
			{
				return new ResponseEntity<List<Company>>(list , HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<String>("No Companies found",HttpStatus.NOT_FOUND);
			}
		}
	
    @GetMapping("/companyById/{id}")
	public ResponseEntity<Company> getById(@PathVariable int id){
		Company company = companyService.getCompanyById(id);
		return new ResponseEntity<Company>(company,HttpStatus.OK);
	}
  
  @DeleteMapping("/deleteCompany/{id}")
	public void delete(@PathVariable int id) {
		companyService.delete(id);
	}

  @PutMapping("/updateCompany")
	public ResponseEntity<Company> update(@RequestBody Company companies){
		companyService.updateCompany(companies);
		return new ResponseEntity<Company>(companies,HttpStatus.OK);
	}

  @RequestMapping(value = "/allCompanies",method = RequestMethod.POST)
	public ResponseEntity<Company> save(@RequestBody Company company){
		companyService.insert(company);
		return new ResponseEntity<Company>(company,HttpStatus.CREATED);
	}
  }

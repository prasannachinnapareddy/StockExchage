import { Component, OnInit } from '@angular/core';
import { CompanyService } from 'src/app/service/company.service';
import { Router } from '@angular/router';
import { Company } from '../models/usermock';

@Component({
  selector: 'app-managecomapany',
  templateUrl: './managecomapany.component.html',
  styleUrls: ['./managecomapany.component.css']
})
export class ManagecomapanyComponent implements OnInit {
  constructor(private companyService:CompanyService,private router:Router) { }
  companies:Company[];
  ngOnInit() {
    this.companyService.getAllCompanies().subscribe(data => {
      this.companies=data;
    });
}
deleteCompany(id:number){
  this.companyService.deleteCompany(id).subscribe(date=>{
  this.companies=this.companies.filter(company => company.id!== id);
});
}
updateCompany(company:Company)
{
  localStorage.removeItem('companyId');
  localStorage.setItem('companyId',company.id.toString());
  this.router.navigate(['company']);
}
}

import { Component, OnInit } from '@angular/core';
import { Company } from '../models/company';
import { CompanyService } from '../service/company.service';

@Component({
  selector: 'app-companieslist',
  templateUrl: './companieslist.component.html',
  styleUrls: ['./companieslist.component.css']
})
export class CompanieslistComponent implements OnInit {

  constructor(private companyService:CompanyService) { }
  companies:Company[];
  ngOnInit() {
    this.companyService.getAllCompanies().subscribe(data => {
      this.companies=data;
    });

}
}
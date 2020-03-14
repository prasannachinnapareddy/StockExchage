import { Component, OnInit } from '@angular/core';
import { Validators, FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { Company } from 'src/app/models/company';
import { CompanyService } from 'src/app/service/company.service';

@Component({
  selector: 'app-compare-company',
  templateUrl: './compare-company.component.html',
  styleUrls: ['./compare-company.component.css']
})
export class CompareCompanyComponent implements OnInit {
  compareCompany:FormGroup;
  companies:Company[];
  constructor(private formBuilder:FormBuilder,private router:Router,
    private companyService:CompanyService) { }
  ngOnInit() {
    this.compareCompany=this.formBuilder.group({
      csselect: ['',Validators.required],
      seselect: ['',Validators.required],
      cnsn: ['',Validators.required],
      ctcnsn: ['',Validators.required],
      fperiod: ['',Validators.required],
      tperiod: ['',Validators.required],
     });
     this.companyService.getAllCompanies().subscribe(data=>{
      this.companies=data;
    });
  }
  onSubmit() {
    this.router.navigate(["/charts"],{
      queryParams:{
        formData: JSON.stringify(this.compareCompany.value)
      }
    });
  }
  // getAllCompanies(){
  //   this.companyService.getAllCompanies().subscribe(data=>{
  //     this.companies=data;
  //   })
  // }

}

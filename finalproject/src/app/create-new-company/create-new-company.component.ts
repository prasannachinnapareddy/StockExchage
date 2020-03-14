import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators,FormControl } from '@angular/forms';
import { CompanyService } from '../service/company.service';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-create-new-company',
  templateUrl: './create-new-company.component.html',
  styleUrls: ['./create-new-company.component.css']
})
export class CreateNewCompanyComponent implements OnInit {
  company:FormGroup;
  constructor(private formBuilder:FormBuilder, private companyService:CompanyService) { }

  ngOnInit() {
    this.company=this.formBuilder.group({
      id:['',[Validators.required]],
      bdec:['',Validators.required],
      bms:['',Validators.required],
      ceo:['',Validators.required],
      cname:['',[Validators.required]],
      se:['',[Validators.required]],
      tover:['',Validators.required],
      cmpcode:['',Validators.required]
    });
      }
  addCompany()
  {
    this.companyService.saveCompany(this.company.value).subscribe
    (data => {
     alert("Company Created Successfully");
     this.company.reset();
    });
  }
}

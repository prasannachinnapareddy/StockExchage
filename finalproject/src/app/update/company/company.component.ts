import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { CompanyService } from 'src/app/service/company.service';
import { Router } from '@angular/router';
import { Company } from 'src/app/models/company';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {
  
  company:FormGroup;
  constructor(private formBuilder:FormBuilder, private companyService:CompanyService,private router:Router) { }

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

  const id = localStorage.getItem('companyId');
  if (+id > 0) {
    this.companyService.getCompanyById(+id).subscribe(Company => {
      this.company.patchValue(Company);
    });
  }
}
updateCompany() 
{
  console.log("uodate cmp");
  this.companyService.updateCompany(this.company.value).subscribe(data => {
    this.router.navigate(['managecompany']);
  },
    error => {
      alert(error);
    });
}

  }
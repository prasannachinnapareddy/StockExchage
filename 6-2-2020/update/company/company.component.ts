import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { CompanyService } from 'src/app/service/company.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {

  updatecompany:FormGroup;
  constructor(private formBuilder:FormBuilder, private companyService:CompanyService,private router:Router) { }

  ngOnInit() {
    this.updatecompany=this.formBuilder.group({
      id:['',[Validators.required]],
      cname:['',[Validators.required]],
      ceo:['',[Validators.required]],
      bms:['',Validators.required],
      lse:['',Validators.required],
      bdesc:['',Validators.required],
      tover:['',Validators.required],
      date:['',Validators.required]
    });
  const id = localStorage.getItem('companyId');
  if (+id > 0) {
    this.companyService.getCompanyById(+id).subscribe(Company => {
      this.updatecompany.patchValue(Company);
    });
  }
}
updateCompany() {
  this.companyService.updateCompany(this.updatecompany.value).subscribe(data => {
    this.router.navigate(['company']);
  },
    error => {
      alert(error);
    });
}
}
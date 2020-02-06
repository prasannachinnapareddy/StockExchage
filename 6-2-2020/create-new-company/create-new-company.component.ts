import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators,FormControl } from '@angular/forms';
import { CompanyService } from '../service/company.service';

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
      cname:['',[Validators.required]],
      ceo:['',[Validators.required]],
      bms:['',Validators.required],
      lse:['',Validators.required],
      bdesc:['',Validators.required],
      tover:['',Validators.required],
      date:['',Validators.required]
    });
      }
  addCompany()
  {
    this.companyService.saveCompany(this.company.value).subscribe
    (data => {
      console.log('Company Inserted Successfully' +data);
    });
  }
   onSubmit()
  {
    console.log(this.company.value);
  }
}

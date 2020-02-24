import { Component, OnInit } from '@angular/core';
import { Validators, FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-compare-company',
  templateUrl: './compare-company.component.html',
  styleUrls: ['./compare-company.component.css']
})
export class CompareCompanyComponent implements OnInit {
  company:FormGroup;
  constructor(private formBuilder:FormBuilder) { }

  ngOnInit() {
    this.company=this.formBuilder.group({
      company_sector:['',[Validators.required]],
      se:['',[Validators.required]],
      cname_sname:['',Validators.required],
      fdate:['',Validators.required],
      tdate:['',Validators.required]
    });
  }
  onSubmit()
  {
    console.log(this.company.value);
  }
}

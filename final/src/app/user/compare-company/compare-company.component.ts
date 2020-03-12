import { Component, OnInit } from '@angular/core';
import { Validators, FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-compare-company',
  templateUrl: './compare-company.component.html',
  styleUrls: ['./compare-company.component.css']
})
export class CompareCompanyComponent implements OnInit {
  company:FormGroup;
  constructor(private formBuilder:FormBuilder,private router:Router) { }

  ngOnInit() {
    this.company=this.formBuilder.group({
      csector:['',[Validators.required]],
      se:['',[Validators.required]],
      cname_sname:['',Validators.required],
      fdate:['',Validators.required],
      tdate:['',Validators.required]
    });
  }
  onSubmit()
  {
    this.router.navigate(["/charts"],{
      queryParams:{
      formData:JSON.stringify(this.company.value)
      }
    });
  }
}

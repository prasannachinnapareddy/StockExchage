import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { IpoService } from '../service/ipo.service';
@Component({
  selector: 'app-ipos',
  templateUrl: './ipos.component.html',
  styleUrls: ['./ipos.component.css']
})
export class IposComponent implements OnInit
{
  ipoForm:FormGroup;
  constructor(private formBuilder:FormBuilder, private ipoService:IpoService) { }
  
  addIpo(){
     this.ipoService.saveIpo(this.ipoForm.value).subscribe(data => {
        alert('Ipo Inserted Successfully' +data);
        this.ipoForm.reset();
      });
    }
    q
    deleteIpo(){
      this.ipoService.deleteIpo(this.ipoForm.value).subscribe(data=>{
        alert('Ipo Deleted Successfully' +data);
      });
    }  
  ngOnInit() {
    this.ipoForm=this.formBuilder.group({
      id:[],
      companyname: ['',Validators.required],
      lse: ['',Validators.required],
      pps: ['',Validators.required],
      tnos: ['',Validators.required],
      odate: ['',Validators.required],
      remarks: ['',Validators.required],
     });
  }
}
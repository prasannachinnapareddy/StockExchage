import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder, FormGroup } from '@angular/forms';
import { IpoService } from 'src/app/service/ipo.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ipo-update',
  templateUrl: './ipo-update.component.html',
  styleUrls: ['./ipo-update.component.css']
})
export class IpoUpdateComponent implements OnInit {

  updateipoForm:FormGroup;
  constructor(private formBuilder:FormBuilder, private ipoService:IpoService,private router:Router) { }
  
  ngOnInit() {
    this.updateipoForm=this.formBuilder.group({
      id:[],
      companyname: ['',Validators.required],
      lse: ['',Validators.required],
      pps: ['',Validators.required],
      tnos: ['',Validators.required],
      odate: ['',Validators.required],
      remarks: ['',Validators.required],
     });
     const id = localStorage.getItem('ipoId');
     if (+id > 0) {
       this. ipoService.getIpoById(+id).subscribe(Ipo => {
         this.updateipoForm.patchValue(Ipo);
       });
     }
   }
   updateIpo() {
     this.ipoService.updateIpo(this.updateipoForm.value).subscribe(data => {
       this.router.navigate(['updateipodetails']);
     },
       error => {
         alert(error);
       });
     }
 }



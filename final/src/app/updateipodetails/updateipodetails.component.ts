import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { IpoService } from '../service/ipo.service';
import { Ipo } from '../models/ipo';
@Component({
  selector: 'app-updateipodetails',
  templateUrl: './updateipodetails.component.html',
  styleUrls: ['./updateipodetails.component.css']
})
export class UpdateipodetailsComponent implements OnInit {
  constructor(private ipoService :IpoService, private router : Router) {}
  ipos:Ipo[];
  ngOnInit() {
    this.ipoService.getAllIpos().subscribe(data=>{
      this.ipos=data;
    })
  }
  deleteIpo(id:number)
  {
    this.ipoService.deleteIpo(id).subscribe(data=>{
      this.ipos=this.ipos.filter(ipos => ipos.id !== id);
    }); 
  }
  updateIpo(ipos: Ipo) {
    localStorage.removeItem('ipoId');
    localStorage.setItem('ipoId', ipos.id.toString());
    this.router.navigate(['ipo-update']);
  }
}


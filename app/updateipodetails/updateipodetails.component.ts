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

  
  constructor(private ipoService:IpoService,private router:Router) { }
  ipos:Ipo[];
  ngOnInit() {
    this.ipoService.getAllIpo().subscribe(data => {
      this.ipos=data;
    });
}
deleteIpo(ipo:Ipo){
  console.log("id in comp "+ipo.id)
  this.ipoService.deleteIpo(ipo.id).subscribe();
  this.ipos=this.ipos.filter(u => u !== ipo);
}
updateIpo(ipo:Ipo)
{
  localStorage.removeItem('ipoId');
  localStorage.setItem('ipoId',ipo.id.toString());
  this.router.navigate(['ipo-update']);
}
}

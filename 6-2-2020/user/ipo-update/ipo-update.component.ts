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

  updateipo:FormGroup;
  constructor(private formBuilder:FormBuilder, private ipoService:IpoService,private router:Router) { }

  ngOnInit() {
    this.updateipo=this.formBuilder.group({
      id:['',[Validators.required]],
      cname:['',[Validators.required]],
      ceo:['',[Validators.required]],
      bms:['',Validators.required],
      lse:['',Validators.required],
      bdesc:['',Validators.required],
      tover:['',Validators.required],
      date:['',Validators.required]
    });
  const id = localStorage.getItem('ipoId');
  if (+id > 0) {
    this.ipoService.getCompanyById(+id).subscribe(Ipo => {
      this.updateipo.patchValue(Ipo);
    });
  }
}
updateCompany() {
  this.ipoService.updateCompany(this.updateipo.value).subscribe(data => {
    this.router.navigate(['see-ipo']);
  },
    error => {
      alert(error);
    });
}
}
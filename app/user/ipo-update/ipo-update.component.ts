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
      price:['',[Validators.required]],
      remarks:['',[Validators.required]],
      se:['',[Validators.required]],
      tshares:['',[Validators.required]]
    });
  const id = localStorage.getItem('ipoId');
  if (+id > 0) {
    this.ipoService.getIpoById(+id).subscribe(Ipo => {
      this.updateipo.patchValue(Ipo);
    });
  }
}
updateIpo() {
  this.ipoService.updateIpo(this.updateipo.value).subscribe(data => {
    this.router.navigate(['updateipodetails']);
  },
    error => {
      alert(error);
    });
}
}
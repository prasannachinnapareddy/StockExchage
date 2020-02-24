import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { IpoService } from '../service/ipo.service';
@Component({
  selector: 'app-ipos',
  templateUrl: './ipos.component.html',
  styleUrls: ['./ipos.component.css']
})
export class IposComponent implements OnInit {
  ipo:FormGroup;
  constructor(private formBuilder:FormBuilder, private ipoService:IpoService) { }

  ngOnInit() {
    this.ipo=this.formBuilder.group({
      id:['',[Validators.required]],
     cname:['',[Validators.required]],
      price:['',[Validators.required]],
      remarks:['',[Validators.required]],
      se:['',[Validators.required]],
      tshares:['',[Validators.required]]
    });
  }
  addIpo()
  {
    this.ipoService.saveIpo(this.ipo.value).subscribe
    (data => {
      console.log('IPO Inserted Successfully' +data);
    });
  }
  onSubmit()
  {
    console.log("on submit"+this.ipo.value);

  }
}
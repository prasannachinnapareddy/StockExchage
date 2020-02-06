import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-updateipodetails',
  templateUrl: './updateipodetails.component.html',
  styleUrls: ['./updateipodetails.component.css']
})
export class UpdateipodetailsComponent implements OnInit {

  ipo:FormGroup;
  constructor(private formBuilder:FormBuilder) { }

  ngOnInit() {
    this.ipo=this.formBuilder.group({
      id:['',[Validators.required]],
     cname:['',[Validators.required]],
      se:['',[Validators.required]],
      price:['',Validators.required],
      tshares:['',Validators.required],
      date:['',Validators.required],
      rms:['',Validators.required],
    });
  }
  onSubmit()
  {
    console.log(this.ipo.value);
  }
}
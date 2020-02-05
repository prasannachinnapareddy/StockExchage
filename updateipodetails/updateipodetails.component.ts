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
     tname:['',[Validators.required]],
      se:['',[Validators.required]],
      price:['',Validators.required],
      repeat:['',Validators.required]
    });
  }
  onSubmit()
  {
    console.log(this.ipo.value);
  }
}
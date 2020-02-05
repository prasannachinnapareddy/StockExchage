import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-ipos',
  templateUrl: './ipos.component.html',
  styleUrls: ['./ipos.component.css']
})
export class IposComponent implements OnInit {
  ipo:FormGroup;
  constructor(private formBuilder:FormBuilder) { }

  ngOnInit() {
    this.ipo=this.formBuilder.group({
      id:['',[Validators.required]],
     tname:['',[Validators.required]],
      se:['',[Validators.required]],
      price:['',Validators.required],
      tshares:['',Validators.required],
     date:['',Validators.required],
      remarks:['',Validators.required]
    });
  }
  onSubmit()
  {
    console.log(this.ipo.value);
  }
}
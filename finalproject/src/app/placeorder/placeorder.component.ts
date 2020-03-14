import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-placeorder',
  templateUrl: './placeorder.component.html',
  styleUrls: ['./placeorder.component.css']
})
export class PlaceorderComponent implements OnInit {
  placeOrderForm:FormGroup;
  constructor(private formBuilder:FormBuilder) 
  { }
  ngOnInit() 
  {
    this.placeOrderForm=this.formBuilder.group({
      giftCardRAmount:['',[Validators.required]],
     giftCardPAmount:['',[Validators.required]],
    receipentFirstName:['',[Validators.required]],
    receipentLastName:['',[Validators.required]],
    street:['',[Validators.required]],
    city:['',[Validators.required]],
    state:['',[Validators.required]],
    country:['',[Validators.required]],
    pincode:['',[Validators.required]],
    buyerFirstName:['',[Validators.required]],
    buyerLastName:['',[Validators.required]],
    phoneNumber:['',[Validators.required]],
    email:['',[Validators.required]]
    });
  }
}
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { StockexchangeService } from '../service/stockexchange.service';

@Component({
  selector: 'app-stockexchange',
  templateUrl: './stockexchange.component.html',
  styleUrls: ['./stockexchange.component.css']
})
export class StockexchangeComponent implements OnInit {

  exchangeForm:FormGroup;
  constructor(private formBuilder:FormBuilder,private stockexchangeService:StockexchangeService) 
  { }
  ngOnInit() 
  {
    this.exchangeForm=this.formBuilder.group({
      id:['',[Validators.required]],
     se:['',[Validators.required]],
    breif:['',[Validators.required]],
    address:['',[Validators.required]],
    remarks:['',[Validators.required]]
    });
  }
  addStockExchange()
  {
    this.stockexchangeService.saveStockExchange(this.exchangeForm.value).subscribe
    (data => {
      alert('StockExchange Inserted Successfully' +data);
      this.exchangeForm.reset();
    });
  }
  deleteStockExchange()
  {
    this.stockexchangeService.saveStockExchange(this.exchangeForm.value).subscribe
    (data => {
      alert('StockExchange Deleted Successfully' +data);
    });
  }
  onSubmit()
  {
    console.log(this.exchangeForm.value);
  }
}
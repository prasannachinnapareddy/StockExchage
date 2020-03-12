import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { StockexchangeService } from '../service/stockexchange.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-updatestock',
  templateUrl: './updatestock.component.html',
  styleUrls: ['./updatestock.component.css']
})
export class UpdatestockComponent implements OnInit {

  updateForm:FormGroup;
  constructor(private formBuilder:FormBuilder, private stockexchangeService:StockexchangeService,private router:Router) { }
  
  ngOnInit() {
    this.updateForm=this.formBuilder.group({
      id:[],
      se: ['',Validators.required],
      breif: ['',Validators.required],
      address: ['',Validators.required],
      remarks: ['',Validators.required],
     });
     const id = localStorage.getItem('exchangeId');
     if (+id > 0) {
       this. stockexchangeService.getStockExchangeById(+id).subscribe(StockExchange => {
         this.updateForm.patchValue(StockExchange);
       });
     }
   }
   updateStockExchange() {
     this.stockexchangeService.updateStockExchange(this.updateForm.value).subscribe(data => {
       this.router.navigate(['manageexchange']);
     },
       error => {
         alert(error);
       });
     }
 }



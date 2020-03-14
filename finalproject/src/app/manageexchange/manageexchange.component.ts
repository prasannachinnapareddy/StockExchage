import { Component, OnInit } from '@angular/core';
import { StockexchangeService } from '../service/stockexchange.service';
import { Router } from '@angular/router';
import { StockExchange } from '../models/stockexchange';

@Component({
  selector: 'app-manageexchange',
  templateUrl: './manageexchange.component.html',
  styleUrls: ['./manageexchange.component.css']
})
export class ManageexchangeComponent implements OnInit {

  constructor(private stockExchangeService:StockexchangeService,private router:Router) { }
  exchanges:StockExchange[];
  ngOnInit() {
    this.stockExchangeService.getAllStockExchanges().subscribe(data => {
      this.exchanges=data;
    });
}
deleteStockExchange(id:number){
  this.stockExchangeService.deleteStockExchange(id).subscribe(data=>{
  this.exchanges=this.exchanges.filter(exchange => exchange.id!== id);
});
}
updateStockExchange(exchanges:StockExchange)
{
  localStorage.removeItem('exchangeId');
  localStorage.setItem('exchangeId',exchanges.id.toString());
  this.router.navigate(['updatestock']);
}
}

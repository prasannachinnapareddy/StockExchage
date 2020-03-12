import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UploadService 
{
  httpUrl=environment.url+"stock-price/allStockPrices/"
  constructor(private httpClient:HttpClient) 
  {} 

  uploadStockSheet(formData:FormData):Observable<object>{
 return this.httpClient.post<object>(this.httpUrl+"uploadStockSheet",formData);
  }

  getCompanyStockPricesBetween(companyCode: string, stockExchange: string, startDate: Date, endDate: Date,periodicity: string): Observable<any[]> {
    let url = "companyStockPriceBetween/"+companyCode+"/"+stockExchange+"/"+startDate+"/"+endDate+"/"+periodicity;
    return this.httpClient.get<any[]>(this.httpUrl+url);
  }
}

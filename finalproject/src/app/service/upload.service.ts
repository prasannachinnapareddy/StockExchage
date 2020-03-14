import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UploadService 
{
  httpUrl=environment.url+"stock-price-service/allStockPrices/"
  constructor(private httpClient:HttpClient) 
  {} 

  uploadStockSheet(formData:FormData):Observable<object>{
 return this.httpClient.post<object>(this.httpUrl+"uploadStockSheet",formData);
  }

  getCompanyStockPricesBetween(companyCode: string, stockExchangeName: string, startDate: Date, endDate: Date): Observable<any[]> {
    let url = "companyStockPriceBetween/"+companyCode+"/"+stockExchangeName+"/"+startDate+"/"+endDate;
    return this.httpClient.get<any[]>(this.httpUrl+url);
  }
}

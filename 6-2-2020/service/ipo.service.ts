import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Ipo} from '../models/ipo';

@Injectable({
  providedIn: 'root'
})
export class IpoService {
  httpUrl='http://localhost:3000/ipo/';
  ipo:Ipo[];
  constructor(private httpClient:HttpClient) { }
  getAllCompanies():Observable<Ipo[]>
  {
    return this.httpClient.get<Ipo[]>(this.httpUrl);
  }
saveCompany(ipo:Ipo):Observable<Ipo>
  {
    return this.httpClient.post<Ipo>(this.httpUrl,ipo);
  }
  deleteCompany(id:number):Observable<Ipo>
  {
    return this.httpClient.delete<Ipo>(this.httpUrl +id);
  }
 updateCompany(ipo:Ipo):Observable<Ipo>
  {
    return this.httpClient.put<Ipo>(this.httpUrl +ipo.id ,ipo);
  }
  getCompanyById(id:number):Observable<Ipo>
  {
    return this.httpClient.get<Ipo>(this.httpUrl +id);
  }
}

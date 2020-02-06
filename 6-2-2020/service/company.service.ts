import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Company } from '../models/usermock';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  httpUrl='http://localhost:3000/company/';
  company:Company[];
  constructor(private httpClient:HttpClient) { }
  getAllCompanies():Observable<Company[]>
  {
    return this.httpClient.get<Company[]>(this.httpUrl);
  }
saveCompany(company:Company):Observable<Company>
  {
    return this.httpClient.post<Company>(this.httpUrl,company);
  }
  deleteCompany(id:number):Observable<Company>
  {
    return this.httpClient.delete<Company>(this.httpUrl +id);
  }
 updateCompany(company:Company):Observable<Company>
  {
    return this.httpClient.put<Company>(this.httpUrl +company.id ,company);
  }
  getCompanyById(id:number):Observable<Company>
  {
    return this.httpClient.get<Company>(this.httpUrl +id);
  }
}

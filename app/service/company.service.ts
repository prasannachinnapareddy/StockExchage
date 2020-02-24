import { Injectable, Inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Company } from '../models/usermock';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  httpUrl='http://localhost:8080/cmp/';
  company:Company[];
  constructor(private httpClient:HttpClient,@Inject (HttpClient) private ht) { }
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
    return this.ht.delete(`http://localhost:8080/cmp/${id}`);
  }
 updateCompany(company:Company):Observable<Company>
  {
    return this.ht.put(`http://localhost:8080/cmp`,company);
  }
  getCompanyById(id:number):Observable<Company>
  {
    return this.ht.get(`http://localhost:8080/cmp/${id}`);
  }
}

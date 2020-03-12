import { Injectable, Inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Company } from '../models/company';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  httpUrl=environment.url+"company-service/allCompanies/"
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
    return this.ht.delete(this.httpUrl+id);
  }
 updateCompany(company:Company):Observable<Company>
  {
    return this.ht.put(this.httpUrl,company);
  }
  getCompanyById(id:number):Observable<Company>
  {
    return this.ht.get(this.httpUrl+id);
  }
}

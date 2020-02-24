import { Injectable, Inject } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../../app/models/user'
@Injectable({
  providedIn: 'root'
})
export class UserService {

  httpUrl='http://localhost:8080/reg';
  user:User[];
  constructor(private httpClient:HttpClient,@Inject (HttpClient) private ht) { }
  getAllUsers():Observable<User[]>
  {
    return this.httpClient.get<User[]>(this.httpUrl);
  }
saveUser(user:User):Observable<User>
  {
    return this.httpClient.post<User>(this.httpUrl,user);
  }
  deleteUser(id:number):Observable<User>
  {
    return this.ht.delete(`http://localhost:8080/reg/${id}`);
  }
 updateUser(user:User):Observable<User>
  {
    console.log("user service:: "+user.name)
    return this.ht.put(`http://localhost:8080/reg`,user);
  }
  getUserById(id:number):Observable<User>
  {
    return this.ht.get(`http://localhost:8080/reg/${id}`);
  }
}

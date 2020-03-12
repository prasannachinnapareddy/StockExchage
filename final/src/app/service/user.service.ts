import { Injectable, Inject } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../../app/models/user'
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  httpUrl=environment.url + "user-service/registerall/"
  user:User[];
  constructor(private httpClient:HttpClient,@Inject (HttpClient) private ht) { }
  getAllUsers():Observable<User[]>
  {
    return this.httpClient.get<User[]>(this.httpUrl);
  }
saveUser(user:User)
  {
    return this.ht.post(this.httpUrl,user);
  }
  deleteUser(id:number):Observable<User>
  {
    return this.ht.delete(this.httpUrl+id);
  }
 updateUser(user:User):Observable<User>
  {
    console.log("user service:: "+user.name)
    return this.ht.put(this.httpUrl,user);
  }
  serviceActivation(obj){
    return this.ht.put(environment.url+"user-service/activate",obj)
  }
  getUserById(id:number):Observable<User>
  {
    return this.ht.get(this.httpUrl+id);
  }
  LoggedIn(){
    let user_id=localStorage.getItem('userId');
    if(user_id==null)
    return false;
    else return true;
  }
  isActivated(user:User){
    if(user.active==true){
          return true;
    }
  }
}
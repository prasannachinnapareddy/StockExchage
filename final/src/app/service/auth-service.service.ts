import { Injectable } from '@angular/core';
import { UserService } from './user.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { User } from '../models/user';
import { environment } from 'src/environments/environment';

const url=environment.url + "user-service/login";

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  constructor(private userService:UserService,private httpClient:HttpClient) { }

  authenticate(userName:string,password:string)
  {
    //-->Creating security token
    let authenticationToken="Basic " + window.btoa(userName +":"+password);
    console.log(authenticationToken);
    let headers=new HttpHeaders({
      Authorization: authenticationToken
    });
    console.log("calling server");
    //Send the request
    return this.httpClient.get(url,{headers}).pipe(
      map((successData:User) => {
        console.log(successData)
        sessionStorage.setItem("username", userName);
        // save the token
        sessionStorage.setItem("token", authenticationToken);
        sessionStorage.setItem("userType",successData.userType==="ROLE_ADMIN" ? "admin":"user"); 
        return successData;
      }),
      // failure function
      map(failureData => {
        // console message 
        console.log("failure")
        return failureData;
      })
    );
  }
  getAuthenticationToken() {
    if (this.isUserLoggedIn())
      return sessionStorage.getItem("token");
    return null;
  }
  isUserLoggedIn(): boolean {
    let user = sessionStorage.getItem('username');
    if (user == null)
      return false;
    return true;
  }
  logout() {
    sessionStorage.removeItem('username');
    sessionStorage.removeItem("token")
  }
}

import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler } from '@angular/common/http';
import { AuthServiceService } from './auth-service.service';

@Injectable({
  providedIn: 'root'
})
export class HttpInterceptorService implements HttpInterceptor{

  constructor(public authService:AuthServiceService) { }

  intercept(request:HttpRequest<any>,next:HttpHandler)
  {
    console.log("Inside Interceptor");
    if(this.authService.getAuthenticationToken())
    {
      let authenticationToken=this.authService.getAuthenticationToken();
      request=request.clone({
        setHeaders:{
          Authorization:authenticationToken
        }
      });
    }
    return next.handle(request);
  }

}

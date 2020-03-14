// import { Injectable } from '@angular/core';
// import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
// import { Observable } from 'rxjs';
// import { UserService } from './service/user.service';

// @Injectable({
//   providedIn: 'root'
// })
// export class SignInGuard implements CanActivate {
//   constructor(private userService:UserService,private router:Router){}
//   canActivate(
//     next: ActivatedRouteSnapshot,
//     state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
//     if(this.userService.LoggedIn()){
//       return true;}
//       else{
//         this.router.navigate(['/login']);
//         alert("please login");
//         return false;
//       }
//   }
  
// }

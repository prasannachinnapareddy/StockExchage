import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { User } from '../models/user';
import { Router } from '@angular/router';
import { UserService } from '../service/user.service';
import { AuthServiceService } from '../service/auth-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginuser:FormGroup;
  users:User[];
  currentUser:User;
  constructor(private formBuilder:FormBuilder,private router:Router,
    private authService:AuthServiceService,private userService:UserService) { }

  ngOnInit() {
    this.loginuser=this.formBuilder.group({
      username:['',[Validators.required]],
      password:['',[Validators.required]]
    });
    this.userService.getAllUsers().subscribe(u=>{this.users=u;})
  }
  login()
  {
    let username=this.loginuser.controls.username.value;
    let password=this.loginuser.controls.password.value;
    const result$=this.authService.authenticate(username,password);
    result$.subscribe(data=>{
      console.log(data);
      sessionStorage.setItem('userId',data.id.toString());
    if(data.userType=='ROLE_ADMIN'){
      this.router.navigate(['/admin-home-page']);
    }
    else{
      this.router.navigate(['/user-home-page']);
    }
    })
   }
  onSubmit()
  {
    console.log(this.loginuser.value);
  }
}

//   isValid()
//   {
//     let admin_userName="admin";
//     let admin_password="admin";
//     let userName=this.loginuser.controls.username.value;
//     let password=this.loginuser.controls.password.value;
//     if((userName==admin_userName) && (password==admin_password))
//     this.router.navigate(['/admin-home-page']);
//     else{
//       if(this.login(userName,password))
//       {
//         if(this.userService.isActivated(this.currentUser))
//         {
//           localStorage.removeItem('userId');
//           localStorage.setItem('userid',this.currentUser.id.toString());
//           this.router.navigate(['/user-home-page']);
//         }
//         else
//         alert('Please Activate your account and logun');
//         this.loginuser.reset();
//       }
//       else
//       {
//         alert('Invalid UserName and Password');
//         this.loginuser.reset();
//       }
//     }
//   }
//   // login(userName:string,password:string){
//   //   for(let user of this.users){
//   //     if((userName===user.username)&&(password===user.password)){
//   //       this.currentUser=user;
//   //       return true;
//   //     }
//   //   }
//   //   return false;
//   // }
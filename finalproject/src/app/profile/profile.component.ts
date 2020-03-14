import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';
import { AuthServiceService } from '../service/auth-service.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user:User;
  constructor(private userService:UserService,private router:Router) { }
  ngOnInit() {
    const id = sessionStorage.getItem('userId');
    if(+id >0 ){
    this.userService.getUserById(+id).subscribe(data =>{
      this.user=data;
    });
  }
  }
  updateUser(){
    this.router.navigate(['/update-profile']);
  }
}
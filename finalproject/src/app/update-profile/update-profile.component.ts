import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { User } from '../models/user';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.css']
})
export class UpdateProfileComponent implements OnInit {

  updateUserProfile: FormGroup;
  user:User;
  constructor(private formBuilder:FormBuilder,private userService:UserService,
    private router: Router){ }
  ngOnInit() {
    this.updateUserProfile = this.formBuilder.group({
      id: [''],
      name: ['',Validators.required],
      email:['',[Validators.required,Validators.email]],
      username:['',Validators.required],
      password:['',Validators.required],
      repeatpassword:['',Validators.required],
      active:['']
    });
    const id = sessionStorage.getItem('userId');
    if(+id)
    {
    this.userService.getUserById(+id).subscribe(user => {
      this.updateUserProfile.patchValue(user);
    });
    }
  }
  updateTheUser(user: User){
    this.userService.updateUser(this.updateUserProfile.value).subscribe(u=>{
      this.router.navigate(['profile']);
    });
  }
}



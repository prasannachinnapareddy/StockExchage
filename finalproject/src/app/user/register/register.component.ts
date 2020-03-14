import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserService } from 'src/app/service/user.service';
import { User } from 'src/app/models/user';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  user:FormGroup;
  users:User[];
  constructor(private formBuilder:FormBuilder, private userService:UserService) { }

  ngOnInit() {
    this.user=this.formBuilder.group({
      id:[''],
      name:['',[Validators.required]],
      username:['',[Validators.required]],
      email:['',[Validators.required,Validators.email]],
      password:['',Validators.required],
      repeatpassword:['',Validators.required]
    });
    this.userService.getAllUsers().subscribe(u=>{this.users=u;})
  }

  
  addUser()
  {
    let e=this.user.controls.email.value;
    if(this.emailValid(e)){
    this.userService.saveUser(this.user.value).subscribe
    (data => {
      alert('User Inserted Successfully' +data);
      this.user.reset()
    });}
    else
    {
      alert('Email Exist...');
      this.user.reset()
    }
  }

  emailValid(e:String)
  {
    for(let user of this.users)
    {
      if(user.email==e)
      return false;
    }
    return true;
  }

  
  onSubmit()
  {
    console.log(this.user.value);
  }
}

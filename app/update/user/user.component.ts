import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserService } from 'src/app/service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  updateuser:FormGroup;
  constructor(private formBuilder:FormBuilder, private userService:UserService,private router:Router) { }

  ngOnInit() {
    this.updateuser=this.formBuilder.group({
      id:['',[Validators.required]],
      name:['',[Validators.required]],
      email:['',[Validators.required,Validators.email]],
      psw:['',Validators.required],
      rpsw:['',Validators.required]
    });
  const id = localStorage.getItem('userId');
  if (+id > 0) {
    this.userService.getUserById(+id).subscribe(User => {
      this.updateuser.patchValue(User);
    });
  }
}
updateUser() {
  console.log("uodate user");
  this.userService.updateUser(this.updateuser.value).subscribe(data => {
    this.router.navigate(['users']);
  },
    error => {
      alert(error);
    });
}
}
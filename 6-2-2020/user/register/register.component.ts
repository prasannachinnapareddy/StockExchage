import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserService } from 'src/app/service/user.service';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  user:FormGroup;
  constructor(private formBuilder:FormBuilder, private userService:UserService) { }

  ngOnInit() {
    this.user=this.formBuilder.group({
      id:['',[Validators.required]],
      name:['',[Validators.required]],
      email:['',[Validators.required,Validators.email]],
      psw:['',Validators.required],
      repeat:['',Validators.required]
    });
  }
  addUser()
  {
    this.userService.saveUser(this.user.value).subscribe
    (data => {
      console.log('User Inserted Successfully' +data);
    });
  }
  
  onSubmit()
  {
    console.log(this.user.value);
  }
}

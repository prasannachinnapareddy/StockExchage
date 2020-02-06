import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginuser:FormGroup;
  constructor(private formBuilder:FormBuilder) { }

  ngOnInit() {
    this.loginuser=this.formBuilder.group({
      uname:['',[Validators.required]],
      psw:['',[Validators.required]]
    });
  }
  
  onSubmit()
  {
    console.log(this.loginuser.value);
  }
}

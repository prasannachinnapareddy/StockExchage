import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-manageexchange',
  templateUrl: './manageexchange.component.html',
  styleUrls: ['./manageexchange.component.css']
})
export class ManageexchangeComponent implements OnInit {

  exchange:FormGroup;
  constructor(private formBuilder:FormBuilder, private userService:UserService) { }

  ngOnInit() {
    this.exchange=this.formBuilder.group({
      id:['',[Validators.required]],
     se:['',[Validators.required]],
    breif:['',[Validators.required]],
    address:['',Validators.required]
    });
  }
  onSubmit()
  {
    console.log(this.exchange.value);
  }
}

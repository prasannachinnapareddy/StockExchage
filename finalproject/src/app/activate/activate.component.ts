import { Component, OnInit, Inject } from '@angular/core';
import { UserService } from '../service/user.service';
import { User } from '../models/user';

@Component({
  selector: 'app-activate',
  templateUrl: './activate.component.html',
  styleUrls: ['./activate.component.css']
})
export class ActivateComponent implements OnInit {
    msg;
    user:User;
    constructor(@Inject(UserService) private service) { }
    ngOnInit() {
      this.checkActivation()
    }
    checkActivation(){
      var urlad = document.URL
      var strarr = urlad.split("?")
      var str = strarr[1]
      str = str.substring(0, str.length-1);
      this.service.serviceActivation({email:str}).subscribe(data => {
        if(data.status="ok"){
          this.user.active=true;
          this.msg="activation successfull"
        }
        else{
          this.msg="already activated"
        }
      });
    }
  }
  
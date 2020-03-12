import { Component, OnInit, OnChanges } from '@angular/core';
import { User } from './models/user';
import { AuthServiceService } from './service/auth-service.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  userLoggedIn:boolean=false;
  constructor(private authService:AuthServiceService)
  {}

  ngDoCheck()
  {
    this.userLoggedIn=this.authService.isUserLoggedIn();
  }

}

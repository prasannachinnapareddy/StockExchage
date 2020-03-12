import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthServiceService } from '../service/auth-service.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private router:Router,private authService:AuthServiceService) { }

  ngOnInit() 
  {
    this.authService.logout();
    //sessionStorage.removeItem('username');
    alert('Logged Out Successfully');
    this.router.navigate(['/login']);
  }

}

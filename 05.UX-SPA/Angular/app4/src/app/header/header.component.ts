import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  title:string;
  isLoggedIn:boolean;

  constructor(private authService:AuthService,private router:Router){
    this.title="Income Statement";
    this.isLoggedIn=false;
  }

  ngOnInit(): void {
    this.authService.getLoginObservable().subscribe({
      next: booleanFlag => this.isLoggedIn=booleanFlag
    })
  }

  logout(){
    this.authService.logout();
    this.router.navigateByUrl("/");
  }
}

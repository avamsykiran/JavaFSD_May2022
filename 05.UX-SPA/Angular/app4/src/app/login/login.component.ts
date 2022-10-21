import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userName!:string;
  password!:string;
  errMsg!:string;

  constructor(private authService:AuthService,private router:Router) {

  }

  ngOnInit(): void {
  }

  login(){
    this.authService.login(this.userName,this.password).subscribe({
      next: approved => this.router.navigateByUrl("/statement"),
      error: err => {console.log(err); this.errMsg=err.message;}
    });
  }
}

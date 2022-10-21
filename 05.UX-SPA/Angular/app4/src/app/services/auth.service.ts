import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { JwtToken } from '../models/jwt-token';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  apiUrl:string;

  constructor(private httpClient:HttpClient) {
    this.apiUrl="http://localhost:8888/login"
  }

  login(userName:string,password:string) : Observable<boolean>{
    return this.httpClient.post<JwtToken>(this.apiUrl,{userName,password}).pipe(
      map( jwtToken =>{
        sessionStorage.setItem("unm",userName);
        sessionStorage.setItem("token",jwtToken.token);
        return true;
      })
    );
  }

  isLoggedIn(){
    return sessionStorage.getItem("unm")!=undefined || sessionStorage.getItem("unm")!=null;
  }

  getUserName():string|null{
    return sessionStorage.getItem("unm");
  }

  getToken():string|null{
    return sessionStorage.getItem("token");
  }

  logout(){
    sessionStorage.clear();
  }
}

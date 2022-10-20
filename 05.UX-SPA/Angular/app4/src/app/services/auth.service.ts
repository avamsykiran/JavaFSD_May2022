import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }

  login(userName:string,password:string) : Observable<boolean>{
    sessionStorage.setItem("unm",userName);
    return new Observable<boolean>();
  }

  isLoggedIn(){
    return sessionStorage.getItem("unm")!=undefined || sessionStorage.getItem("unm")!=null;
  }

  logout(){
    sessionStorage.clear();
  }
}

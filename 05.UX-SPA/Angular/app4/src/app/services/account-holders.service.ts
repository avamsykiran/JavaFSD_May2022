import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AccountHolder } from '../models/account-holder';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AccountHoldersService {

  apiUrl:string;

  constructor(private httpClient:HttpClient,private authService:AuthService) {
    this.apiUrl="http://localhost:8888/accounts"
  }

  getAllAccounts():Observable<AccountHolder[]>{
    return this.httpClient.get<AccountHolder[]>(this.apiUrl);
  }

  getAccountById(ahId:number):Observable<AccountHolder>{
    return this.httpClient.get<AccountHolder>(`${this.apiUrl}/${ahId}`);
  }

  getAccountByUserName():Observable<AccountHolder>{
    let userName = this.authService.getUserName();
    return this.httpClient.get<AccountHolder>(`${this.apiUrl}/userName/${userName}`);
  }

  addAccount(ah:AccountHolder):Observable<AccountHolder>{
    return this.httpClient.post<AccountHolder>(this.apiUrl,ah);
  }

  updateAccount(ah:AccountHolder):Observable<AccountHolder>{
    return this.httpClient.put<AccountHolder>(this.apiUrl,ah);
  }
}

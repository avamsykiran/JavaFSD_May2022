import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TxnService {
  apiUrl:string;

  constructor(private httpClient:HttpClient) {
    this.apiUrl="http://localhost:8888/txns"
  }
}

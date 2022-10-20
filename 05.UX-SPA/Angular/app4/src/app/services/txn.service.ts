import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Txn } from '../models/txn';

@Injectable({
  providedIn: 'root'
})
export class TxnService {
  apiUrl:string;

  constructor(private httpClient:HttpClient) {
    this.apiUrl="http://localhost:8888/txns"
  }

  getAllTxnsByAccount(ahId:number):Observable<Txn[]>{
    return this.httpClient.get<Txn[]>(`${this.apiUrl}/byAccount/${ahId}`);
  }

  getTxnsById(txnId:number):Observable<Txn>{
    return this.httpClient.get<Txn>(`${this.apiUrl}/${txnId}`);
  }

  deleteTxnsById(txnId:number):Observable<void>{
    return this.httpClient.delete<void>(`${this.apiUrl}/${txnId}`);
  }

  addTxn(txn:Txn):Observable<Txn>{
    return this.httpClient.post<Txn>(this.apiUrl,txn);
  }

  updateTxn(txn:Txn):Observable<Txn>{
    return this.httpClient.put<Txn>(this.apiUrl,txn);
  }
}

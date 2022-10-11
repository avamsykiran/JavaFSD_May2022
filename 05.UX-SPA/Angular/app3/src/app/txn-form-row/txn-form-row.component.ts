import { Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges } from '@angular/core';
import { Txn } from '../models/txn';

@Component({
  selector: 'app-txn-form-row',
  templateUrl: './txn-form-row.component.html',
  styleUrls: ['./txn-form-row.component.css']
})
export class TxnFormRowComponent implements OnInit,OnChanges {

  @Input()
  txn:Txn;

  txnDate:string;

  @Output()
  formSubmitted:EventEmitter<Txn>;

  @Output()
  cancelBtnClicked:EventEmitter<number>;

  constructor() {
    this.txn={txnId:0,desp:'',amount:0,txnDate:new Date(),type:"CREDIT"};
    this.txnDate=new Date().toISOString().substring(0,10);
    this.formSubmitted=new EventEmitter<Txn>();
    this.cancelBtnClicked=new EventEmitter<number>();
  }

  ngOnInit(): void {
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.txnDate= new Date(this.txn.txnDate).toISOString().substring(0,10);
  }

  raiseFormSubmitted(){
    this.txn.txnDate=new Date(this.txnDate);
    this.formSubmitted.emit(this.txn);
    if(this.txn.txnId==0){
      this.txn={txnId:0,desp:'',amount:0,txnDate:new Date(),type:"CREDIT"};
    }
  }

  raiseCancelBtnClicked(){
    if(this.txn.txnId==0){
      this.txn={txnId:0,desp:'',amount:0,txnDate:new Date(),type:"CREDIT"};
    }else{
      this.cancelBtnClicked.emit(this.txn.txnId);
    }
  }

  changeType(type:string){
    this.txn.type=type;
  }
}

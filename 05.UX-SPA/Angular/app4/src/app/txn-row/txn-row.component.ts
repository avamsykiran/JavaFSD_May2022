import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Txn } from '../models/txn';

@Component({
  selector: 'app-txn-row',
  templateUrl: './txn-row.component.html',
  styleUrls: ['./txn-row.component.css']
})
export class TxnRowComponent implements OnInit {

  @Input()
  txn!:Txn;

  @Output()
  editBtnClicked:EventEmitter<number>;
  
  @Output()
  deleteBtnClicked:EventEmitter<number>;

  constructor() {
    this.editBtnClicked=new EventEmitter<number>();
    this.deleteBtnClicked=new EventEmitter<number>();
  }

  ngOnInit(): void {
  }

  raiseEditEvent(){
    this.editBtnClicked.emit(this.txn.txnId);
  }

  raiseDeleteEvent(){
    this.deleteBtnClicked.emit(this.txn.txnId);
  }
}

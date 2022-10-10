import { Component, Input, OnInit } from '@angular/core';
import { Txn } from '../models/txn';

@Component({
  selector: 'app-txn-row',
  templateUrl: './txn-row.component.html',
  styleUrls: ['./txn-row.component.css']
})
export class TxnRowComponent implements OnInit {

  @Input()
  txn!:Txn;

  constructor() { }

  ngOnInit(): void {
  }

}

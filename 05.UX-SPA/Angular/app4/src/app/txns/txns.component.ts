import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AccountHolder } from '../models/account-holder';
import { Txn } from '../models/txn';
import { AccountHoldersService } from '../services/account-holders.service';
import { AuthService } from '../services/auth.service';
import { TxnService } from '../services/txn.service';

@Component({
  selector: 'app-txns',
  templateUrl: './txns.component.html',
  styleUrls: ['./txns.component.css']
})
export class TxnsComponent implements OnInit {

  account!: AccountHolder;
  txns!: Txn[];
  errMsg!: string;

  constructor(private txnService: TxnService, private ahService: AccountHoldersService, 
    private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.loadAccountDetails();
  }

  loadAccountDetails() {
    this.ahService.getAccountByUserName().subscribe({
      next: account => { this.account = account; this.loadTxns(); },
      error: err => { console.log(err); this.errMsg = "Unable to load account detials!"; }
    })
  }

  loadTxns() {
    this.txnService.getAllTxnsByAccount(this.account.ahId).subscribe({
      next: txns => this.txns = txns,
      error: err => { console.log(err); this.errMsg = "Unable to load transactions!"; }
    })
  }

  addTxn(txn: Txn) {
    txn.holder = this.account;
    this.txnService.addTxn(txn).subscribe({
      next: data => this.loadTxns(),
      error: err => { console.log(err); this.errMsg = "Unable to save transaction!"; }
    })
  }

  updateTxn(txn: Txn) {
    txn.holder = this.account;
    txn.editable = undefined;
    this.txnService.updateTxn(txn).subscribe({
      next: data => this.loadTxns(),
      error: err => { console.log(err); this.errMsg = "Unable to save transaction!"; }
    })
  }

  deleteTxn(txnId: number) {
    this.txnService.deleteTxnsById(txnId).subscribe({
      next: () => this.loadTxns(),
      error: err => { console.log(err); this.errMsg = "Unable to delete transaction!"; }
    })
  }

  markEditable(txnId: number) {
    let index = this.txns.findIndex(t => t.txnId == txnId);
    this.txns[index].editable = true;
  }

  unMarkEditable(txnId: number) {
    let index = this.txns.findIndex(t => t.txnId == txnId);
    this.txns[index].editable = undefined;
  }
}

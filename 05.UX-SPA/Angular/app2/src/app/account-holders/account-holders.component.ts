import { Component, OnInit } from '@angular/core';
import { AccountHolder } from '../models/account-holder';
import { AccountHoldersService } from '../services/account-holders.service';

@Component({
  selector: 'app-account-holders',
  templateUrl: './account-holders.component.html',
  styleUrls: ['./account-holders.component.css']
})
export class AccountHoldersComponent implements OnInit {

  accounts!:AccountHolder[];
  errMsg!:string;

  constructor(private ahs:AccountHoldersService) { }

  ngOnInit(): void {
    this.loadData();
  }

  loadData(){
    let ob = this.ahs.getAllAccounts();

    ob.subscribe({
      next: data => this.accounts=data,
      error: err => {console.error(err); this.errMsg="Unable to load data, Please retry later!";}
    });
  }
}

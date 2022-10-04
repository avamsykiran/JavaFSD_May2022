import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AccountHolder } from '../models/account-holder';
import { AccountHoldersService } from '../services/account-holders.service';

@Component({
  selector: 'app-account-holder-form',
  templateUrl: './account-holder-form.component.html',
  styleUrls: ['./account-holder-form.component.css']
})
export class AccountHolderFormComponent implements OnInit {

  account:AccountHolder;
  errMsg!:string;
  isNew:boolean;

  constructor(private ahs:AccountHoldersService,private router:Router,private activatedRoute:ActivatedRoute) {
    this.account={ahId:0,fullName:'',mobile:'',mailId:'',currentBalance:0};
    this.isNew=true;
  }

  ngOnInit(): void {
    let ahId = this.activatedRoute.snapshot.params["ahId"];

    if(ahId){
      this.isNew=false;
      this.ahs.getAccountById(ahId).subscribe({
        next: data => this.account=data,
        error: err => {console.error(err);this.errMsg="Unable to load record!";}
      })
    }
  }

  save(){
    let ob = null;

    if(this.isNew){
      ob = this.ahs.addAccount(this.account);
    }else{
      ob = this.ahs.updateAccount(this.account);
    }

    ob.subscribe({
      next: data => this.router.navigateByUrl("/accounts"),
      error: err => {console.error(err);this.errMsg="Unable to save record!";}
    })
  }
}

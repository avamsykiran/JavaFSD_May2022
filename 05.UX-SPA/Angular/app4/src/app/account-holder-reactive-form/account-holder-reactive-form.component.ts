import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AccountHoldersService } from '../services/account-holders.service';

@Component({
  selector: 'app-account-holder-reactive-form',
  templateUrl: './account-holder-reactive-form.component.html',
  styleUrls: ['./account-holder-reactive-form.component.css']
})
export class AccountHolderReactiveFormComponent implements OnInit {

  
  ahIdFC:FormControl;
  fnm:FormControl;
  mob:FormControl;
  mid:FormControl;

  ahForm:FormGroup;

  errMsg!:string;
  isNew:boolean;

  constructor(private ahs:AccountHoldersService,private router:Router,private activatedRoute:ActivatedRoute) {
    this.ahIdFC = new FormControl(0);
    this.fnm= new FormControl("",[Validators.required]);
    this.mob=new FormControl("",[Validators.required,Validators.pattern("[1-9][0-9]{9}")]);
    this.mid=new FormControl("",[Validators.required,Validators.email]);

    this.ahForm=new FormGroup({ahId:this.ahIdFC,fullName:this.fnm,mobile:this.mob,mailId:this.mid,currentBalance:new FormControl(0)});
    this.isNew=true;
  }

  ngOnInit(): void {
    let ahId = this.activatedRoute.snapshot.params["ahId"];

    if(ahId){
      this.isNew=false;
      this.ahs.getAccountById(ahId).subscribe({
        next: data => this.ahForm.setValue(data),
        error: err => {console.error(err);this.errMsg="Unable to load record!";}
      })
    }
  }

  save(){
    let ob = null;

    if(this.isNew){
      ob = this.ahs.addAccount(this.ahForm.value);
    }else{
      ob = this.ahs.updateAccount(this.ahForm.value);
    }

    ob.subscribe({
      next: data => this.router.navigateByUrl("/accounts"),
      error: err => {console.error(err);this.errMsg="Unable to save record!";}
    })
  }

}

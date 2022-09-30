import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-friends',
  templateUrl: './friends.component.html',
  styleUrls: ['./friends.component.css']
})
export class FriendsComponent implements OnInit {

  friends:string[];
  friend:string;

  constructor() {
    this.friends=[];
    this.friend="";
  }

  ngOnInit(): void {
  }

  add(){
    this.friends.push(this.friend);
    this.friend="";
  }
}

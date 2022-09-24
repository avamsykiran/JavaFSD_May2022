import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  userName:string;

  constructor() {
    this.userName="Vamsy Kiran";
  }

  ngOnInit(): void {
  }

}

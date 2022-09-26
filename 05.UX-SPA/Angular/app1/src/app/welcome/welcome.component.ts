import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  userName:string;
  logos:string[];
  logoIndex:number;
  logoWidth:number;

  isBorderApplied:boolean;
  isCenterApplied:boolean;

  constructor() {
    this.userName="Vamsy Kiran";
    this.logoIndex=0;
    this.logoWidth=250;
    this.logos=[
      "assets/imgs/namaskar1.jpg",
      "assets/imgs/namaskar2.jpg",
      "assets/imgs/namaskar3.jpg",
      "assets/imgs/namaskar4.jpg"
    ];
    this.isBorderApplied=true;
    this.isCenterApplied=true;
  }

  ngOnInit(): void {
  }

  toggle(){
    this.logoIndex++;
    if(this.logoIndex===this.logos.length){
      this.logoIndex=0;
    }
  }

}

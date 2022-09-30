import { Component, OnInit } from '@angular/core';
import { NumberSeriesService } from '../services/number-series.service';

@Component({
  selector: 'app-number-series',
  templateUrl: './number-series.component.html',
  styleUrls: ['./number-series.component.css']
})
export class NumberSeriesComponent implements OnInit {

  lb:number;
  ub:number;

  results!:number[];
  errMsg!:string|null;
  didJobStart!:boolean;

  constructor(private nss:NumberSeriesService) {
    this.lb=0;
    this.ub=0;
  }

  ngOnInit(): void {
  }

  start(){
    this.results=[];
    this.errMsg=null;
    this.didJobStart=true;

    let ob = this.nss.generateSeries(this.lb,this.ub);

    ob.subscribe({
      next: val => this.results.push(val),
      error: errMsg => { this.errMsg=errMsg; this.didJobStart=false; },
      complete: () => this.didJobStart=false
    })
  }
}

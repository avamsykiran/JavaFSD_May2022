import { Injectable } from '@angular/core';
import { Observable, Observer } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NumberSeriesService {

  constructor() { }

  generateSeries(lb:number,ub:number):Observable<number>{
    const job = (observer:Observer<number>) => {

      if(lb>ub) {
        observer.error("Invalid boundaries");
        return;
      }

      let value = lb;

      let handler = setInterval(() => {
        observer.next(value);
        value++;
        if(value>ub){
          clearInterval(handler);
          observer.complete();
        }
      },500);

    };
    return new Observable(job);
  }
}

import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ArthService {

  constructor() { }

  sum(a:number,b:number):number{
    return a+b;
  }
  diff(a:number,b:number):number{
    return a-b;
  }
  prod(a:number,b:number):number{
    return a*b;
  }
  qut(a:number,b:number):number{
    return a/b;
  }
  rem(a:number,b:number):number{
    return a%b;
  }
}

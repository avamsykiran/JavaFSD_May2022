import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'inWords'
})
export class InWordsPipe implements PipeTransform {

  transform(value: number): string {
    let digits = ["ZERO","ONE"]
    return value>=0 && value<=9 ? digits[value]:"unknown";
  }

}

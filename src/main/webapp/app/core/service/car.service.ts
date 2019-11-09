import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { delay} from 'rxjs/operators';
import { ListCar } from '../data-fake/car';

@Injectable()
export class CarService {
  constructor() {}

  // Method: Get list Worker Wages
  getListCar(param?): Observable<any> {
    const fakeObservable = of(ListCar).pipe(delay(1000));
    return fakeObservable;
  }
}

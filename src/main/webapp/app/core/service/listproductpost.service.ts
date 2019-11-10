import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { delay } from 'rxjs/operators';
import { ListProductPost } from '../data-fake/listproductpost';

@Injectable()
export class ListProductPostService {
  constructor() {}

  // Method: Get list ProducPost
  getListProductPost(param?): Observable<any> {
    const fakeObservable = of(ListProductPost).pipe(delay(500));
    return fakeObservable;
  }
}

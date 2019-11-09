import { ListNews, DetaiNew } from './../data-fake/news';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { delay } from 'rxjs/operators';

@Injectable()
export class NewsService {
  constructor() {}

  // Method: Get list Worker Wages
  getListNews(param?): Observable<any> {
    const fakeObservable = of(ListNews).pipe(delay(1000));
    return fakeObservable;
  }
  // Method: Get list Worker Wages
  getDetailNews(param?): Observable<any> {
    const fakeObservable = of(DetaiNew).pipe(delay(1000));
    return fakeObservable;
  }
}

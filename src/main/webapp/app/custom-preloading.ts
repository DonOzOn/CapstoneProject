import { Observable, of } from 'rxjs';
// import {of} from 'rxjs/add/observable/of';
import { Injectable } from '@angular/core';
import { PreloadingStrategy, Route } from '@angular/router';

@Injectable()
export class CustomPreloadingStrategy implements PreloadingStrategy {
  preloadedModules: string[] = [];

  preload(route: Route, load: () => Observable<any>): Observable<any> {
    if (route.data && route.data[' preload ']) {
      this.preloadedModules.push(route.path);
      return load();
    } else {
      return of(null);
    }
  }
}
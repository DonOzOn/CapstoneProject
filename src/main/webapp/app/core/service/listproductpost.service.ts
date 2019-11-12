import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { CommonService } from './common.service';
import { serviceAPI } from '../constants/service-api';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class ListProductPostService {
  constructor(private commonService: CommonService, private http: HttpClient) {}

  // Method: Get list ProducPost
  getListProductPost(param?): Observable<any> {
    const api = this.commonService.buildAPIUrl(serviceAPI.productPost.getListProductPost);
    console.log(api);
    return this.http.get(api, { observe: 'response' });
  }
}

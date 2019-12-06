import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { SERVER_API_URL } from 'app/app.constants';
import { IDirecHouse } from './model/direcHouse.model';
// import { createRequestOption } from 'app/shared/util/request-util';
@Injectable({
  providedIn: 'root'
})
export class ParService {
  public resourceUrl = SERVER_API_URL + 'api/fengshui';
  constructor(private http: HttpClient, private alertService: JhiAlertService) {}
  findman(yearitem: any): Observable<IDirecHouse> {
    return this.http.get<any>(`${this.resourceUrl}/man/${yearitem}`);
  }
  findwoman(yearitem: any): Observable<IDirecHouse> {
    return this.http.get<any>(`${this.resourceUrl}/woman/${yearitem}`);
  }
}

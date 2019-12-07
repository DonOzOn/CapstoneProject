import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SERVER_API_URL } from 'app/app.constants';
import { tap } from 'rxjs/operators';
import { JhiAlertService } from 'ng-jhipster';
import { INotification } from './notification.model';
import { createRequestOption } from 'app/shared/util/request-util';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {
  public noTiResourceUrl = SERVER_API_URL + 'api/notification';
  public resourceUrl2 = SERVER_API_URL + 'api/sendTopic';
  public resourceUrlToUser = SERVER_API_URL + 'api/sendTopicToUser';
  formData: INotification[];

  constructor(private http: HttpClient, private alertService: JhiAlertService) {}

  sendMessage(token: any, title: any, content: any, type: any): Observable<HttpResponse<INotification[]>> {
    const param = {
      token,
      title,
      content,
      type
    };
    return this.http.get<INotification[]>(`${this.resourceUrl2}`, { params: param, observe: 'response' });
  }

  sendMessageAndAddNoti(noti: INotification): Observable<HttpResponse<INotification>> {
    return this.http.post<INotification>(`${this.resourceUrl2}`, noti, { observe: 'response' });
  }

  sendMessageToUser(noti: INotification): Observable<HttpResponse<any>> {
    return this.http.post<any>(`${this.resourceUrlToUser}`, noti, { observe: 'response' });
  }

  getListNoti(reg?: any): Observable<HttpResponse<INotification[]>> {
    const options = createRequestOption(reg);
    this.http
      .get(this.noTiResourceUrl)
      .toPromise()
      .then(res => {
        this.formData = res as INotification[];
      });
    return this.http.get<INotification[]>(this.noTiResourceUrl, { params: options, observe: 'response' });
  }

  getListNotiByStatus(reg?: any): Observable<HttpResponse<INotification[]>> {
    const options = createRequestOption(reg);
    this.http
      .get(this.noTiResourceUrl)
      .toPromise()
      .then(res => {
        this.formData = res as INotification[];
      });
    return this.http.get<INotification[]>(`${this.noTiResourceUrl}/status`, { params: options, observe: 'response' });
  }

  create(noti: INotification): Observable<HttpResponse<INotification>> {
    return this.http.post<INotification>(this.noTiResourceUrl, noti, { observe: 'response' });
  }

  toggleStatus(id): Observable<HttpResponse<INotification>> {
    return this.http.put(`${this.noTiResourceUrl}/${id}/toggle-status`, { observe: 'response' }).pipe(
      tap((response: HttpResponse<INotification>) => {
        if (response.ok) {
          // const g = response.body;
          this.alertService.success('Cập nhật thành công post #', null, null);
        }
      })
    );
  }

  find(id: any): Observable<INotification> {
    return this.http.get<INotification>(`${this.noTiResourceUrl}/${id}`);
  }

  searchbyDate(fromDate: any, toDate: any): Observable<HttpResponse<INotification[]>> {
    const param = {
      from: fromDate,
      to: toDate
    };
    return this.http.get<INotification[]>(`${this.noTiResourceUrl}/search-by-date`, { params: param, observe: 'response' });
  }

  update(news: INotification): Observable<INotification> {
    return this.http.put<INotification>(this.noTiResourceUrl, news);
  }

  delete(id: any): Observable<HttpResponse<any>> {
    return this.http.delete<HttpResponse<any>>(`${this.noTiResourceUrl}/${id}`, { observe: 'response' });
  }
}

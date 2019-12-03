import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SERVER_API_URL } from 'app/app.constants';
import { tap } from 'rxjs/operators';
import { JhiAlertService } from 'ng-jhipster';
import { INotification } from './notification.model';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {
  public newsResourceUrl = SERVER_API_URL + 'api/notification';
  public resourceUrl2 = SERVER_API_URL + 'api/sendTopic';

  constructor(private http: HttpClient, private alertService: JhiAlertService) {}

  sendMessage(token: any): Observable<HttpResponse<INotification[]>> {
    const param = {
      token
    };
    return this.http.get<INotification[]>(`${this.resourceUrl2}`, { params: param, observe: 'response' });
  }

  getListNoti(): Observable<HttpResponse<INotification[]>> {
    return this.http.get<INotification[]>(this.newsResourceUrl, { observe: 'response' });
  }

  create(noti: INotification): Observable<HttpResponse<INotification>> {
    return this.http.post<INotification>(this.newsResourceUrl, noti, { observe: 'response' }).pipe(
      tap((response: HttpResponse<INotification>) => {
        if (response.ok) {
          this.alertService.success('Tạo thành công bài đăng', null, null);
        }
      })
    );
  }

  toggleStatus(id): Observable<HttpResponse<INotification>> {
    return this.http.put(`${this.newsResourceUrl}/${id}/toggle-status`, { observe: 'response' }).pipe(
      tap((response: HttpResponse<INotification>) => {
        if (response.ok) {
          // const g = response.body;
          this.alertService.success('Cập nhật thành công post #', null, null);
        }
      })
    );
  }

  find(id: any): Observable<INotification> {
    return this.http.get<INotification>(`${this.newsResourceUrl}/${id}`);
  }

  searchbyDate(fromDate: any, toDate: any): Observable<HttpResponse<INotification[]>> {
    const param = {
      from: fromDate,
      to: toDate
    };
    return this.http.get<INotification[]>(`${this.newsResourceUrl}/search-by-date`, { params: param, observe: 'response' });
  }

  update(news: INotification): Observable<INotification> {
    return this.http.put<INotification>(this.newsResourceUrl, news);
  }

  delete(id: any): Observable<HttpResponse<any>> {
    return this.http.delete(`${this.newsResourceUrl}/${id}`, { observe: 'response' });
  }
}

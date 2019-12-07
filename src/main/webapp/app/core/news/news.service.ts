import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SERVER_API_URL } from 'app/app.constants';
import { INews } from './news.model';
import { tap } from 'rxjs/operators';
import { JhiAlertService } from 'ng-jhipster';

@Injectable({
  providedIn: 'root'
})
export class NewsService {
  public newsResourceUrl = SERVER_API_URL + 'api/news';
  constructor(private http: HttpClient, private alertService: JhiAlertService) {}

  getListNews(): Observable<HttpResponse<INews[]>> {
    return this.http.get<INews[]>(this.newsResourceUrl, { observe: 'response' });
  }

  create(news: INews): Observable<HttpResponse<INews>> {
    return this.http.post<INews>(this.newsResourceUrl, news, { observe: 'response' }).pipe(
      tap((response: HttpResponse<INews>) => {
        if (response.ok) {
          this.alertService.success('Tạo thành công bài đăng', null, null);
        }
      })
    );
  }

  toggleStatus(id): Observable<HttpResponse<INews>> {
    return this.http.put(`${this.newsResourceUrl}/${id}/toggle-status`, { observe: 'response' }).pipe(
      tap((response: HttpResponse<INews>) => {
        if (response.ok) {
          // const g = response.body;
          this.alertService.success('Cập nhật thành công post #', null, null);
        }
      })
    );
  }
  find(id: any): Observable<INews> {
    return this.http.get<INews>(`${this.newsResourceUrl}/${id}`);
  }
  searchbyDate(fromDate: any, toDate: any): Observable<HttpResponse<INews[]>> {
    const param = {
      from: fromDate,
      to: toDate
    };
    return this.http.get<INews[]>(`${this.newsResourceUrl}/search-by-date`, { params: param, observe: 'response' });
  }

  update(news: INews): Observable<INews> {
    return this.http.put<INews>(this.newsResourceUrl, news);
  }

  delete(id: any): Observable<HttpResponse<any>> {
    return this.http.delete(`${this.newsResourceUrl}/${id}`, { observe: 'response' });
  }
}

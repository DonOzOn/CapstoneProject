import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SERVER_API_URL } from 'app/app.constants';
import { tap } from 'rxjs/operators';
import { JhiAlertService } from 'ng-jhipster';
import { IReview } from './review.model';
import { createRequestOption } from 'app/shared/util/request-util';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {
  public newsResourceUrl = SERVER_API_URL + 'api/review';
  formData: IReview[];
  constructor(private http: HttpClient, private alertService: JhiAlertService) {}

  getListReview(req?: any): Observable<HttpResponse<IReview[]>> {
    // eslint-disable-next-line @typescript-eslint/no-unused-vars
    const options = createRequestOption(req);
    this.http
      .get(this.newsResourceUrl)
      .toPromise()
      .then(res => {
        this.formData = res as IReview[];
      });
    return this.http.get<IReview[]>(this.newsResourceUrl, { params: options, observe: 'response' });
  }

  create(review: IReview): Observable<HttpResponse<IReview>> {
    return this.http.post<IReview>(this.newsResourceUrl, review, { observe: 'response' }).pipe(
      tap((response: HttpResponse<IReview>) => {
        if (response.ok) {
          this.alertService.success('Tạo thành công bài đăng', null, null);
        }
      })
    );
  }

  toggleStatus(id): Observable<HttpResponse<IReview>> {
    return this.http.put(`${this.newsResourceUrl}/${id}/toggle-status`, { observe: 'response' }).pipe(
      tap((response: HttpResponse<IReview>) => {
        if (response.ok) {
          // const g = response.body;
          this.alertService.success('Cập nhật thành công post #', null, null);
        }
      })
    );
  }

  listAllByUserID(req?: any): Observable<HttpResponse<IReview[]>> {
    // eslint-disable-next-line @typescript-eslint/no-unused-vars
    const options = createRequestOption(req);
    this.http
      .get(this.newsResourceUrl)
      .toPromise()
      .then(res => {
        this.formData = res as IReview[];
      });
    return this.http.get<IReview[]>(`${this.newsResourceUrl}/user`, { params: options, observe: 'response' });
  }

  find(id: any): Observable<IReview> {
    return this.http.get<IReview>(`${this.newsResourceUrl}/${id}`);
  }

  searchbyDate(fromDate: any, toDate: any): Observable<HttpResponse<IReview[]>> {
    const param = {
      from: fromDate,
      to: toDate
    };
    return this.http.get<IReview[]>(`${this.newsResourceUrl}/search-by-date`, { params: param, observe: 'response' });
  }

  update(news: IReview): Observable<IReview> {
    return this.http.put<IReview>(this.newsResourceUrl, news);
  }

  delete(id: any): Observable<HttpResponse<any>> {
    return this.http.delete<any>(`${this.newsResourceUrl}/${id}`, { observe: 'response' });
  }

  /**
   * Fulls text search
   * @param searchKey
   * @returns text search
   */
  fullTextSearch(searchKeys: any): Observable<HttpResponse<IReview[]>> {
    const param = {
      searchKey: searchKeys
    };
    return this.http.get<IReview[]>(`${this.newsResourceUrl}/search`, { params: param, observe: 'response' });
  }
}

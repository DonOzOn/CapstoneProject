import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SERVER_API_URL } from 'app/app.constants';
import { tap } from 'rxjs/operators';
import { JhiAlertService } from 'ng-jhipster';
import { IGuestCareProduct } from './guest-care-product.model';
import { createRequestOption } from 'app/shared/util/request-util';

@Injectable({
  providedIn: 'root'
})
export class GuestCareProductService {
  public guestResourceUrl = SERVER_API_URL + 'api/guest';
  formData: IGuestCareProduct[];
  constructor(private http: HttpClient, private alertService: JhiAlertService) {}

  getListGuest(): Observable<HttpResponse<IGuestCareProduct[]>> {
    return this.http.get<IGuestCareProduct[]>(this.guestResourceUrl, { observe: 'response' });
  }

  create(news: IGuestCareProduct): Observable<HttpResponse<IGuestCareProduct>> {
    return this.http.post<IGuestCareProduct>(this.guestResourceUrl, news, { observe: 'response' }).pipe(
      tap((response: HttpResponse<IGuestCareProduct>) => {
        if (response.ok) {
          this.alertService.success('Tạo thành công bài đăng', null, null);
        }
      })
    );
  }

  toggleStatus(id): Observable<HttpResponse<IGuestCareProduct>> {
    return this.http.put(`${this.guestResourceUrl}/${id}/toggle-status`, { observe: 'response' }).pipe(
      tap((response: HttpResponse<IGuestCareProduct>) => {
        if (response.ok) {
          // const g = response.body;
          this.alertService.success('Cập nhật thành công post #', null, null);
        }
      })
    );
  }

  find(id: any): Observable<IGuestCareProduct> {
    return this.http.get<IGuestCareProduct>(`${this.guestResourceUrl}/${id}`);
  }

  searchbyDate(fromDate: any, toDate: any): Observable<HttpResponse<IGuestCareProduct[]>> {
    const param = {
      from: fromDate,
      to: toDate
    };
    return this.http.get<IGuestCareProduct[]>(`${this.guestResourceUrl}/search-by-date`, { params: param, observe: 'response' });
  }

  update(news: IGuestCareProduct): Observable<IGuestCareProduct> {
    return this.http.put<IGuestCareProduct>(this.guestResourceUrl, news);
  }

  delete(id: any): Observable<HttpResponse<any>> {
    return this.http.delete(`${this.guestResourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<HttpResponse<IGuestCareProduct[]>> {
    const options = createRequestOption(req);
    this.http
      .get(this.guestResourceUrl)
      .toPromise()
      .then(res => {
        this.formData = res as IGuestCareProduct[];
      });
    return this.http.get<IGuestCareProduct[]>(`${this.guestResourceUrl}/getAllGuest`, { params: options, observe: 'response' });
  }
}

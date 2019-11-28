import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SERVER_API_URL } from 'app/app.constants';
import { IPostRespone } from './model/postRespone.model';
import { JhiAlertService } from 'ng-jhipster';
import { tap } from 'rxjs/operators';
import { IPostRequest } from './model/postRequest.model copy';
// import { createRequestOption } from 'app/shared/util/request-util';

@Injectable({
  providedIn: 'root'
})
export class PostService {
  public resourceUrl = SERVER_API_URL + 'api/product-post';
  public resourceUrlImage = SERVER_API_URL + 'api/upload';

  constructor(private http: HttpClient, private alertService: JhiAlertService) {}

  create(post: IPostRequest): Observable<HttpResponse<IPostRequest>> {
    return this.http.post<IPostRequest>(this.resourceUrl, post, { observe: 'response' }).pipe(
      tap((response: HttpResponse<IPostRequest>) => {
        if (response.ok) {
          // const g = response.body;
          this.alertService.success('Tạo thành công bài đăng', null, null);
        }
      })
    );
  }

  upload(uploadFiles: File): Observable<HttpResponse<any>> {
    const formData: FormData = new FormData();
    formData.append('file', uploadFiles, uploadFiles.name);
    return this.http.post<any>(this.resourceUrlImage, formData, { observe: 'response' });
  }

  update(post: IPostRequest): Observable<HttpResponse<IPostRequest>> {
    return this.http.put<IPostRequest>(this.resourceUrl, post, { observe: 'response' }).pipe(
      tap((response: HttpResponse<IPostRequest>) => {
        if (response.ok) {
          // const g = response.body;
          this.alertService.success('Cập nhật thành công post #', null, null);
        }
      })
    );
  }

  toggleStatus(id): Observable<HttpResponse<IPostRespone>> {
    return this.http.put(`${this.resourceUrl}/${id}/toggle-status`, { observe: 'response' }).pipe(
      tap((response: HttpResponse<IPostRespone>) => {
        if (response.ok) {
          // const g = response.body;
          this.alertService.success('Cập nhật thành công post #', null, null);
        }
      })
    );
  }

  find(id: any): Observable<IPostRespone> {
    return this.http.get<IPostRespone>(`${this.resourceUrl}/${id}`);
  }

  listAllByUserID(id: any): Observable<HttpResponse<IPostRespone[]>> {
    return this.http.get<IPostRespone[]>(`${this.resourceUrl}/user/${id}`, { observe: 'response' });
  }

  listAllByType(idType: any, postTypeID: any): Observable<HttpResponse<IPostRespone[]>> {
    const param = {
      id: idType,
      postType: postTypeID
    };
    return this.http.get<IPostRespone[]>(`${this.resourceUrl}/typeSearch`, { params: param, observe: 'response' });
  }

  listAllByTypeChild(idTypeChild: any, postTypeID: any): Observable<HttpResponse<IPostRespone[]>> {
    const param = {
      id: idTypeChild,
      postType: postTypeID
    };
    return this.http.get<IPostRespone[]>(`${this.resourceUrl}/typeChildSearch`, { params: param, observe: 'response' });
  }

  query(): Observable<HttpResponse<IPostRespone[]>> {
    return this.http.get<IPostRespone[]>(this.resourceUrl, { observe: 'response' });
  }

  searchbyDate(fromDate: any, toDate: any): Observable<HttpResponse<IPostRespone[]>> {
    const param = {
      from: fromDate,
      to: toDate
    };
    return this.http.get<IPostRespone[]>(`${this.resourceUrlImage}/search-by-date`, { params: param, observe: 'response' });
  }

  delete(id: any): Observable<HttpResponse<any>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}

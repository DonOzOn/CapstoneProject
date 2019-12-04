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

  /**
   * Uploads post service
   * @param uploadFiles
   * @returns upload
   */
  upload(uploadFiles: File): Observable<HttpResponse<any>> {
    const formData: FormData = new FormData();
    formData.append('file', uploadFiles, uploadFiles.name);
    return this.http.post<any>(this.resourceUrlImage, formData, { observe: 'response' });
  }

  /**
   * Updates post service
   * @param post
   * @returns update
   */
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

  /**
   * Toggles status
   * @param id
   * @returns status
   */
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

  /**
   * Finds post service
   * @param id
   * @returns find
   */
  find(id: any): Observable<IPostRespone> {
    return this.http.get<IPostRespone>(`${this.resourceUrl}/${id}`);
  }

  /**
   * Lists all by user id
   * @param id
   * @returns all by user id
   */
  listAllByUserID(id: any): Observable<HttpResponse<IPostRespone[]>> {
    return this.http.get<IPostRespone[]>(`${this.resourceUrl}/user/${id}`, { observe: 'response' });
  }

  /**
   * Lists all by type
   * @param idType
   * @param postTypeID
   * @returns all by type
   */
  listAllByType(idType: any, postTypeID: any): Observable<HttpResponse<IPostRespone[]>> {
    const param = {
      id: idType,
      postType: postTypeID
    };
    return this.http.get<IPostRespone[]>(`${this.resourceUrl}/typeSearch`, { params: param, observe: 'response' });
  }

  /**
   * Lists all by product post type
   * @param idType
   * @param postTypeID
   * @returns all by product post type
   */
  listAllByProductPostType(postTypes: any): Observable<HttpResponse<IPostRespone[]>> {
    const param = {
      postType: postTypes
    };
    return this.http.get<IPostRespone[]>(`${this.resourceUrl}/productposttypeSearch`, { params: param, observe: 'response' });
  }

  /**
   * Lists all by province
   * @param provinces
   * @returns all by province
   */
  listAllByProvince(provinces: any): Observable<HttpResponse<IPostRespone[]>> {
    const param = {
      province: provinces
    };
    return this.http.get<IPostRespone[]>(`${this.resourceUrl}/province`, { params: param, observe: 'response' });
  }

  /**
   * Lists all by type child
   * @param idTypeChild
   * @param postTypeID
   * @returns all by type child
   */
  listAllByTypeChild(idTypeChild: any, postTypeID: any): Observable<HttpResponse<IPostRespone[]>> {
    const param = {
      id: idTypeChild,
      postType: postTypeID
    };
    return this.http.get<IPostRespone[]>(`${this.resourceUrl}/typeChildSearch`, { params: param, observe: 'response' });
  }

  /**
   * Fulls text search
   * @param searchKey
   * @returns text search
   */
  fullTextSearch(searchKeys: any): Observable<HttpResponse<IPostRespone[]>> {
    const param = {
      searchKey: searchKeys
    };
    return this.http.get<IPostRespone[]>(`${this.resourceUrl}/search`, { params: param, observe: 'response' });
  }

  /**
   * Querys post service
   * @returns query
   */
  query(): Observable<HttpResponse<IPostRespone[]>> {
    return this.http.get<IPostRespone[]>(this.resourceUrl, { observe: 'response' });
  }

  /**
   * Searchbys date
   * @param fromDate
   * @param toDate
   * @returns date
   */
  searchbyDate(fromDate: any, toDate: any): Observable<HttpResponse<IPostRespone[]>> {
    const param = {
      from: fromDate,
      to: toDate
    };
    return this.http.get<IPostRespone[]>(`${this.resourceUrl}/search-by-date`, { params: param, observe: 'response' });
  }

  /**
   * Deletes post service
   * @param id
   * @returns delete
   */
  delete(id: any): Observable<HttpResponse<any>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}

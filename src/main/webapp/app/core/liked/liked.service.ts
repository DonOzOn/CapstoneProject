import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SERVER_API_URL } from 'app/app.constants';
import { JhiAlertService } from 'ng-jhipster';
import { tap } from 'rxjs/operators';
import { ILikedReview } from './model/liked-review.model';
import { ILikedPost } from './model/liked-post.model';

// import { createRequestOption } from 'app/shared/util/request-util';

@Injectable({
  providedIn: 'root'
})
export class LikedService {
  public resourceUrl = SERVER_API_URL + 'api/like';
  public resourceUrlImage = SERVER_API_URL + 'api/upload';

  constructor(private http: HttpClient, private alertService: JhiAlertService) {}
  createLikeReview(like: ILikedReview): Observable<HttpResponse<ILikedReview>> {
    return this.http.post<ILikedReview>(this.resourceUrl, like, { observe: 'response' }).pipe(
      tap((response: HttpResponse<ILikedReview>) => {
        if (response.ok) {
          // const g = response.body;
          this.alertService.success('Tạo thành công bài đăng', null, null);
        }
      })
    );
  }

  createLikePost(like: ILikedPost): Observable<HttpResponse<ILikedReview>> {
    return this.http.post<ILikedPost>(this.resourceUrl, like, { observe: 'response' }).pipe(
      tap((response: HttpResponse<ILikedPost>) => {
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
  update(post: ILikedPost): Observable<HttpResponse<ILikedPost>> {
    return this.http.put<ILikedPost>(this.resourceUrl, post, { observe: 'response' }).pipe(
      tap((response: HttpResponse<ILikedPost>) => {
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
  find(id: any): Observable<ILikedPost> {
    return this.http.get<ILikedPost>(`${this.resourceUrl}/${id}`);
  }

  /**
   * Querys post service
   * @returns query
   */
  query(): Observable<HttpResponse<ILikedPost[]>> {
    return this.http.get<ILikedPost[]>(this.resourceUrl, { observe: 'response' });
  }

  /**
   * Deletes post service
   * @param id
   * @returns delete
   */
  delete(id: any): Observable<HttpResponse<any>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  /**
   * Filters by character
   * @param [req]
   * @returns by character
   */
  filterByCharacter(req?: any): Observable<HttpResponse<ILikedPost[]>> {
    return this.http.get<ILikedPost[]>(`${this.resourceUrl}/filters`, { params: req, observe: 'response' });
  }
}

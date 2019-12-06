import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SERVER_API_URL } from 'app/app.constants';
import { JhiAlertService } from 'ng-jhipster';
import { ILikedReview } from './model/liked-review.model';
import { ILikedPost } from './model/liked-post.model';

// import { createRequestOption } from 'app/shared/util/request-util';

@Injectable({
  providedIn: 'root'
})
export class LikedService {
  public resourceUrlPost = SERVER_API_URL + 'api/liked-post';
  public resourceUrlReview = SERVER_API_URL + 'api/liked-review';

  constructor(private http: HttpClient, private alertService: JhiAlertService) {}

  /**
   * Checks liked post
   * @param userids
   * @param postIds
   * @returns liked post
   */
  checkLikedPost(userids: any, postIds: any): Observable<HttpResponse<ILikedPost>> {
    const param = {
      userId: userids,
      postId: postIds
    };
    return this.http.get<ILikedPost>(this.resourceUrlPost, { params: param, observe: 'response' });
  }

  /**
   * Checks status post
   * @param userids
   * @param postIds
   * @returns status post
   */
  checkStatusPost(userids: any, postIds: any): Observable<HttpResponse<ILikedPost>> {
    const param = {
      userId: userids,
      postId: postIds
    };
    return this.http.get<ILikedPost>(`${this.resourceUrlPost}/checkstatus`, { params: param, observe: 'response' });
  }

  /**
   * Checks liked review
   * @param userids
   * @param postIds
   * @returns liked review
   */
  checkLikedReview(userids: any, reviewIds: any): Observable<HttpResponse<ILikedReview>> {
    const param = {
      userId: userids,
      reviewId: reviewIds
    };
    return this.http.get<ILikedReview>(this.resourceUrlReview, { params: param, observe: 'response' });
  }

  /**
   * Checks status review
   * @param userids
   * @param postIds
   * @returns status review
   */
  checkStatusReview(userids: any, reviewIds: any): Observable<HttpResponse<ILikedReview>> {
    const param = {
      userId: userids,
      reviewId: reviewIds
    };
    return this.http.get<ILikedReview>(`${this.resourceUrlReview}/checkstatus`, { params: param, observe: 'response' });
  }
}

import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse} from '@angular/common/http';
import { Observable } from 'rxjs';
import { SERVER_API_URL } from 'app/app.constants';
import { IPost } from './model/post.model';
import { JhiAlertService } from 'ng-jhipster';
import { tap } from 'rxjs/operators';
import { createRequestOption } from 'app/shared/util/request-util';

@Injectable({
    providedIn: 'root'
})
export class PostService {
    public resourceUrl = SERVER_API_URL + 'api/product-post';
    constructor(private http: HttpClient, private alertService: JhiAlertService) {}

    create(post: IPost): Observable<HttpResponse<IPost>> {
        return this.http.post<IPost>(this.resourceUrl, post, { observe: 'response' }).pipe(
            tap((response: HttpResponse<IPost>) => {
                if (response.ok) {
                    const g = response.body;
                    this.alertService.success('Tạo thành công bài đăng' , null, null);
                }
            })
        );
    }

    update(post: IPost): Observable<HttpResponse<IPost>> {
        return this.http.put<IPost>(this.resourceUrl, post, { observe: 'response' }).pipe(
            tap((response: HttpResponse<IPost>) => {
                if (response.ok) {
                    const g = response.body;
                    this.alertService.success('Cập nhật thành công post #' , null, null);
                }
            })
        );
    }

    toggleStatus(id): Observable<HttpResponse<IPost>> {
        return this.http.put(`${this.resourceUrl}/${id}/toggle-status`, { observe: 'response' }).pipe(
            tap((response: HttpResponse<IPost>) => {
                if (response.ok) {
                    const g = response.body;
                    this.alertService.success('Cập nhật thành công post #' , null, null);
                }
            })
        );
    }

    find(id: any): Observable<HttpResponse<IPost>> {
        return this.http.get<IPost>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<HttpResponse<IPost[]>> {
        const options = createRequestOption(req);
        return this.http.get<IPost[]>(`${this.resourceUrl}/find-by-name`, { params: options, observe: 'response' });
    }
}

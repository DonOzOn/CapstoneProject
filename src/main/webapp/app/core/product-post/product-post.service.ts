import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { tap } from 'rxjs/operators';
import { JhiAlertService } from 'ng-jhipster';
import { IProductPost } from './product-post.model';

@Injectable({ providedIn: 'root' })
export class ProductPostService {
    public resourceUrl = SERVER_API_URL + 'api/product-post';

    constructor(private http: HttpClient, private alertService: JhiAlertService) {}

    create(shift: IProductPost): Observable<HttpResponse<IProductPost>> {
        return this.http.post<IProductPost>(this.resourceUrl, shift, { observe: 'response' }).pipe(
            tap((response: HttpResponse<IProductPost>) => {
                if (response.ok) {
                    const g = response.body;
                    this.alertService.success('Tạo thành công bài đăng' + g.id, null, null);
                }
            })
        );
    }

    update(shift: IProductPost): Observable<HttpResponse<IProductPost>> {
        return this.http.put<IProductPost>(this.resourceUrl, shift, { observe: 'response' }).pipe(
            tap((response: HttpResponse<IProductPost>) => {
                if (response.ok) {
                    const g = response.body;
                    this.alertService.success('Cập nhật thành công ca #' + g.id, null, null);
                }
            })
        );
    }

    updateStatus(id: any): Observable<HttpResponse<IProductPost>> {
        return this.http.put(`${this.resourceUrl}/${id}`, { observe: 'response' }).pipe(
            tap((response: HttpResponse<IProductPost>) => {
                if (response.ok) {
                    const g = response.body;
                    this.alertService.success('Xoá thành công ca làm #' + g.id, null, null);
                }
            })
        );
    }

    toggleStatus(id): Observable<HttpResponse<IProductPost>> {
        return this.http.put(`${this.resourceUrl}/${id}/toggle-status`, { observe: 'response' }).pipe(
            tap((response: HttpResponse<IProductPost>) => {
                if (response.ok) {
                    const g = response.body;
                    this.alertService.success('Cập nhật thành công ca #' + g.id, null, null);
                }
            })
        );
    }

    find(id: any): Observable<HttpResponse<IProductPost>> {
        return this.http.get<IProductPost>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<HttpResponse<IProductPost[]>> {
        const options = createRequestOption(req);
        return this.http.get<IProductPost[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: any): Observable<HttpResponse<any>> {
        return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' }).pipe(
            tap((response: HttpResponse<any>) => {
                if (response.ok) {
                    this.alertService.success('Xóa bộ phận thứ ' + id + ' thành công', null, null);
                }
            })
        );
    }
}

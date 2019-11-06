import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { tap } from 'rxjs/operators';
import { JhiAlertService } from 'ng-jhipster';
import { IUtilities } from '../utilities/utilities.model';

@Injectable({ providedIn: 'root' })
export class UsingUtilitiesService {
    public resourceUrl = SERVER_API_URL + 'api/Utilities-post';

    constructor(private http: HttpClient, private alertService: JhiAlertService) { }

    create(Utilities: IUtilities): Observable<HttpResponse<IUtilities>> {
        return this.http.post<IUtilities>(this.resourceUrl, Utilities, { observe: 'response' }).pipe(
            tap((response: HttpResponse<IUtilities>) => {
                if (response.ok) {
                    const g = response.body;
                    this.alertService.success('Tạo thành công bài đăng' + g.id, null, null);
                }
            })
        );
    }

    update(Utilities: IUtilities): Observable<HttpResponse<IUtilities>> {
        return this.http.put<IUtilities>(this.resourceUrl, Utilities, { observe: 'response' }).pipe(
            tap((response: HttpResponse<IUtilities>) => {
                if (response.ok) {
                    const g = response.body;
                    this.alertService.success('Cập nhật thành công ca #' + g.id, null, null);
                }
            })
        );
    }

    updateStatus(id: any): Observable<HttpResponse<IUtilities>> {
        return this.http.put(`${this.resourceUrl}/${id}`, { observe: 'response' }).pipe(
            tap((response: HttpResponse<IUtilities>) => {
                if (response.ok) {
                    const g = response.body;
                    this.alertService.success('Xoá thành công ca làm #' + g.id, null, null);
                }
            })
        );
    }

    toggleStatus(id): Observable<HttpResponse<IUtilities>> {
        return this.http.put(`${this.resourceUrl}/${id}/toggle-status`, { observe: 'response' }).pipe(
            tap((response: HttpResponse<IUtilities>) => {
                if (response.ok) {
                    const g = response.body;
                    this.alertService.success('Cập nhật thành công ca #' + g.id, null, null);
                }
            })
        );
    }

    find(id: any): Observable<HttpResponse<IUtilities>> {
        return this.http.get<IUtilities>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<HttpResponse<IUtilities[]>> {
        const options = createRequestOption(req);
        return this.http.get<IUtilities[]>(this.resourceUrl, { params: options, observe: 'response' });
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

import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { tap } from 'rxjs/operators';
import { JhiAlertService } from 'ng-jhipster';
import { IImage } from '../image/image.model';

@Injectable({ providedIn: 'root' })
export class ImageService {
    public resourceUrl = SERVER_API_URL + 'api/image';

    constructor(private http: HttpClient, private alertService: JhiAlertService) { }

    create(image: IImage): Observable<HttpResponse<IImage>> {
        return this.http.post<IImage>(this.resourceUrl, image, { observe: 'response' }).pipe(
            tap((response: HttpResponse<IImage>) => {
                if (response.ok) {
                    const g = response.body;
                    this.alertService.success('Tạo thành công hình ảnh' + g.id, null, null);
                }
            })
        );
    }

    update(image: IImage): Observable<HttpResponse<IImage>> {
        return this.http.put<IImage>(this.resourceUrl, image, { observe: 'response' }).pipe(
            tap((response: HttpResponse<IImage>) => {
                if (response.ok) {
                    const g = response.body;
                    this.alertService.success('Cập nhật thành công hình ảnh #' + g.id, null, null);
                }
            })
        );
    }

    updateStatus(id: any): Observable<HttpResponse<IImage>> {
        return this.http.put(`${this.resourceUrl}/${id}`, { observe: 'response' }).pipe(
            tap((response: HttpResponse<IImage>) => {
                if (response.ok) {
                    const g = response.body;
                    this.alertService.success('Xoá thành công hình ảnh làm #' + g.id, null, null);
                }
            })
        );
    }

    toggleStatus(id): Observable<HttpResponse<IImage>> {
        return this.http.put(`${this.resourceUrl}/${id}/toggle-status`, { observe: 'response' }).pipe(
            tap((response: HttpResponse<IImage>) => {
                if (response.ok) {
                    const g = response.body;
                    this.alertService.success('Cập nhật thành công hình ảnh #' + g.id, null, null);
                }
            })
        );
    }

    find(id: any): Observable<HttpResponse<IImage>> {
        return this.http.get<IImage>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<HttpResponse<IImage[]>> {
        const options = createRequestOption(req);
        return this.http.get<IImage[]>(this.resourceUrl, { params: options, observe: 'response' });
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
